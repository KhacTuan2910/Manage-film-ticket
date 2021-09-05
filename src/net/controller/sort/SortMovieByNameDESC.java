package net.controller.sort;

import java.util.Comparator;
import net.model.Movie;

/**
 *
 * @author NGUYEN KHAC TUAN
 */
public class SortMovieByNameDESC implements Comparator<Movie>{

    @Override
    public int compare(Movie o1, Movie o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
