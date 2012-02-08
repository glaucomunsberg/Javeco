import java.awt.*;  
import javax.swing.*;  
  
public class Exemlo extends JFrame {  
    public Exemlo() {  
        super("Exemplo1");  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
          
        Container c = this.getContentPane();  
     
        GridBagConstraints cons = new GridBagConstraints();  
        GridBagLayout layout = new GridBagLayout();  
        c.setLayout(layout);  
         
        cons.fill = GridBagConstraints.BOTH;  
        cons.gridy = 0;  
        cons.gridx = 0;  
      
        c.add(new JButton("Esquerda"), cons);  
        cons.gridx = 2;  
        c.add(new JButton("Direita"), cons);  
  
        cons.gridx = 0;  
        cons.gridy = 1;  
        c.add(new JButton("Esquerda"), cons);  
          
        cons.gridx = 1;  
        c.add(new JButton("Meio"), cons);  
          
        cons.gridx = 2;  
        c.add(new JButton("Direita"), cons);          
          
        this.setSize(600,600);         
    }  
      
    public static void main(String[] args ) {  
        Exemlo exe = new Exemlo();  
        exe.show();        
    }  
}  