package put.io.testing.junit;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
public class FailureOnErrorTest {
    @Test
    public void test1(){
        assertEquals(5, 6+4);
    }
    @Test
    public void test2(){
        int[] tab = {1,2,3};
        System.out.println(tab[4]);
    }
    @Test
    public void test3(){
        try{
            assertEquals(5,10);
        }catch(Throwable e){
            System.out.println(e.getClass().getCanonicalName());
        }
    }
}
