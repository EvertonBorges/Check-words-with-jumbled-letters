package br.com.cesar.checkwordswithjumbledletters;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExampleUnitTest {

    @Test
    public void testPartialPermutationYou(){
        boolean result = Utils.checkPartialPermutation("you", "yuo");
        assertTrue(result);
    }

    @Test
    public void testPartialPermutationProbably(){
        boolean result = Utils.checkPartialPermutation("probably", "porbalby");
        assertTrue(result);
    }

    @Test
    public void testPartialPermutation(){
        boolean result = Utils.checkPartialPermutation("despite", "desptie");
        assertTrue(result);
    }

    @Test
    public void testPartialPermutationMoon(){
        boolean result = Utils.checkPartialPermutation("moon", "nmoo");
        assertFalse(result);
    }

    @Test
    public void testPartialPermutationMisspellings(){
        boolean result = Utils.checkPartialPermutation("misspellings", "mpeissngslli");
        assertFalse(result);
    }

    @Test
    public void testPartialPermutationOccurrence(){
        boolean result = Utils.checkPartialPermutation("occurrence", "occurrency");
        assertFalse(result);
    }

}