/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.myclassroomproject.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author 8570w
 */
@Document(collection = "tbclassroom")
public class ClassRoom implements Serializable {
    
    public ClassRoom(String id, String name, String teacher, int amount) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.amount = amount;
    }
    @Field("id")
    private String id;
    @Field("name")
    private String name;
    @Field("teacher")
    private String teacher;
    @Field("amount")
    private int amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getAmount() {
        return amount;
    }

    
}
