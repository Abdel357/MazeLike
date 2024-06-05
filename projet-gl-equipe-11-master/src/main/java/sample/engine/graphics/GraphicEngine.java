package sample.engine.graphics;

import sample.engine.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class GraphicEngine extends JPanel {
    private ArrayList<Sprite> sprites = new ArrayList<>();



    public GraphicEngine(int width, int height, ArrayList<Entity> listGraphicO) {

        setSize(width, height);
        setBackground(Color.lightGray);
        chargerLesSprites(listGraphicO);
    }

    private void chargerLesSprites(ArrayList<Entity> kk) {
        for (Entity k : kk) {
            BufferedImage image = chargerImage(k.getRessource());
            double x = k.getPosX();
            double y = k.getPosY();
            double widht = k.getWidth();
            double height = k.getHeight();
            sprites.add(new Sprite(x, y, widht, height, image));
        }
    }

    private BufferedImage chargerImage(String str) {
        String spritePath = str;
        try {
            return ImageIO.read(new FileInputStream(spritePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Sprite sprite : sprites) {
            sprite.draw(g);
        }
    }

    public ArrayList<Sprite> getSprites() {
        return sprites;
    }
    public void setSprites(ArrayList<Sprite> sprites) {
        this.sprites = sprites;
    }
}
