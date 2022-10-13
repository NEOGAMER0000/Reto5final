/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Motorbike;
import com.example.demo.Repositorio.MotorbikeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service

public class MotorbikeService {
    @Autowired
    private MotorbikeRepository motorbikeRepository;
    
    public List<Motorbike> getAll(){
        return motorbikeRepository.getAll();
    }
    
    public Optional<Motorbike> getMotorbike(int id){
        return motorbikeRepository.getMotorbike(id);
    }
    
     public Motorbike save(Motorbike motorbike){
        if ( motorbike.getId()== null){
            return motorbikeRepository.save(motorbike);
        }else{
            Optional<Motorbike> motorbike1 = motorbikeRepository.getMotorbike(motorbike.getId());
            if(motorbike1.isEmpty()){
                return motorbikeRepository.save(motorbike);
            }else{
                return motorbike;
            }
        }
    }
     
       public Motorbike update(Motorbike motorbike){
        if(motorbike.getId()!=null){
            Optional<Motorbike> e= motorbikeRepository.getMotorbike(motorbike.getId());
            if(!e.isEmpty()){
                if(motorbike.getName()!=null){
                    e.get().setName(motorbike.getName());
                }
                if(motorbike.getHotel()!=null){
                    e.get().setHotel(motorbike.getHotel());
                }
                if(motorbike.getStars()!=null){
                    e.get().setStars(motorbike.getStars());
                }
                if(motorbike.getDescription()!=null){
                    e.get().setDescription(motorbike.getDescription());
                }
                if(motorbike.getCategory()!=null){
                    e.get().setCategory(motorbike.getCategory());
                }
                motorbikeRepository.save(e.get());
                return e.get();
            }else{
                return motorbike;
            }
        }else{
            return motorbike;
        }
    }
     
        public boolean deleteMotorbike(int id){
        Boolean d = getMotorbike(id).map(motorbike -> {
            motorbikeRepository.delete(motorbike);
            return true;
        }).orElse(false);
        return d;
    }
}
