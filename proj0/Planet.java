public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    
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
        p.xxPos = xxPos;
        p.yyPos = yyPos;
        p.xxVel = xxVel;
        p.yyVel = yyVel;
        p.mass = mass;
        p.imgFileName = imgFileName;
    }



}
