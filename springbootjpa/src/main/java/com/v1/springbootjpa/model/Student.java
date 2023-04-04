package com.v1.springbootjpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
   private int id;
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
   private String lastName;

    @Column(name="email")
   private String email;


}
