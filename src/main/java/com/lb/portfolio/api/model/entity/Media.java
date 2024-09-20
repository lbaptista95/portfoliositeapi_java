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
@Table(name = "media")
public class Media implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "media_id_seq")
    @SequenceGenerator(name = "media_id_seq", sequenceName = "media_id_seq", allocationSize = 1)
    private Integer id;
    @Column
    private String name;
    @Column(length = 50)
    private String type;
    @Column(nullable = false)
    private String url;
    // media projects
}
