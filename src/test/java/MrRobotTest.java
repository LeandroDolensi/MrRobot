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

    @ParameterizedTest
    @CsvSource({"1, 1, 0, 4, 0, (1 5)",
                "-1, 1, 45, 6, 0, (3 5)",
                "1, -1, 90, 4, 0, (5 -1)",
                "-1, -1, 135, 6, 0, (3 -5)",
                "-1, -1, 180, 4, 0, (-1 -5)",
                "1, 1, 0, 6, 45, (-3 5)",
                "1, 1, 45, 4, 45, (1 5)",
                "1, 1, 90, 6, 45, (5 5)",
                "1, 1, 45, 6, 90, (-3 5)",
                "1, 1, 90, 4, 90, (1 5)",
                "1, 1, 135, 6, 90, (5 5)",
                "1, 1, 180, 4, 90, (5 1)",
                "1, 1, 0, 6, 135, (-3 -3)",
                "1, 1, 45, 4, 135, (-3 1)",
                "1, 1, 90, 6, 135, (-3 5)",
                "1, 1, 135, 4, 135, (1 5)",
                "1, 1, 180, 6, 135, (5 5)",
                "1, 1, 0, 4, 180, (1 -3)",
                "1, 1, 45, 6, 180, (-3 -3)",
                "1, 1, 90, 4, 180, (-3 1)",
                "1, 1, 135, 6, 180, (-3 5)",
                "1, 1, 180, 4, 180, (1 5)",
                "1, 1, 0, 4, 270, (5 1)",
                "1, 1, 45, 6, 270, (5 -3)",
                "1, 1, 90, 4, 270, (1 -3)",
                "1, 1, 135, 6, 270, (-3 -3)",
                "1, 1, 180, 4, 270, (-3 1)"})
    @DisplayName("should return valid obstacle position when robot is rotation and movind around cartesian plan")
    void shouldReturnValidObstaclePositionWhenRobotIsRotationAndMovingAroundCartesianPlan(
            int robotX1Position,
            int robotY1Position,
            int feixeValue,
            int feixeDistance,
            int robotAngle,
            String expected
    ){
        sut.setRobotPosition(robotX1Position, robotY1Position, robotAngle);
        sut.setFeixe(feixeValue, feixeDistance);

        String result = sut.getObstaclePosition();

        assertThat(result).isEqualTo(expected);
    }

}
