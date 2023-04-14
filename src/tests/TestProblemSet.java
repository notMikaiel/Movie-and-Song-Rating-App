package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestProblemSet {

    private final double EPSILON = 0.001;
    public void compareDoubles(double d1, double d2){
        assertTrue(Math.abs(d1-d2) < EPSILON);
    }
    @Test
    public void testAverage(){
        ArrayList<Double> test1 = new ArrayList<>(List.of(1.0,2.0,3.0));
        ArrayList<Double> test2 = new ArrayList<>(List.of(-5.0,5.0));
        ArrayList<Double> test3 = new ArrayList<>(List.of(6.5,6.5,8.5,8.5));
        ArrayList<Double> test4 = new ArrayList<>(List.of(-2.0,-4.0));
        ArrayList<Double> test5 = new ArrayList<>();
        ArrayList<Double> test6 = new ArrayList<>(List.of(0.0));
        ArrayList<Double> test7 = new ArrayList<>(List.of(1.0));
        ArrayList<Double> test8 = new ArrayList<>(List.of(-1.0));



        compareDoubles(ProblemSet.average(test1),2.0);
        compareDoubles(ProblemSet.average(test2),0.0);
        compareDoubles(ProblemSet.average(test3),7.5);
        compareDoubles(ProblemSet.average(test4),-3.0);
        compareDoubles(ProblemSet.average(test5),0.0);
        compareDoubles(ProblemSet.average(test6),0.0);
        compareDoubles(ProblemSet.average(test7),1.0);
        compareDoubles(ProblemSet.average(test8),-1.0);
    }
    @Test
    public void testSumOfDigit(){
        assertTrue(ProblemSet.sumOfDigits(123) == 6);
        assertTrue(ProblemSet.sumOfDigits(57) == 12);
        assertTrue(ProblemSet.sumOfDigits(-36) == 9);
    }

    @Test
    public void testBestKey(){
        HashMap<String,Integer> test1 = new HashMap<>(){{put("CSE",100); put("MTH",90); put("MGT",10);}};
        HashMap<String,Integer> test2 = new HashMap<>(){{put("cat",5);put("dog",5);put("fox",4);}};
        HashMap<String,Integer> test3 = new HashMap<>();
        HashMap<String, Integer> test4 = new HashMap<>(){{put("first",-1000);put("Second",-69);put("third",-2432);}};
        HashMap<String, Integer> test5 = new HashMap<>(){{put("first",0);put("second", 0);put("third",0);}};
        HashMap<String, Integer> test6 = new HashMap<>(){{put("first",1);put("second", 0);put("third",-1);}};
        HashMap<String, Integer> test7 = new HashMap<>(){{put("first",Integer.MIN_VALUE);put("second", Integer.MAX_VALUE);put("third",0);}};
        HashMap<String,Integer> test8 = new HashMap<>(){{put("first",5);}};
        HashMap<String, Integer> test9 = new HashMap<>(){{put("first",-1);put("second", -10);put("third",-100);}};
        HashMap<String, Integer> test10 = new HashMap<>(){{put("first",-1);put("second", -1);put("third",1000000);}};
        HashMap<String,Integer> test11 = new HashMap<>(){{put("first",-5);}};
        HashMap<String,Integer> test12 = new HashMap<>(){{put("",0);}};




        assertTrue(ProblemSet.bestKey(test1).equals("CSE"));
        assertTrue(ProblemSet.bestKey(test2).equals("cat"));
        assertTrue(ProblemSet.bestKey(test3).equals(""));
        assertTrue(ProblemSet.bestKey(test4).equals("Second"));
        assertTrue(ProblemSet.bestKey(test5).equals("third"));
        assertTrue(ProblemSet.bestKey(test5).equals("third"));
        assertTrue(ProblemSet.bestKey(test6).equals("first"));
        assertTrue(ProblemSet.bestKey(test7).equals("second"));
        assertTrue(ProblemSet.bestKey(test8).equals("first"));
        assertTrue(ProblemSet.bestKey(test9).equals("first"));
        assertTrue(ProblemSet.bestKey(test10).equals("third"));
        assertTrue(ProblemSet.bestKey(test11).equals("first"));
        assertTrue(ProblemSet.bestKey(test12).equals(""));


    }
}