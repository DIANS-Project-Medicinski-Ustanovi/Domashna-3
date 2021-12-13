package com.example.medicinksi_ustanovitest.Service;

import com.example.medicinksi_ustanovitest.Model.Medicinska_Ustanova;

import java.util.List;
import java.util.Optional;

public interface Medicinski_UstanoviService {

    public List<Medicinska_Ustanova> findAllMedicinskiUstanovi();

    public List<Medicinska_Ustanova> findAllCovid19TestingLabs();

    public Optional<Medicinska_Ustanova> findById(int id);

    public Integer all();

    public Integer covid();

}
