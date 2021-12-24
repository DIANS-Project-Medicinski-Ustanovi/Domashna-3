package com.example.medicinksi_ustanovitest.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Medicinski_Ustanovi")
public class Medicinska_Ustanova {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Medicinska_ustanova_ID;
    private String Naziv, Kategorija, Adresa, Grad;
    private Double Ocena;
    private Integer Broj_na_kritiki;
    private String Website, Tel_broj;
    private String Ponedelnik, Vtornik, Sreda, Cetvrtok, Petok, Sabota, Nedela;
    private Boolean Covid19_PCR_test, Brz_antigenski_test, Imuno_test;
    private String Online_booking, Cenovnik, Promocii;
    private String placeURL, imgURL;
    private Double Latitude, Longitude;
    private String Zabeleshki;

    public Medicinska_Ustanova(String naziv, String kategorija, String grad,
     Boolean covid19_PCR_test, Boolean brz_antigenski_test,
          Boolean imuno_test, Double latitude, Double longitude) {
        Naziv = naziv;
        Kategorija = kategorija;
        Grad = grad;
        Covid19_PCR_test = covid19_PCR_test;
        Brz_antigenski_test = brz_antigenski_test;
        Imuno_test = imuno_test;
        Latitude = latitude;
        Longitude=longitude;
    }

    public Medicinska_Ustanova() {
    }

//    public Double getLongitude() {
//        return Double.parseDouble(Longitude);
//    }
//
//    public Double getLatitude() {
//        return Double.parseDouble(Latitude);
//    }
}
