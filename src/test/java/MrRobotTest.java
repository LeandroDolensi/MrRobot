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
    @CsvSource({"0, 4, (0 4)",
                "45, 6, (4 4)",
                "90, 4, (4 0)",
                "135, 6, (4 -4)",
                "180, 4, (0 -4)"})
    @DisplayName("should return valid obstacle position when robot angle and position is zero")
    void shouldReturnValidObstaclePositionWhenRobotAngleAndPositionIsZero(
            int feixeValue, int feixeDistance, String expected
    ){
        sut.setRobotPosition(0, 0, 0);
        sut.setFeixe(feixeValue, feixeDistance);

        String result = sut.getObstaclePosition();

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0, 6, (-4 4)",
                "45, 4, (0 4)",
                "90, 6, (4 4)",
                "135, 4, (4 0)",
                "180, 6, (4 -4)"})
    @DisplayName("should return valid obstacle position when robot angle is 45 and position is zero")
    void shouldReturnValidObstaclePositionWhenRobotAngleIs45AndPositionIsZero(
            int feixeValue, int feixeDistance, String expected
    ){
        sut.setRobotPosition(0, 0, 45);
        sut.setFeixe(feixeValue, feixeDistance);

        String result = sut.getObstaclePosition();

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0, 4, (-4 0)",
                "45, 6, (-4 4)",
                "90, 4, (0 4)",
                "135, 6, (4 4)",
                "180, 4, (4 0)"})
    @DisplayName("should return valid obstacle position when robot angle is 90 and position is zero")
    void shouldReturnValidObstaclePositionWhenRobotAngleIs90AndPositionIsZero(
            int feixeValue, int feixeDistance, String expected
    ){
        sut.setRobotPosition(0, 0, 90);
        sut.setFeixe(feixeValue, feixeDistance);

        String result = sut.getObstaclePosition();

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0, 6, (-4 -4)",
                "45, 4, (-4 0)",
                "90, 6, (-4 4)",
                "135, 4, (0 4)",
                "180, 6, (4 4)"})
    @DisplayName("should return valid obstacle position when robot angle is 135 and position is zero")
    void shouldReturnValidObstaclePositionWhenRobotAngleIs135AndPositionIsZero(
            int feixeValue, int feixeDistance, String expected
    ){
        sut.setRobotPosition(0, 0, 135);
        sut.setFeixe(feixeValue, feixeDistance);

        String result = sut.getObstaclePosition();

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0, 4, (0 -4)",
                "45, 6, (-4 -4)",
                "90, 4, (-4 0)",
                "135, 6, (-4 4)",
                "180, 4, (0 4)"})
    @DisplayName("should return valid obstacle position when robot angle is 180 and position is zero")
    void shouldReturnValidObstaclePositionWhenRobotAngleIs180AndPositionIsZero(
            int feixeValue, int feixeDistance, String expected
    ){
        sut.setRobotPosition(0, 0, 180);
        sut.setFeixe(feixeValue, feixeDistance);

        String result = sut.getObstaclePosition();

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0, 4, (4 0)",
                "45, 6, (4 -4)",
                "90, 4, (0 -4)",
                "135, 6, (-4 -4)",
                "180, 4, (-4 0)"})
    @DisplayName("should return valid obstacle position when robot angle is 270 and position is zero")
    void shouldReturnValidObstaclePositionWhenRobotAngleIs270AndPositionIsZero(
            int feixeValue, int feixeDistance, String expected
    ){
        sut.setRobotPosition(0, 0, 270);
        sut.setFeixe(feixeValue, feixeDistance);

        String result = sut.getObstaclePosition();

        assertThat(result).isEqualTo(expected);
    }
}
