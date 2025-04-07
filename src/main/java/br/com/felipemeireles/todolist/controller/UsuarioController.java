package br.com.felipemeireles.todolist.controller;

import br.com.felipemeireles.todolist.model.UsuarioModel;
import br.com.felipemeireles.todolist.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/")
    public ResponseEntity criar(@RequestBody UsuarioModel usuarioModel){
        var usuario = usuarioRepository.findByNomeUsuario(usuarioModel.getNomeUsuario());

        //Validando se existe algum usuário com as mesmas informações.
        if (usuario != null){
            System.out.println("Usuário já existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }

        var usuarioCriado = usuarioRepository.save(usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
    }
}
