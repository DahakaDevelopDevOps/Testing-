package Planes;

public class DesignedPlane extends Plane {
    public DesignedPlane(Plane plane) {
        super(plane.model, plane.getMaxSpeed(), plane.getMaxFlightDistance(), plane.getMaxLoadCapacity());
    }

}
