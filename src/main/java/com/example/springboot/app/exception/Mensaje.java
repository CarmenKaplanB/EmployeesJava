package com.example.springboot.app.exception;

// Clase para mostrar mensajes por pantalla en el cliente (Front)

public class Mensaje {
    private String mensaje;

    public Mensaje(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje(){
        return mensaje;
    }

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }
}
