package org.nbk.catalog.movies.domain;

public class Movie {

	private String movieName;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie [movieName=");
		builder.append(movieName);
		builder.append("]");
		return builder.toString();
	}

}
