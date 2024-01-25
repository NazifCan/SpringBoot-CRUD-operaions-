package com.nazifcankabakcioglu.springbootrestapi.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity {
    private Date createdAt;
    private String createdBy;


    private Date updatedAt;

    private String updatedBy;
}
