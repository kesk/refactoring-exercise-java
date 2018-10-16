package com.greatersum.rental;

import com.greatersum.rental.model.Movie;
import com.greatersum.rental.model.MovieCode;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

public class MovieStorage {
    public static HashMap<String, Movie> loadMovies(String yamlFile) throws FileNotFoundException {
        Constructor constructor = new Constructor(Movie.class);
        TypeDescription movieDescription = new TypeDescription(Movie.class);
        movieDescription.addPropertyParameters("code", MovieCode.class);

        InputStream is = new FileInputStream(new File(yamlFile));
        Yaml yaml = new Yaml(constructor);
        Iterable<Object> data = yaml.loadAll(is);

        HashMap<String, Movie> movies = new HashMap<>();

        for (Object o : data) {
            Movie m = (Movie) o;
            movies.put(m.getId(), m);
        }

        return movies;
    }
}
