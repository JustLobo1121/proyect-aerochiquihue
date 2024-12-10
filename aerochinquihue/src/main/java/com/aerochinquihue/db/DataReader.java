package com.aerochinquihue.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aerochinquihue.model.AssistantData;
import com.aerochinquihue.model.EncomiendaData;
import com.aerochinquihue.model.ViajeData;

public class DataReader {
    private static final String dbUrl = "jdbc:sqlite:test1.db";

    public List<AssistantData> readData(String filepath) {
        List<AssistantData> assistantDataList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(dbUrl); Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery("SELECT * FROM AssistantData")) {

            while (rs.next()) {
                AssistantData data = new AssistantData();
                data.setNombre(rs.getString("nombre"));
                data.setApellidos(rs.getString("apellidos"));
                data.setTelefono(rs.getString("telefono"));
                data.setRut(rs.getString("rut"));
                data.setDireccion(rs.getString("direccion"));
                data.setDestino(rs.getString("destino"));
                data.setFecha(rs.getString("fecha"));
                data.setAvion(rs.getString("avion"));
                data.setTipoEncomienda(rs.getString("tipoEncomienda"));
                data.setPeso(rs.getString("peso"));
                data.setAsiento(rs.getString("asiento"));
                data.setEmergencia(rs.getBoolean("emergencia"));
                data.setDescuento(rs.getInt("descuento"));
                data.setValorFinal(rs.getInt("valorFinal"));

                assistantDataList.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return assistantDataList;
    }
    
    public List<ViajeData> readDataViaje() {
        List<ViajeData> viajeDataList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(dbUrl); Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery("SELECT * FROM ViajeData")) {
            while (rs.next()) {
                ViajeData data = new ViajeData();
                data.setNombre(rs.getString("nombre"));
                data.setApellidos(rs.getString("apellidos"));
                data.setTelefono(rs.getString("telefono"));
                data.setRut(rs.getString("rut"));
                data.setDireccion(rs.getString("direccion"));
                data.setDestino(rs.getString("destino"));
                data.setFecha(rs.getString("fecha"));
                data.setAvion(rs.getString("avion"));
                data.setAsiento(rs.getString("asientos"));
                data.setEmergencia(rs.getBoolean("emergencia"));
                data.setDescuento(rs.getInt("descuento"));
                data.setValorFinal(rs.getInt("valorFinal"));

                viajeDataList.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return viajeDataList;
    }
    public List<EncomiendaData> readDataEncomienda() {
        List<EncomiendaData> encomiendaDataList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(dbUrl); Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery("SELECT * FROM EncomiendaData")) {

            while (rs.next()) {
                EncomiendaData data = new EncomiendaData();
                data.setNombre(rs.getString("nombre"));
                data.setApellidos(rs.getString("apellidos"));
                data.setTelefono(rs.getString("telefono"));
                data.setRut(rs.getString("rut"));
                data.setDireccion(rs.getString("direccion"));
                data.setDestino(rs.getString("destino"));
                data.setFecha(rs.getString("fecha"));
                data.setAvion(rs.getString("avion"));
                data.setPeso(rs.getString("peso"));
                data.setEmergencia(rs.getBoolean("emergencia"));
                data.setDescuento(rs.getInt("descuento"));
                data.setValorFinal(rs.getInt("valorFinal"));

                encomiendaDataList.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encomiendaDataList;
    }
    
    public void updateViaje(ViajeData viajeData) {
        String sql = "UPDATE ViajeData SET descuento = ?, valorFinal = ? WHERE rut = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, viajeData.getDescuento());
            pstmt.setInt(2, viajeData.getValorFinal());
            pstmt.setString(3, viajeData.getRut());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteViaje(String rut) {
        String sql = "DELETE FROM ViajeData WHERE rut = ?";
    
        try (Connection conn = DriverManager.getConnection(dbUrl); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, rut);
    
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateEncomienda(EncomiendaData encomiendaData) {
        String sql = "UPDATE EncomiendaData SET peso = ?, descuento = ?, valorFinal = ? WHERE rut = ?";
    
        try (Connection conn = DriverManager.getConnection(dbUrl); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, encomiendaData.getPeso());
            pstmt.setInt(2, encomiendaData.getDescuento());
            pstmt.setInt(3, encomiendaData.getValorFinal());
            pstmt.setString(4, encomiendaData.getRut());
    
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteEncomienda(String rut) {
        String sql = "DELETE FROM EncomiendaData WHERE rut = ?";
    
        try (Connection conn = DriverManager.getConnection(dbUrl); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, rut);
    
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}