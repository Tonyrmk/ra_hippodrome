import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class HippodromeTest {


    @Test
    public void hippodromeMadeThrowExceptionWithNullParamTest() {

        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));

    }

    @Test
    public void hippodromeMadeMessageNullParamTest() {

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));

        assertEquals("Horses cannot be null.", exception.getMessage());


    }

    @Test
    public void hippodromeMadeThrowExceptionWithNoneParamTest() {

        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(Arrays.asList()));


    }

    @Test
    public void hippodromeMadeMessageWithNoneParamTest() {

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(Arrays.asList()));

        assertEquals("Horses cannot be empty.", exception.getMessage());

    }

    @Test
    public void getHorseTest() {
        Horse horse = Mockito.mock(Horse.class);
        List<Horse> horses = new ArrayList();
        for (int i = 0; i < 30; i++) {
            horses.add(horse);
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertArrayEquals(horses.toArray(), hippodrome.getHorses().toArray());
    }

    @Test
    public void moveTest() {
        Horse horse = Mockito.mock(Horse.class);
        List<Horse> horses = new ArrayList();
        for (int i = 0; i < 50; i++) {
            horses.add(horse);
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();
        Mockito.verify(horse, times(50)).move();
    }


    @Test
    public void getWinnerTest() {
        Horse horse1 = new Horse("Pony", 12.4, 7.8);
        Horse horse2 = new Horse("Pony", 12.4, 7.6);
        Horse horse3 = new Horse("Pony", 12.4, 7.5);
        List<Horse> horses = new ArrayList();
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horse1, hippodrome.getWinner());
    }
}


