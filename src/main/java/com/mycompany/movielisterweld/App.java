//package com.mycompany.movielisterweld;
//
//import de.hsos.kbse.movie.impl.Movie;
//import de.hsos.kbse.movie.impl.MovieLister;
//import de.hsos.kbse.movie.inf.GetMovies;
//import java.util.List;
//import org.jboss.weld.environment.se.Weld;
//
//
///**
// * Hello world!
// *
// */
//public class App 
//{
//    public static void main( String[] args )
//    {
//        String input;
//        List<Movie> output;
//        MovieLister ml = new Weld().initialize().instance().select(MovieLister.class).get();
//        System.out.println("Regisseur eingeben:\n");
//        input = ml.readInput();
//        ml.setOutput(ml.moviesDirectedBy(input));
//        ml.output();
//    }
//}
