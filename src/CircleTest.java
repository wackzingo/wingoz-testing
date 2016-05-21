/*
* TCSS 305 – Winter 2016
* Assignment 1 – Testing
*/

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Zachariah Wingo
 * @version 1.1
 */
public class CircleTest {
    
    /**
     * A default tolerance level for double and floats.
     */
    private static final Double TOLERANCE = 0.0001;
    
    /**
     * A circle with radius of 2.0, Point x=2, y=3, color=Blue.
     */
    private Circle myTestCircleR2X2Y3Blue;
    
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() {
        
        //Create a point
        final Point p1 = new Point(2, 3);
      
        //Instantiate our circle fixtures
        myTestCircleR2X2Y3Blue = new Circle(2.0, p1, Color.BLUE);
    }


    /**
     * Test method for {@link Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test
    public void testCircleDoublePointColor() {
        
        // Here we test the values for the circle created in the setUp
        assertEquals(2.0, myTestCircleR2X2Y3Blue.getRadius(), TOLERANCE);
        assertTrue(myTestCircleR2X2Y3Blue.getCenter().equals(new Point(2, 3)));
        assertTrue(myTestCircleR2X2Y3Blue.getColor().equals(Color.BLUE));
        
    }


    // A zero radius should throw an illegal argument exception.
    /**
     * Test method for {@link Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCircleZeroDoublePointColor() {
        new Circle(0, new Point(7, 8), Color.CYAN);
    }

    
    // A negative radius should throw an illegal argument exception.
    /**
     * Test method for {@link Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCircleNegativeDoublePointColor() {
        new Circle(-8, new Point(7, 8), Color.CYAN);
    }


    // A null Color should throw a NullPointerException.
    /**
     * Test method for {@link Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test (expected = NullPointerException.class)
    public void testCircleDoublePointNullColor() {
        new Circle(2.0, new Point(7, 8), null);
    }


    // A null Point should throw a NullPointerException.
    /**
     * Test method for {@link Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test (expected = NullPointerException.class)
    public void testCircleDoubleNullPointColor() {
        new Circle(2.0, null, Color.BLUE);
    }


    /**
     * Test method for {@link Circle#Circle()}.
     */
    @Test
    public void testCircle() {
        
        final Circle testCircle = new Circle();
        
        assertEquals(1.0, testCircle.getRadius(), TOLERANCE);
        assertTrue(testCircle.getCenter().equals(new Point(0, 0)));
        assertTrue(testCircle.getColor().equals(Color.BLACK));
    }


    /**
     * Test method for {@link Circle#setRadius(double)}.
     */
    @Test
    public void testSetRadius() {
        
        // Tests initial value before setting a new value.
        assertEquals(2.0, myTestCircleR2X2Y3Blue.getRadius(), TOLERANCE);
        
        // Set a new value.
        myTestCircleR2X2Y3Blue.setRadius(5.5);
       
        // Test to see if value was correctly changed.
        assertEquals(5.5, myTestCircleR2X2Y3Blue.getRadius(), TOLERANCE);
        
        // Now we try setting the radius to something more complex
        myTestCircleR2X2Y3Blue.setRadius(8.442);
       
        // Test to see if value was correctly changed.
        assertEquals(8.442, myTestCircleR2X2Y3Blue.getRadius(), TOLERANCE);
    }
 
    
    /**
     * Test method for {@link Circle#setRadius(double)}.
     */
    @Test  (expected = IllegalArgumentException.class)
    public void testSetRadiusZero() {
        myTestCircleR2X2Y3Blue.setRadius(0);
    }


    /**
     * Test method for {@link Circle#setRadius(double)}.
     */
    @Test  (expected = IllegalArgumentException.class)
    public void testSetRadiusNegative() {
        myTestCircleR2X2Y3Blue.setRadius(-8);
    }

    
    /**
     * Test method for {@link Circle#setCenter(java.awt.Point)}.
     */
    @Test
    public void testSetCenter() {
               
        // Set a new value.
        myTestCircleR2X2Y3Blue.setCenter(new Point(9, 12));
       
        // Test to see if value was correctly changed.
        assertEquals(9, myTestCircleR2X2Y3Blue.getCenter().getX(), TOLERANCE);
        assertEquals(12, myTestCircleR2X2Y3Blue.getCenter().getY(), TOLERANCE);
    }
    
    
    // Setting a null Point should throw a NullPointerException
    /**
     * Test method for {@link Circle#setCenter(java.awt.Point)}.
     */
    @Test (expected = NullPointerException.class)   
    public void testSetCenterNull() {
               
        myTestCircleR2X2Y3Blue.setCenter(null);

    }
    

