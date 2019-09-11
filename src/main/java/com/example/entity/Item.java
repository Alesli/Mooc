package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "item")
public class Item implements Serializable {


    @Id
    @Column(name = "id")
    @Access(value = AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description", columnDefinition = "mediumtext")
    private String description;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_item",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            foreignKey = @ForeignKey(name = "FK_item_id"))
    private List<User> users;
}
