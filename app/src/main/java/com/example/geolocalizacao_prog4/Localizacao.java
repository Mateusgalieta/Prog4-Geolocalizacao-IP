package com.example.geolocalizacao_prog4;

public class Localizacao {
    //Documentação da API utilizada:  https://ip-api.com/docs/api:json

    private String zip; //variavel para recebimento do CEP (ZIP)
    private String countryCode; // Variavel para recebimento do codigo do pais (retornado da API).
    private String country; // Variavel para recebimento do nome do pais
    private String regionName; //variavel para recebimento da regiao
    private String city; // variavel para recebimento da cidade


    // Logo abaixo é o contrutor da classe Localizacao
    public Localizacao(String countryCode, String country, String city, String regionName, String zip) {
        this.countryCode = countryCode;
        this.country = country;
        this.city = city;
        this.regionName = regionName;
        this.zip = zip;
    }

    //Abaixo fiz os Getters e Setters dos atributos da classe

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }


}
