package com.github.Filmorum.controller;

import com.github.Filmorum.EMUtils;
import com.github.Filmorum.model.User;
import com.github.Filmorum.model.enums.ValidateSignup;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
public class UserController {

    EntityManager entityManager = EMUtils.getEntityManager();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<User> list(){
        List<User> users = null;

        return users;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public User get(@PathParam("id") Long id){
        User user = new User();

        return user;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(User user){
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response update(User user){
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login/{nickname}/{password}")
    public User login(@PathParam("nickname") String nickname, @PathParam("password") String password){
        List<User> listUsers = entityManager.createNativeQuery
                ("select * from users where " +
                        "nickname = '" + nickname + "'and password = '" + password + "'", User.class).getResultList();

        if(listUsers.size() != 0){
            return listUsers.get(0);
        } else {
            return null;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/validate/{nickname}/{email}")
    public ValidateSignup validate(@PathParam("nickname") String nickname, @PathParam("email") String email){
        ValidateSignup validateSignup = new ValidateSignup();
        List<User> validateIfNicknameExists = entityManager.createNativeQuery
                ("select * from users where " +
                        "nickname = '" + nickname + "'", User.class).getResultList();

        List<User> validateIfEmailExists = entityManager.createNativeQuery
                ("select * from users where " +
                        "email = '" + email + "'", User.class).getResultList();

        if(validateIfNicknameExists.size() > 0){
            validateSignup.setNicknameExists(true);
        }

        if(validateIfEmailExists.size() > 0){
            validateSignup.setEmailExists(true);
        }

        return validateSignup;
    }
}
