package com.aerochinquihue.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.aerochinquihue.model.AssistantData;

public class DataSaver {
    private static final String dbUrl = "jdbc:sqlite:test1.db";

    public static void saveViajeToDb(AssistantData assistantData, String asientosOcupados) {
        String sql = "INSERT INTO ViajeData (nombre, apellidos, telefono, rut, direccion, destino, fecha, avion, asientos, emergencia, descuento, valorFinal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(dbUrl); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, assistantData.getNombre());
            pstmt.setString(2, assistantData.getApellidos());
            pstmt.setString(3, assistantData.getTelefono());
            pstmt.setString(4, assistantData.getRut());
            pstmt.setString(5, assistantData.getDireccion());
            pstmt.setString(6, assistantData.getDestino());
            pstmt.setString(7, assistantData.getFecha());
            pstmt.setString(8, assistantData.getAvionSel());
            pstmt.setString(9, asientosOcupados);
            pstmt.setBoolean(10, assistantData.isEmergencia());
            pstmt.setInt(11, assistantData.getDescuento());
            pstmt.setInt(12, assistantData.getValorFinal());

            pstmt.executeUpdate();
            System.out.println("Datos guardados exitosamente en la base de datos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveEncomiendaToDb(AssistantData assistantData) {
        String sql = "INSERT INTO EncomiendaData (nombre, apellidos, telefono, rut, direccion, destino, fecha, avion, peso, remitente, emergencia, descuento, valorFinal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(dbUrl); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, assistantData.getNombre());
            pstmt.setString(2, assistantData.getApellidos());
            pstmt.setString(3, assistantData.getTelefono());
            pstmt.setString(4, assistantData.getRut());
            pstmt.setString(5, assistantData.getDireccion());
            pstmt.setString(6, assistantData.getDestino());
            pstmt.setString(7, assistantData.getFecha());
            pstmt.setString(8, assistantData.getAvionSel());
            pstmt.setString(9, assistantData.getPeso());
            pstmt.setString(10, assistantData.getRemitente()); // Add this line
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
