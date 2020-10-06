import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class ElGamalFrame extends JFrame implements ActionListener { 

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
    private JLabel r;
    private JLabel n;
    private JLabel e;
    private JLabel d;
    private JLabel m;
    private JLabel c1;
    private JLabel m2; 
    private JTextField tx;
    private JTextField ty;
    private JTextField tname; 
    private JTextField tr;
    private JTextField tn;
    private JTextField te;
    private JTextField td;
    private JTextField tm;
    private JTextField tc1;
    private JTextField tc2;
    
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
    private JButton comy; 
    private JButton comc1;
    private JButton comc2;
    private JButton enc;
    private JButton dec; 
    public ElGamalFrame() 
    { 
        setTitle("ELGamal Simulation"); 
        setBounds(5, 5, 550, 430); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("ELGamal Encryption and Decrytion"); 
        title.setFont(new Font("Arial", Font.PLAIN, 18)); 
        title.setSize(300, 30); 
        title.setLocation(140, 10); 
        c.add(title); 
  
        step0 = new JLabel("0. Given a large prime p=65537, a primary root g=3"); 
        step0.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step0.setSize(400, 20); 
        step0.setLocation(20, 50); 
        c.add(step0); 

        step1 = new JLabel("1. Choose a private key x    x = "); 
        step1.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step1.setSize(500, 20); 
        step1.setLocation(20, 80); 
        c.add(step1); 

        tx = new JTextField(); 
        tx.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tx.setSize(250, 20); 
        tx.setLocation(250, 80); 
        c.add(tx);

        step2 = new JLabel("2. Compute the corresponding public key y=g^x mod p"); 
        step2.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step2.setSize(450, 20); 
        step2.setLocation(20, 110); 
        c.add(step2); 
        
        comy = new JButton("com"); 
        comy.setFont(new Font("Arial", Font.PLAIN, 15)); 
        comy.setSize(70, 20); 
        comy.setLocation(410, 110); 
        comy.addActionListener(this); 
        c.add(comy); 

        y = new JLabel(" y = "); 
        y.setFont(new Font("Arial", Font.PLAIN, 16)); 
        y.setSize(40, 20); 
        y.setLocation(40, 140); 
        c.add(y);

        ty = new JTextField(); 
        ty.setFont(new Font("Arial", Font.PLAIN, 15)); 
        ty.setSize(420, 20); 
        ty.setLocation(80, 140); 
        c.add(ty);

        step3 = new JLabel("3. Input a message m           m ="); 
        step3.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step3.setSize(500, 20); 
        step3.setLocation(20, 170); 
        c.add(step3); 

        tm = new JTextField(); 
        tm.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tm.setSize(250, 20); 
        tm.setLocation(250, 170); 
        c.add(tm);

        step4 = new JLabel("4. Encrypt  "); 
        step4.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step4.setSize(400, 20); 
        step4.setLocation(20, 200); 
        c.add(step4); 

        step4_1 = new JLabel(" 4.1 Choose a random number r                  r = "); 
        step4_1.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step4_1.setSize(400, 20); 
        step4_1.setLocation(30, 230); 
        c.add(step4_1);

        tr = new JTextField(); 
        tr.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tr.setSize(150, 20); 
        tr.setLocation(350, 230); 
        c.add(tr);

        step4_2 = new JLabel(" 4.2 Compute c1=g^r mod p                       c1 = "); 
        step4_2.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step4_2.setSize(400, 20); 
        step4_2.setLocation(30, 260); 
        c.add(step4_2);

        comc1 = new JButton("com"); 
        comc1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        comc1.setSize(65, 20); 
        comc1.setLocation(245, 260); 
        comc1.addActionListener(this); 
        c.add(comc1);

        tc1 = new JTextField(); 
        tc1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tc1.setSize(150, 20); 
        tc1.setLocation(350, 260); 
        c.add(tc1);

        step4_3 = new JLabel(" 4.3 Compute c2=m*y^r mod p                  c2 = "); 
        step4_3.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step4_3.setSize(400, 20); 
        step4_3.setLocation(30, 290); 
        c.add(step4_3);

        comc2 = new JButton("com"); 
        comc2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        comc2.setSize(65, 20); 
        comc2.setLocation(245, 290); 
        comc2.addActionListener(this); 
        c.add(comc2);

        tc2 = new JTextField(); 
        tc2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tc2.setSize(150, 20); 
        tc2.setLocation(350, 290); 
        c.add(tc2);

        step5 = new JLabel(" 5. Decrypt C=(c1,c2 )"); 
        step5.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step5.setSize(300, 20); 
        step5.setLocation(20, 320); 
        c.add(step5); 

        m = new JLabel("  m=c2/(c1) x mod p                                     m = "); 
        m.setFont(new Font("Arial", Font.PLAIN, 16)); 
        m.setSize(400, 20); 
        m.setLocation(30, 350); 
        c.add(m);

        dec = new JButton("dec"); 
        dec.setFont(new Font("Arial", Font.PLAIN, 15)); 
        dec.setSize(65, 20); 
        dec.setLocation(245, 350); 
        dec.addActionListener(this); 
        c.add(dec);

        tm1 = new JTextField(); 
        tm1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tm1.setSize(150, 20); 
        tm1.setLocation(350, 350); 
        c.add(tm1);

        setVisible(true); 
    } 
    
    BigInteger bx= new BigInteger("0");
    BigInteger by= new BigInteger("0");
    BigInteger bp= new BigInteger("65537");
    BigInteger bg= new BigInteger("3");
    BigInteger br= new BigInteger("0");
    BigInteger bm= new BigInteger("0");
    BigInteger bc1= new BigInteger("0");
    BigInteger bc2= new BigInteger("0");
    
    
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == comy) 
        { 
            bx = new BigInteger(tx.getText());
            by = bg.modPow(bx,bp);
            String data = "" + by;
            System.out.println(" Y =" +by );
            ty.setText(data);
        }
        if (e.getSource() == comc1) 
        { 
            bm = new BigInteger(tm.getText());
            br = new BigInteger(tr.getText());
            bc1 = bg.modPow(br,bp);
            String data = "" + bc1;
            System.out.println(" bc1 =" +bc1 );
            tc1.setText(data);
        }
        
        if (e.getSource() == comc2) 
        { 
            bc2 = by.modPow(br,bp);
            bc2 = bm.multiply(bc2);
            bc2 = bc2.mod(bp); 
            String data = "" + bc2;
            System.out.println(" bc2 =" +bc2 );
            tc2.setText(data);
        }

        if (e.getSource() == dec) 
        { 
            BigInteger m1 = bc1.modPow(bx, bp);
            BigInteger m2 = m1.modInverse(bp);
            BigInteger dm = m2.multiply(bc2);
            dm=dm.mod(bp); 
            String data = "" + dm;
            System.out.println(" m =" +dm );
            tm1.setText(data);
        }
            
    } 
} 

class ELGamal 
{
    public static void main(String args[])
    {
        ElGamalFrame f = new ElGamalFrame(); 
    }
}