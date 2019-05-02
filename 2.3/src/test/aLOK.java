package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class aLOK
    {
        
        @Test
        public void test3()
            {
                
                System.out.println("test3 passes successfully");
            }
            
        @Test
        public void test4()
            {
                Assert.assertEquals("abn", "a");
            }
    }
