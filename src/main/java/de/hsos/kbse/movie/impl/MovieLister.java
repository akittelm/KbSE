/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.movie.impl;

import de.hsos.kbse.interceptor.LogLevel;
import de.hsos.kbse.interceptor.Logable;
import de.hsos.kbse.movie.inf.GetMovies;
import de.hsos.kbse.moviefinder.inf.MovieFinder;
import de.hsos.kbse.qualifier.moviefinder.CSV;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author Alex
 */
@Singleton
public class MovieLister implements GetMovies {

	List<Movie> movies;
	Movie[] output;

	@Inject
	@CSV
	MovieFinder mf;

	public void start() {
		String input;
		System.out.println("Regisseur eingeben:\n");
		input = readInput();
		output = this.moviesDirectedBy(input);
		output();
	}

	public String readInput() {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = console.readLine();
		} catch (IOException e) {
			System.err.println("IOException");
		}
		return line;
	}

	@Logable(LogLevel.INFO)
	@Override
	public Movie[] moviesDirectedBy(String directorName) {
		movies = mf.findAllMovies();
		System.out.println("MovieLister.moviesDirectedBy()");
		ArrayList<Movie> movieListDirector = new ArrayList<>();
		for (Movie m : movies) {
			if (m.getDirector().equals(directorName)) {
				movieListDirector.add(m);
			}
		}

		return movieListDirector.toArray(new Movie[movieListDirector.size()]);
	}

	@Logable(LogLevel.INFO)
	public void output() {
		for (Movie m : output) {
			System.out.println(m.getTitle());
		}

	}

	public void setOutput(Movie[] output) {
		this.output = output;
	}

	public List<Movie> getMovies() {
		return movies;
	}

}
