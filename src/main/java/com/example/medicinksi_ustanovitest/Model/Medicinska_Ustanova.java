package com.example.medicinksi_ustanovitest.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Medicinski_Ustanovi")
public class Medicinska_Ustanova {
    //private
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
    private String Latitude, Longitude;
    private String Zabeleshki;

    public String getNaziv() {
        return Naziv;
    }

    public Double getLongitude() {
        return Double.parseDouble(Longitude);
    }
    public Double getLatitude() {
        return Double.parseDouble(Latitude);
    }
}
