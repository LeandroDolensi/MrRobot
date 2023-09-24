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
    @CsvSource({"0, 4, 0, (0 4)",
                "45, 6, 0, (4 4)",
                "90, 4, 0, (4 0)",
                "135, 6, 0, (4 -4)",
                "180, 4, 0, (0 -4)",
                "0, 6, 45, (-4 4)",
                "45, 4, 45, (0 4)",
                "90, 6, 45, (4 4)",
                "135, 4, 45, (4 0)",
                "180, 6, 45, (4 -4)",
                "0, 4, 90, (-4 0)",
                "45, 6, 90, (-4 4)",
                "90, 4, 90, (0 4)",
                "135, 6, 90, (4 4)",
                "180, 4, 90, (4 0)",
                "0, 6, 135, (-4 -4)",
                "45, 4, 135, (-4 0)",
                "90, 6, 135, (-4 4)",
                "135, 4, 135, (0 4)",
                "180, 6, 135, (4 4)",
                "0, 4, 180, (0 -4)",
                "45, 6, 180, (-4 -4)",
                "90, 4, 180, (-4 0)",
                "135, 6, 180, (-4 4)",
                "180, 4, 180, (0 4)",
                "0, 4, 270, (4 0)",
                "45, 6, 270, (4 -4)",
                "90, 4, 270, (0 -4)",
                "135, 6, 270, (-4 -4)",
                "180, 4, 270, (-4 0)"})
    @DisplayName("should return valid obstacle position when robot is rotation whithout self moving")
    void shouldReturnValidObstaclePositionWhenRobotIsRotationWhithoutSelfMoving(
            int feixeValue, int feixeDistance, int robotAngle, String expected
    ){
        sut.setRobotPosition(0, 0, robotAngle);
        sut.setFeixe(feixeValue, feixeDistance);

        String result = sut.getObstaclePosition();

        assertThat(result).isEqualTo(expected);
    }

}
