package com.example.laboras2;

import org.junit.Test;

import static org.junit.Assert.*;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void TestCountChars1() {
        final String givenString = "sdfsdf";

        final Integer expectedResult = 6;
        final Integer actualResult = TextCounter.getCharsCount( givenString );

        assertEquals(expectedResult, actualResult);
        }

    @Test
    public void TestCountChars2() {
        final String givenString = "";

        final Integer expectedResult = 0;
        final Integer actualResult = TextCounter.getCharsCount( givenString );

        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = NullPointerException.class)
    public void TestCountChars3() {
        final String givenString = null;
        final Integer actualResult = TextCounter.getCharsCount( givenString );
    }
}
