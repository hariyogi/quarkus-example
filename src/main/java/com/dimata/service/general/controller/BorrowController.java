package com.dimata.service.general.controller;

import com.dimata.service.general.model.entity.Borrow;
import com.dimata.service.general.model.entity.BorrowBody;
import com.dimata.service.general.model.entity.Member;
import com.dimata.service.general.service.BorrowCrude;
import org.jboss.resteasy.reactive.RestQuery;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/api/borrow")
public class BorrowController {

    @Inject
    BorrowCrude borrowCrude;

    @POST
    @Transactional
    public Borrow createBorrow(BorrowBody body) {
        return borrowCrude.create(body);
    }

    @GET
    public List<Borrow> get(@RestQuery String bukuAuthor) {
        return Borrow.findByBukuAuthor(bukuAuthor);
    }

    @GET
    @Path("/lazy")
    public Member getLaxy() {
        var borrow = (Borrow) Borrow.findById(846099763345280L);
        return null;
    }
}
