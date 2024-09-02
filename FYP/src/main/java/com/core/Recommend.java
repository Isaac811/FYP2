package com.core;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Recommend {
    /**
     * Given a username, calculate the distance between other users and it and sort them
     *
     * @param username
     * @return
     */
    private Map<Double, String> computeNearestNeighbor(String username, List<UserRecord> users) {
        Map<Double, String> distances = new TreeMap<>();

        UserRecord u1 = new UserRecord(username);
        for (UserRecord user : users) {
            if (username.equals(user.username)) {
                u1 = user;
            }
        }

        for (int i = 0; i < users.size(); i++) {
            UserRecord u2 = users.get(i);

            if (!u2.username.equals(username)) {
                double distance = pearson_dis(u2.dianYingList, u1.dianYingList);
                distances.put(distance, u2.username);
            }
        }

        System.out.println("Pearson correlation coefficient between this user and other users -> " + distances);

        return distances;
    }


    /**
     * Calculate the pearson distance between 2 sequences
     *
     * @param rating1
     * @param rating2
     * @return
     */
    private double pearson_dis(List<DianYing> rating1, List<DianYing> rating2) {
        int n = rating1.size() > rating2.size() ? rating2.size() : rating1.size();
        List<Integer> rating1ScoreCollect = rating1.stream().map(A -> A.score).collect(Collectors.toList());
        List<Integer> rating2ScoreCollect = rating2.stream().map(A -> A.score).collect(Collectors.toList());

        double Ex = rating1ScoreCollect.stream().mapToDouble(x -> x).sum();
        double Ey = rating2ScoreCollect.stream().mapToDouble(y -> y).sum();
        double Ex2 = rating1ScoreCollect.stream().mapToDouble(x -> Math.pow(x, 2)).sum();
        double Ey2 = rating2ScoreCollect.stream().mapToDouble(y -> Math.pow(y, 2)).sum();
        double Exy = IntStream.range(0, n).mapToDouble(i -> rating1ScoreCollect.get(i) * rating2ScoreCollect.get(i)).sum();
        double numerator = Exy - Ex * Ey / n;
        double denominator = Math.sqrt((Ex2 - Math.pow(Ex, 2) / n) * (Ey2 - Math.pow(Ey, 2) / n));
        if (denominator == 0)
            return 0.0;

        double r = numerator / denominator;
        if (Double.isNaN(r)) {
            return 0.0;
        } else if (r > 1.0) {
            return 1.0;
        } else if (r < -1.0) {
            return -1.0;
        }
        return r;
    }


    public List<DianYing> recommend(String username, List<UserRecord> users) {
        Map<Double, String> distances = computeNearestNeighbor(username, users);
        if (distances.size() == 0) return null;
        String nearest = distances.values().iterator().next();
        System.out.println("The most same user -> " + nearest);

        UserRecord neighborRatings = new UserRecord();
        for (UserRecord user : users) {
            if (nearest.equals(user.username)) {
                neighborRatings = user;
            }
        }
        System.out.println("Movies recently watched by similar users -> " + neighborRatings.dianYingList);

        UserRecord userRatings = new UserRecord();
        for (UserRecord user : users) {
            if (username.equals(user.username)) {
                userRatings = user;
            }
        }
        System.out.println("Movies the user has watched-> " + userRatings.dianYingList);

        List<DianYing> recommendationMovies = new ArrayList<>();
        for (DianYing movie : neighborRatings.dianYingList) {
            if (userRatings.find(movie.movieId) == null) {
                recommendationMovies.add(movie);
            }
        }
        Collections.sort(recommendationMovies);
        System.out.println("Recommendation Movies -> " + recommendationMovies);
        return recommendationMovies;
    }
}
