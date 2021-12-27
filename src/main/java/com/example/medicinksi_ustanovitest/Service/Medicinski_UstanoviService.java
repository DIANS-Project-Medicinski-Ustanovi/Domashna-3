package com.example.medicinksi_ustanovitest.Service;

import com.example.medicinksi_ustanovitest.Model.Medicinska_Ustanova;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface Medicinski_UstanoviService {

    public List<Medicinska_Ustanova> findAllMedicinskiUstanovi();

    public List<Medicinska_Ustanova> findAllCovid19TestingLabs();

    public Optional<Medicinska_Ustanova> findById(int id);

    public Integer all();

    public Integer covid();

    List<Medicinska_Ustanova> findAllByCategory(String category);

    List<Medicinska_Ustanova> findAllByCity(String city);

    List<Medicinska_Ustanova> findAllNotCovid19Testing();

    List<Medicinska_Ustanova> getMedicalLabsByFilter(String category, String city, String covid19Test);

    List<String> getAllCities();

    List<String> getAllCategories();

    public HashMap<Integer, Medicinska_Ustanova> FilterdMedUstanovi(String category, String city, String covid19Test);

}