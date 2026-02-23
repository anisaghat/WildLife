package model.dao;

import model.entities.Habitat;

import java.util.ArrayList;
import java.util.Objects;

public class HabitatDAO {

    private final ConnectDB connectDB;
    private final ArrayList<Habitat> habitatsList;


    public HabitatDAO() {
        this.connectDB = new ConnectDB();
        this.habitatsList = new ArrayList<>();
    }

    public HabitatDAO(ConnectDB connectDB) {
        this.connectDB = connectDB;
        this.habitatsList = new ArrayList<>();
    }

    public ArrayList<Habitat> getAllHabitats() {
        return this.habitatsList;
    }

    public Habitat getById(Integer id)
    {
        for(Habitat entity : habitatsList) {
            if (Objects.equals(entity.getId(), id)) {
                return entity;
            }
        }
        return null;
    }

    public ArrayList<Habitat> load()
    {
        return this.habitatsList;
    }

    public void save(Habitat habitat)
    {

    }

    public void delete(Habitat habitat) {
        if (habitat != null && habitat.getId() != null) {
            this.delete(habitat.getId());
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
