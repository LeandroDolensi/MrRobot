public class MrRobot {

    private int robotX1Position;
    private int robotY1Position;
    private int robotAngle;
    private int feixeValue;
    private int feixeDistance;


    public void setRobotPosition(int robotX1Position, int robotY1Position, int robotAngle) {
        this.robotX1Position = robotX1Position;
        this.robotY1Position = robotY1Position;
        this.robotAngle = robotAngle;
    }

    public void setFeixe(int feixeValue, int feixeDistance) {
        this.feixeValue = feixeValue;
        this.feixeDistance = feixeDistance;
    }

    public String getObstaclePosition() {

        int obstacleX1 = getObstacleX1Position();
        int obstacleY1 = getObstacleY1Position();

        String result = String.format("(%d %d)", obstacleX1, obstacleY1);

        return result;
    }

    private int getObstacleX1Position(){
        return (int) Math.round(feixeDistance * Math.cos(getThetaPolarAngleInRadians()));
    }

    private int getObstacleY1Position(){
        return (int) Math.round(feixeDistance * Math.sin(getThetaPolarAngleInRadians()));
    }

    private double getThetaPolarAngleInRadians(){

        int thetaPolarAngle = (90-feixeValue) + robotAngle;

        return Math.toRadians(thetaPolarAngle);
    }
}
