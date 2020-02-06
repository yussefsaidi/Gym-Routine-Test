package com.yussefsaidi.ppl.models;

import android.view.View;

public class Exercise {
    private String name;
    private String sets;
    private String repetitions;
    private boolean expanded;

    public Exercise() {
        expanded = false;
    }

    public Exercise(String name, String sets, String repetitions) {
        this.name = name;
        this.sets = sets;
        this.repetitions = repetitions;
        expanded = false;
    }

    public boolean isExpanded() { return expanded; }

    public void setExpanded(boolean expanded) { this.expanded = expanded; }

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
