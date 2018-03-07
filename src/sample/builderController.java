package sample;

import javafx.fxml.FXML;
import Serializable.DatosNivel;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.*;


public class builderController {
    private int x;
    private int y;
    GridPane grid;
    @FXML
    BorderPane bp;
    @FXML
    TextField nombreNivel;




    public void setGrid(){
        grid = new GridPane();
        grid.setMaxSize(100*x,100*y);

        for (int i = 0; i < x ; i++) {
            for (int j = 0; j < y; j++) {
                boton_personalizado btn = new boton_personalizado();
                btn.setPrefSize(100,100);
                btn.setOnAction(e -> {
                    btn.actualizar();
                });
                grid.add(btn, j, i); // column=2 row=0
            }
        }
        grid.setGridLinesVisible(true);
        bp.setCenter(grid);

    }

    public void imprimirTablero(){
        int [][] matriz = new int[x][y];
        System.out.println("Tablero");
        int n = 0;
        String msg = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matriz[i][j] =((boton_personalizado)grid.getChildren().get(n)).getEstado();
                msg+=((boton_personalizado)grid.getChildren().get(n)).getEstado();
                n++;

            }
            msg+= "\n";
        }
        System.out.println(msg);

        DatosNivel nivel = new DatosNivel(x,y);
        nivel.setMatriz(matriz);
        try {
            FileOutputStream fileOut = new FileOutputStream("objetosSer/"+nombreNivel.getText()+".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(nivel);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }
}