    /**
     * Test method for {@link Circle#setColor(java.awt.Color)}.
     */
    @Test
    public void testSetColor() {
        
        // Tests initial value before setting a new value.
        assertEquals(myTestCircleR2X2Y3Blue.getColor(), Color.BLUE);
        
        // Set a new value.
        myTestCircleR2X2Y3Blue.setColor(Color.CYAN);
       
        // Test to see if value was correctly changed.
        assertEquals(myTestCircleR2X2Y3Blue.getColor(), Color.CYAN);

    }
    
    
    // Test to make sure NullPointerException is thrown when setting color
    /**
     * Test method for {@link Circle#setColor(java.awt.Color)}.
     */
    @Test (expected = NullPointerException.class)
    public void testSetNullColor() {
        
        myTestCircleR2X2Y3Blue.setColor(null);

    }


    /**
     * Test method for {@link Circle#getRadius()}.
     */
    @Test
    public void testGetRadius() {
        
        // Test initial radius=2.0 value.
        assertEquals(2.0, myTestCircleR2X2Y3Blue.getRadius(), TOLERANCE);
        
        // Change the value and re-test
        myTestCircleR2X2Y3Blue.setRadius(5.432);
        
        // Test new value of radius=5.432 value.
        assertEquals(5.432, myTestCircleR2X2Y3Blue.getRadius(), TOLERANCE);
    }


    /**
     * Test method for {@link Circle#getCenter()}.
     */
    @Test
    public void testGetCenter() {

        //Change them and make sure they still return the expected values.
        myTestCircleR2X2Y3Blue.setCenter(new Point(101, 8)); 
   
        // Retrieve the new values x=101, y=8 values.
        assertEquals(101, myTestCircleR2X2Y3Blue.getCenter().getX(), TOLERANCE);
        assertEquals(8, myTestCircleR2X2Y3Blue.getCenter().getY(), TOLERANCE);
    }


    /**
     * Test method for {@link Circle#getColor()}.
     */
    @Test
    public void testGetColor() {
        
        // Tests initial value before setting a new value.
        assertEquals(myTestCircleR2X2Y3Blue.getColor(), Color.BLUE);
        
        // Set a new value.
        myTestCircleR2X2Y3Blue.setColor(Color.ORANGE);
       
        // Test to see if value was correctly changed.
        assertEquals(myTestCircleR2X2Y3Blue.getColor(), Color.ORANGE);
    }


    /**
     * Test method for {@link Circle#calculateDiameter()}.
     */
    @Test
    public void testCalculateDiameter() {
        
        // The initial radius=2.0 thus diameter should be 2*radius=4.0
        assertEquals(4.0, myTestCircleR2X2Y3Blue.calculateDiameter(), TOLERANCE);
        
        // Here we set the radius to something more complex
        // Radius*2 = 9.12
        myTestCircleR2X2Y3Blue.setRadius(4.56);
        assertEquals(9.12 , myTestCircleR2X2Y3Blue.calculateDiameter(), TOLERANCE);
        
    }


    /**
     * Test method for {@link Circle#calculateCircumference()}.
     */
    @Test
    public void testCalculateCircumference() {
        // Circumference is 2*Pi*r where radius=2.0
        final Double circumferance1 = 2 * Math.PI * 2.0;
        
        assertEquals(circumferance1, myTestCircleR2X2Y3Blue.calculateCircumference(), 
                     TOLERANCE);
        
        // Change the radius and try a more complex calculation.
        myTestCircleR2X2Y3Blue.setRadius(6.85);
        
        // Circumferance is 2*Pi*r where radius=6.85
        final Double circumferance2 = 2 * Math.PI * 6.85;
        
        assertEquals(circumferance2, myTestCircleR2X2Y3Blue.calculateCircumference(), 
                     TOLERANCE);
    }


    /**
     * Test method for {@link Circle#calculateArea()}.
     */
    @Test
    public void testCalculateArea() {
       
        // The initial radius=2.0 thus the area should be PI * radius^2 = 12.5663
        final Double area1 = Math.PI * (2.0 * 2.0);
        assertEquals(area1, myTestCircleR2X2Y3Blue.calculateArea(), TOLERANCE);
        
        // Test area with a more complex number.
        myTestCircleR2X2Y3Blue.setRadius(5.65);
        
        //The new radius = 5.65 thus the area should be PI * radius^2 = 100.287
        final Double area2 = Math.PI * (5.65 * 5.65);
        assertEquals(area2, myTestCircleR2X2Y3Blue.calculateArea(), TOLERANCE);
    }

    
    /**
     * Test method for {@link Circle#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("There was an error with toString() method.",
                     "Circle [radius=2.00, center=java.awt.Point[x=2,y=3], "
                        + "color=java.awt.Color[r=0,g=0,b=255]]", 
                        myTestCircleR2X2Y3Blue.toString());
    }

}
