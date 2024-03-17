package br.edu.infnet.evertonrsilva.model.domain;

public class Escola {
	
	private long id;
    private String name;
    private Endereco endereco;
    private String cep;

    public Escola() {}
    
    public Escola(long id, String name) {
    	this.id = id;
    	this.name = name;
    }
    
    public Escola(long id, String name, Endereco endereco, String cep ) {
    	this.id = id;
        this.name = name;
        this.endereco = endereco;
    }
    

    public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

	
    
}
