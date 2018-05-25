package com.epam.hwtwo.Services;

import com.epam.hwtwo.Entity.Horse;
import com.epam.hwtwo.Entity.Race;
import com.epam.hwtwo.Entity.Rider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RaceService {

    private List<Race> races = new ArrayList();
    private Random random;
    private HorseService horseService;
    private RiderService riderService;

    public void addRace(Race race) {
        races.add(race);
    }

    public Race makeRace(List<Horse> horses, List<Rider> riders) {
        Race race = new Race();
        for (Horse horse : horses) {
            race.addParticipant(horse, riders.get(horses.indexOf(horse)));
            race.addResult(horse, 0);
        }
        return race;
    }

    public Race getRace() {
        List<Horse> horses = horseService.getHorses(2);
        List<Rider> riders = riderService.getRiders(2);
        Race race = makeRace(horses, riders);
        race.setLength(10 + random.nextInt(20));
        race.setTrackName("Grandy");
        return race;
    }

    public Map.Entry<Horse, Integer> maxResult(Race race) {
        Map.Entry<Horse, Integer> maxEntry = null;
        for (Map.Entry<Horse, Integer> entry : race.getResults().entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public HorseService getHorseService() {
        return horseService;
    }

    public void setHorseService(HorseService horseService) {
        this.horseService = horseService;
    }

    public RiderService getRiderService() {
        return riderService;
    }

    public void setRiderService(RiderService riderService) {
        this.riderService = riderService;
    }
}
