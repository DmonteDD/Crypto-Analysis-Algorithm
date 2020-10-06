import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class RSAFrame extends JFrame implements ActionListener { 

    // Components of the Form 
    int KeySizep = 1024;
    int KeySizeq = 13;
    BigInteger p_no = new BigInteger("0");
    BigInteger q_no = new BigInteger("0");
    BigInteger npq = new BigInteger("0");
    BigInteger bm = new BigInteger("0");
    BigInteger bd = new BigInteger("0");
    BigInteger be = new BigInteger("0");
    BigInteger benc = new BigInteger("0");
    BigInteger bdec = new BigInteger("0");
    BigInteger bpt = new BigInteger("0");
    BigInteger one_thou = new BigInteger("1000");
    BigInteger five_thou = new BigInteger("5000");
    private Container c; 
    private JLabel title; 
    private JLabel step1a;
    private JLabel step1b;
    private JLabel step2;
    private JLabel step3;
    private JLabel step4;
    private JLabel step5;
    private JLabel step6;
    private JLabel step7;
    private JLabel p;
    private JLabel q;
    private JLabel n;
    private JLabel e;
    private JLabel d;
    private JLabel m;
    private JLabel c1;
    private JLabel m2; 
    private JTextField tp;
    private JTextField tname; 
    private JTextField tq;
    private JTextField tn;
    private JTextField te;
    private JTextField td;
    private JTextField tm;
    private JTextField tc;
    private JTextField tm1;

    private JTextField tmess;
    
    private JLabel mno; 
    private JTextField tmno; 
    private JLabel gender; 
    private JButton sub; 
    private JButton gen;
    private JButton compq;
    private JButton cal;
    private JButton enc;
    private JButton dec; 
    
    public RSAFrame() 
    { 

        setTitle("RSA Simulation"); 
        setBounds(5, 5, 550, 410); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("RSA Encryption and Decrytion"); 
        title.setFont(new Font("Arial", Font.PLAIN, 18)); 
        title.setSize(300, 30); 
        title.setLocation(140, 10); 
        c.add(title); 
  
        step1a = new JLabel("1. Generate Primes p and q"); 
        step1a.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step1a.setSize(300, 20); 
        step1a.setLocation(20, 50); 
        c.add(step1a); 

        gen = new JButton("gen"); 
        gen.setFont(new Font("Arial", Font.PLAIN, 15)); 
        gen.setSize(80, 20); 
        gen.setLocation(230, 50); 
        gen.addActionListener(this); 
        c.add(gen); 

        step1b = new JLabel(" ( 1000 < p, q < 5000 ) "); 
        step1b.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step1b.setSize(500, 20); 
        step1b.setLocation(320, 50); 
        c.add(step1b); 

        p = new JLabel(" p = "); 
        p.setFont(new Font("Arial", Font.PLAIN, 16)); 
        p.setSize(300, 20); 
        p.setLocation(40, 75); 
        c.add(p); 

        tp = new JTextField(); 
        tp.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tp.setSize(430, 20); 
        tp.setLocation(70, 75); 
        c.add(tp);

        q = new JLabel(" q = "); 
        q.setFont(new Font("Arial", Font.PLAIN, 16)); 
        q.setSize(300, 20); 
        q.setLocation(40, 100); 
        c.add(q); 
   
        tq = new JTextField(); 
        tq.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tq.setSize(430, 20); 
        tq.setLocation(70, 100); 
        c.add(tq);

        step2 = new JLabel("2. Compute n=pq"); 
        step2.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step2.setSize(200, 20); 
        step2.setLocation(20, 130); 
        c.add(step2); 

        compq = new JButton("Com"); 
        compq.setFont(new Font("Arial", Font.PLAIN, 15)); 
        compq.setSize(80, 20); 
        compq.setLocation(270, 130); 
        compq.addActionListener(this); 
        c.add(compq); 


        n = new JLabel(" n = "); 
        n.setFont(new Font("Arial", Font.PLAIN, 16)); 
        n.setSize(300, 20); 
        n.setLocation(40, 155); 
        c.add(n);

        tn = new JTextField(); 
        tn.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tn.setSize(430, 20); 
        tn.setLocation(70, 155); 
        c.add(tn);

        step3 = new JLabel("3. Set a public key e  e ="); 
        step3.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step3.setSize(200, 20); 
        step3.setLocation(20, 180); 
        c.add(step3); 

        te = new JTextField(); 
        te.setFont(new Font("Arial", Font.PLAIN, 15)); 
        te.setSize(300, 20); 
        te.setLocation(200, 180); 
        c.add(te);

        step4 = new JLabel("4. Calculate the private key d  "); 
        step4.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step4.setSize(400, 20); 
        step4.setLocation(20, 210); 
        c.add(step4); 

        cal = new JButton("cal"); 
        cal.setFont(new Font("Arial", Font.PLAIN, 15)); 
        cal.setSize(70, 20); 
        cal.setLocation(240, 210); 
        cal.addActionListener(this); 
        c.add(cal); 

        d = new JLabel(" d = "); 
        d.setFont(new Font("Arial", Font.PLAIN, 16)); 
        d.setSize(300, 20); 
        d.setLocation(40, 240); 
        c.add(d);

        td = new JTextField(); 
        td.setFont(new Font("Arial", Font.PLAIN, 15)); 
        td.setSize(430, 20); 
        td.setLocation(70, 240); 
        c.add(td);

        step5 = new JLabel("5. Input a message m                         m =  "); 
        step5.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step5.setSize(300, 20); 
        step5.setLocation(20, 270); 
        c.add(step5); 

        tm = new JTextField(); 
        tm.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tm.setSize(200, 20); 
        tm.setLocation(300, 270); 
        c.add(tm);

        step6 = new JLabel("6. Encrypt c=m^e mod n                     c =  "); 
        step6.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step6.setSize(300, 20); 
        step6.setLocation(20, 300); 
        c.add(step6); 

        enc = new JButton("enc"); 
        enc.setFont(new Font("Arial", Font.PLAIN, 15)); 
        enc.setSize(60, 20); 
        enc.setLocation(200, 300); 
        enc.addActionListener(this); 
        c.add(enc); 

        tc = new JTextField(); 
        tc.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tc.setSize(200, 20); 
        tc.setLocation(300, 300); 
        c.add(tc);

        step7 = new JLabel("7. Decrypt m=c^d mod n                    m =  "); 
        step7.setFont(new Font("Arial", Font.PLAIN, 16)); 
        step7.setSize(300, 20); 
        step7.setLocation(20, 330); 
        c.add(step7); 

        dec = new JButton("dec"); 
        dec.setFont(new Font("Arial", Font.PLAIN, 15)); 
        dec.setSize(60, 20); 
        dec.setLocation(200, 330); 
        dec.addActionListener(this); 
        c.add(dec); 

        tm1 = new JTextField(); 
        tm1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tm1.setSize(200, 20); 
        tm1.setLocation(300, 330); 
        c.add(tm1);

        tmess = new JTextField(); 
        tmess.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tmess.setSize(400, 20); 
        tmess.setLocation(20, 360); 
        c.add(tmess);

      setVisible(true); 
    } 

    private BigInteger generateP()
    {
        BigInteger p= new BigInteger("0");
        SecureRandom rand = new SecureRandom();
        while(true)
        {
        p = BigInteger.probablePrime(12, rand);
        if(p.compareTo(one_thou) == 1 && p.compareTo(five_thou) == -1)
                return p;  
        } 
    }

    private BigInteger generateQ()
    {
        BigInteger q= new BigInteger("0");
        SecureRandom rand = new SecureRandom();
        while(true)
        {
        q = BigInteger.probablePrime(12, rand);
        if(q.compareTo(one_thou) == 1 && q.compareTo(five_thou) == -1)
                return q;  
        } 
    }

    public void actionPerformed(ActionEvent e) 
    { 
        
        if (e.getSource() == gen) 
        {    
            p_no = generateP();
            q_no = generateQ();
            System.out.println("p= " +p_no);
            System.out.println("q= " +q_no);
            String data1 = "" + p_no;
            tp.setText(data1);
            String data2 = "" + q_no;
            tq.setText(data2); 
       } 

       if (e.getSource() == compq) 
        {    
            p_no = new BigInteger(tp.getText());
            q_no = new BigInteger(tq.getText());
            npq = p_no.multiply(q_no);
            System.out.println("npq= " +npq);
            String data1 = "" + npq;
            tn.setText(data1); 
       } 


        if (e.getSource() == cal) 
        {    
            bm = (p_no.subtract(BigInteger.ONE)).multiply(q_no.subtract(BigInteger.ONE));
            System.out.println(" bm = " +bm);
            be = new BigInteger(te.getText());
            System.out.println(" be = " +be);
            if(be.gcd(bm).equals(BigInteger.ONE))
            {
                String data1 = "e and φ(n) are co-prime";
                tmess.setText(data1);  
                //be = getCoprime(bm);
                System.out.println(" be = " +be);
                bd = be.modInverse(bm);
                data1 = "" + bd;
                td.setText(data1);  
            }
            else
            {
                String data1 = "e and φ(n) are not co-prime. Re-enter the value of e";
                tmess.setText(data1);
            }
         
        } 

        if (e.getSource() == enc) 
        {    
            bpt = new BigInteger(tm.getText());
            System.out.println(" ============ \n bpt m = " +bpt);
            System.out.println(" be = " +be);
            System.out.println(" npq = " +npq);
            
            
            //be = getCoprime(bm);
            benc = bpt.modPow(be, npq);
            System.out.println(" benc = " +benc);
            String data1 = "" + benc;
            tc.setText(data1);   
        }

        if (e.getSource() == dec) 
        {    
            bdec = benc.modPow(bd, npq);
            System.out.println(" dec = " +bdec);
            String data1 = "" + bdec;
            tm1.setText(data1);   
        }

}
}

class RSA 
{
    public static void main(String args[])
    {
        RSAFrame f = new RSAFrame(); 
    }
}