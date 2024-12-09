package com.aerochinquihue.db;

import java.sql.Connection;
import java.sql.DriverManager;
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
                data.setTipoEncomienda(rs.getString("tipoEncomienda"));
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
                data.setTipoEncomienda(rs.getString("tipoEncomienda"));
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
}
/*
 * backup
 * 
 * try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            String[] values;
            while ((values = reader.readNext()) != null) {
                if (values.length >= 14) {
                    AssistantData data = new AssistantData();
                    data.setNombre(values[0]);
                    data.setApellidos(values[1]);
                    data.setTelefono(values[2]);
                    data.setRut(values[3]);
                    data.setDireccion(values[4]);
                    data.setDestino(values[5]);
                    data.setFecha(values[6]);
                    data.setAvion(values[7]);  
                    data.setTipoEncomienda(values[8]);
                    data.setPeso(values[9]); 
                    data.setAsiento(values[10]);
                    data.setEmergencia(Boolean.parseBoolean(values[11]));
                    data.setDescuento(Integer.parseInt(values[12]));
                    data.setValorFinal(Integer.parseInt(values[13]));
                    
                    assistantDataList.add(data);
                } else {
                    System.out.println("Error: la linea leida no contiene suficientes columnas");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
 */