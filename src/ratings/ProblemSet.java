package ratings;

import java.util.ArrayList;
import java.util.HashMap;

public class ProblemSet {
    public static double average(ArrayList<Double> numbers) {
        if(numbers.isEmpty()){return 0.0;}

        double counter = 0.0;
        double sum = 0;

        for (int i=0; i < numbers.size(); i++){
            counter+=1;
            sum += numbers.get(i);
        }
        return (sum/counter);
    }

    public static int sumOfDigits(int x){
        int sum = 0;
        int inputAbs = Math.abs(x);

        while (inputAbs > 0){
            sum += inputAbs % 10;
            inputAbs /=10;
        }
        return sum;
    }

    public static String bestKey(HashMap<String,Integer> input){
        if (input.isEmpty()){return "";}

        String retval = null;
        int max_value = Integer.MIN_VALUE;

        for(String key : input.keySet()){
            if(input.get(key) > max_value){
                max_value = input.get(key);
                retval = key;
            }
        }
        return retval;
    }
}
