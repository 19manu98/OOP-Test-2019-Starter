package ie.tudublin;

import processing.*;

public class Colour{
    public String r;
    public String g;
    public String b;
    private String colour;

    public Colour(processing.data.TableRow row){
        r=row.getString("R");
        g=row.getString("G");
        b=row.getString("B");
        colour=row.getString("Colour");
    }

    /**
     * @return the r
     */
    public char getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(char r) {
        this.r = r;
    }

    /**
     * @return the g
     */
    public char getG() {
        return g;
    }

    /**
     * @param g the g to set
     */
    public void setG(char g) {
        this.g = g;
    }

    /**
     * @return the b
     */
    public char getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(char b) {
        this.b = b;
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

    public String toString()
    {
        return colour + "\t" + r + "\t" + g + "\t" + b;  
    }
}