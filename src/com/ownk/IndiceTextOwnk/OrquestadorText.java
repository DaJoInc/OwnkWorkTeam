package com.ownk.IndiceTextOwnk;
import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrquestadorText {

	private static Scanner nombre;
	private static Scanner ruta;

	public static void main(String[] args) {
		
		String rutaBiblioteca="";
		String nombreUser="";
		String contenidoArchivos="";
		
		
		TextUtil metodos = new TextUtil();
		System.out.println("Ingrese su nombre");
		nombre = new Scanner(System.in);
		nombreUser = nombre.nextLine();
		System.out.println("Bienvenido " + nombreUser);
		System.out.println("Ingrese la ruta de su biblioteca");
		ruta = new Scanner(System.in);
		rutaBiblioteca= ruta.nextLine();
		
	/***************Listar Carpetas***********/				

		List<String> listadoDeArchivos= new ArrayList<String>();
		listadoDeArchivos= metodos.listaArchivos(rutaBiblioteca);
		for (String carpetas : listadoDeArchivos) {
			System.out.println(carpetas);
			
	/***************Listar Archivos en carpetas ***********/				

			String listarContenido = rutaBiblioteca+"\\"+carpetas;
			List<String> listadoDeArchivosEnCarpeta= new ArrayList<String>();
			listadoDeArchivosEnCarpeta = metodos.listaArchivosEnCarpeta(listarContenido);
				for (String libros : listadoDeArchivosEnCarpeta) {
					System.out.println(libros);
					File seleccionTexto=metodos.obtenerArchivo(listarContenido+"/"+libros);
					contenidoArchivos = contenidoArchivos + metodos.leerArchivo(seleccionTexto);
					System.out.println(contenidoArchivos);
					
	/***************Crear archivos indice_nombreLibro y carpeta libro_nombreUser ***********/		
					
					File directorio=new File(rutaBiblioteca+"/Libros__"+nombreUser); 
					directorio.mkdir(); 
					String nombreFinal= "Indice_"+libros+".txt";	
					metodos.crearArchivo(contenidoArchivos, nombreFinal,rutaBiblioteca+"/Libros__"+nombreUser);
					System.out.println("Se creo su archivo en la carpeta destino");					
			}	  
				
		}		
	}
}

		
		

