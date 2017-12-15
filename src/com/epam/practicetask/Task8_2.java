package com.epam.practicetask;

import java.util.*;

public class Task8_2 {

    public static void main(String[] args) {

        Task8_2 task = new Task8_2();
        List<Point> blockedPoints = Arrays.asList(task.new Point(0, 3), task.new Point(1, 3), task.new Point(3, 0),
                task.new Point(2, 5), task.new Point(3, 5), task.new Point(4, 3));

        Table table = task.new Table(5, 8, blockedPoints);
        System.out.println(table);
        task.findPath(table);
    }

    private void findPath(Table table) {
        final int rows = table.isPointBlocked.length;
        final int columns = table.isPointBlocked[0].length;
        if (rows < 2 || columns < 2) throw new RuntimeException("That's not a table!");

        Point start = new Point(0, 0);
        final Point[][] previous = new Point[rows][columns];

        boolean pathExists = isPathExists(start, table, new Boolean[rows][columns], previous);

        System.out.println(pathExists ? "Such a way exists!" : "No such a way found");
        System.out.println("Number of iterations: " + table.count);
        if (pathExists) {
            LinkedList<Point> list = new LinkedList<>();
            int i = rows - 1;
            int j = columns - 1;
            Point current = new Point(i, j);
            while (previous[i][j] != null) {
                list.addFirst(current);
                current = previous[i][j];
                i = current.y;
                j = current.x;
            }
            list.addFirst(start);
            System.out.println("Path: " + list);
        }

    }

    private boolean isPathExists(Point current, Table table, Boolean[][] pathExists, Point[][] previous) {
        if (pathExists[current.y][current.x] != null) {
            return pathExists[current.y][current.x];
        }
        table.count++;
        if ((current.x == table.isPointBlocked[0].length - 1) && (current.y == table.isPointBlocked.length - 1)) {
            pathExists[current.y][current.x] = true;
            return true;
        }
        if (current.canMoveDown(table) && isPathExists(current.moveDown(), table, pathExists, previous)) {
            pathExists[current.y][current.x] = true;
            previous[current.moveDown().y][current.moveDown().x] = current;
            return true;
        }
        if (current.canMoveRight(table) && isPathExists(current.moveRight(), table, pathExists, previous)) {
            pathExists[current.y][current.x] = true;
            previous[current.moveRight().y][current.moveRight().x] = current;
            return true;
        }
        pathExists[current.y][current.x] = false;
        return false;
    }


    class Table {

        int count = 0;
        boolean[][] isPointBlocked;

        public Table(int rows, int columns, List<Point> blockedPointsCoordinates) {
            this.isPointBlocked = new boolean[rows][columns];
            for (int i = 0; i < blockedPointsCoordinates.size(); i++) {
                isPointBlocked[blockedPointsCoordinates.get(i).y][blockedPointsCoordinates.get(i).x] = true;
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < isPointBlocked.length; i++) {
                for (int j = 0; j < isPointBlocked[0].length; j++) {
                    builder.append(isPointBlocked[i][j] ? "|x" : "| ");
                }
                builder.append("|\n");
            }
            return builder.toString();
        }
    }

    class Point {
        final int x;
        final int y;

        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }

        Point moveRight() {
            return new Point(y, x + 1);
        }

        Point moveDown() {
            return new Point(y + 1, x);
        }

        boolean canMoveRight(Table table) {
            return (x < table.isPointBlocked[0].length - 1) && (!table.isPointBlocked[y][x + 1]);
        }

        boolean canMoveDown(Table table) {
            return (y < table.isPointBlocked.length - 1) && (!table.isPointBlocked[y + 1][x]);
        }

        @Override
        public String toString() {
            return "(" + y + ", " + x + ")";
        }
    }
}
