/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Alvin
 */
import java.lang.Exception;

public class Dog {

    private String name, color;
    private int number;

    public Dog(String dogName, int colorNum) {
        name = dogName;
        number = (int) Math.random();
        switch (colorNum) {
            case 1:
                color = "red";
                break;
            case 2:
                color = "blue";
                break;
            case 3:
                color = "green";
                break;
            case 4:
                color = "silver";
                break;
            case 5:
                color = "brown";
                break;
            case 6:
                color = "yellow";
                break;
            case 7:
                color = "";
                break;
            default:
                System.out.println("Invalid Num");
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }
}
