package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Id
    @Column(name="id")
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="name")
    String name;
}
