package model.authentication;

import java.io.*;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class MapAuthenticator extends Authenticator{
    final private Map<String, String> mapData = new HashMap<>();
    private final File file = new File("user.csv");


    public MapAuthenticator()
    {
        loadFromFile();
    }

    private void loadFromFile() {

        if(!file.exists())
        {
            System.out.println("ERREUR : le fichier n'existe pas");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",",2);

                if(parts.length == 2)
                {
                    mapData.put(parts[0],parts[1]);
                }
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException("ERREUR : chargement des utilisateurs failed");
        }

    }

    private void saveToFile()
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
        {
            for (Map.Entry<String,String> entry : mapData.entrySet())
            {
                writer.write(entry.getKey()+","+entry.getValue());
                writer.newLine();
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException("ERREUR : lors de l'écriture dans le fichier");
        }
    }

    @Override
    public boolean isLoginExists(String username)
    {
        return mapData.containsKey(username);
    }

    @Override
    public String getPassword(String username)
    {
        return mapData.get(username);
    }

    @Override
    public boolean register(String username, String password) {
        if (!mapData.containsKey(username)) {
            mapData.put(username, password);
            saveToFile();
            return true;
        }
        return false;
    }
}

// ici c une new hashmap à chaque fois mais faudrait en fait retenir les infos dans un fichier properties
