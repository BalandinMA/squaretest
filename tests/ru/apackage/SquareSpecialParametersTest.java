package ru.apackage;

import org.junit.Test;
import ru.socialquantum.testtasks.Square;
import ru.socialquantum.testtasks.SquareFactory;
import static org.junit.Assert.*;

public class SquareSpecialParametersTest {
    private double delta = 0.00000000000001;

    @Test
    public void testNegativeSideLength() {
        //preparing
        double sideLength=-1;

        //verification
        try{
            Square square = SquareFactory.newSquare(sideLength);
            fail();
        }catch (Exception e){
        }
    }

    @Test
    public void testMaxValueSideLength() {
        //preparing
        double sideLength = Math.sqrt(Double.MAX_VALUE);

        //verification
        try{
            Square square = SquareFactory.newSquare(sideLength);
            fail();
        }catch (Exception e){
        }
    }

    @Test
    public void testMinValueSideLength() {
        //preparing
        double sideLength = Math.sqrt(Double.MIN_NORMAL);

        //verification
        try{
            Square square = SquareFactory.newSquare(sideLength);
            fail();
        }catch (Exception e){
        }
    }

    @Test
    public void testNanSideLength() {
        //preparing
        double sideLength=Double.NaN;

        //verification
        try{
            Square square = SquareFactory.newSquare(sideLength);
            fail();
        }catch (Exception e){
        }
    }

    @Test
    public void testNullEqualsSquare() {
        //preparing
        double sideLength = 3002.3466;
        Square square = SquareFactory.newSquare(sideLength);

        //verification
        assertFalse(square.equalsSquare(null));
    }

    @Test
    public void testHighPrecisionSquare() {
        //preparing
        double sideLength =  40.00000000000001;
        Double correctSquare = Math.pow(sideLength, 2);
        Square square = SquareFactory.newSquare(sideLength);

        //verification
        assertEquals(correctSquare, square.square(), delta);
    }

}
