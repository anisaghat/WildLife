package model.dao;

import model.entities.animals.Animal;
import java.util.ArrayList;
import java.util.Objects;


public class AnimalDAO
{
    private final ConnectDB connectDB;
    private final ArrayList<Animal> animalsList;

    public AnimalDAO(ConnectDB connectDB) {
        this.connectDB = connectDB;
        this.animalsList = new ArrayList<>();
    }

    public AnimalDAO()
    {
        this.connectDB = new ConnectDB();
        this.animalsList = new ArrayList<>();
    }

    public ArrayList<Animal> getAllAnimals()
    {
        return this.animalsList;
    }

    public Animal getById(Integer id)
    {
        for(Animal entity : animalsList) {
            if(Objects.equals(entity.getId(), id)) {
                return entity;
            }
        }
        return null;
    }

    public ArrayList<Animal> load()
    {
        // à voir ?? pcq dans le projet dasc c'est un peu plus poussé que les dao de deuxième

        ///  note c'est parce que j'utitlise une base de donnée alors que le projet de 2eme c'est juste des fichier.txt ou csv idk
        return this.animalsList;
    }

    public void save(Animal animal)
    {
        // à voir ?? pcq dans le projet dasc c'est un peu plus poussé que les dao de deuxième
        ///  note c'est parce que j'utitlise une base de donnée alors que le projet de 2eme c'est juste des fichier.txt ou csv idk
    }

    public void delete(Animal animal) {
        if (animal != null && animal.getId() != null) {
            this.delete(animal.getId());
        }
    }

    public void delete(Integer id)
    {
        if(id!= null)
        {
            // ici delete dans le base de donnée encore une fois mais à voir parce que idk yet
        }
    }




}
