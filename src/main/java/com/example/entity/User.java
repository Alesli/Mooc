package com.example.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "user")
public class User implements Serializable {

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
