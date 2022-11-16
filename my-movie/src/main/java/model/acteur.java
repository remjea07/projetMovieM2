package model;

import io.swagger.annotations.ApiModelProperty;

public class acteur {

    @ApiModelProperty(notes = "nom",name="nom",required=true,value="test nom")
    private String nom;

    @ApiModelProperty(notes = "prenom",name="prenom",required=true,value="test prenom")
    private String prenom;

    @ApiModelProperty(notes = "Date of naissance",name="naissance",required=true,value="test naissance")
    private String naissance;

    @ApiModelProperty(notes = "List of filmographie",name="filmographie",required=true,value="test filmographie")
    private movie filmographie;

    public acteur(String nom, String prenom, String naissance, movie filmographie) {

        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
        this.filmographie = filmographie;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNaissance() {
        return naissance;
    }

    public movie getFilmographie() {
        return filmographie;
    }

    @Override
    public String toString() {
        return "Movie [nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + ", filmographie=" + filmographie + "]";
    }

}
