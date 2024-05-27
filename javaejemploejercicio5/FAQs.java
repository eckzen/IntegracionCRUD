/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaejemploejercicio5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author pc
 */
class Faq {
    private int faqId;
    private String pregunta;
    private String respuesta;

    public Faq(int faqId, String pregunta, String respuesta) {
        this.faqId = faqId;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public int getFaqId() {
        return faqId;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }
}