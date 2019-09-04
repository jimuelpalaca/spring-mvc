package com.spring.mvc.model;

import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Data
@Table(name = "products")
public class Product implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private Instant created_at;

    private Instant updated_at;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
