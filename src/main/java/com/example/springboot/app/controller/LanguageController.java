package com.example.springboot.app.controller;
import com.example.springboot.app.exception.Mensaje;
import com.example.springboot.app.model.Language;
import com.example.springboot.app.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    // FIND ALL - Metodo por GET y URL
    @GetMapping("/listalanguage")
    public ResponseEntity<?> getAllLanguage(){
        List<Language> lista = LanguageService.getAllLanguage();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin empleados en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(LanguageService.getAllLanguage());
    }

    // FIND BY ID - Definimos que a nuestro metodo se accede por peticion GET y por URL
    @GetMapping("/detallelanguage/{id}")
    public ResponseEntity<Language> getByLanguageId(@PathVariable long id) {
        return ResponseEntity.ok().body(this.languageService.getLanguageById(id));
    }

    // CREATE - Definimos que nuestro metodo solo para hacer uso de el, debe ser UNICAMENTE por POST
    @PostMapping("/crealanguage")
    public ResponseEntity<Language> createLanguage(@RequestBody Language language) {
        return ResponseEntity.ok().body(this.languageService.createLanguage(language));
    }

    // UPDATE - Para actualizar los datos de un empleado es a traves de la peticion PUT, realiza una actualizacion
    @PutMapping("/actualizalanguage/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable long id, @RequestBody Language language){
        language.setId(id);
        return ResponseEntity.ok().body(this.languageService.updateLanguage(language));
    }

    // DELETE - Para eliminar un language de DB, se hace por medio de la peticion DELETE, el id del prodcuto a eliminar
    @DeleteMapping("/eliminalanguage/{id}")
    public HttpStatus deleteLanguage(@PathVariable long id){
        this.languageService.deleteLanguage(id);
        return HttpStatus.OK;
    }
}
