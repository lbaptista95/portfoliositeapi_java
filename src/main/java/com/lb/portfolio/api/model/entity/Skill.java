package com.lb.portfolio.api.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Skill implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skills_id_seq")
    @SequenceGenerator(name = "skills_id_seq", sequenceName = "skills_id_seq", allocationSize = 1)
    private Integer id;
    @Column(length = 200, nullable = false)
    private String name;
    // skill projects
}
