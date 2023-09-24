import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MrRobotTest {
    
    
    
    @Test
    @DisplayName("should return d value collision if a is zero and feixe is 90")
    void shouldReturnDValueCollisionIfAIsZeroAndFeixeIs90(){

        MrRobot sut = new MrRobot();

        sut.setRobotPosition(0, 0, 0);
        sut.setFeixe(90, 4);

        String result = sut.getCollision();

        assertThat(result).isEqualTo("(4, 0");
    }
}
