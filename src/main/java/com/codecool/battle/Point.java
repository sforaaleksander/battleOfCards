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

    public Point() {
        y = 0;
        x = 0;
    }

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

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }
}
