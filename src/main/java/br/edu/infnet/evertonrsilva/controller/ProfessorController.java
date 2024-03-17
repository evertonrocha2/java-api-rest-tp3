package br.edu.infnet.evertonrsilva.controller;

import br.edu.infnet.evertonrsilva.model.domain.Escola;
import br.edu.infnet.evertonrsilva.model.domain.Professor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final List<Professor> professores = new ArrayList<>();
    private final List<Escola> escolas = new ArrayList<>(); 
    
    @GetMapping
    public List<Professor> getTodosProfessores() {
        return professores;
    }
    
    
    @GetMapping(value = "/{escola}")
    public List<Professor> getProfessorPorEscola(@PathVariable String escola) {
        final List<Professor> professoresEscola = new ArrayList<>();
        for (Professor professor : professores) {
            if (professor.getEscola().getName().equals(escola)) {
                professoresEscola.add(professor);
            }
        }
        return professoresEscola;
    }	
    
    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
        professores.add(professor);
        return professor;
    }

    @DeleteMapping("/{id}")
    public boolean deleteProfessor(@PathVariable long id) {
        return professores.removeIf(professores -> professores.getId() == id);
    }
    
}
