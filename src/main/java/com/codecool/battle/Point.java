package com.codecool.battle;

import java.util.Objects;

/**
 * Point
 */
public class Point {
    private int y;
    private int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }

    //TODO
    public void moveDown() {
        y++;
    }

    public void moveUp() {
        y--;
    }

    public void moveRight() {
        x++;
    }

    public void moveLeft() {
        x--;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return point.y == y && point.x == x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
}
