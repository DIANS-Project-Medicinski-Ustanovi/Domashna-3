package com.example.medicinksi_ustanovitest.Service.impl;

import com.example.medicinksi_ustanovitest.Model.Medicinska_Ustanova;
import com.example.medicinksi_ustanovitest.Repository.jpa.Medicinski_UstanoviRepository;
import com.example.medicinksi_ustanovitest.Service.Medicinski_UstanoviService;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
                .filter(i -> (i.getMedicinska_ustanova_ID() == id)).findFirst();
    }

    @Override
    public Integer all() {
        return medicinski_ustanoviRepository.countAll();
    }

    @Override
    public Integer covid() {
        return medicinski_ustanoviRepository.countcovid19();
    }

    @Override
    public List<Medicinska_Ustanova> findAllByCategory(String category) {
        return medicinski_ustanoviRepository.findAll().stream()
                .filter(i -> i.getKategorija().equals(category)).collect(Collectors.toList());
    }

    @Override
    public List<Medicinska_Ustanova> findAllByCity(String city) {
        String trimedCity;
        if (city!=null) {
            trimedCity = city.trim();
        }
        else {
            trimedCity=city;
        }
        return medicinski_ustanoviRepository.findAll()
                .stream().filter(i -> i.getGrad().contains(trimedCity)).collect(Collectors.toList());
    }


    @Override
    public List<Medicinska_Ustanova> findAllNotCovid19Testing() {
        return medicinski_ustanoviRepository.findAll().stream()
                .filter(i -> i.getCovid19_PCR_test() == Boolean.FALSE
                        && i.getImuno_test() == Boolean.FALSE
                        && i.getBrz_antigenski_test() == Boolean.FALSE)
                .collect(Collectors.toList());
    }

    public List<Medicinska_Ustanova> getMedicalLabsByFilter(String category, String city, String covid19Test) {
        if (category==null && city==null && covid19Test==null) {
            return findAllMedicinskiUstanovi();
        } else if (category!=null && city==null && covid19Test==null) {
            return findAllByCategory(category);
        } else if (category==null && city!=null && covid19Test==null) {
            return findAllByCity(city);
        } else if (category==null && city==null && covid19Test!=null) {
            if (covid19Test.equals("да")) {
                return findAllCovid19TestingLabs();
            } else return findAllNotCovid19Testing();
        } else if (category!=null && city!=null && covid19Test==null) {
            return findAllByCity(city).stream()
                    .filter(i -> i.getKategorija().toLowerCase().equals(category.toLowerCase()))
                    .collect(Collectors.toList());
        } else if (category!=null && city==null && covid19Test!=null) {
            if (covid19Test.equals("да")) {
                return findAllByCategory(category).stream()
                        .filter(findAllCovid19TestingLabs()::contains)
                        .distinct().collect(Collectors.toList());
            } else {
                return findAllByCategory(category).stream()
                        .filter(findAllNotCovid19Testing()::contains)
                        .distinct().collect(Collectors.toList());
            }
        } else if (category==null && city!=null && covid19Test!=null) {
            if (covid19Test.equals("да")) {
                return findAllByCity(city).stream()
                        .filter(findAllCovid19TestingLabs()::contains)
                        .distinct().collect(Collectors.toList());
            } else {
                return findAllByCity(city).stream()
                        .filter(findAllNotCovid19Testing()::contains)
                        .distinct().collect(Collectors.toList());
            }
        } else if (category!=null && city!=null && covid19Test!=null) {
            if (covid19Test.equals("да")) {
                return findAllByCity(city).stream()
                        .filter(findAllCovid19TestingLabs()::contains)
                        .filter(findAllByCategory(category)::contains)
                        .distinct().collect(Collectors.toList());
            } else {
                return findAllByCity(city).stream()
                        .filter(findAllNotCovid19Testing()::contains)
                        .filter(findAllByCategory(category)::contains)
                        .distinct().collect(Collectors.toList());
            }
        }
        return null;
    }

    @Override
    public List<String> getAllCities() {
        return medicinski_ustanoviRepository.getAllCities();
    }

    @Override
    public List<String> getAllCategories() {
        return medicinski_ustanoviRepository.getAllCategories();
    }

    public HashMap<Integer, Medicinska_Ustanova> FilterdMedUstanovi(String category, String city, String covid19Test){

        HashMap<Integer, Medicinska_Ustanova> hashMap = new HashMap<>();
        getMedicalLabsByFilter(category, city, covid19Test).stream().forEach(i -> hashMap.put(i.getMedicinska_ustanova_ID(), i));
        return hashMap;

    }

}
