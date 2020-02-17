package org.nbk.catalog.movies.domain;

public class MovieCatalog {

	private Movie movie;

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MovieCatalog [movie=");
		builder.append(movie);
		builder.append("]");
		return builder.toString();
	}

}
