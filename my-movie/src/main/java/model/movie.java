package model;

import io.swagger.annotations.ApiModelProperty;


public class movie {

    @ApiModelProperty(notes = "Titre of movie",name="titre",required=true,value="test titre")
    private String titre;

    @ApiModelProperty(notes = "Name of the Realisateur",name="realisateur",required=true,value="test realisateur")
    private String realisateur;

    @ApiModelProperty(notes = "Name of the acteur_principal",name="acteur_principal",required=true,value="test acteur_principal")
    private acteur acteur_principal;

    @ApiModelProperty(notes = "Date of sortie",name="sortie",required=true,value="test sortie")
    private String sortie;

    public movie(String titre, String realisateur, acteur acteur_principal, String sortie) {

        this.titre = titre;
        this.realisateur = realisateur;
        this.acteur_principal = acteur_principal;
        this.sortie = sortie;
    }

    public String getTitre() {
        return titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public acteur getActeur_principal() {
        return acteur_principal;
    }

    public String getSortie() {
        return sortie;
    }

    @Override
    public String toString() {
        return "Movie [titre=" + titre + ", realisateur=" + realisateur + ", acteur_principal=" + acteur_principal + ", sortie=" + sortie + "]";
    }

}
