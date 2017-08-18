import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = Yatzy.chance(Arrays.asList(2,3,4,5,1));
        assertEquals(expected, actual);
    }

    @Test public void yatzy_scores_50() {
        int expected = 50;
        int actual = Yatzy.yatzy(Arrays.asList(4,4,4,4,4));
        assertEquals(expected, actual);
        assertEquals(50, Yatzy.yatzy(Arrays.asList(6,6,6,6,6)));
        assertEquals(0, Yatzy.yatzy(Arrays.asList(6,6,6,6,3)));
    }

    @Test public void countScoreForOnes() {
        assertTrue(Yatzy.eyes(Arrays.asList(1,2,3,4,5), 1) == 1);
        assertEquals(2, Yatzy.eyes(Arrays.asList(1,2,1,4,5), 1));
        assertEquals(0, Yatzy.eyes(Arrays.asList(6,2,2,4,5), 1));
        assertEquals(4, Yatzy.eyes(Arrays.asList(1,2,1,1,1), 1));
    }

    @Test
    public void countScoreForTwos() {
        assertEquals(4, Yatzy.eyes(Arrays.asList(1,2,3,2,6), 2));
        assertEquals(10, Yatzy.eyes(Arrays.asList(2,2,2,2,2), 2));
    }

    @Test
    public void countScoreForThrees() {
        assertEquals(6, Yatzy.eyes(Arrays.asList(1,2,3,2,3), 3));
        assertEquals(12, Yatzy.eyes(Arrays.asList(2,3,3,3,3), 3));
    }

    @Test
    public void one_pair() {
        assertEquals(6, Yatzy.scoreDicesOfSameValue(Arrays.asList(3,4,3,5,6), 2));
        assertEquals(10, Yatzy.scoreDicesOfSameValue(Arrays.asList(5,3,3,3,5), 2));
        assertEquals(12, Yatzy.scoreDicesOfSameValue(Arrays.asList(5,3,6,6,5), 2));
    }

    @Test
    public void two_Pair() {
        assertEquals(16, Yatzy.two_pair(Arrays.asList(3,3,5,4,5)));
        assertEquals(16, Yatzy.two_pair(Arrays.asList(3,3,5,5,5)));
    }

    @Test
    public void three_of_a_kind() 
    {
        assertEquals(9, Yatzy.scoreDicesOfSameValue(Arrays.asList(3,3,3,4,5), 3));
        assertEquals(15, Yatzy.scoreDicesOfSameValue(Arrays.asList(5,3,5,4,5), 3));
        assertEquals(9, Yatzy.scoreDicesOfSameValue(Arrays.asList(3,3,3,3,5), 3));
    }

    @Test
    public void four_of_a_kind() {
        assertEquals(12, Yatzy.scoreDicesOfSameValue(Arrays.asList(3,3,3,3,5), 4));
        assertEquals(20, Yatzy.scoreDicesOfSameValue(Arrays.asList(5,5,5,4,5), 4));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(Arrays.asList(1,2,3,4,5)));
        assertEquals(15, Yatzy.smallStraight(Arrays.asList(2,3,4,5,1)));
        assertEquals(0, Yatzy.smallStraight(Arrays.asList(1,2,2,4,5)));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(Arrays.asList(6,2,3,4,5)));
        assertEquals(20, Yatzy.largeStraight(Arrays.asList(2,3,4,5,6)));
        assertEquals(0, Yatzy.largeStraight(Arrays.asList(1,2,2,4,5)));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.fullHouse(Arrays.asList(6,2,2,2,6)));
        assertEquals(0, Yatzy.fullHouse(Arrays.asList(2,3,4,5,6)));
        assertEquals(0, Yatzy.fullHouse(Arrays.asList(2,2,4,5,6)));
    }
}
