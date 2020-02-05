package com.yussefsaidi.ppl.models;

public class Exercise {
    private String name;
    private String sets;
    private String repetitions;

    public Exercise() {
    }

    public Exercise(String name, String sets, String repetitions) {
        this.name = name;
        this.sets = sets;
        this.repetitions = repetitions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public String getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(String repetitions) {
        this.repetitions = repetitions;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", sets='" + sets + '\'' +
                ", repetitions='" + repetitions + '\'' +
                '}';
    }
}
