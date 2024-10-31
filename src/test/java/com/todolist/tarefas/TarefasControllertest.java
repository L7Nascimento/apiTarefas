package com.todolist.tarefas;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.todolist.tarefas.controles.TarefasController;
import com.todolist.tarefas.models.Tarefa;
import com.todolist.tarefas.repositories.TarefaRepository;

@ExtendWith(MockitoExtension.class)
public class TarefasControllertest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefasController tarefasController;

    @Test
    public void testListar() {
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setId(1L);
        tarefa1.setDescription("Tarefa 1");
        tarefa1.setStatus(true);

        Tarefa tarefa2 = new Tarefa();
        tarefa2.setId(2L);
        tarefa2.setDescription("Tarefa 2");
        tarefa2.setStatus(false);

        List<Tarefa> tarefas = Arrays.asList(tarefa1, tarefa2);
        when(tarefaRepository.findAll()).thenReturn(tarefas);

        List<Tarefa> result = tarefasController.listar();
        assertEquals(2, result.size());
    }

    @Test
    public void testAdicionarTarefa() {
        Tarefa tarefa = new Tarefa();
        tarefa.setDescription("Nova Tarefa");
        tarefa.setStatus(false);

        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefa);

        Tarefa result = tarefasController.adicionarTarefa(tarefa);
        assertEquals("Nova Tarefa", result.getDescription());
    }

    @Test
    public void testAdicionarDetalhe() {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setDescription("Tarefa 1");
        tarefa.setStatus(true);

        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));

        Tarefa result = tarefasController.adicionarDetalhe(1L);
        assertEquals("Tarefa 1", result.getDescription());
    }

    @Test
    public void testAtualizarTarefa() {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setDescription("Tarefa Atualizada");
        tarefa.setStatus(true);

        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));
        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefa);

        Tarefa result = tarefasController.atualizarTarefa(1L, tarefa);
        assertEquals("Tarefa Atualizada", result.getDescription());
    }

    @Test
    public void testDeletarTarefa() {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setDescription("Tarefa 1");
        tarefa.setStatus(true);

        tarefasController.deletarTarefa(1L);
        assertEquals(Optional.empty(), tarefaRepository.findById(1L));
    }
}
