package com.aerochinquihue.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBInitializer {
    private static final String dbUrl = "jdbc:sqlite:test1.db";

    public static void createTable() {
        String sqlCreateEncomiendaData = "CREATE TABLE IF NOT EXISTS EncomiendaData ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nombre TEXT NOT NULL,"
                + "apellidos TEXT NOT NULL,"
                + "telefono TEXT NOT NULL,"
                + "rut TEXT NOT NULL,"
                + "direccion TEXT NOT NULL,"
                + "destino TEXT NOT NULL,"
                + "fecha TEXT NOT NULL,"
                + "avion TEXT NOT NULL,"
                + "peso TEXT NOT NULL,"
                + "remitente TEXT NOT NULL,"
                + "emergencia BOOLEAN NOT NULL,"
                + "descuento INTEGER NOT NULL,"
                + "valorFinal INTEGER NOT NULL"
                + ");";

        String sqlCreateViajeData = "CREATE TABLE IF NOT EXISTS ViajeData ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nombre TEXT NOT NULL,"
                + "apellidos TEXT NOT NULL,"
                + "telefono TEXT NOT NULL,"
                + "rut TEXT NOT NULL,"
                + "direccion TEXT NOT NULL,"
                + "destino TEXT NOT NULL,"
                + "fecha TEXT NOT NULL,"
                + "avion TEXT NOT NULL,"
                + "asientos TEXT NOT NULL,"
                + "emergencia BOOLEAN NOT NULL,"
                + "descuento INTEGER NOT NULL,"
                + "valorFinal INTEGER NOT NULL"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(dbUrl);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCreateViajeData);
            stmt.execute(sqlCreateEncomiendaData);
            System.out.println("Tabla AssistantData creada exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
