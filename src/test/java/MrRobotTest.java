import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MrRobotTest {

    private static MrRobot sut;

    @BeforeAll
    static void buildRobot(){
        sut = new MrRobot();
    }
    @ParameterizedTest
    @CsvSource({"90, 4, (4 0)"})
    @DisplayName("should return valid obstacle position when robot angle and position is zero")
    void shouldReturnValidObstaclePositionWhenRobotAngleAndPositionIsZero(
            int feixeValue, int feixeDistance, String expected
    ){
        sut.setRobotPosition(0, 0, 0);
        sut.setFeixe(feixeValue, feixeDistance);

        String result = sut.getObstaclePosition();

        assertThat(result).isEqualTo(expected);
    }
}
