package com.dimata.service.general.controller;

import com.dimata.service.general.model.body.BukuBody;
import com.dimata.service.general.model.entity.Buku;
import com.dimata.service.general.service.BukuCrude;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Path("/api/buku")
public class BukuController {

    @Inject
    BukuCrude bukuCrude;

    @POST
    @Transactional
    public Buku createBuku(BukuBody body) {
        return bukuCrude.create(body);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Buku updateBuku(BukuBody body, @RestPath long id) {
        return bukuCrude.update(body, id);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteBuku(@RestPath long id) {
        Buku.deleteById(id);
    }

    @GET
    public List<Buku> findByAuthor(@RestQuery String author, @RestQuery int page) {
        if(page > 0) {
            return Buku.findByAuthorAndPage(author, page);
        }

        return Buku.findByAuthor(author);
    }
}
