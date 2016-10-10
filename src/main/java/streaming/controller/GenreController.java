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
import streaming.entity.Genre;
import streaming.service.GenreCrudService;

/**
 *
 * @author admin
 */

@Controller
public class GenreController {
    @Autowired
    private GenreCrudService crud;
    
    @RequestMapping(value = "/editer_genre", method = RequestMethod.POST)
    public String editerPOST(@ModelAttribute("genre") Genre genre){
        crud.save(genre);
        return "redirect:/liste_genre";
    }
    
    @RequestMapping(value = "/add_genre", method = RequestMethod.POST)
    public String ajouterPOST(@ModelAttribute("genre") Genre genre){
        crud.save(genre);
        return "redirect:/liste_genre";
    }
    @RequestMapping(value = "/ajouter_genre", method = RequestMethod.GET)
    public String ajouter(){
        
        
        return "ajouter_genre.jsp";
    }
    @RequestMapping(value = "/editer_genre/{val}", method = RequestMethod.GET)
    public String editer(@PathVariable("val") Long id, Model m){
        Genre genre = crud.findOneById(id);
        m.addAttribute("genre", genre);
        return "modifier_genre.jsp";
    }
    
    @RequestMapping(value = "/supprimer_genre/{val}", method = RequestMethod.GET)
    public String supprimer(@PathVariable("val") Long id){
        crud.delete(id);
        return "redirect:/liste_genre";
    }
            
    @RequestMapping(value = {"/liste_genre","/"}, method = RequestMethod.GET)
    public String lister(Model m){
        List<Genre> genres = crud.findAllBy();
        m.addAttribute("genres", genres);
        return "genre_lister.jsp";
    }
}
