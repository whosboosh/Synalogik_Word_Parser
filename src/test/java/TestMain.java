
import com.synalogik.Dictionary;
import com.synalogik.Main;

import com.synalogik.MutableInt;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {

    String filePath = "src/main/resources/short.txt";
    Dictionary dict = new Dictionary(filePath);

    @Test
    public void testAverageWordLength()
    {
        assertEquals(dict.getAverageWordLength(), 4.666666666666667 );
    }

    @Test
    public void testWordCount()
    {
        assertEquals(dict.getWordCount(), 9);
    }

    @Test
    public void testFrequencyEachLength()
    {
        HashMap<Integer, MutableInt> wordMap = dict.getWordMap();

        assertEquals(1, wordMap.get(1).get());
        assertEquals(1, wordMap.get(2).get());
        assertEquals(1, wordMap.get(3).get());
        assertEquals(2, wordMap.get(4).get());
        assertEquals(2, wordMap.get(5).get());
        assertEquals(1, wordMap.get(8).get());
        assertEquals(1, wordMap.get(10).get());
    }

    @Test
    public void testHighestWordCount()
    {
        assertEquals(2, dict.getHighestWordCount());
    }
}
