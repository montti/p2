
package profinalmonttidavison;

import java.awt.Color;
import java.awt.Graphics;

public class Avion {
    private int posX, posY, direccion;
    private Misil m;
    
    public Avion(int x, int y) {
        this.posX = x;
        this.posY = y; 
        
        this.direccion = 1; 
    }
    
    public void dispararMisil(Objetivo o) {
        this.m = new Misil(o, this.posX, this.posY);
    }
    
    public boolean contactoObjetivo() {
        if (m != null && m.contacto()) {
            this.m = null;
            return true;
        }
        
        return false;
    }
    
    public void altitud(int n) {
        this.posY = this.posY + n;
    }
    
    public void cambioDirec() {
        this.direccion *= -1;
    }
    
    public void step() {
        if (this.posX < 0 || this.posX > 1000) cambioDirec();
        
        this.posX = this.posX + 2 * this.direccion; 
        
        if (m != null) {
            m.step();
            m.step();
        }
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(posX, posY, 50, 20);
        if (m != null) m.paint(g);
    }
}
