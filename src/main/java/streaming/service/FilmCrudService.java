/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import streaming.entity.Film;
import streaming.entity.Genre;

/**
 *
 * @author tom
 */
public interface FilmCrudService extends CrudRepository<Film, Long>{
    public List<Film> findAllBy();
    public Film findOneById(Long id);
}
