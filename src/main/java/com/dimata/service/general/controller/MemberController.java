package com.dimata.service.general.controller;

import com.dimata.service.general.model.entity.Member;
import org.jboss.resteasy.reactive.RestQuery;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/api/member")
public class MemberController {

    @GET
    public List<Member> findByName(@RestQuery String name) {
        return Member.find("name = ?1", name ).list();
    }
}
