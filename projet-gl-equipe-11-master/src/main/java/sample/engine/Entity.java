package sample.engine;

import sample.engine.physics.Direction;

public abstract class Entity {
    private double posX;
    private double posY;
    private double stepX;
    private double stepY;
    private double lastX;
    private double lastY;
    private double speed;
    private double height;
    private double width;
    private Direction direction;
    private String ressource;




    public Entity(double posX, double posY, double speed, double height, double width, String ressource) {
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
        this.height = height;
        this.width = width;
        this.direction = Direction.STOP;
        this.ressource = ressource;
    }

    public Entity(double posX, double posY , String ressource){
        this.ressource = ressource;
        this.posY= posY;
        this.posX= posX;
    }
    public Entity(double posX, double posY, double width, double height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }
    public Entity(double posX, double posY, double width, double height,String ressource) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.ressource =ressource;
    }


    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public void setStepX(double stepX) {
        this.stepX = stepX;
    }

    public void setStepY(double stepY) {
        this.stepY = stepY;
    }

    public void setLastX(double lastX) {
        this.lastX = lastX;
    }

    public void setLastY(double lastY) {
        this.lastY = lastY;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }



    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getStepX() {
        return stepX;
    }

    public double getStepY() {
        return stepY;
    }

    public double getLastX() {
        return lastX;
    }

    public double getLastY() {
        return lastY;
    }

    public double getSpeed() {
        return speed;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public Direction getDirection() {
        return direction;
    }
    public String getRessource() {
        return ressource;
    }

    public void setRessource(String ressource) {
        this.ressource = ressource;
    }

    public double getLeftBound() {
        return posX;
    }

    public double getRightBound() {
        return posX + width;
    }

    public double getTopBound() {
        return posY;
    }

    public double getBottomBound() {
        return posY + height;
    }






}
