package com.xb.Movie;

import java.util.Random;

import com.mstf.t1.Meau;

public class Cinema implements Play {

	private Movie[] movie;
	
	public void addMovie(Movie movies) {
		if(movie==null) {
			movie = new Movie[1];
			movie[0] = movies;
		}else{
			int len = movie.length;
			Movie[] newMovie = new Movie[len+1];
			for(int i=0;i<len;i++) {
				newMovie[i] = movie[i];
			}
			newMovie[len] = movies;
			movie = newMovie;
		}
	}
	
	public void showMovie() {
		if(movie==null) {
			System.out.println("本影院暂时还没有电影");
			return;
		}
		for(int i=0;i<movie.length;i++) {
			movie[i].showInfo();
		}
	}
	
	@Override
	public void playMovie() {
		Random random = new Random();
		if(movie==null) {
			System.out.println("本影院暂时还没有电影");
			return;
		}
		int id =random.nextInt(movie.length);
		System.out.println("随机放映一部电影："+movie[id].getName());
	}

	
}
