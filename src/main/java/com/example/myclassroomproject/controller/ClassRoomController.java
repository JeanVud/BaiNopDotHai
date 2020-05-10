package com.example.myclassroomproject.controller;

import com.example.myclassroomproject.model.ClassRoom;
import com.example.myclassroomproject.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 8570w
 */
@RestController
public class ClassRoomController {

    @Autowired
    private ClassRoomService service;    
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<ClassRoom> readAll() {
        return service.readAll();
    }
    
    //GET single item
    @GetMapping("/classroomrestful/{id}")
    public ClassRoom read(@PathVariable String id) {
        return service.read(id);
        
    }

    //POST create item
    //https://www.youtube.com/watch?v=8xiRQHqXADY
    @PostMapping("/classroomrestful")
    public ClassRoom create(@RequestBody ClassRoom newClassRoom) {
        return service.create(newClassRoom);
    }
    

    //PUT edit item
    @PutMapping("/classroomrestful/{id}")
    public ClassRoom update(@RequestBody ClassRoom edittedClassRoom, @PathVariable String id) {
        return service.update(edittedClassRoom, id);
    }

    // DELETE remove item
    @DeleteMapping("/classroomrestful/{id}")
    public void deleteById(@PathVariable String id) {
        service.delete(id);
    }
    
    @DeleteMapping("/del")
    public String deleteByJSon(@RequestBody ClassRoom cl ) {
        service.deleteUser(cl);
        return "deleted successfully";
    }
}
