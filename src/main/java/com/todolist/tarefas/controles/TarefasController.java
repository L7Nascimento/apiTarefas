package com.todolist.tarefas.controles;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.tarefas.models.Tarefa;
import com.todolist.tarefas.repositories.TarefaRepository;





@RestController
@RequestMapping("/tarefas")
public class TarefasController {
    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping
    public List<Tarefa> listar(){
        return tarefaRepository.findAll();
    }
    @PostMapping // este método leva a anotação que carrega o HTTP POST e vara a requisição ao database
    public Tarefa adicionarTarefa(@RequestBody Tarefa tarefa) {
        // cria-se uma função publica do tipo Tarefa(model) chamada "adicionar tarefa"
        // que requisita o corpo da classe Tarefa e cria um objeto tarefa.
        // a função retonrna uma interface do tipo TarefaRepository chamado
        // terafeRepository que por sua vez salva os dados obtidos no objeto tarefa.
        
        return tarefaRepository.save(tarefa);
    }
    @GetMapping("/{id}")
    public Tarefa adicionarDetalhe(@PathVariable Long id) {
        Optional<Tarefa> tarefaDetalhe = tarefaRepository.findById(id);

        if( tarefaDetalhe.isPresent()){
            return tarefaDetalhe.get();
        }
        return null;
    }
    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
        Optional<Tarefa> tarefaExistente = tarefaRepository.findById(id);
        if(tarefaExistente.isPresent()){
            Tarefa tarefa = tarefaExistente.get();
                tarefa.setDescription(tarefaAtualizada.getDescription());
                tarefa.setStatus(tarefaAtualizada.getStatus());
            return tarefaRepository.save(tarefa);
        }
        return null;
    }
    
    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id){
        tarefaRepository.deleteById(id);
    }
    
    
    
    

}