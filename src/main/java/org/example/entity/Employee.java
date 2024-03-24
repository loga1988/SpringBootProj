package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import jakarta.validation.*;
import org.antlr.v4.runtime.misc.NotNull;

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
    //
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="name", nullable = false, length = 512, unique = true)
    @NotBlank(message = "Product name cannot be blank")
    @Pattern(regexp ="\\d{6}", message="ISBN string should be a 13 digit number")
    String name;
}
