package com.agrodelas.agrodelas.controller;


import com.agrodelas.agrodelas.model.Usuario;
import com.agrodelas.agrodelas.model.UsuarioLogin;
import com.agrodelas.agrodelas.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/all")
    public ResponseEntity <List<Usuario>> getAll(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getId (@PathVariable Long id){
        return usuarioRepository.findById(id)
                .map(respota -> ResponseEntity.ok(respota))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/logar")
    public  ResponseEntity<UsuarioLogin> login(@RequestBody Optional<UsuarioLogin> usuarioLogin){
        return usuarioService.autenticarUsuario(usuarioLogin)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse (ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> postUsuario(@Valid @RequestBody Usuario usuario){
        return usuarioService.cadastrarUsuario(usuario)
                .map(respota -> ResponseEntity.status(HttpStatus.CREATED).body(respota))
                        .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());


    }

    @PutMapping("/atualizar")
    public ResponseEntity<Usuario> putUsuario (@Valid @RequestBody Usuario usuario){
        return usuarioService.atualizarUsuario(usuario)
                .map(respota -> ResponseEntity.status(HttpStatus.OK).body(respota))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
