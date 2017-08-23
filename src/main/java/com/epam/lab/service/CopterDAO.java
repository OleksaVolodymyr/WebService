package com.epam.lab.service;

import com.epam.lab.model.Copter;

public class CopterDAO {
    private static final int CHANGE_DISTANCE = 15;
    private static final int MAX_POSITIVE_DISTANCE = 100;
    private static final int MAX_NEGATIVE_DISTANCE = -100;
    private static final int MAX_HEIGHT = 100;
    private static final int START_POSITION = 0;
    private Copter copter;

    public CopterDAO() {
        copter = new Copter();
    }

    public Copter moveUp() {
        if (copter.getHeight() + CHANGE_DISTANCE <= MAX_HEIGHT) {
            copter.setHeight(copter.getHeight() + CHANGE_DISTANCE);
        } else return null;
        return copter;
    }

    public Copter moveDown() {
        if (copter.getHeight() - CHANGE_DISTANCE >= START_POSITION) {
            copter.setHeight(copter.getHeight() - CHANGE_DISTANCE);
        } else return null;
        return copter;
    }

    public Copter moveForward() {
        if (copter.getDistance() + CHANGE_DISTANCE <= MAX_POSITIVE_DISTANCE) {
            copter.setDistance(copter.getDistance() + CHANGE_DISTANCE);
        } else return null;
        return copter;
    }

    public Copter moveBack() {
        if (copter.getDistance() - CHANGE_DISTANCE >= MAX_NEGATIVE_DISTANCE) {
            copter.setDistance(copter.getDistance() - CHANGE_DISTANCE);
        } else return null;
        return copter;
    }

    public Copter stop() {
        return copter;
    }

    public Copter getCopter() {
        return copter;
    }
}
