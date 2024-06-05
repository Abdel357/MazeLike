package sample;

import sample.game.MazeGenerator;
import sample.game.SimpleGame;

import javax.swing.*;

public class Main {
  public static void main(String[] args){
      SwingUtilities.invokeLater(() -> {
        SimpleGame game = new SimpleGame();
        game.startGame();
        game.setVisible(true);
        System.out.println("true");
      });
    }
  }

