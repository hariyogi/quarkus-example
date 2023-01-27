package com.dimata.service.general.service;

import com.dimata.service.general.model.entity.Borrow;
import com.dimata.service.general.model.entity.BorrowBody;
import com.dimata.service.general.model.entity.Buku;
import com.dimata.service.general.model.entity.Member;

import javax.enterprise.context.ApplicationScoped;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
public class BorrowCrude {

    public Borrow create(BorrowBody body) {
        Objects.requireNonNull(body);

        // TODO var itu shorthand
        var member = Member.findByIdOptional(body.memberId())
                .map(Member.class::cast)
                .orElseThrow();

        var buku = Buku.findByIdOptional(body.bukuId())
                .map(Buku.class::cast)
                .orElseThrow();

        var borrow = new Borrow();
        borrow.buku = buku;
        borrow.member = member;
        borrow.lateFee = body.lateFee();
        borrow.persist();

        return borrow;
    }
}
