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

    public String getObstaclePosition() {

        int obstacleX1 = getObstacleX1Position();
        int obstacleY1 = getObstacleY1Position();

        String result = String.format("(%d, %d)", obstacleX1, obstacleY1);

        return result;
    }

    private int getObstacleX1Position(){
        return (int) Math.round(distance * Math.cos(getThetaPolarAngleInRadians()));
    }

    private int getObstacleY1Position(){
        return (int) Math.round(distance * Math.sin(getThetaPolarAngleInRadians()));
    }

    private double getThetaPolarAngleInRadians(){
        return Math.toRadians(90 - feixeValue);
    }
}
