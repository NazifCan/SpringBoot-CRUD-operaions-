package com.nazifcankabakcioglu.springbootrestapi.Entity;


import com.nazifcankabakcioglu.springbootrestapi.BaseEntity.BaseEntity;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Users")
@Data
public class User extends BaseEntity {

    @Id
    @GeneratedValue(generator = "user-gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user-gen",allocationSize = 100,initialValue = 100)
    private long id;


    @Column(name = "ad",length = 50,nullable = false)
    private String firstName;
    @Column(name = "soyad",length = 50,nullable = false)
    private String lastName;
}
