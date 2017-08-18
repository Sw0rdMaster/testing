import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Yatzy {

    public static int chance(List<Integer> dices)
    {
        return dices.stream().mapToInt(Integer::intValue).sum();
    }

    public static int yatzy(List<Integer> dices)
    {
        int firstDice = dices.get(0);
        long count = dices.stream().filter(d -> d == firstDice).count();
        return count == 5 ? 50 : 0;
    }

    public static int eyes(List<Integer> dices, int numberOfEyes){
        return (int) dices.stream().filter(d -> d == numberOfEyes).count() * numberOfEyes;
    }

    public static int scoreDicesOfSameValue(List<Integer> dices, int amountOfEyes)
    {
        int score = 0;
        for(int i = 1; i <= 6; i++){
            int amount = Collections.frequency(dices, i);
            if(amount >= amountOfEyes){
                score = amountOfEyes*i;
            }
        }
        return score;
    }

    public static int two_pair(List<Integer> dices)
    {
        int score = 0;
        for(int i = 1; i <= 6; i++){
            int amount = Collections.frequency(dices, i);
            if(amount >= 2){
                score += 2*i;
            }
        }
        return score;
    }

    public static int smallStraight(List<Integer> dices)
    {
        return dices.containsAll(Arrays.asList(1,2,3,4,5)) ? 15 : 0;
    }

    public static int largeStraight(List<Integer> dices)
    {
        return dices.containsAll(Arrays.asList(2,3,4,5,6)) ? 20 : 0;
    }

    public static int fullHouse(List<Integer> dices)
    {
        int result = 0;
        boolean hasThreeOfAKind = false;
        boolean hasPair = false;
        for(int i = 1; i <= 6; i++){
            if(Collections.frequency(dices, i) == 3){
                hasThreeOfAKind = true;
                result += 3 * i;
            };
            if(Collections.frequency(dices, i) == 2){
                hasPair = true;
                result += 2 * i;
            }
        }
        return (hasPair && hasThreeOfAKind) ? result : 0;
    }
}



