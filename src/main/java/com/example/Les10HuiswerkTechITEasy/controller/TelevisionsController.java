package com.example.Les10HuiswerkTechITEasy.controller;


import com.example.Les10HuiswerkTechITEasy.products.Tv;
import com.example.Les10HuiswerkTechITEasy.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TelevisionsController {

    ArrayList<Tv> allTvs = new ArrayList<>();

    @GetMapping("/allTvs")
    public ResponseEntity<Object> getTvs() {
        return ResponseEntity.ok(this.allTvs);
    }

    @GetMapping("/tv")
    public ResponseEntity<Tv> getTv(@RequestBody Tv t) {
        return ResponseEntity.ok(t);
    }

    @PostMapping("/tv")
    public ResponseEntity<Tv> createTv(@RequestBody Tv t) {

        this.allTvs.add(t);

        return ResponseEntity.created();
    }

    @PutMapping("/tv/{id}")
    public ResponseEntity<Object> updateTv (@PathVariable int id, @RequestBody Tv t){
        if(id < 0 || id >= allTvs.size()){
            throw new RecordNotFoundException("ID cannot be found");
        }

            this.allTvs.set(id, t);
            return ResponseEntity.noContent();
        }

    @DeleteMapping("/tv/{id}")
    public ResponseEntity<Object> deleteTv (@PathVariable int id){
        if(id < 0 || id >= allTvs.size()){
            throw new RecordNotFoundException("ID cannot be found");
        }

            this.allTvs.remove(id);
            return ResponseEntity.noContent();
        }

    }


