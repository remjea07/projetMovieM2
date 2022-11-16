package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.acteur;
import model.movie;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "leController", description = "REST Apis related to Movie and Acteur Entity!!!!")
@RestController
public class leController {


    List<acteur> acteurs = new ArrayList<acteur>();
    List<movie> movies = new ArrayList<movie>();
    {
        acteurs.add(new acteur("Swartzi", "Arnold", "en Autriche", movies.get(0)));
        acteurs.add(new acteur("Stallone", "Sylvesters", "en Italie", movies.get(1)));
        movies.add(new movie("Terminator", "je c plus", acteurs.get(0), "annee 80"));
        movies.add(new movie("Rambo", "je c plus", acteurs.get(1), "annee 80"));
    }

    @ApiOperation(value = "Get list of Movie in the System ", response = Iterable.class, tags = "getMovies")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succes"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    @RequestMapping(value = "/getMovies")
    public List<movie> getMovies() {
        return movies;
    }

    @ApiOperation(value = "Get specific Movie in the System ", response = movie.class, tags = "getMovieTitre")
    @RequestMapping(value = "/getMovieTitre/{titre}")
    public List<movie> getMovieTitre(@PathVariable(value = "cls") String titre) {
        return movies.stream().filter(x -> x.getTitre().equalsIgnoreCase(titre)).collect(Collectors.toList());
    }


    @ApiOperation(value = "Get specific Sortie in the System ", response = movie.class, tags = "getMovieSortie")
    @RequestMapping(value = "/getMovieSortie/{sortie}")
    public List<movie> getMovieSortie(@PathVariable(value = "sortie") String sortie) {
        return movies.stream().filter(x -> x.getSortie().equalsIgnoreCase(sortie)).collect(Collectors.toList());
    }

    @ApiOperation(value = "Get specific film in the System ", response = acteur.class, tags = "getActeurFilm")
    @RequestMapping(value = "/getActeurFilm/{acteur}")
    public List<acteur> getActeurByFilm(@PathVariable(value = "movie") acteur acteur) {
        return acteurs.stream().filter(x -> x.getFilmographie().equalsIgnoreCase(acteur)).collect(Collectors.toList());
    }

    @ApiOperation(value = "Get list of Acteur in the System ", response = Iterable.class, tags = "getActeurs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succes"),
            @ApiResponse(code = 401, message = "not authorized"),
            @ApiResponse(code = 403, message = "forbidden"),
            @ApiResponse(code = 404, message = "not found") })
    @RequestMapping(value = "/getActeurs")
    public List<acteur> getActeurs() {
        return acteurs;
    }

    @ApiOperation(value = "Get specific Nom in the System ", response = acteur.class, tags = "getActeurNom")
    @RequestMapping(value = "/getActeurNom/{nom}")
    public List<acteur> getActeurNom(@PathVariable(value = "nom") String nom) {
        return acteurs.stream().filter(x -> x.getNom().equalsIgnoreCase(nom)).collect(Collectors.toList());
    }

}
