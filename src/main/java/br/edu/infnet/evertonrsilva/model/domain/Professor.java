package br.edu.infnet.evertonrsilva.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    
    private long id;
    private String name;
    private Escola escola;
    public Professor(long id, String name, Escola escola) {
        this.id = id;
        this.name = name;
        this.escola = escola;
    }
    
    public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    
}
