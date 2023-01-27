package com.dimata.service.general.model.entity;

import com.dimata.service.general.model.enums.MemberStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
public class Member extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "member_id")
    public Long id;

    @CreationTimestamp
    @Column(name = "created_at")
    public LocalDateTime createdAt;

    @CreationTimestamp
    @Column(name = "updated_at")
    public LocalDateTime updatedAt;

    @Column(name = "name")
    public String name;

    public String getName() {
        return name.toUpperCase();
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public String address;

    @Enumerated(EnumType.STRING)
    public MemberStatus status;

    public void setStatus(MemberStatus status) {
        if(status == null) {
            this.status = MemberStatus.ACTIVE;
        }

        this.status = status;
    }

}
