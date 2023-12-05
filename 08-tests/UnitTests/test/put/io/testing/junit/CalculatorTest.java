package put.io.testing.junit;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAdd(){
        Calculator kacoolator = new Calculator();
        assertEquals(-5, kacoolator.add(-8,3));
        assertEquals(11, kacoolator.add(9,2));
    }
    @Test
    public void testMultiply(){
        Calculator kacoolator = new Calculator();
        assertEquals(0, kacoolator.multiply(2136,0));
        assertEquals(21, kacoolator.multiply(3,7));
    }

    @Test
    public void testAddPositiveNumbers(){
        Calculator kacoolator = new Calculator();
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                ()->{kacoolator.addPositiveNumbers(-5,6);}
        );
        assertEquals("The arguments must be positive",e.getMessage());
    }
}