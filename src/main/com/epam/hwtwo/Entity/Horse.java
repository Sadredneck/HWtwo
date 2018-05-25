package com.epam.hwtwo.Entity;

import java.util.Objects;

public class Horse {

    private String nickName;
    private String breed;

    public Horse() {
    }

    public Horse(String nickName, String breed) {
        this.nickName = nickName;
        this.breed = breed;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Horse horse = (Horse) o;
        return Objects.equals(nickName, horse.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName);
    }

}
