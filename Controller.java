package com;

import com.sun.jdi.InvocationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import jdk.nashorn.internal.runtime.regexp.joni.Warnings;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    static int posicion = 0;
    static String guardarNumero = "";
    private App app = new App ();
    ArrayList<Usuarios> usuarios = new ArrayList();
    Procesos procesos = new Procesos ();
    @FXML
    TextField NIP, NumeroTarjeta,Cantidad,consulta, ActualNip, NuevoNip, transferir, cantidadTrans;

    public void botonTarjeta(){
        app.IngresaTarjeta();
    }

    public void validarTarjeta(){
        String nip = NIP.getText ();
        String numTarjeta = NumeroTarjeta.getText ();
        guardarNumero = numTarjeta;
        int validar = 0;
        usuarios = procesos.cargar();
        for(int i = 0; i < usuarios.size (); i++){
            if(usuarios.get(i).getNumeroTarjeta ().equalsIgnoreCase (numTarjeta)){
                if(usuarios.get (i).getNip ().equalsIgnoreCase (nip)){
                    app.Menu ();
                    validar =1;
                }
            }
        }
        if(validar == 0){
            JOptionPane.showMessageDialog(null, "NIP o Numero de tarjeta incorrectos");
            NIP.setText ("");
            NumeroTarjeta.setText ("");
        }
    }
    public void botonSinTarjeta(){
        app.SinTarjeta();
    }

    public void VentanaRetiro(){
        app.retiro();
    }


    public void VentanaServicios(){
        app.servicios();
    }

    public void estadoCuenta(ActionEvent actionEvent) {
        app.Consulta ();
    }

    public void retirar() throws IOException {
        double retirar,saldo;
        Usuarios aux;
        String cantidad1 = Cantidad.getText ();
        usuarios = procesos.cargar ();
        for(int i = 0; i < usuarios.size (); i++){
            if(usuarios.get (i).getNumeroTarjeta ().equalsIgnoreCase (guardarNumero)){
                retirar = Double.parseDouble (cantidad1);
                saldo = Double.parseDouble (usuarios.get (i).getSaldo ()) - retirar;
                aux = new Usuarios ();
                usuarios.get (i).setSaldo (String.valueOf (saldo));
                usuarios.add (aux);
                System.out.println (saldo);
                procesos.escribir();
            }
        }
    }
    public void mostrarSaldo(){
        System.out.println ("hola");
        System.out.println (usuarios.size ());
        System.out.println (guardarNumero);
        usuarios = procesos.cargar ();

        for(int i = 0; i < usuarios.size (); i++){
            if(usuarios.get (i).getNumeroTarjeta ().equalsIgnoreCase (guardarNumero)){
               consulta.setText (usuarios.get (i).getSaldo ());
                System.out.println (String.valueOf (usuarios.get (i).getSaldo ()));
            }
        }
    }

    public  void CambiarNip() throws IOException {
        Usuarios aux;
        String nip = ActualNip.getText ();
        String nuevoNip = NuevoNip.getText ();
        usuarios = procesos.cargar ();
        for(int i = 0; i < usuarios.size (); i++){
            if(usuarios.get (i).getNip ().equalsIgnoreCase (nip)){

                aux = new Usuarios ();
                usuarios.get (i).setNip(nuevoNip);
                usuarios.add (aux);
                System.out.println (nuevoNip);
                procesos.escribir();
            }
        }
    }
    public void VentanaCambiarNip() throws IOException {
        app.CambiarNip ();

    }

    public void transferencia() throws IOException {
        Usuarios aux;
        double cantidad, transferido,numero;

        String cantidad2 = cantidadTrans.getText ();
        String transferido2 = transferir.getText ();
        usuarios = procesos.cargar ();
        aux = new Usuarios ();
        cantidad = Double.parseDouble (cantidad2);
        for(int i = 0; i < usuarios.size (); i++){
            if(usuarios.get (i).getNumeroTarjeta ().equalsIgnoreCase (transferido2)){
                numero = Double.parseDouble (usuarios.get (i).getSaldo ()) + cantidad;
                usuarios.get (i).setSaldo (String.valueOf (numero));
                usuarios.add (aux);
                for(int j = 0; j < usuarios.size (); j++){
                    if(usuarios.get (j).getNumeroTarjeta ().equalsIgnoreCase (guardarNumero)){
                        numero = Double.parseDouble (usuarios.get (j).getSaldo ()) - cantidad;
                        usuarios.get (j).setSaldo (String.valueOf (numero));
                        usuarios.add (aux);
                    }
                }

            }
        }
        procesos.escribir();
    }

    public void ventanaTranferir(){
        app.transferir ();
    }
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }


}
