/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Inteface.MotorbikeInterface;
import com.example.demo.Modelo.Motorbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */

@Repository

public class MotorbikeRepository {
     @Autowired
    private MotorbikeInterface extensionesCrud;
    
    public List<Motorbike> getAll(){
        return (List<Motorbike>) extensionesCrud.findAll();
    }
    
    public Optional<Motorbike> getMotorbike(int id){
        return extensionesCrud.findById(id);
    }
    
    public Motorbike save (Motorbike motorbike){
        return extensionesCrud.save(motorbike);
    } 
    
    public void delete (Motorbike motorbike){
        extensionesCrud.delete(motorbike);
    }
}
