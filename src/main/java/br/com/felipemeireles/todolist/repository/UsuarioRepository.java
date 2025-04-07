package br.com.felipemeireles.todolist.repository;

import br.com.felipemeireles.todolist.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {

    UsuarioModel findByNomeUsuario(String nomeUsuario);
}
