package ru.apackage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import ru.socialquantum.testtasks.Square;
import ru.socialquantum.testtasks.SquareFactory;


@RunWith(Parameterized.class)
public class SquareStandardWorkTest {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                //Fill in the values of the most interval used by the user
                { 0.0, 1.0 },{ 0.334 , 0.00046 },{ 7.4355 , 5.3466 },{ 10.0 , 10.1 },{ 13.0456 , 17.233 },
                { 20.0 , 20.01 },{ 24.00456 , 27.000342 },{ 30.0 , 31.01 },{ 67 , 48 },{ 134 , 256 },
                { 145435.2344 , 348064.0045365 },{ 1000000.0002324 , 233445.28933 }
        });
    }

    private double sideLength1;
    private double sideLength2;
    private double delta = 0.0000000000001;
    private Square square;

    public SquareStandardWorkTest(double inputSideLength1, double inputSideLength2) {
        sideLength1= inputSideLength1;
        sideLength2= inputSideLength2;
    }

    @Before
    public void before(){
        square = SquareFactory.newSquare(sideLength1);
    }

    @Test
    public void testSideLength() {
        //verification
        assertEquals(sideLength1, square.sideLength(), delta);
    }

    @Test
    public void testSquare() {
        //preparing
        Double correctSquare = Math.pow(sideLength1, 2);

        //verification
        assertEquals(correctSquare, square.square(), delta);
    }

    @Test
    public void testRightEqualsSquare() {
        //preparing
        Square square2 = SquareFactory.newSquare(sideLength1);

        //verification
        assertTrue(square.equalsSquare(square2));
    }

    @Test
    public void testWrongEqualsSquare() {
        //preparing
        Square square2 = SquareFactory.newSquare(sideLength2);

        //verification
        assertFalse(square.equalsSquare(square2));
    }

    @Test
    public void testEqualsSquareToItself() {
        //verification
        assertTrue(square.equalsSquare(square));
    }



}

