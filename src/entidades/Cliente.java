package entidades;

public class Cliente {

	private int id;
    private String name;
    private String email;
    
    public Cliente (int idCliente, String name, String email) {
    	this.id=idCliente;
    	this.name=name;
    	this.email=email;
    }

	public int getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
