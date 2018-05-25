package com.epam.hwtwo.Services;

import com.epam.hwtwo.Entity.Horse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class HorseService {

    private Random random;
    private List<Horse> horses = new ArrayList();

    public void addHorse(Horse horse) {
        horses.add(horse);
    }

    public List<Horse> getHorses(int count) {
        return random.ints(count, 0, horses.size()).
            mapToObj(i -> horses.get(i)).
            collect(Collectors.toList());
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
