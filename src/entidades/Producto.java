package entidades;

public class Producto {

	private int idProducto;
    private String nombre;
    private Float valor;
    
    public Producto (int idProducto, String nombre, Float valor) {
    	this.idProducto=idProducto;
    	this.nombre=nombre;
    	this.valor=valor;
    }
    
    public String getNombre() {
		return nombre;
	}
	public void setNombre(String name) {
		this.nombre = name;
	}
	
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	
}
