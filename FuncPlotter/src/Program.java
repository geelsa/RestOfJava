import java.awt.Color;

import graphics.Canvas;

public class Program {
    // Canvas GUI instance providing the drawing area on which to plot the functions
    private static Canvas canvas;

    public static void main(String[] args) {
        
        // Create the canvas instance, set its range to x:[-360, 360] and y:[-240, 240] then 
        // open it on the screen. Use canvas.plot(pX, pY) to plot a point at the (pX, pY) coords
        canvas = new Canvas();
        canvas.setRange(-360, -240, 360, 240);
        canvas.open();

        // Draw a short red diagonal on the canvas
        canvas.pause();
        canvas.setColor(Color.red);
        GetY sin = new GetY() {
        	public int calcY(int x) {
        		return (int) (200 * Math.sin(Math.PI * x / 360));
        	}
        	public Color getColor() {
        		return Color.blue;
        	}
        };
        
        GetY quadratic = new GetY() {
        	public int calcY(int x) {
        		return (int) ((x-200) * (x+200) /250);
        	}
        	public Color getColor() {
        		return Color.green;
        	}
        	
        };
        
        GetY log = new GetY() {
        	public int calcY(int x) {
        		return (int) ( 20 * Math.log(x * 2));
        	}
        	public Color getColor() {
        		return Color.orange;
        	}
        	
        };
        
        GetY cubic = new GetY() {
        	public int calcY(int x) {
        		return (int) (Math.pow(x, 3) / 200000);
        	}
        	public Color getColor() {
        		return Color.yellow;
        	}
        	
        };
        
        plotFunction(sin, quadratic, log, cubic);
                
        
        
        
        
        // Pause and close the canvas then terminate the program.
        canvas.pause();
        canvas.close();
    }
    
    //plots a given function
    public static void plotFunction(GetY...functions) {
    	for (int i = 0; i < functions.length; i++) {
    		canvas.setColor(functions[i].getColor());
    		for (int x = -360; x < 360; x++) {
                canvas.plot(x, (int) functions[i].calcY(x));
            }
    	}
    	
    }
    
    
}
