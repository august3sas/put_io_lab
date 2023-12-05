package put.io.testing.audiobooks;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AudiobookPriceCalculatorTest {
    @Test
    public void testCustomerSubscriber(){
        AudiobookPriceCalculator apc = new AudiobookPriceCalculator();
        Customer c = new Customer("c1", Customer.LoyaltyLevel.STANDARD,true);
        Audiobook a = new Audiobook("a1",10.0);
        assertEquals(0.0,apc.calculate(c,a));
    }
    @Test
    public void testCustomerNonSubscriberStandard(){
        AudiobookPriceCalculator apc = new AudiobookPriceCalculator();
        Customer c = new Customer("c2", Customer.LoyaltyLevel.STANDARD,false);
        Audiobook a = new Audiobook("a2",10.0);
        assertEquals(10.0,apc.calculate(c,a));
    }
    @Test
    public void testCustomerNonSubscriberSilver(){
        AudiobookPriceCalculator apc = new AudiobookPriceCalculator();
        Customer c = new Customer("c3", Customer.LoyaltyLevel.SILVER,false);
        Audiobook a = new Audiobook("a3",10.0);
        assertEquals(9.0,apc.calculate(c,a));
    }
    @Test
    public void testCustomerNonSubscriberGold(){
        AudiobookPriceCalculator apc = new AudiobookPriceCalculator();
        Customer c = new Customer("c4", Customer.LoyaltyLevel.GOLD,false);
        Audiobook a = new Audiobook("a4",10.0);
        assertEquals(8.0,apc.calculate(c,a));
    }
}