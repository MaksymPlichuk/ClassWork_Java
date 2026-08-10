package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product_photos")
public class ProductPhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "url", nullable = false, length = 500)
    private String url;

    @Column(name = "is_main")
    private Boolean isMain = false;

    @ManyToOne(fetch = FetchType.LAZY)              //include
    @JoinColumn(name = "product_id", nullable = false) //назва у таблиці при посиланні
    private ProductEntity product;
}
