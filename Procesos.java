package com;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Procesos {
	ArrayList<Usuarios> usuarios = new ArrayList<> ();
	BufferedReader br;

	public void escribir() throws IOException {

		BufferedWriter bf = new BufferedWriter (new FileWriter ("/home/brian/Documentos/cuentas.txt"));
		System.out.println (usuarios.size ());
		for(int i = 0; i < this.usuarios.size ()-1; i++){

			bf.write (this.usuarios.get (i).getNumeroTarjeta ()+"#" + this.usuarios.get(i).getNip () + "$" + this.usuarios.get (i).getSaldo () + "@" + this.usuarios.get (i).getTipoTarjeta () + "/\n");
		}
		bf.close ();
		usuarios = new ArrayList<> ();

	}

	public ArrayList cargar(){

		int x = 0;
		int i = 0;
		x = 0;
		Usuarios aux;
		try {

			br = new BufferedReader(new FileReader ("/home/brian/Documentos/cuentas.txt"));
			String linea, numeroTarjeta, Nip, saldo, tipoTarjeta;
			while((linea = br.readLine()) != null) {
				//System.out.println (cuenta[j]);
				numeroTarjeta = linea.substring (linea.indexOf (""),linea.indexOf ("#"));
				Nip = linea.substring (linea.indexOf ("#")+1, linea.indexOf ("$"));
				saldo = linea.substring (linea.indexOf ("$")+1, linea.indexOf ("@"));
				tipoTarjeta = linea.substring (linea.indexOf ("@")+1, linea.indexOf ("/"));
				System.out.println (numeroTarjeta);
				System.out.println (Nip);
				System.out.println (saldo);
				System.out.println (tipoTarjeta);
				aux = new Usuarios ();
				aux.setNumeroTarjeta (numeroTarjeta);
				aux.setNip (Nip);
				aux.setSaldo (saldo);
				aux.setTipoTarjeta (tipoTarjeta);

				usuarios.add(aux);
			}
			br.close ();

		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if( null != br ){
					br.close();
				}
			}catch (Exception e2){
				e2.printStackTrace();
			}
		}
		return usuarios;
	}

}
