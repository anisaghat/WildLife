package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB
{
    private static Connection conn = null;

    public connectDB() {
        if (conn == null) {
            try {

                String host = config.get("DB.HOST");
                String name = config.get("DB.NAME");
                String user = config.get("DB.USER");
                String pass = config.get("DB.PASSWORD");

                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
                System.out.println("Connexion BD établie avec succès !");
                    } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Erreur de connexion à la base de donnée");
            }
        }
    }

    public Connection getConn() {
        return conn;
    }

    public static void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("connexion à la base de donnée fermée");
            }
        } catch (SQLException e) {
            System.out.println("ERREUR : problème lors de la fermeture de la base de donnée");
        }
    }
}
