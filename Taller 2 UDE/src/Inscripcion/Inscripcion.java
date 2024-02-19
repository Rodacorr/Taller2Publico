package Inscripcion;

public class Inscripcion {

	private int numero;
	private int anioLectivo;
	private float monto;
	private int calificacion;
	//private Asignatura asig;
	
	public Inscripcion (int num, int anio, float mon, int cal) {
		this.numero = num;
		this.anioLectivo = anio;
		this.monto = mon;
		this.calificacion = cal;
		//this.asig = as;
	}
	
	public int getNumero(){ 
		return numero; 
	}
	
	public int getAnioLectivo(){ 
		return anioLectivo; 
	}
	
	
	public float getMonto(){ 
		return monto; 
	}
	
	public int getCalificacion(){ 
		return calificacion; 
	}
	
	
	/*public Asignatura getAsignatura(){ 
		return asig; 
	}
	*/
	public void setCalificacion(){ 
		this.calificacion = 0;
	}
	
	/*public float calcularRecaudado(int x){ 
		
	}
	*/
}