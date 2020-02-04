package com.yussefsaidi.ppl.models;

public class Exercise {
    private String title;
    private String sets;
    private String repetitions;

    public Exercise() {
    }

    public Exercise(String title, String sets, String repetitions) {
        this.title = title;
        this.sets = sets;
        this.repetitions = repetitions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
                "title='" + title + '\'' +
                ", sets='" + sets + '\'' +
                ", repetitions='" + repetitions + '\'' +
                '}';
    }
}
