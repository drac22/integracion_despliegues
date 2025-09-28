package com.integration.integracion_despliegues.controller;

import org.springframework.web.bind.annotation.RestController;

import com.integration.integracion_despliegues.Service.ServiceUserImpl;
import com.integration.integracion_despliegues.models.User;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController {

    private ServiceUserImpl serviceUserImpl;

    public UserController(ServiceUserImpl serviceUserImpl){
        this.serviceUserImpl = serviceUserImpl;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<User>> usuarios() {
        List<User> usuarios = serviceUserImpl.usuarios();
        if (usuarios.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(usuarios, HttpStatus.OK); 
    }

    @PostMapping("/createUsuario")
    public ResponseEntity<User> crearUsuario(@RequestBody User user) {
        User usuario_nuevo = serviceUserImpl.createUser(user);
        return new ResponseEntity<>(usuario_nuevo, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteUsuarioById(@PathVariable int id){
        if (serviceUserImpl.deleteUser(id)) {
            
            return new ResponseEntity<>("Usuario Eliminado", HttpStatus.OK);
        }
        return new ResponseEntity<>("Usuario no eliminado", HttpStatus.BAD_REQUEST);
    }
    
}
