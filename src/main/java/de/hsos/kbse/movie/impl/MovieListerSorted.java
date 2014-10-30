package de.hsos.kbse.movie.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import de.hsos.kbse.interceptor.LogLevel;
import de.hsos.kbse.interceptor.Logable;
import de.hsos.kbse.movie.impl.Movie;
import de.hsos.kbse.movie.inf.GetMovies;
import java.util.Arrays;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 *
 * @author Alex
 */
@Decorator
public abstract class MovieListerSorted implements GetMovies {
    
    @Inject @Delegate @Any
    private GetMovies ml;
    
    public MovieListerSorted() {}
  
    	@Logable(LogLevel.INFO)
        @Override
        public Movie[] moviesDirectedBy(String directorName) {
                Movie[] movieListDirector;
                               
                movieListDirector = ml.moviesDirectedBy(directorName);
		
                Arrays.sort(movieListDirector);
		                
            return movieListDirector;
	}
}
