package org.example.resources;

import org.example.database.DbUtil;
import org.example.models.Animal;
import org.example.repositories.AnimalRepository;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("animals")
public class AnimalsResource {

    AnimalRepository animalRepository;

    {
        try {
            animalRepository = new AnimalRepository();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Animal> getAnimal() throws SQLException {

        return animalRepository.getanimals();
    }

    @POST
    @Path("animal")
    public Animal createAnimal(Animal animal){

        System.out.println(animal);
        animalRepository.create(animal);
        return animal;
    }

}
