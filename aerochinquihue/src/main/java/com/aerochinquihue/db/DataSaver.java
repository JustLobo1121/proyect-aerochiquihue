package com.aerochinquihue.db;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.aerochinquihue.model.AssistantData;

public class DataSaver {
    private static final String dbUrl = "jdbc:sqlite:test1.db";

    public static void saveToFile(AssistantData assistantData, String filePath, String asientosOcupados) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
            // String hashVuelo = assistantData.generateHash();
            String line = String.join(",",
                assistantData.getNombre(),
                assistantData.getApellidos(),
                assistantData.getTelefono(),
                assistantData.getRut(),
                assistantData.getDireccion(),
                assistantData.getDestino(),
                assistantData.getFecha(),
                assistantData.getAvionSel(),
                assistantData.getTipoEncomienda(),
                assistantData.getPeso(),
                String.valueOf(assistantData.getAsiento()),
                String.valueOf(assistantData.isEmergencia()),
                String.valueOf(assistantData.getDescuento()),
                String.valueOf(assistantData.getValorFinal()),
                asientosOcupados
            );
            writer.write(line);
            writer.newLine();
            System.out.println("Datos guardados exitosamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveViajeToDb(AssistantData assistantData, String asientosOcupados) {
        String sql = "INSERT INTO ViajeData (nombre, apellidos, telefono, rut, direccion, destino, fecha, avion, tipoEncomienda, asientos, emergencia, descuento, valorFinal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(dbUrl); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, assistantData.getNombre());
            pstmt.setString(2, assistantData.getApellidos());
            pstmt.setString(3, assistantData.getTelefono());
            pstmt.setString(4, assistantData.getRut());
            pstmt.setString(5, assistantData.getDireccion());
            pstmt.setString(6, assistantData.getDestino());
            pstmt.setString(7, assistantData.getFecha());
            pstmt.setString(8, assistantData.getAvionSel());
            pstmt.setString(9, assistantData.getTipoEncomienda());
            pstmt.setString(10, asientosOcupados);
            pstmt.setBoolean(11, assistantData.isEmergencia());
            pstmt.setInt(12, assistantData.getDescuento());
            pstmt.setInt(13, assistantData.getValorFinal());

            pstmt.executeUpdate();
            System.out.println("Datos guardados exitosamente en la base de datos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveEncomiendaToDb(AssistantData assistantData) {
        String sql = "INSERT INTO ViajeData (nombre, apellidos, telefono, rut, direccion, destino, fecha, avion, tipoEncomienda, peso, emergencia, descuento, valorFinal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(dbUrl); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, assistantData.getNombre());
            pstmt.setString(2, assistantData.getApellidos());
            pstmt.setString(3, assistantData.getTelefono());
            pstmt.setString(4, assistantData.getRut());
            pstmt.setString(5, assistantData.getDireccion());
            pstmt.setString(6, assistantData.getDestino());
            pstmt.setString(7, assistantData.getFecha());
            pstmt.setString(8, assistantData.getAvionSel());
            pstmt.setString(9, assistantData.getTipoEncomienda());
            pstmt.setString(10, assistantData.getPeso());
            pstmt.setBoolean(11, assistantData.isEmergencia());
            pstmt.setInt(12, assistantData.getDescuento());
            pstmt.setInt(13, assistantData.getValorFinal());

            pstmt.executeUpdate();
            System.out.println("Datos guardados exitosamente en la base de datos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
