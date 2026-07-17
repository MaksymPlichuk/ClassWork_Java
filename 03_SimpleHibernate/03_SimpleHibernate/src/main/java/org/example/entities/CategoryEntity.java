package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.time.LocalDateTime;

@Data
@Entity //означ що це таблиця у БД
@Table(name="tblCategories")    //Назва таблиці
public class CategoryEntity {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //атвоінкремент
    private int id;

    @Column(length=150, nullable=false)
    private String name;

    @Column(name="date_created", nullable = false)
    private LocalDateTime dateCreated;

    public CategoryEntity() {
        this.dateCreated = LocalDateTime.now();
    }

    public CategoryEntity(String name) {
        //super();
        this.dateCreated = LocalDateTime.now();
        this.name = name;
    }
}
