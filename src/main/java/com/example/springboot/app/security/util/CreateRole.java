package com.example.springboot.app.security.util;

import com.example.springboot.app.security.entity.Rol;
import com.example.springboot.app.security.enums.RolNombre;
import com.example.springboot.app.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
// Crea los roles de la tabla
@Component
public class CreateRole implements CommandLineRunner {
    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        Optional<Rol> radm = rolService.getByRolNombre(RolNombre.ROLE_ADMIN);
        Optional<Rol> ruse = rolService.getByRolNombre(RolNombre.ROLE_USER);

        if(radm.isPresent()){
            System.out.println("Ya esta registrado el rol de admin");
        }else {
            rolService.save(rolAdmin);
        }
        if (ruse.isPresent()){
            System.out.println("Ya esta registrado el rol de usuario");
        }else {
            rolService.save(rolUser);
        }
    }
}
