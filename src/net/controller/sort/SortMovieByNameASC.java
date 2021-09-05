/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.controller.sort;

import java.util.Comparator;
import net.model.Movie;

/**
 *
 * @author NGUYEN KHAC TUAN
 */
public class SortMovieByNameASC implements Comparator<Movie>{

    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
