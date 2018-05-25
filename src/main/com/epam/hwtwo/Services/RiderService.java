package com.epam.hwtwo.Services;

import com.epam.hwtwo.Entity.Rider;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RiderService {

    private Random random;
    private List<Rider> riders = new ArrayList();

    public void addRider(Rider rider) {
        riders.add(rider);
    }

    public List<Rider> getRiders(int count) {
        return random.ints(count, 0, riders.size()).
            mapToObj(i -> riders.get(i)).
            collect(Collectors.toList());
    }

    public List<Rider> getRiders() {
        return riders;
    }

    public void setRiders(List<Rider> riders) {
        this.riders = riders;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
