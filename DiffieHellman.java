import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


class DiffieHellmanFrame extends JFrame implements ActionListener { 

    // Components of the Form 
    private Container c; 
    private JLabel title; 
    private JLabel step0;
    private JLabel step1;
    private JLabel step2;
    private JLabel step3;
    private JLabel step4;
    private JLabel step4_1;
    private JLabel step4_2;
    private JLabel step4_3;
    private JLabel step5;
    private JLabel step6;
    private JLabel step7;
    private JLabel x;
    private JLabel y;
    private JLabel X;
    private JLabel Y;
    private JLabel K;
    private JLabel n;
    private JLabel e;
    private JLabel d;
    private JLabel m;
    private JLabel c1;
    private JLabel m2; 
    private JTextField tx;
    private JTextField ty;
    private JTextField tX;
    private JTextField tY;
    private JTextField tname; 
    private JTextField tr;
    private JTextField tn;
    private JTextField te;
    private JTextField td;
    private JTextField tm;
    private JTextField tK1;
    private JTextField tK2;
    
    private JTextField tm1;
    
    private JLabel mno; 
    private JTextField tmno; 
    private JLabel gender; 
    private JRadioButton male; 
    private JRadioButton female; 
    private ButtonGroup gengp; 
    private JLabel dob; 
    private JComboBox date; 
    private JComboBox month; 
    private JComboBox year; 
    private JLabel add; 
    private JTextArea tadd; 
    private JCheckBox term; 
    private JButton com1;
    private JButton com2;  
    private JButton cal1;
    private JButton cal2;
    private JButton enc;
    private JButton dec; 
    private JButton reset; 
    private JTextArea tout; 
    private JLabel res; 
    private JTextArea resadd; 
  
    // constructor, to initialize the components 
    // with default values. 
    public DiffieHellmanFrame() 
    { 
        setTitle("Diffie-Hellman"); 
        setBounds(5, 5, 600, 430); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Diffie-Hellman Key Exchange Simulation"); 
        title.setFont(new Font("Arial", Font.PLAIN, 18)); 
        title.setSize(350, 30); 
        title.setLocation(140, 10); 
        c.add(title); 
  
        step0 = new JLabel("0. Given a large prime p=65537, a primary root g=3"); 
        step0.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step0.setSize(400, 20); 
        step0.setLocation(20, 50); 
        c.add(step0); 

        step1 = new JLabel("1. Choose a random number x "); 
        step1.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step1.setSize(500, 20); 
        step1.setLocation(20, 80); 
        c.add(step1); 

        x = new JLabel("x = "); 
        x.setFont(new Font("Arial", Font.PLAIN, 16)); 
        x.setSize(500, 20); 
        x.setLocation(50, 110); 
        c.add(x); 

        tx = new JTextField(); 
        tx.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tx.setSize(500, 20); 
        tx.setLocation(80, 110); 
        c.add(tx);

        step2 = new JLabel("2. Compute X=g^x mod p"); 
        step2.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step2.setSize(450, 20); 
        step2.setLocation(20, 140); 
        c.add(step2); 

        com1 = new JButton("Com"); 
        com1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        com1.setSize(70, 20); 
        com1.setLocation(210, 140); 
        com1.addActionListener(this); 
        c.add(com1);
        
        X = new JLabel("X = "); 
        X.setFont(new Font("Arial", Font.PLAIN, 16)); 
        X.setSize(500, 20); 
        X.setLocation(50, 170); 
        c.add(X); 

        tX = new JTextField(); 
        tX.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tX.setSize(500, 20); 
        tX.setLocation(80, 170); 
        c.add(tX);

        step3 = new JLabel("3. Choose a random number y"); 
        step3.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step3.setSize(500, 20); 
        step3.setLocation(20, 200); 
        c.add(step3); 

        y = new JLabel("y = "); 
        y.setFont(new Font("Arial", Font.PLAIN, 16)); 
        y.setSize(500, 20); 
        y.setLocation(50, 230); 
        c.add(y); 

        ty = new JTextField(); 
        ty.setFont(new Font("Arial", Font.PLAIN, 15)); 
        ty.setSize(500, 20); 
        ty.setLocation(80, 230); 
        c.add(ty);

        step4 = new JLabel("4. Compute Y=g^y mod p"); 
        step4.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step4.setSize(400, 20); 
        step4.setLocation(20, 260); 
        c.add(step4); 

        com2 = new JButton("Com"); 
        com2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        com2.setSize(70, 20); 
        com2.setLocation(210, 260); 
        com2.addActionListener(this); 
        c.add(com2);

        Y = new JLabel("Y = "); 
        Y.setFont(new Font("Arial", Font.PLAIN, 16)); 
        Y.setSize(500, 20); 
        Y.setLocation(50, 290); 
        c.add(Y); 

        tY = new JTextField(); 
        tY.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tY.setSize(500, 20); 
        tY.setLocation(80, 290); 
        c.add(tY);

        step5 = new JLabel("5. Calculate the session key K=g^xy mod p"); 
        step5.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step5.setSize(400, 20); 
        step5.setLocation(20, 320); 
        c.add(step5); 

        K = new JLabel("K=Y^x mod p=                                        K=X^y mod p="); 
        K.setFont(new Font("Arial", Font.PLAIN, 16)); 
        K.setSize(500, 20); 
        K.setLocation(50, 350); 
        c.add(K);

        cal1 = new JButton("Cal"); 
        cal1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        cal1.setSize(60, 20); 
        cal1.setLocation(250, 350); 
        cal1.addActionListener(this); 
        c.add(cal1);

        tK1 = new JTextField(); 
        tK1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tK1.setSize(90, 20); 
        tK1.setLocation(155, 350); 
        c.add(tK1);

        cal2 = new JButton("Cal"); 
        cal2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        cal2.setSize(60, 20); 
        cal2.setLocation(520, 350); 
        cal2.addActionListener(this); 
        c.add(cal2);

        tK2 = new JTextField(); 
        tK2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tK2.setSize(90, 20); 
        tK2.setLocation(420, 350); 
        c.add(tK2);

        setVisible(true); 
    } 
  
    BigInteger bX= new BigInteger("0");
    BigInteger bY= new BigInteger("0");
    BigInteger bx= new BigInteger("0");
    BigInteger by= new BigInteger("0");
    BigInteger bp= new BigInteger("65537");
    BigInteger bg= new BigInteger("3");
    BigInteger bK1= new BigInteger("0");
    BigInteger bK2= new BigInteger("0");

    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == com1) 
        { 
            bx= new BigInteger(tx.getText());
            bX = bg.modPow(bx,bp);
            String data = "" + bX;
            System.out.println(" X =" +bX );
            tX.setText(data);
        } 
        if (e.getSource() == com2) 
        { 
            by= new BigInteger(ty.getText());
            bY = bg.modPow(by,bp);
            String data = "" + bY;
            System.out.println(" Y =" +by );
            tY.setText(data);
        }
        if (e.getSource() == cal1) 
        { 
            bK1 = bY.modPow(bx,bp);
            String data = "" + bK1;
            System.out.println(" bK1 =" +bK1 );
            tK1.setText(data);
        } 
        if (e.getSource() == cal2) 
        { 
            bK2 = bX.modPow(by,bp);
            String data = "" + bK2;
            System.out.println(" bK2 =" +bK2 );
            tK2.setText(data);
        } 
    } 
} 

class DiffieHellman 
{
    public static void main(String args[])
    {
        DiffieHellmanFrame f = new DiffieHellmanFrame(); 
    }
}