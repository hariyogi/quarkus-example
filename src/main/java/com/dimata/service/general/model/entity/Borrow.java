package com.dimata.service.general.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "borrow")
public class Borrow extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "borrow_id")
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buku_id")
    public Buku buku;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    public Member member;

    @CreationTimestamp
    @Column(name = "borrowed_at")
    public LocalDateTime borrowedAt;

    @Column(name = "due_at")
    public LocalDateTime dueAt;

    @Column(name = "late_fee")
    public Double lateFee;

    public static List<Borrow> findByBukuAuthor(String bukuAuthor) {
        return find("buku.author = ?1", bukuAuthor).list();
    }
}
