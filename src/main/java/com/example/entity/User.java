package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @Access(value = AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "full_name")
    private String fullName;

    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "login")
    private String login;
    @Basic
    @Column(name = "role")
    private String role;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_item",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"),
            foreignKey = @ForeignKey(name = "FK_user_id"))
    private List<Item> items;
}
