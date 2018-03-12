package com.ownk.IndiceTextOwnk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TextUtil {
	
	private BufferedReader textoInterior;

	public List<String> listaArchivos(String rutaArchivos){
		List<String> listaArchivos = new ArrayList<String>();
		
		
		String sDirectorio = rutaArchivos;
		File f = new File(sDirectorio);
		
			if (f.exists())
				{ 
				System.out.println("Encontrada su ruta");
				}
			
			else 
				{ 
				System.out.println("No existe");
				}
			File[] ficheros = f.listFiles();
			for (int x=0;x<ficheros.length;x++){
				listaArchivos.add(ficheros[x].getName());
			}
			return listaArchivos;
		}
	public List<String> listaArchivosEnCarpeta(String rutaCarpeta){
		List<String> listaArchivosEnCarpeta = new ArrayList<String>();
		
		
		String sDirectorio = rutaCarpeta;
		File f = new File(sDirectorio);
		
			if (f.exists())
				{ 
				System.out.println("Encontrada su ruta");
				}
			
			else 
				{ 
				System.out.println("No existe");
				}
			File[] ficheros = f.listFiles();
			for (int x=0;x<ficheros.length;x++){
				listaArchivosEnCarpeta.add(ficheros[x].getName());
			}
			return listaArchivosEnCarpeta;
		}
		
	public File obtenerArchivo(String nombre) {
		File txt = null;
		 try {
			 
			 String path=nombre;
			 txt = new File (path);
			 
		} catch (Exception e) {
			System.out.println("CLV");
		}
		return txt;
	}
	
	public String leerArchivo(File archivo) {
			String texto="";
			String textoSiguiente="";
		try {
			FileReader abrirRuta = new FileReader (archivo);
			textoInterior = new BufferedReader(abrirRuta);
			while((texto=textoInterior.readLine())!=null)
			{
				textoSiguiente=textoSiguiente+texto;
			}
			
		} catch (Exception e) {
			System.out.println("Error al leer: "+ e);
		}
		return textoSiguiente;
	}
		
	public Boolean crearArchivo(String datosArchivo, String nombre, String ruta) {
	
		Boolean exito = false;
	
		try {
			File archivo = new File(ruta+"/"+ nombre);
			FileWriter escribir = new FileWriter(archivo,true);
			escribir.write(datosArchivo);
			escribir.close(); 
		} 
		
		catch (Exception e) {
			{
				System.out.println("Error al escribir : " + e);
			}
		}
		
		return exito;
	}


}
