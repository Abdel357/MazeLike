package sample.engine.graphics;

import sample.engine.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite extends Entity {
    BufferedImage image;

    public Sprite(double posX, double posY, double speed, double height, double width, String ressource, BufferedImage image) {
        super(posX, posY, speed, height, width, ressource);
        this.image = image;
    }

    public Sprite(double posX, double posY, String ressource, BufferedImage image) {
        super(posX, posY, ressource);
        this.image = image;
    }
    public Sprite(double posX, double posY, BufferedImage image){
        super(posX,posY,"");
        this.image = image;
    }

    public Sprite(double posX, double posY, double width, double height, BufferedImage image){
        super(posX,posY, width, height,"");
        this.image = image;
    }
    public BufferedImage getImage() {
        return image;
    }

    public void draw(Graphics g){
        g.drawImage(image, (int )this.getPosX(), (int)this.getPosY(), null);
    }
}
