package com.example.medicinksi_ustanovitest.Service.impl;

import com.example.medicinksi_ustanovitest.Model.Medicinska_Ustanova;
import com.example.medicinksi_ustanovitest.Repository.jpa.Medicinski_UstanoviRepository;
import com.example.medicinksi_ustanovitest.Service.Medicinski_UstanoviService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Medicinski_UstanoviServiceImpl implements Medicinski_UstanoviService {
    private final Medicinski_UstanoviRepository medicinski_ustanoviRepository;

    public Medicinski_UstanoviServiceImpl(Medicinski_UstanoviRepository medicinski_ustanoviRepository) {
        this.medicinski_ustanoviRepository = medicinski_ustanoviRepository;
    }

    @Override
    public List<Medicinska_Ustanova> findAllMedicinskiUstanovi() {
        return medicinski_ustanoviRepository.findAll();
    }

    @Override
    public List<Medicinska_Ustanova> findAllCovid19TestingLabs() {
        return medicinski_ustanoviRepository.findAllCovid19TestingLabs();
    }

    @Override
    public Optional<Medicinska_Ustanova> findById(int id) {
        return medicinski_ustanoviRepository.findAll().stream()
                .filter(i->(i.getMedicinska_ustanova_ID() == id)).findFirst();
    }

    @Override
    public Integer all() {
        return medicinski_ustanoviRepository.countAll();
    }

    @Override
    public Integer covid() {
        return medicinski_ustanoviRepository.countcovid19();
    }


}
