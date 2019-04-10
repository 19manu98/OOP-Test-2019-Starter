package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet
{	
	private ArrayList<Colour> colours = new ArrayList<Colour>();
	private ArrayList<Resistor> resistors = new ArrayList<Resistor>();
	
	public void separate(int value)
	{
		int hundreds = (value / 100);
		int tens = (value - (hundreds * 100)) / 10;
		int ones = value - ((hundreds * 100)  + (tens * 10));
		print(hundreds + ",");
		print(tens + ",");
		println(ones);
	}

	public void settings()
	{
		size(500, 800);
		loadColours();
		loadResistor();
	}

	public void setup() 
	{
		printColours();
		println();
		findColor(2);
		println();
		printResistor();
	}
	public void loadColours(){
		Table table = loadTable("colours.csv","header");

		for (TableRow row : table.rows()){
			Colour colour = new Colour(row);
			colours.add(colour);
		}
	}

	private void loadResistor(){
		Table table = loadTable("resistors.csv","header");

		for (TableRow row : table.rows()){
			int value = row.getInt("value");
			Resistor resistor = new Resistor(value);
			resistors.add(resistor);
		}
	}
	public void printResistor(){
		for (Resistor r : resistors){
			println(r);
		}
	}
	public void printColours(){
		for (Colour colour : colours){
			println(colour);
		}
	}

	public void findColor(int value){
		for (Colour colour : colours){
			if (colour.value == value)
				println(colour);
		}
	}
	public void draw()
	{			
	}
}
