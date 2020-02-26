package edu.nyu.cs9053.homework6;

import java.util.List;

public class WireDiagramHelper implements WireDiagram {

    private final TripWire tripWire;
    private List<Wire> tripwires;

    public WireDiagramHelper(TripWire tripWire, List<Wire> tripwires) {
        this.tripWire = tripWire;
        this.tripwires = tripwires;
    }

    @Override
    public TripWire getTripWires() { return tripWire; }

    public List<Wire> getTripWiress() {
        return tripwires;
    }

}

