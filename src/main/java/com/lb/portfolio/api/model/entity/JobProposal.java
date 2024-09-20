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
@Table(name = "job_proposals")
public class JobProposal implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "propostas_trabalho_id_seq")
    @SequenceGenerator(name = "propostas_trabalho_id_seq", sequenceName = "propostas_trabalho_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(length = 100)
    private String email;
    @Column(name = "recruiter_name", length = 100)
    private String recruiterName;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(name = "seniority_level", length = 50)
    private String seniorityLevel;
    @Column(length = 50)
    private String salary;
    @Column(length = 50)
    private String schedule;
    @Column(nullable = false)
    private String description;
    @Column
    private String requirements;
    @Column
    private String benefits;

    // 1-1, 1-y, y-1?
    // private User user;
}
