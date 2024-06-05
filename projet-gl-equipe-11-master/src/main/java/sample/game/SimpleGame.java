package sample.game;

import sample.engine.Entity;
import sample.engine.core.CoreEngine;
import sample.engine.graphics.GraphicEngine;
import sample.engine.graphics.Player;
import sample.engine.physics.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class SimpleGame extends JFrame implements KeyListener {

    private CoreEngine coreEngine;
    private Timer timer;
    GraphicEngine graphicEngine;

    PhysicEngine physicEngine;
    Direction currentDirectionPlayer1 = Direction.STOP;
    Direction currentDirectionPlayer2 = Direction.STOP;


    public SimpleGame() {
        ArrayList<Entity> graphicObjects = new ArrayList<>();

        Entity playerSprite = new Player(0, 0,15, 15,"src/main/images/spritej115x15.png");
        Entity playerSprite2 = new Player(0, 0,15, 15,"src/main/images/spritej215x15.png");
        Goal goal = new Goal(760, 760, 20, 20, "src/main/images/drapeau.png");

        graphicObjects.add(playerSprite);
        graphicObjects.add(playerSprite2);
        graphicObjects.add(goal);


        MazeGenerator testmaze = new MazeGenerator(40, 40);
        testmaze.generateMaze();
        int[][] map = testmaze.getMaze();


        physicEngine = new PhysicEngine(0, 0, 10, 50, 50, "Simple Game Window");

        for (int i = 0; i < map.length; i++){
            Obstacle obstacle3 = new Obstacle(i*20,-20,20,20);
            obstacle3.setRessource("src/main/images/noir20par20.png");
            graphicObjects.add(obstacle3);
            physicEngine.addObstacle(obstacle3);
            Obstacle obstacle4 = new Obstacle(-20,i*20,20,20);
            obstacle4.setRessource("src/main/images/noir20par20.png");
            graphicObjects.add(obstacle4);
            physicEngine.addObstacle(obstacle4);
        }

        for (int i = 0; i < map.length; i++){
            for(int j=0; j< map.length; j++){
                if (map[i][j] == 0){
                    Obstacle obstacle3 = new Obstacle(i*20,j*20,20,20);


                    if(i == 0 && j > 0 && i < map.length - 1 && j < map.length - 1){
                        obstacle3.setRessource("src/main/images/linehori.png");
                    } else if(i > 0 && j == 0 && i < map.length - 1 && j < map.length - 1){
                        obstacle3.setRessource("src/main/images/linevert.png");
                    } else if(i > 0 && j > 0 && i < map.length - 1 && j < map.length - 1){
                        if(map[i + 1][j] == 0 && map[i][j + 1] == 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0){
                            obstacle3.setRessource("src/main/images/cross.png");
                        } else if (map[i + 1][j] == 0 && map[i][j + 1] == 0 && map[i - 1][j] == 0 && map[i][j - 1] == 1) {
                            obstacle3.setRessource("src/main/images/tdown.png");
                        } else if (map[i + 1][j] == 0 && map[i][j + 1] == 0 && map[i - 1][j] == 1 && map[i][j - 1] == 0) {
                            obstacle3.setRessource("src/main/images/tright.png");
                        } else if (map[i + 1][j] == 0 && map[i][j + 1] == 1 && map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                            obstacle3.setRessource("src/main/images/tup.png");
                        } else if (map[i + 1][j] == 1 && map[i][j + 1] == 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                            obstacle3.setRessource("src/main/images/tleft.png");
                        } else if (map[i + 1][j] == 1 && map[i][j + 1] == 0 && map[i - 1][j] == 1 && map[i][j - 1] == 0) {
                            obstacle3.setRessource("src/main/images/linevert.png");
                        } else if (map[i + 1][j] == 0 && map[i][j + 1] == 1 && map[i - 1][j] == 0 && map[i][j - 1] == 1) {
                            obstacle3.setRessource("src/main/images/linehori.png");
                        } else if (map[i + 1][j] == 0 && map[i][j + 1] == 0 && map[i - 1][j] == 1 && map[i][j - 1] == 1) {
                            obstacle3.setRessource("src/main/images/cornerse.png");
                        } else if (map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                            obstacle3.setRessource("src/main/images/cornerno.png");
                        } else if (map[i + 1][j] == 1 && map[i][j + 1] == 0 && map[i - 1][j] == 0 && map[i][j - 1] == 1) {
                            obstacle3.setRessource("src/main/images/cornerso.png");
                        } else if (map[i + 1][j] == 0 && map[i][j + 1] == 1 && map[i - 1][j] == 1 && map[i][j - 1] == 0) {
                            obstacle3.setRessource("src/main/images/cornerne.png");
                        } else if (map[i + 1][j] == 1 && map[i][j + 1] == 0 && map[i - 1][j] == 1 && map[i][j - 1] == 1) {
                            obstacle3.setRessource("src/main/images/todown.png");
                        } else if (map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i - 1][j] == 0 && map[i][j - 1] == 1) {
                            obstacle3.setRessource("src/main/images/toleft.png");
                        } else if (map[i + 1][j] == 0 && map[i][j + 1] == 1 && map[i - 1][j] == 1 && map[i][j - 1] == 1) {
                            obstacle3.setRessource("src/main/images/toright.png");
                        } else if (map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i - 1][j] == 1 && map[i][j - 1] == 0) {
                            obstacle3.setRessource("src/main/images/toup.png");
                        } else{
                            obstacle3.setRessource("src/main/images/noir20par20.png");
                        }
                    } else {
                        obstacle3.setRessource("src/main/images/noir20par20.png");
                    } // Ce bout de if else if sert a donné le bon sprite au mur en fonction de ses voisins


                    graphicObjects.add(obstacle3);
                    physicEngine.addObstacle(obstacle3);
                }
            }
        }





        graphicEngine = new GraphicEngine(780, 815, graphicObjects);

        coreEngine = new CoreEngine(graphicEngine,physicEngine);
        coreEngine.getPhysicEngine().setGoal(goal);



        setTitle("Maze-Like");
        setSize(780,815);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setLayout(new BorderLayout());
        add(graphicEngine, BorderLayout.CENTER);
        this.setFocusable(true);
        this.setResizable(false);
        this.requestFocusInWindow();

        timer = new Timer(6, e -> {
            Entity player1 = coreEngine.getWindow().getSprites().get(0);
            Entity player2 = coreEngine.getWindow().getSprites().get(1);
            if (currentDirectionPlayer1 != Direction.STOP) {
                physicEngine.move(player1, currentDirectionPlayer1);
            }
            if (currentDirectionPlayer2 != Direction.STOP) {
                physicEngine.move(player2, currentDirectionPlayer2);
            }
            graphicEngine.repaint();
        });
        timer.start();
    }


    public void startGame() {
        coreEngine.start();
        System.out.println("lancement");
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleGame game = new SimpleGame();
            game.startGame();
            game.setVisible(true);
            System.out.println("true");
        });
    }*/

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                currentDirectionPlayer1 = Direction.UP;
                if (coreEngine.getPhysicEngine().checkGoalReached(coreEngine.getWindow().getSprites().get(0))) {
                    JOptionPane.showMessageDialog(this, "Player 1 wins!");
                    timer.stop();
                }
                break;
            case KeyEvent.VK_DOWN:
                currentDirectionPlayer1 = Direction.DOWN;
                if (coreEngine.getPhysicEngine().checkGoalReached(coreEngine.getWindow().getSprites().get(0))) {
                    JOptionPane.showMessageDialog(this, "Player 1 wins!");
                    timer.stop();
                }
                break;
            case KeyEvent.VK_LEFT:
                currentDirectionPlayer1 = Direction.LEFT;
                if (coreEngine.getPhysicEngine().checkGoalReached(coreEngine.getWindow().getSprites().get(0))) {
                    JOptionPane.showMessageDialog(this, "Player 1 wins!");
                    timer.stop();
                }
                break;
            case KeyEvent.VK_RIGHT:
                currentDirectionPlayer1 = Direction.RIGHT;
                if (coreEngine.getPhysicEngine().checkGoalReached(coreEngine.getWindow().getSprites().get(0))) {
                    JOptionPane.showMessageDialog(this, "Player 1 wins!");
                    timer.stop();
                }
                break;

            case KeyEvent.VK_Z:
                currentDirectionPlayer2 = Direction.UP;
                if (coreEngine.getPhysicEngine().checkGoalReached(coreEngine.getWindow().getSprites().get(1))) {
                    JOptionPane.showMessageDialog(this, "Player 2 wins!");
                    timer.stop();
                }
                break;
            case KeyEvent.VK_S:
                currentDirectionPlayer2 = Direction.DOWN;
                if (coreEngine.getPhysicEngine().checkGoalReached(coreEngine.getWindow().getSprites().get(1))) {
                    JOptionPane.showMessageDialog(this, "Player 2 wins!");
                    timer.stop();
                }
                break;
            case KeyEvent.VK_Q:
                currentDirectionPlayer2 = Direction.LEFT;
                if (coreEngine.getPhysicEngine().checkGoalReached(coreEngine.getWindow().getSprites().get(1))) {
                    JOptionPane.showMessageDialog(this, "Player 2 wins!");
                    timer.stop();
                }
                break;
            case KeyEvent.VK_D:
                currentDirectionPlayer2 = Direction.RIGHT;
                if (coreEngine.getPhysicEngine().checkGoalReached(coreEngine.getWindow().getSprites().get(1))) {
                    JOptionPane.showMessageDialog(this, "Player 2 wins!");
                    timer.stop();
                }
                break;

            case KeyEvent.VK_SPACE:
                currentDirectionPlayer1 = Direction.STOP;
                currentDirectionPlayer2 = Direction.STOP;
                break;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
