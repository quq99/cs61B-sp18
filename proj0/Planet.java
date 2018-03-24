public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    /**
     * static final means to use that variable 
     * anytime wish to use the constant
     * java supports scientific notation
     */
    public static final double G = 6.67e-11;
    
    public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
        xxPos       =  xP;
        yyPos       =  yP;
        xxVel       =  xV;
        yyVel       =  yV;
        mass        =  m ;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos       = p.xxPos;
        yyPos       = p.yyPos;
        xxVel       = p.xxVel;
        yyVel       = p.yyVel;
        mass        = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dxx = xxPos - p.xxPos;
        double dyy = yyPos - p.yyPos;
        return Math.sqrt(dxx*dxx + dyy*dyy);
    }

    public double calcForceExertedBy(Planet p) {
        double distance = calcDistance(p);
        return (G*mass*p.mass / (distance*distance));
    }

    public double calcForceExertedByX(Planet p) {
        double distance = calcDistance(p);
        double force = calcForceExertedBy(p);
        double dxx = p.xxPos - xxPos;
        return force * dxx / distance;
    }

    public double calcForceExertedByY(Planet p) {
        double distance = calcDistance(p);
        double force = calcForceExertedBy(p);
        double dyy = p.yyPos - yyPos;
        return force * dyy / distance;
    }


}
