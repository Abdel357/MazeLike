module sample {
  requires javafx.controls;
    requires java.desktop;

    //exports sample;
  exports sample.engine.physics;
  exports sample.engine;
}