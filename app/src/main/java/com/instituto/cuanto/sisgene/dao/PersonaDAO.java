package com.instituto.cuanto.sisgene.dao;

import android.content.Context;
import android.database.Cursor;

import com.instituto.cuanto.sisgene.entidad.Allegado;

/**
 * Created by Jesus on 08/11/2015.
 */
public class PersonaDAO {

    public PersonaDAO() {
    }

    public boolean actualizarPersona(Context context, String nombre, String appaterno, String apmaterno,
                                     String numdoc, String telefono, String celular, String correo, int per_id) {
        Cursor cursor = null;
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        String idPers = per_id + "";
        String arg[] = {nombre, appaterno, apmaterno, numdoc, telefono, celular, correo, idPers};
        boolean response = false;

        System.out.println("IDM PERSONA : " + per_id);

        try {
            String sql = " UPDATE persona " +
                    " SET per_nombres = ?, " +
                    " per_appaterno = ?, " +
                    " per_apmaterno = ?, " +
                    " per_num_documento = ?, " +
                    " per_telefono = ?, " +
                    " per_celular = ?, " +
                    " per_correo = ? " +
                    " WHERE per_id = ?";

            dataBaseHelper.db.execSQL(sql, arg);

            response = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }

        return response;

    }

    public boolean insertarPersona(Context context, String nombre, String appaterno, String apmaterno,
                                   String numdoc, String telefono, String celular, String correo) {
        Cursor cursor = null;
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        String arg[] = {nombre, appaterno, apmaterno, numdoc, telefono, celular, correo, "1"};
        boolean response = false;

        try {
            String sql = " INSERT INTO persona (per_nombres,per_appaterno,per_apmaterno,per_num_documento,per_telefono,per_celular,per_correo,tip_id)" +
                    " VALUES(?,?,?,?,?,?,?,?)";
            System.out.println("insertarPersona: sql: " + sql);
            dataBaseHelper.db.execSQL(sql, arg);
            response = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }
        System.out.println("insertarPersona: response:" + response);
        return response;
    }

    public int obtenerUltIdPersona(Context context) {

        Cursor cursor = null;
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);

        int response = 0;

        try {

            cursor = dataBaseHelper.db.rawQuery(" select per.per_id" +
                    " from persona per" +
                    " order by per.per_id desc", null);

            if (cursor.moveToFirst()) {

                response = cursor.getInt(0);

            }
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }
        System.out.println("obtenerUltIdPersona: id:" + response);
        return 0;

    }

    public int obtenerIdPersonabyNombres(Context context, String nombre, String appaterno, String apmaterno) {

        Cursor cursor = null;
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);

        int response = 0;
        String arg[] = {nombre, appaterno, apmaterno};

        String sql = " SELECT alle.all_id " +
                " from allegado alle " +
                " where alle.all_nombres = ? " +
                " and alle.all_appaterno = ? " +
                " and alle.all_apmaterno = ?";

        try {
            cursor = dataBaseHelper.db.rawQuery(sql, arg);

            if (cursor.moveToFirst()) {
                response = cursor.getInt(1);
            }

            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }

        return -1;

    }

    public boolean insertarAllegado(Context context, String nombre, String appaterno, String apmaterno, String caer_id, String codIden) {
        Cursor cursor = null;
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        String arg[] = {nombre, appaterno, apmaterno, caer_id, codIden};
        boolean response = false;

        try {
            String sql = " INSERT INTO allegado (all_nombre,all_appaterno,all_apmaterno,caer_id, all_codigo_identificacion)" +
                    " VALUES(?,?,?,?,?)";

            dataBaseHelper.db.execSQL(sql, arg);

            response = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }
        System.out.println("insertarAllegado: response: " + response);
        return response;
    }

    public int obtenerUltIdAlle(Context context) {
        Cursor cursor = null;
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);

        int response = 0;

        try {

            cursor = dataBaseHelper.db.rawQuery("select alle.all_id from allegado alle order by alle.all_id desc", null);

            if (cursor.moveToFirst()) {
                response = cursor.getInt(0);
            }
            System.out.println("obtenerUltIdAlle: OK, id: " + response);
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }
        System.out.println("obtenerUltIdAlle: ERROR ");
        return 0;


    }

    public Allegado obtenerUltAlle(Context context) {
        Cursor cursor = null;
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);

        int response = 0;
        Allegado allegado = new Allegado();

        try {

            cursor = dataBaseHelper.db.rawQuery("select alle.all_nombre, alle.all_appaterno, alle.all_apmaterno from allegado alle order by alle.all_id desc", null);

            if (cursor.moveToFirst()) {

                allegado.setNombres(cursor.getString(0));
                allegado.setApellido_paterno(cursor.getString(1));
                allegado.setApellido_materno(cursor.getString(2));
            }

            return allegado;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return allegado;


    }

}
