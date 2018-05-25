package com.epam.hwtwo.Entity;

import java.util.HashMap;

public class Race {

    private HashMap<Horse, Rider> participants = new HashMap();
    private HashMap<Horse, Integer> results = new HashMap();
    private String trackName;
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public void addParticipant(Horse horse, Rider rider) {
        participants.put(horse, rider);
    }

    public void addResult(Horse horse, Integer result) {
        results.put(horse, result);
    }

    public HashMap<Horse, Integer> getResults() {
        return results;
    }

    public void setResults(HashMap<Horse, Integer> results) {
        this.results = results;
    }
}
