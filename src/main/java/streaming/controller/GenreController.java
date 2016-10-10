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
    
    @RequestMapping(value = "/liste_genre", method = RequestMethod.GET)
    public String lister(Model m){
        List<Genre> genres = crud.findAllBy();
        m.addAttribute("genres", genres);
        return "genre_lister.jsp";
    }
}
