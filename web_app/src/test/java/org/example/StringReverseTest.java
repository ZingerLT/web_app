package org.example;

import org.example.exception.InputException;
import org.example.exception.LenghtException;
import org.example.exception.ServerException;
import org.junit.jupiter.api.Test;

public class StringReverseTest {

    @Test
    public void CorrectTest() throws InputException, ServerException, LenghtException {
      // String resultStr = StringReverse.Reversing("Wag1");
       //Assert.assertEquals("1gaW",resultStr);
    }

    @Test
    public void IncorrectTest() throws InputException, ServerException, LenghtException {
        //String resultStr = StringReverse.Reversing("");
        //Assert.assertNotEquals("", resultStr);
    }
}
