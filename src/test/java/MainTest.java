import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTimeout;

@Disabled("stopped to avoid overloading the system")
public class MainTest {


    @Test
    public void MainTest() {
        assertTimeout(
                ofSeconds(22),
                () -> {

                    Main.main(new String[0]);

                }
        );
    }


}
