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
@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_id_seq")
    @SequenceGenerator(name = "usuarios_id_seq", sequenceName = "usuarios_id_seq", allocationSize = 1)
    private Integer id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 100)
    private String company;
    @Column(length = 100, nullable = false)
    private String password;
    @Column(length = 15)
    private String contact;
    @Column(name = "social_url")
    private String socialUrl;
    @Column(name = "email_confirmed")
    private Boolean emailConfirmed;
    @Column
    private String email;
}
