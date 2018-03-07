package sample;

import javafx.scene.control.Button;

import java.awt.*;

public class boton_personalizado extends Button {
    private int estado = 1;

    public boton_personalizado() {
        this.setStyle("-fx-background-color:#c5cec4");
    }

    public void actualizar(){
        if (estado < 2){
            estado+=1;
        }else {estado = 0;}
        this.setStyle("");
        switch (estado){
            case 1:this.setStyle("-fx-background-color:#c5cec4");
                break;
            case 0:this.setStyle("-fx-background-color:#a0062f");
                break;
            case 2:this.setStyle("-fx-background-color:#151519");
                break;
        }
    }

    public int getEstado() {
        return estado;
    }
}
