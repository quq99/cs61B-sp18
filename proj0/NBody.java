public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);
        int first = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet [] readPlanets(String filename) {
        In in = new In(filename);
        int numbers = in.readInt();
        double radius = in.readDouble();

        Planet [] planets = new Planet[numbers];
        for (int i=0; i<numbers; i++) {
            double xx = in.readDouble();
            double yy = in.readDouble();
            double xv = in.readDouble();
            double yv = in.readDouble();
            double mass = in.readDouble();
            String name = in.readString();

            planets[i] = new Planet(xx, yy, xv, yv, mass, name);
        }

        return planets;
    }
}
