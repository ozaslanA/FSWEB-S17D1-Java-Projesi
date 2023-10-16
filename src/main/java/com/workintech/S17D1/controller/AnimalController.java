package com.workintech.S17D1.controller;

import com.workintech.S17D1.entitty.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping
public class AnimalController {

    private Map<Integer, Animal> animals;

    @PostConstruct
    public void init(){
       animals =new HashMap<>();

    }

    public AnimalController(){
        System.out.println("Animal created");
    }
    @GetMapping("/")
    public List<Animal> findAll(){
        return animals.values().stream().toList();
    }


    @GetMapping("/{id}")
        public Animal find(@PathVariable int id){
        return animals.get(id);
    }


    @PostMapping("/")
    public Animal save(@RequestBody Animal animal){
        animals.put(animal.getId(),animal);
        return  animals.get(animal.getId());
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable int id,)
}
