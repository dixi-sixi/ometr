package com.sigireu.ometr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nod on 02.09.15.
 */
public class Board {
    private static List<Board> boardList = new ArrayList<>();
    private String name = "";
    private float length;
    private float width;
    private float height;
    public float getLength() {
        return length;
    }
    public float getWidth() {
        return width;
    }
    public float getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            System.err.println("Параметр NULL, Имя не изменено!");
            return;
        }
        this.name = name;
    }

    public void setLength(float length) {
        if (length < 0) {
            System.err.println("Длина < 0, установите корректное значение!!");
            return;
        }
        this.length = length;
    }

    public void setWidth(float width) {
        if (width < 0) {
            System.err.println("Ширина < 0, установите корректное значение!");
            return;
        }
        this.width = width;
    }

    public void setHeight(float height) {
        if (height < 0) {
            System.err.println("Высота < 0, установите корректное значение!");
            return;
        }
        this.height = height;
    }

    /* Method getArea will return -1 code in case length or width isn't initialized
           Otherwise it will return correct number*/
    public float getArea() {
        if (length == 0 || width == 0) {
            System.err.println("Длина или ширина не инициализированы, сперва задайте их!");
            return -1;
        }
        return getLength()*getWidth();
    }
    /* Method getVolume will return -1 in case one of params aren't correct
    * Otherwise it will return correct number */
    public float getVolume() {
        if (getArea() == -1 || height == 0) {
            System.err.println("Одно или более измерений не задано, установите их!");
            return -1;
        }
        return getArea()*getHeight();
    }
    // Method createBoards used by constructors to set boards in common way
    public static void createBoards(int quantity, String name, float length, float width, float height) {
        if (name != null && quantity > 0 && length > 0 && width > 0 && height >= 0) {
            for (int i = 0; i < quantity; i++) {
                boardList.add(new Board(name, length, width, height));
            }
            System.out.println(String.format(
                    "#%s досок с именем \"%s\" создано со следующими параметрами: %s X %s X %s",
                    quantity, name, length, width, height));
        }
        else {
            System.err.println("Один или более параметров неверно заданы. Метод не выполнен");
        }
    }
    public static void updateBoards(int quantity, String name, String newName, float length, float width, float height) {
        System.out.println("Обновляем список досок...");
        int c = 0;
        for (Board board : boardList) {
            if (name.equalsIgnoreCase(board.getName())) {
                c++;
                System.out.print(String.format(
                        "Найдена доска #%s с именем %s. Старые параметры: %s X %s X %s.",
                        c, name, board.getLength(), board.getWidth(), board.getHeight()));
                board.setLength(length);
                board.setWidth(width);
                board.setHeight(height);
                board.setName(newName);
                System.out.println(String.format(
                        " Данные доски обновлены. Новое имя: \"%s\" Новые параметры: %s X %s X %s",
                        board.getName(), board.getLength(), board.getWidth(), board.getHeight()));
                if (c == quantity) {
                    System.out.println(String.format(
                            "Выполнено. #%s досок обновлено",
                            c));
                    return;
                }
            }
        }
        if (c == 0) {
            System.out.println("Ничего не обновлено. Измените параметры: имя и/или количество");
            return;
        }
        if (c < quantity) {
            //System.out.println();
            System.out.println(String.format(
                    "Выполнено с ошибкой. %s досок не обновлено.",
                    quantity-c));
        }
    }
    // Following 3 constructors are used to set in various ways 2-dimensional boards
    public Board(float length, float width) {
        String defaultName;
        defaultName = String.format("Доска %s X %s", length, width);
        createBoards(1, defaultName, length, width, 0);
    }
    public Board(int quantity, float length, float width) {
        String defaultName;
        defaultName = String.format("Доска %s X %s", length, width);
        createBoards(quantity, defaultName, length, width, 0);
    }
    public Board(int quantity, String name, float length, float width) {
        createBoards(quantity, name, length, width, 0);
    }
    // Below are 3 constructors used to set in various ways fully parametrized board i.e. 3-dimensional
    public Board(float length, float width, float height) {
        String defaultName;
        defaultName = String.format("Доска %s X %s X %s", length, width, height);
        createBoards(1, defaultName, length, width, height);
    }
    public Board(int quantity, float length, float width, float height) {
        String defaultName;
        defaultName = String.format("Доска %s X %s X %s", length, width, height);
        createBoards(quantity, defaultName, length, width, height);
    }
    public Board(int quantity, String name, float length, float width, float height) {
        createBoards(quantity, name, length, width, height);
    }
    /*Main constructor which uses setters to correctly set all params of board.
    * It is possible that some of params hadn't been set, most likely NAME OR HEIGHT
    * Every setter checks whether param is incorrect and will print error message
     * but no exception will be thrown*/
    public Board(String name, float length, float width, float height) {
        this.setName(name);
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

}
