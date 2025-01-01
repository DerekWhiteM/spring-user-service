package com.example.user_service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorities")
@IdClass(AuthorityId.class)
public class Authority {
    @Id
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @Id
    @Column(nullable = false)
    private String authority;
    
}


