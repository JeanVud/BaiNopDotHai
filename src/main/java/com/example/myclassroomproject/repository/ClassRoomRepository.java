/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.myclassroomproject.repository;

import com.example.myclassroomproject.model.ClassRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 8570w
 */
@Repository
public interface ClassRoomRepository extends MongoRepository<ClassRoom, String>{
    
}
