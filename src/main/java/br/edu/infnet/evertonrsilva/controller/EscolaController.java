package br.edu.infnet.evertonrsilva.controller;
import br.edu.infnet.evertonrsilva.model.domain.Endereco;
import br.edu.infnet.evertonrsilva.model.domain.Escola;
import br.edu.infnet.evertonrsilva.service.ViaCepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/escolas")
public class EscolaController {

    private final List<Escola> escolas = new ArrayList<>();

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping
    public List<Escola> getTodasEscolas() {
        return escolas;
    }
    
    
    @PostMapping
    public Escola createEscola(@RequestBody Escola escola) {
        String cep = escola.getEndereco().getCep();
        System.out.println(cep);
        Endereco endereco = viaCepService.getEnderecoComCodigo(cep);      
        if (endereco != null) {
            escola.setEndereco(endereco);
            escolas.add(escola);
        } else {
            throw new RuntimeException("Erro: Endereço não encontrado para o CEP fornecido.");
        }
        
        return escola;
    }

    @DeleteMapping("/{id}")
    public boolean deleteEscola(@PathVariable long id) {
        return escolas.removeIf(escolas -> escolas.getId() == id);
    }

    
}
