import acm.program.*;
import acm.graphics.*;

public class ArkanoidBeta extends GraphicsProgram{
	
	public void init(){
		setSize(800,600);
	}
	
	public void run(){
		crearLadrillos();
	}
	
	
	private static int N_FILAS = 6;
	private static int N_COLUMNAS = 16;

	private static int ALTO_LADRILLO = 20;
	
	public void crearLadrillos(){
		int ANCHO_LADRILLO = getWidth()/N_COLUMNAS;
		for ( int i =0; i<N_FILAS; i++){
			for( int j=0; j<N_COLUMNAS; j++){
				GRect ladrillo = new GRect(ANCHO_LADRILLO, ALTO_LADRILLO);
				add(ladrillo);
				ladrillo.setLocation(j*ANCHO_LADRILLO, i*ALTO_LADRILLO+40);
				pause(100);
			}
		}
	}
}
