
package profinalmonttidavison;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Ventana extends JFrame{
    private Ambiente amb;
    
    public Ventana() {
        this.amb = new Ambiente();
        this.add(amb, BorderLayout.CENTER);
       
        this.setSize(1000, 1000);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }  
}