package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;


public class App extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        File archivo;
        FileReader fr = null;
        BufferedReader br;

        stage = FXMLLoader.load(getClass().getResource("/InterfazGrafica.fxml"));
        stage.show();
    }

    public void IngresaTarjeta(){
        try {
            Stage op = FXMLLoader.load(getClass().getResource("/IngresarTarjeta.fxml"));
            op.show();

        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }

    public void Consulta(){
        try {
            Stage op = FXMLLoader.load(getClass().getResource("/Consulta.fxml"));
            op.show();

        } catch (IOException e) {

        }
    }
    public void CambiarNip(){
        try {
            Stage op = FXMLLoader.load(getClass().getResource("/Cambiar Nip.fxml"));
            op.show();

        } catch (IOException e) {

        }
    }

    public void SinTarjeta(){
        try {
            Stage op = FXMLLoader.load(getClass().getResource("/SinTarjeta.fxml"));
            op.show();

        } catch (IOException e) {

        }
    }
    public void Menu(){
        try {
            Stage op = FXMLLoader.load(getClass().getResource("/InterfazMenuOpciones.fxml"));
            op.show();

        } catch (IOException e) {

        }
    }
    public void retiro(){
        try {
            Stage op = FXMLLoader.load(getClass().getResource("/RetiroConTarjeta2.fxml"));
            op.show();

        } catch (IOException e) {

        }
    }
    public void servicios(){
        try {
            Stage op = FXMLLoader.load(getClass().getResource("/PagoServicios.fxml"));
            op.show();

        } catch (IOException e) {

        }
    }
    public void transferir(){
        try {
            Stage op = FXMLLoader.load(getClass().getResource("/Transferencia.fxml"));
            op.show();

        } catch (IOException e) {

        }
    }
}