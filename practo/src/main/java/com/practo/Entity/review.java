package com.practo.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="reviews")

public class review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long patientId;
    private long doctorId;
    private int rating;
    private String description;
}
