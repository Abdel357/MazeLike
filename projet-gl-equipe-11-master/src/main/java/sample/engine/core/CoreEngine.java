package sample.engine.core;

import sample.engine.physics.PhysicEngine;
import sample.engine.graphics.GraphicEngine;

public class CoreEngine {

    private PhysicEngine physicEngine;
    private GraphicEngine graphicEngine;

    public CoreEngine(GraphicEngine graphicEngine, PhysicEngine physicEngine) {
        this.physicEngine = physicEngine;
        this.graphicEngine = graphicEngine;
    }

    public void start() {
        this.graphicEngine.setVisible(true);
    }

    public PhysicEngine getPhysicEngine() {
        return this.physicEngine;
    }

    public GraphicEngine getWindow() {
        return this.graphicEngine;
    }

}
