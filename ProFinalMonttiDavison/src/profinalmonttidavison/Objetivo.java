
package profinalmonttidavison;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Objetivo {
    private int posX, posY;
    private int w, h;
    private int direccionX, direccionY;
    
    public Objetivo(int w, int h) {
        this.posX = w;
        this.posY = h;
        
        this.direccionX = 1;
        this.direccionY = 1;
        
        this.w = w;
        this.h = h;
    }
    
    public Point getPos() {
        return new Point(this.posX, this.posY);
    }
    
    private void setPos(double x, double y) {
        this.posX = (int) x;
        this.posY = (int) y; 
    }
    
    public void step() {
      if (this.posX > this.w || this.posX < 0 || Math.random() <= 0.005) {
          this.direccionX *= -1;
      }
      
      if (this.posY > this.h || this.posY < 0 || Math.random() <= 0.005) {
          this.direccionY *= -1;
      }
      
      setPos(this.posX + 2*this.direccionX, this.posY + this.direccionY);
    } 
    
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(posX-15, posY-15, 30, 30);
    }
}
