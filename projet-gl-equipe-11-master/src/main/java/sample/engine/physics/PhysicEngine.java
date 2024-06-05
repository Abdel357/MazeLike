package sample.engine.physics;

import sample.engine.Entity;

import java.util.ArrayList;
import java.util.List;

public class PhysicEngine extends Entity implements Movement
        {
    public List<Obstacle> obstacles = new ArrayList<>();

    private Goal goal;

    public PhysicEngine(double posX, double posY, double speed, double height, double width, String ressource) {
        super(posX, posY, speed, height, width,ressource);
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    @Override
    public void move(Entity e, Direction direction) {

        switch (direction) {
            case UP:
                e.setDirection(direction);
                e.setStepX(0);
                e.setStepY(-1);
                break;
            case DOWN:
                e.setDirection(direction);
                e.setStepX(0);
                e.setStepY(1);
                break;
            case LEFT:
                e.setDirection(direction);
                e.setStepX(-1);
                e.setStepY(0);
                break;
            case RIGHT:
                e.setDirection(direction);
                e.setStepX(1);
                e.setStepY(0);
                break;
            case STOP:
                e.setDirection(direction);
                e.setStepX(0);
                e.setStepY(0);
                break;
        }
        double newX = e.getPosX() + e.getStepX();
        double newY = e.getPosY() + e.getStepY();

        if (!checkObstacleCollision(newX, newY, e)) {
            e.setPosX(newX);
            e.setPosY(newY);
        } else {
            e.setStepX(0);
            e.setStepY(0);

        }
    }


    public boolean checkObstacleCollision(double playerX, double playerY, Entity e) {
        for (Obstacle obstacle : obstacles) {
            if(e.getRightBound() + e.getStepX()  > obstacle.getLeftBound() &&
                    e.getLeftBound() + e.getStepX() < obstacle.getRightBound() &&
                    e.getBottomBound() + e.getStepY() > obstacle.getTopBound() &&
                    e.getTopBound() + e.getStepY() < obstacle.getBottomBound())
            {
                return true;
            }
        }
        return false;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public boolean checkGoalReached(Entity player) {
        return goal != null && goal.checkPlayerCollision(player);
    }
}
