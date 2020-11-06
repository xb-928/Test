package com.mstf.t1;

public class Cinema {

	private Movie[] movie;
	public void addMovie(Movie movies) {
		if(movie ==null) {
			movie = new Movie[1];
			movie[0] = movies;
		}else {
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
			movie[i].show();
		}
	}
	

}
