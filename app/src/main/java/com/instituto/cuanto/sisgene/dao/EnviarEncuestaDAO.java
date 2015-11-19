package com.instituto.cuanto.sisgene.dao;

import android.content.Context;
import android.database.Cursor;

import com.instituto.cuanto.sisgene.bean.EncuestaPregunta;
import com.instituto.cuanto.sisgene.entidad.DireccionViviendaEncuestada;
import com.instituto.cuanto.sisgene.entidad.Persona;

/**
 * Created by Jesus on 17/11/2015.
 */
public class EnviarEncuestaDAO {


    public Persona obtenerPersonaEncuestada(Context context,String idCabEnc) {

        Cursor cursor = null;
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        Persona persona = null;

        String sql = " select per.per_id,per.per_num_documento,per.per_nombres,per.per_appaterno, " +
                " per.per_apmaterno,per.per_telefono,per.per_celular,per.per_correo,per.per_fnacimiento, " +
                " per.per_edad,per.per_gradinstruccion,per.per_estadocivil,per.per_genero,per.tip_id " +
                " from persona per " +
                " inner join cab_enc_rpta caer on per.per_id = caer.per_id " +
                " where caer.caer_id = "+idCabEnc;

        try {

            cursor = dataBaseHelper.db.rawQuery(sql, null);

            if (cursor.moveToFirst()) {
                persona = new Persona();

                persona.setPer_id((cursor.getString(0) != null) ? cursor.getString(0) : "");
                persona.setNum_documento((cursor.getString(1) != null) ? cursor.getString(1) : "");
                persona.setNombres((cursor.getString(2) != null) ? cursor.getString(2) : "");
                persona.setApellido_paterno((cursor.getString(3) != null) ? cursor.getString(3) : "");
                persona.setApellido_materno((cursor.getString(4) != null) ? cursor.getString(4) : "");
                persona.setTelefono((cursor.getString(5) != null) ? cursor.getString(5) : "");
                persona.setCelular((cursor.getString(6) != null) ? cursor.getString(6) : "");
                persona.setCorreo((cursor.getString(7) != null) ? cursor.getString(7) : "");
                persona.setFecha_nacimiento((cursor.getString(8) != null) ? cursor.getString(8) : "");
                persona.setEdad((cursor.getString(9) != null) ? cursor.getString(9) : "");
                persona.setGrado_instruccion((cursor.getString(10) != null) ? cursor.getString(10) : "");
                persona.setEstado_civil((cursor.getString(11) != null) ? cursor.getString(11) : "");
                persona.setGenero((cursor.getString(12) != null) ? cursor.getString(12) : "");
                persona.setId_tipo_doc((cursor.getString(13) != null) ? cursor.getString(13) : "");

            }
            System.out.println("OKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
            return persona;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }
        System.out.println("nullllllllllllllllllllllllllllllllllll");
        return null;

    }

    public DireccionViviendaEncuestada obtenerDireccionEncuestada(Context context,String idCabEnc) {

        Cursor cursor = null;
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        DireccionViviendaEncuestada direccion = null;

        String sql = " select dir.dir_tipo_ubicacion,dir.dir_num_puerta,dir.dir_int,dir.dir_piso,dir.dir_etapa, " +
                " dir.dir_sector,dir.dir_grupo,dir.dir_manzana,dir.dir_lote,dir.dir_km " +
                " from direccion dir " +
                " inner join cab_enc_rpta caer on caer.dir_id = dir.dir_id " +
                " where caer.caer_id = "+idCabEnc;

        try {

            cursor = dataBaseHelper.db.rawQuery(sql, null);

            if (cursor.moveToFirst()) {
                direccion = new DireccionViviendaEncuestada();

                direccion.setTipo_ubicacion((cursor.getString(0) != null) ? cursor.getString(0) : "");
                direccion.setNum_puerta((cursor.getString(1) != null) ? cursor.getString(1) : "");
                direccion.setInterior((cursor.getString(2) != null) ? cursor.getString(2) : "");
                direccion.setPiso((cursor.getString(3) != null) ? cursor.getString(3) : "");
                direccion.setEtapa((cursor.getString(4) != null) ? cursor.getString(4) : "");
                direccion.setSector((cursor.getString(5) != null) ? cursor.getString(5) : "");
                direccion.setGrupo((cursor.getString(6) != null) ? cursor.getString(6) : "");
                direccion.setManzana((cursor.getString(7) != null) ? cursor.getString(7) : "");
                direccion.setLote((cursor.getString(8) != null) ? cursor.getString(8) : "");
                direccion.setKm((cursor.getString(9) != null) ? cursor.getString(9) : "");
            }
            System.out.println("OKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
            return direccion;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }
        System.out.println("nullllllllllllllllllllllllllllllllllll");
        return null;

    }
}
