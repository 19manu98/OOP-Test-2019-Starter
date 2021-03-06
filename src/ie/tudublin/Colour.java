package ie.tudublin;

import processing.*;

public class Colour{
    public String r;
    public String g;
    public String b;
    public int value;
    private String colour;

    public Colour(processing.data.TableRow row){
        r=row.getString("r");
        g=row.getString("g");
        b=row.getString("b");
        value = row.getInt("value");
        colour=row.getString("colour");
    }

    public String toString()
    {
        return colour + "\t" + r + "\t" + g + "\t" + b +"\t" + value;  
    }

    /**
     * @return the r
     */
    public String getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(String r) {
        this.r = r;
    }

    /**
     * @return the g
     */
    public String getG() {
        return g;
    }

    /**
     * @param g the g to set
     */
    public void setG(String g) {
        this.g = g;
    }

    /**
     * @return the b
     */
    public String getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(String b) {
        this.b = b;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * @param colour the colour to set
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

   
}