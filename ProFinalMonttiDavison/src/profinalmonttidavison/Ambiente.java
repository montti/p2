
package profinalmonttidavison;

import geometricas.Angular;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Ambiente extends JPanel implements MouseListener, ActionListener, MouseWheelListener{
    private Timer t;
    private Avion av;
    private Objetivo o;
    private Random rand;
    
    public Ambiente() {
        this.addMouseListener(this);
        this.addMouseWheelListener(this);
        this.t = new Timer(16, null);
        this.t.addActionListener(this);
        this.t.start();
        this.rand = new Random();
        
        this.av = new Avion(500, 500);
        this.o = new Objetivo(1 + rand.nextInt(999), 10 + rand.nextInt(780));
        
        this.setBackground(Color.white);
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        if (o != null) o.paint(g);
        if (av != null) av.paint(g);
        g.drawLine(0, 800, 1000, 800);
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1 && o != null) av.dispararMisil(o);
        if (e.getButton() == 3) av.cambioDirec();
        repaint();
    }

    public void mousePressed(MouseEvent e) {; }
    public void mouseReleased(MouseEvent e) {;}
    public void mouseEntered(MouseEvent e) {;}
    public void mouseExited(MouseEvent e) {;}


    public void actionPerformed(ActionEvent e) {
    
        if (o != null) o.step();
        
        if (av.contactoObjetivo()) {
            this.o = new Objetivo(rand.nextInt(1000), rand.nextInt(1000));
        }
        
        av.step();
    
        repaint();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        av.altitud(e.getWheelRotation() * 2);
    }
}