package com.aerochinquihue.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;

public class DataReader {
    public List<AssistantData> readData(String filepath) {
        List<AssistantData> assistantDataList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
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
        return assistantDataList;
    }
}