package model.dao;

import model.entities.animals.Animal;
import java.util.ArrayList;


public class AnimalDAO
{
    private final ConnectDB connectDB;
    private final ArrayList<Animal> animals;

    public AnimalDAO(ConnectDB connectDB) {
        this.connectDB = connectDB;
        this.animals = new ArrayList<>();
    }

    public AnimalDAO()
    {
        this.connectDB = new ConnectDB();
        this.animals = new ArrayList<>();
    }


}
