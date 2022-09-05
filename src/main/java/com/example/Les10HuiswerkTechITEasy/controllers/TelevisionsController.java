package com.example.Les10HuiswerkTechITEasy.controllers;
import com.example.Les10HuiswerkTechITEasy.models.Television;
import com.example.Les10HuiswerkTechITEasy.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TelevisionsController {

    ArrayList<Television> allTelevisions = new ArrayList<>();

    @GetMapping("/allTelevisions")
    public ResponseEntity<Object> getTvs() {
        return ResponseEntity.ok(this.allTelevisions);
    }

    @GetMapping("/television")
    public ResponseEntity<Television> getTv(@RequestBody Television t) {
        return ResponseEntity.ok(t);
    }

    @PostMapping("/television")
    public ResponseEntity<Television> createTv(@RequestBody Television t) {

        this.allTelevisions.add(t);

        return ResponseEntity.created();
    }

    @PutMapping("/television/{id}")
    public ResponseEntity<Object> updateTv (@PathVariable int id, @RequestBody Television t){
        if(id < 0 || id >= allTelevisions.size()){
            throw new RecordNotFoundException("ID cannot be found");
        }

            this.allTelevisions.set(id, t);
            return ResponseEntity.noContent();
        }

    @DeleteMapping("/television/{id}")
    public ResponseEntity<Object> deleteTv (@PathVariable int id){
        if(id < 0 || id >= allTelevisions.size()){
            throw new RecordNotFoundException("ID cannot be found");
        }

            this.allTelevisions.remove(id);
            return ResponseEntity.noContent();
        }


    }


