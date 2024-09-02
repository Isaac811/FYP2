package com.core;

import java.util.ArrayList;
import java.util.List;


public class UserRecord {
    public String username;
    public List<DianYing> dianYingList = new ArrayList<>();

    public UserRecord() {}

    public UserRecord(String username) {
        this.username = username;
    }

    public UserRecord set(String caipinName, int score) {
        this.dianYingList.add(new DianYing(caipinName, score));
        return this;
    }

    public DianYing find(String caipinName) {
        for (DianYing caiPin : dianYingList) {
            if (caiPin.movieId.equals(caipinName)) {
                return caiPin;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}