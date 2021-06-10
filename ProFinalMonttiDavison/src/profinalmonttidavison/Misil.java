
package profinalmonttidavison;

import geometricas.Angular;
import geometricas.RellenaConPuntos;
import java.awt.*;

public class Misil {
    private int posX, posY, posLinea;
    private Objetivo o;
    private Polygon path;

    public Misil(Objetivo objetivo, int posX, int posY) {
        this.o = objetivo;
        
        this.posX = posX;
        this.posY = posY;
        
        genPath();
    }
    
    private void setPos(int x, int y) {
        this.posX = x;
        this.posY = y; 
    }
    
    private void genPath() {
        this.posLinea = 0;
        this.path = new Polygon();
        Point pAux = this.o.getPos();
        this.path.addPoint(this.posX, this.posY);
        RellenaConPuntos.nuevaLinea(new Point(this.posX, this.posY), pAux, this.path);
        this.path.addPoint(pAux.x, pAux.y);
    }
    
    public void step() {
      if (Math.random() <= 0.05 || this.posLinea == path.npoints - 1) genPath();
      this.posLinea++;
      setPos(this.path.xpoints[this.posLinea], this.path.ypoints[this.posLinea]);
    } 
    
    public boolean contacto() {
        return (Angular.distEntre2Puntos(new Point(this.posX, this.posY), this.o.getPos()) < 20.0);
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(posX-10, posY-10, 20, 20);
        g.setColor(Color.BLACK);
        g.drawPolyline(path.xpoints, path.ypoints, path.npoints);
    }
}
