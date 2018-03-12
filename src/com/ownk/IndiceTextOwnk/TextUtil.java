package com.ownk.IndiceTextOwnk;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class TextUtil {
	
	

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
	
	/********Lista Adicional *******/	
	
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

  /********Ubicar archivo o carpeta individualmente*******/	

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
		/****Metodo para leer y obtener contenido de un archivo*****/
	
	public String leerArchivo(File archivo) {
			String texto="";
			String textoSiguiente="";
		try {
			FileReader lector=new FileReader(archivo);
			BufferedReader contenido=new BufferedReader(lector);
			while((texto=contenido.readLine())!=null)
			{		
								
					textoSiguiente=textoSiguiente+"\r\n"+texto;
					
		/******* Unsolved BUG ***********/
					
					/*String[] Lineas=texto.split(":");
					for (String lineasIndependientes : Lineas) {
						System.out.println(lineasIndependientes);
						String[] campo=lineasIndependientes[0];
						String[] contenidoCampo=lineasIndependientes[1];
						
					}*/
					
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
		
		catch (Exception e) 
			{
				System.out.println("Error al escribir : " + e);
		}
		
		return exito;
	}
}
