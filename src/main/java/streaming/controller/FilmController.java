/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import streaming.entity.Film;
import streaming.entity.Genre;
import streaming.service.FilmCrudService;
import streaming.service.GenreCrudService;

/**
 *
 * @author tom
 */
@Controller
public class FilmController {
    @Autowired
    private FilmCrudService crud;
    @RequestMapping(value = {"/liste_film", "/"}, method = RequestMethod.GET)
    public String lister(Model m){
        List<Film> films = crud.findAllBy();
        m.addAttribute("films", films);
        return "film_lister.jsp";
    }
    @RequestMapping(value = "/supprimer_film/{val}", method = RequestMethod.GET)
    public String supprimer(@PathVariable("val") Long id){
        crud.delete(id);
        return "redirect:/liste_film";
    }
    @RequestMapping(value = "/editer_film/{val}", method = RequestMethod.GET)
    public String editer(@PathVariable("val") Long id, Model m){
        Film film = crud.findOneById(id);
        m.addAttribute("film", film);
        return "modifier_film.jsp";
    }
    @RequestMapping(value = "/editer_film", method = RequestMethod.POST)
    public String editerPOST(@ModelAttribute("genre") Film film){
        crud.save(film);
        return "redirect:/liste_film";
    }
    @RequestMapping(value = "/add_film", method = RequestMethod.POST)
    public String ajouterPOST(@ModelAttribute("film") Film film){
        crud.save(film);
        return "redirect:/liste_film";
    }
    @RequestMapping(value = "/ajouter_film", method = RequestMethod.GET)
    public String ajouter(){
        
        
        return "ajouter_film.jsp";
    }
}
