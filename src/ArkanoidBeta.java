import java.awt.event.MouseEvent;

import acm.program.*;
import acm.graphics.*;

public class ArkanoidBeta extends GraphicsProgram{
	

	private static int N_FILAS = 6;
	private static int N_COLUMNAS = 16;
	private static int ANCHO_LADRILLO = 800 / N_COLUMNAS;
	private static int ALTO_LADRILLO = 20;
	
	private static int ANCHO_PLATAFORMA = 120;
	private static int ALTO_PLATAFORMA = 20;
	
	private static int DIMENSION_PELOTA = 15;
	
	GRect plataforma = new GRect(ANCHO_PLATAFORMA, ALTO_PLATAFORMA);
	GOval pelota = new GOval(DIMENSION_PELOTA, DIMENSION_PELOTA);
	
	double pelotaX = 3;
	double pelotaY = -3;
	
	boolean gameOver = false;
	
	
	public void init(){
		setSize(800,600);
		addMouseListeners();
		crearLadrillos();
		crearPlataforma();
		crearPelota();
	}
	
	public void run(){
		while(true){
			pelota.move(pelotaX, pelotaY);
			chequeaColision();
			pause(20);
		}

		
	}
	
	private void chequeaColision(){
		if (chequeaColisionParedes()){
			//chequeo si toca con el cursor
			if(!chequeaCursor()){
				//chequeaLadrillos();
			}
		}

	}
	private boolean chequeaCursor(){
		if (getElementAt(pelota.getX(), pelota.getY()+DIMENSION_PELOTA)==plataforma){
			pelotaY = -pelotaY;	
		}
		else if (getElementAt(pelota.getX()+DIMENSION_PELOTA, pelota.getY()+DIMENSION_PELOTA)==plataforma){
			pelotaY = -pelotaY;	
		}
		else if (getElementAt(pelota.getX(), pelota.getY())==plataforma){
			pelotaX = -pelotaX;	
		}
		else if (getElementAt(pelota.getX()+DIMENSION_PELOTA, pelota.getY())==plataforma){
			pelotaX = -pelotaX;	
		}else {
			return false;
		} 
		return true;
	}
	
	
	private boolean chequeaColisionParedes(){
		boolean cabezazo = true;
		//si toca el techo
		if (pelota.getY() <= 0){
			pelotaY = -pelotaY;
			cabezazo = false;
		}

		//si toca la pared derecha
		if (pelota.getX() >= getWidth() - DIMENSION_PELOTA){
			pelotaX = -pelotaX;
			cabezazo = false;
		}

		//si toca la pared izquierda
		if (pelota.getX() <= 0){
			pelotaX = -pelotaX;
			cabezazo = false;
		}
		return cabezazo;
	}
	
	
	public void mouseMoved (MouseEvent evento){
		plataforma.setLocation(evento.getX(), 480);	
	}
	
	private void crearPelota(){
		double pelotaX = plataforma.getX() + ANCHO_PLATAFORMA;
		double pelotaY = plataforma.getY();
		
		
		add(pelota);
		pelota.setLocation(pelotaX, pelotaY);
	}
	
	private void pelotaMoved(){
		while(true){
		pelota.move(pelotaX, pelotaY);
		pause(4);
		}
	}
	
	private void crearPlataforma(){
		plataforma.setLocation(getWidth()/2 - ANCHO_PLATAFORMA/2, 480);
		add(plataforma);
		
		
	}
	
	private void crearLadrillos(){
		for ( int i =0; i<N_FILAS; i++){
			for( int j=0; j<N_COLUMNAS; j++){
				GRect ladrillo = new GRect(ANCHO_LADRILLO, ALTO_LADRILLO);
				add(ladrillo);
				ladrillo.setLocation(j*ANCHO_LADRILLO, i*ALTO_LADRILLO+40);
			}
		}
	}
}
