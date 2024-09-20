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
@Table(name = "projects")
public class Project implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projetos_id_seq")
    @SequenceGenerator(name = "projetos_id_seq", sequenceName = "projetos_id_seq", allocationSize = 1)
    private Integer id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(name = "start_date", length = 100)
    private String startDate;
    @Column(name = "end_date", nullable = false)
    private String endDate;
    @Column(length = 100)
    private String client;
    @Column(length = 1000)
    private String description;
    @Column(length = 50)
    private String company;

    // media projects - skill projects
}
