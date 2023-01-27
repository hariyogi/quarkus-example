package com.dimata.service.general.service;

import com.dimata.service.general.model.body.BukuBody;
import com.dimata.service.general.model.entity.Buku;

import javax.enterprise.context.ApplicationScoped;
import java.util.Objects;

@ApplicationScoped
public class BukuCrude {

    public Buku create(BukuBody body) {
        Objects.requireNonNull(body);

        if(!body.isValid()) {
            throw new IllegalArgumentException("Ini gak valid sat");
        }

        var buku = new Buku();
        buku.name = body.name();
        buku.author = body.author();
        buku.page = body.page();
        buku.persist();
        return buku;
    }

    public Buku update(BukuBody body, long bukuId) {
        Objects.requireNonNull(body);

        var buku = Buku.findByIdOptional(bukuId)
                .map(Buku.class::cast)
                .orElseThrow(() -> new NullPointerException("Bukunya gak ada sat"));

        // Mode presistent

        if(body.name() != null) {
            buku.name = body.name();
        }

        if(body.page() != null) {
            buku.page = body.page();
        }

        if(body.author() != null) {
            buku.author = body.author();
        }

        return buku;
    }
}
