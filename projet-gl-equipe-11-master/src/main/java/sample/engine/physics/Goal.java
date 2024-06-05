package sample.engine.physics;

import sample.engine.Entity;

public class Goal extends Entity {

    public Goal(double x, double y, double width, double height, String resource) {
        super(x, y, 0, width, height, resource);
    }

    public boolean checkPlayerCollision(Entity player) {
        return player.getPosX() < this.getPosX() + this.getWidth() &&
                player.getPosX() + player.getWidth() > this.getPosX() &&
                player.getPosY() < this.getPosY() + this.getHeight() &&
                player.getPosY() + player.getHeight() > this.getPosY();
    }
}
