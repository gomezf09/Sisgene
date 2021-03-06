package com.instituto.cuanto.sisgene.entities;

import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Gustavo on 27/10/2015.
 */
public class TipoPreguntaMixtaItem {
    ArrayList<String> respuestas;
    ArrayList<String> alternativas;
    String title;
    public LinearLayout lvLayout;
    Boolean hasView;

    public String getPreguntaMixta() {
        return preguntaMixta;
    }

    public void setPreguntaMixta(String preguntaMixta) {
        this.preguntaMixta = preguntaMixta;
    }

    String preguntaMixta;

    public TipoPreguntaMixtaItem() {
        this.hasView = false;
        this.respuestas = new ArrayList<>();
    }

    public Boolean getHasView() {
        return hasView;
    }

    public void setHasView(Boolean hasView) {
        this.hasView = hasView;
    }

    public ArrayList<String> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<String> respuestas) {
        this.respuestas = respuestas;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(ArrayList<String> alternativas) {
        this.alternativas = alternativas;
    }
}
