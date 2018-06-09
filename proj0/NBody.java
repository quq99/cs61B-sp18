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

    public static void main (String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        Planet [] allPlanets = readPlanets(filename);
        double radius = readRadius(filename);

        /**
         * draw the background
         */
        String backgroundFilename = "images/starfield.jpg";
        StdDraw.setScale(-1.5*radius, 1.5*radius);
        StdDraw.clear();

        StdDraw.picture(0, 0, backgroundFilename);

        for (Planet p : allPlanets) {
            p.draw();
        }

        /**
         * draw animation
         */
        StdDraw.enableDoubleBuffering();

        double timeCount = 0;
        int allPlanetsLen = allPlanets.length;
        /**
         * initial xForce and yForce of each planet
         */
        double[] xForces = new double[allPlanetsLen];
        double[] yForces = new double[allPlanetsLen];
        while (timeCount < T) {
            StdDraw.clear();
            /**
             * initial xForce and yForce of each planet
             */
            for (int i=0; i<allPlanetsLen; i++) {
                xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
                yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
            }
            /**
            * update on each of the planets.This 
            * will update each planet's position, velocity, and 
            * acceleration.
            */
            for (int i=0; i<allPlanetsLen; i++) {
                allPlanets[i].update(dt, xForces[i], yForces[i]);
            }


            /**
             * draw the background image
             */
            StdDraw.picture(0, 0, backgroundFilename);
            /**
             * draw all of the planets
             */
            for (Planet p : allPlanets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            timeCount += dt;
        }
        StdOut.printf("%d\n", allPlanets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < allPlanets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
               allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel, 
               allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);
        }

    }
}
