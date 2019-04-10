package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet
{	
	private ArrayList<Colour> colours = new ArrayList<Colour>();
	private ArrayList<Resistor> resistors = new ArrayList<Resistor>();
	
	public float mid;
	public int R;
	public int G;
	public int B;

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
		mid = height/(3*resistors.size()+1);
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
			if (colour.value == value){
				println(colour);
				R=Integer.valueOf(colour.r);
				G=Integer.valueOf(colour.g);
				B=Integer.valueOf(colour.b);
			}
		}
	}

	public void drawResistor(){
		for(int i=0; i<resistors.size();i++){
			fill(150);
			rect(width/3,(i)*3*mid+mid,width/3,2*mid);
			line(width/3-20,2*mid+3*i*mid,width/3,2*mid+3*i*mid);
			line(2*width/3+20,2*mid+3*i*mid,2*width/3,2*mid+3*i*mid);
			textSize(50);
			fill(0);
			text(nf(resistors.get(i).value), width-140,2*mid+3*i*mid );
			findColor(resistors.get(i).hundreds);
			fill(R,G,B);
			rect(width/3+20,(i)*3*mid+mid,15,2*mid);
			findColor(resistors.get(i).tens);
			fill(R,G,B);
			rect(width/3+40,(i)*3*mid+mid,15,2*mid);
			findColor(resistors.get(i).ones);
			fill(R,G,B);
			rect(width/3+60,(i)*3*mid+mid,15,2*mid);
		}
	}
	public void draw()
	{		
		background(150);
		drawResistor();
		
	}


}
