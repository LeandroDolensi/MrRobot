public class MrRobot {

    int x1;
    int y1;
    int robotAngle;
    int feixeValue;
    int distance;


    public void setRobotPosition(int x1, int y1, int robotAngle) {
        this.x1 = x1;
        this.y1 = y1;
        this.robotAngle = robotAngle;
    }

    public void setFeixe(int feixeValue, int distance) {
        this.feixeValue = feixeValue;
        this.distance = distance;
    }

    public String getCollision() {

        int angleTheta = 90 - feixeValue;
        double angleThetaInRadians = Math.toRadians(angleTheta);

        int obstacleX1 = (int) Math.round(distance * Math.cos(angleThetaInRadians));
        int obstacleY1 = (int) Math.round(distance * Math.sin(angleThetaInRadians));

        String result = String.format("(%d, %d)", obstacleX1, obstacleY1);

        return result;
    }
}
