package edu.nyu.cs9053.homework6;

import java.util.ArrayList;
import java.util.List;

public class BombHandler implements BombSquadTechnician {

    // by creating one static instance, the recruit() will only return the same object, which is the static part of BombHandler,
    // in this way there will be only one instance in the whole process (the best one)

    private final static BombHandler instance = new BombHandler();
    private final Toolbox toolBox = new Toolbox();
    public BombHandler() {
    }

    static BombHandler getBombHandler() {
        return instance;
    }

    @Override
    public WireDiagram assess(Bomb bomb) {
        // System.out.println("Start assessing bomb " + bomb.getBombNumber());
        Wire[] bombWires = bomb.getWires();
        List<Wire> tripWires = new ArrayList<>();
        try {
            for (Wire bombWire : bombWires) {
                WireColor color = toolBox.getColor(bombWire);
                if (color == WireColor.Blue || color == WireColor.Red) {
                    tripWires.add(bombWire);
                }
                Object object = toolBox.invokeMethod(bombWire, "callingCard");
                if (object.getClass() != bombWire.getClass()) {
                    EvilVillain evilguy = (EvilVillain) object;
                    toolBox.setField(evilguy, "free", false);
                }
            }
        } catch (ToolMisuseException e) {
            System.out.println("Assess bomb wrong! reason:" + e.getMessage());
        }
        // Add the whole wire to a new class, make it easy to defuse and cut
        TripWire fakeTripWire = new TripWire(tripWires.get(0), tripWires.get(0));
        return new WireDiagramHelper(fakeTripWire, tripWires);
    }

    @Override
    public void defuse(Bomb bomb, WireDiagram diagram) {
        WireDiagramHelper wireDiagramHelper = (WireDiagramHelper) diagram;
        List<Wire> tripWires = wireDiagramHelper.getTripWiress();
        int size = tripWires.size();
        for (int i = 0; i < size; i++) {
            Wire wire = tripWires.get(0);
            tripWires.remove(0);
            wire.cut();
        }
    }
}
