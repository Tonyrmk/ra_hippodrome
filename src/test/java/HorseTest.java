import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class HorseTest {

    @ParameterizedTest
    @CsvSource({
            ", 2.4,7.5",
    })
    public void horseMadeThrowExceptionWithNullNameTest(String name, double speed, double distance) {

        assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));

    }

    @ParameterizedTest
    @CsvSource({
            ", 2.4,7.5",
    })
    public void horseMadeExceptionMessageWithNullNameTest(String name, double speed, double distance) {

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));

        assertEquals("Name cannot be null.", exception.getMessage());

    }

    @ParameterizedTest
    @CsvSource({
            "'', 2.4,7.5",
            "'  ', 2.4,7.5",
    })

    public void horseMadeThrowExceptionWithBlankNameTest(String name, double speed, double distance) {

        assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));

    }

    @ParameterizedTest
    @CsvSource({
            "'', 2.4,7.5",
            "'  ', 2.4,7.5"
    })
    public void horseMadeExceptionMessageWithBlankNameTest(String name, double speed, double distance) {

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));

        assertEquals("Name cannot be blank.", exception.getMessage());

    }

    @ParameterizedTest
    @CsvSource({
            "Pony, -12.4,7.5"
    })
    public void horseMadeThrowExceptionWithNegativeSpeedTest(String name, double speed, double distance) {

        assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));


    }

    @ParameterizedTest
    @CsvSource({
            "Pony, -12.4,7.5"
    })
    public void horseMadeExceptionMessageWithNegativeSpeedTest(String name, double speed, double distance) {

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));

        assertEquals("Speed cannot be negative.", exception.getMessage());

    }

    @ParameterizedTest
    @CsvSource({
            "Pony, 12.4,-7.5"
    })
    public void horseMadeThrowExceptionWithNegativeDistanceTest(String name, double speed, double distance) {

        assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));

    }

    @ParameterizedTest
    @CsvSource({
            "Pony, 12.4,-7.5"
    })
    public void horseMadeExceptionMessageWithNegativeDistanceTest(String name, double speed, double distance) {

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));

        assertEquals("Distance cannot be negative.", exception.getMessage());

    }

    @Test
    public void getNameTest() {
        Horse horse = new Horse("Pony", 12.4, 7.5);
        assertEquals("Pony", horse.getName());
    }

    @Test
    public void getSpeedTest() {
        Horse horse = new Horse("Pony", 12.4, 7.5);
        assertEquals(12.4, horse.getSpeed(), 0.1);
    }

    @Test
    public void getDistanceWithParamTest() {
        Horse horse = new Horse("Pony", 12.4, 7.5);
        assertEquals(7.5, horse.getDistance(), 0.1);
    }

    @Test
    public void getDistanceWithoutParamTest() {
        Horse horse = new Horse("Pony", 12.4);
        assertEquals(0, horse.getDistance(),0.1);
    }

    @Test
    public void moveGetRandomTest() {
        MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class);
        Horse horse = new Horse("Pony", 12.4, 7.5);
        horse.move();
        mockedStatic.verify(()->Horse.getRandomDouble(0.2, 0.9));
        mockedStatic.close();
    }

    @Test
    public void moveLogicTest() {
        MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class);
        mockedStatic.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(0.5);
        //Use mockito spy to test move method
        Horse horse =Mockito.spy(new Horse("Pony", 12.4, 7.5));
        horse.move();
        double expected = 7.5 + 12.4 * 0.5;
        assertEquals(expected, horse.getDistance(), 0.1);
        mockedStatic.close();
    }


}

