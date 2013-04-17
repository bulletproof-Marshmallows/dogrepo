/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DogRecorder;

/**
 *
 * @author Alvin
 */
import java.lang.Exception;

public class Dog {

    private String name, color;
    private int number;

    public Dog(String dogName, int entryNum) {
        name = dogName;
        number = entryNum;
        color = "white";
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
