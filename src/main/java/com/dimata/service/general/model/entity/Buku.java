package com.dimata.service.general.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "buku")
public class Buku extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "buku_id")
    public Long id;

    @CreationTimestamp
    @Column(name = "created_at")
    public LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    public LocalDateTime updatedAt;

    public String name;

    public String author;

    public Integer page;

//    Active Record

    public static List<Buku> findByAuthor(String author) {
        // select b from Buku b where b.author = ?1
        return find("author = ?1", author).list();
    }

    public static List<Buku> findByAuthorAndPage(String author, int page) {
        // select b from Buku b where b.author = ?1 and page ?2
        return find("author = ?1 and page = ?2", author, page).list();
    }
}
