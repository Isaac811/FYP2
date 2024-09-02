package com.core;

public class DianYing implements Comparable<DianYing>{
    public String movieId;
    public int score;
    public DianYing(String movieId, int score) {
        this.movieId = movieId;
        this.score = score;
    }

    @Override
    public String toString() {
        return "This {" +
                "movieId='" + movieId + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(DianYing o) {
        return score > o.score ? -1 : 1;
    }

    public String getMovieId() {
        return movieId;
    }

    public int getScore() {
        return score;
    }
}
