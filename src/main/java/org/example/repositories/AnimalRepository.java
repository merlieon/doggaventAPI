package org.example.repositories;

import org.example.database.DbUtil;
import org.example.models.Animal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnimalRepository {

    List<Animal> animalList;
    DbUtil dbUtil = new DbUtil();
    Connection con = dbUtil.getConnection();

    Statement statm;
     public AnimalRepository() throws SQLException {
        animalList = new ArrayList<>();

        statm = con.createStatement();

        ResultSet rs = statm.executeQuery("SELECT * FROM animals");
        animalList = new ArrayList<>();
        while (rs.next()){
            animalList.add(new Animal(rs.getInt("id"), rs.getString("animal_name"), rs.getString("animal_description"),rs.getInt("animal_type_id")));
        }
    }

    public List<Animal> getanimals(){
        return animalList;
    }

    public Animal getAnimal(int id){
        Animal a1 = null;

        for (Animal a : animalList){
            if (a.getId()==id){
                return a;
            }
        }
        return new Animal();
    }

    public void create(Animal animal) {
         animalList.add(animal);
    }
}
