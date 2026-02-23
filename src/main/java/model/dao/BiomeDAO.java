package model.dao;

import model.entities.Biome;
import model.entities.animals.Animal;

import java.util.ArrayList;
import java.util.Objects;

public class BiomeDAO {

    private final ConnectDB connectDB;
    private final ArrayList<Biome> biomesList;


    public BiomeDAO() {
        this.connectDB = new ConnectDB();
        this.biomesList = new ArrayList<>();
    }

    public BiomeDAO(ConnectDB connectDB) {
        this.connectDB = connectDB;
        this.biomesList = new ArrayList<>();
    }

    public ArrayList<Biome> getAllBiomes() {
        return this.biomesList;
    }

    public Biome getById(Integer id)
    {
        for(Biome entity : biomesList) {
            if (Objects.equals(entity.getId(), id)) {
                return entity;
            }
        }
        return null;
    }

    public ArrayList<Biome> load()
    {
        return this.biomesList;
    }

    public void save(Biome biome)
    {

    }

    public void delete(Biome biome) {
        if (biome != null && biome.getId() != null) {
            this.delete(biome.getId());
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


