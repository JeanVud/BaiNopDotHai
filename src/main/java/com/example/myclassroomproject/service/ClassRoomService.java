/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.myclassroomproject.service;

import com.example.myclassroomproject.repository.ClassRoomRepository;
import com.example.myclassroomproject.model.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author 8570w
 */
@Service
public class ClassRoomService {
    
    @Autowired
    private ClassRoomRepository repository;
    
    //GET list items
    
    public Iterable<ClassRoom> readAll() {
        return repository.findAll();
    }

    //GET single item
    
    public ClassRoom read(@PathVariable String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    //POST create item
    
    public ClassRoom create(ClassRoom newClassRoom) {
        return repository.save(newClassRoom);
    }

    //PUT edit item 
    
    public ClassRoom update(@RequestBody ClassRoom edittedClassRoom, @PathVariable String id) {
        return repository.findById(id)
                .map(classroom -> {
                    classroom.setName(edittedClassRoom.getName());
                    classroom.setTeacher(edittedClassRoom.getTeacher());
                    classroom.setAmount(edittedClassRoom.getAmount());
                    return repository.save(classroom);
                })
                .orElseGet(() -> {
                    edittedClassRoom.setId(id);
                    return repository.save(edittedClassRoom);
                });
    }

    // DELETE remove item
    
    public void delete(String id) {
        repository.deleteById(id);
    }

    public void deleteUser(ClassRoom cl) {
        repository.delete(cl);
    }
}
