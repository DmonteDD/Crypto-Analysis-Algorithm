import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
import java.math.BigInteger;

class ExtendedEuclideanAlgorithmFrame extends JFrame implements ActionListener
{ 
      private Container c; 
      private JLabel title; 
      private JLabel step0;
      private JLabel step1;
      private JLabel step2;
      private JLabel step3;
      private JLabel la;
      private JLabel lb;
      private JLabel lc;
      private JLabel ld;
      private JLabel lgcd;
      
      private JTextField ta;
      private JTextField tb;
      private JTextField tc; 
      private JTextField td;
      private JTextField tgcd;
      private JButton calgcd; 
      private JButton cal1;
      private JButton cal2;
      
      public ExtendedEuclideanAlgorithmFrame() 
      { 
          setTitle("Extended Euclidean Algorithm"); 
          setBounds(5, 5, 550, 330); 
          setDefaultCloseOperation(EXIT_ON_CLOSE); 
          setResizable(false); 
          c = getContentPane(); 
          c.setLayout(null); 
    
          title = new JLabel("Extended Euclidean Algorithm Simulator"); 
          title.setFont(new Font("Arial", Font.PLAIN, 18)); 
          title.setSize(400, 30); 
          title.setLocation(140, 10); 
          c.add(title); 
    
          step0 = new JLabel(" 1. (a * c) + (b * d) = gcd(a, b)"); 
          step0.setFont(new Font("Arial", Font.PLAIN, 16)); 
          step0.setSize(400, 20); 
          step0.setLocation(20, 50); 
          c.add(step0); 
        
          la = new JLabel(" Enter value for a  ="); 
          la.setFont(new Font("Arial", Font.PLAIN, 16)); 
          la.setSize(500, 30); 
          la.setLocation(40, 80); 
          c.add(la); 

          ta = new JTextField(); 
          ta.setFont(new Font("Arial", Font.PLAIN, 15)); 
          ta.setSize(330, 20); 
          ta.setLocation(185, 80); 
          c.add(ta);

          lb = new JLabel(" Enter value for b  ="); 
          lb.setFont(new Font("Arial", Font.PLAIN, 16)); 
          lb.setSize(500, 20); 
          lb.setLocation(40, 110); 
          c.add(lb); 

          tb = new JTextField(); 
          tb.setFont(new Font("Arial", Font.PLAIN, 15)); 
          tb.setSize(330, 20); 
          tb.setLocation(185, 110); 
          c.add(tb);
  
          step1 = new JLabel(" 2. Calculate GCD of a and b"); 
          step1.setFont(new Font("Arial", Font.PLAIN, 16)); 
          step1.setSize(400, 20); 
          step1.setLocation(20, 140); 
          c.add(step1);
            
          calgcd = new JButton("Cal"); 
          calgcd.setFont(new Font("Arial", Font.PLAIN, 15)); 
          calgcd.setSize(70, 20); 
          calgcd.setLocation(250, 140); 
          calgcd.addActionListener(this); 
          c.add(calgcd);

          lgcd = new JLabel(" GCD ="); 
          lgcd.setFont(new Font("Arial", Font.PLAIN, 16)); 
          lgcd.setSize(400, 20); 
          lgcd.setLocation(40, 170); 
          c.add(lgcd); 

          tgcd = new JTextField(); 
          tgcd.setFont(new Font("Arial", Font.PLAIN, 15)); 
          tgcd.setSize(250, 20); 
          tgcd.setLocation(100, 170); 
          c.add(tgcd);
  
          step1 = new JLabel(" 3. c = a^-1 mod b and d = b^-1 mod a "); 
          step1.setFont(new Font("Arial", Font.PLAIN, 16)); 
          step1.setSize(400, 20); 
          step1.setLocation(20, 200); 
          c.add(step1);
   
          cal1 = new JButton("Cal"); 
          cal1.setFont(new Font("Arial", Font.PLAIN, 15)); 
          cal1.setSize(70, 20); 
          cal1.setLocation(310, 200); 
          cal1.addActionListener(this); 
          c.add(cal1);

          lc = new JLabel(" c  ="); 
          lc.setFont(new Font("Arial", Font.PLAIN, 16)); 
          lc.setSize(400, 20); 
          lc.setLocation(40, 230); 
          c.add(lc); 

          tc = new JTextField(); 
          tc.setFont(new Font("Arial", Font.PLAIN, 15)); 
          tc.setSize(250, 20); 
          tc.setLocation(100, 230); 
          c.add(tc);
  
          ld = new JLabel(" d  ="); 
          ld.setFont(new Font("Arial", Font.PLAIN, 16)); 
          ld.setSize(400, 20); 
          ld.setLocation(40, 260); 
          c.add(ld); 

          td = new JTextField(); 
          td.setFont(new Font("Arial", Font.PLAIN, 15)); 
          td.setSize(250, 20); 
          td.setLocation(100, 260); 
          c.add(td);
  
          setVisible(true); 
      } 
    
    public static CalGCD_C_D cal(final BigInteger a, final BigInteger b) 
    {
        if (b.equals(BigInteger.ZERO)) 
        {
            return new CalGCD_C_D(a, BigInteger.ONE, BigInteger.ZERO);
        } 
        else 
        {
            final CalGCD_C_D extension = cal(b, a.mod(b));
            return new CalGCD_C_D(extension.gcd, extension.d, extension.c.subtract(a.divide(b).multiply(extension.d)));
        }
    }
    private static class CalGCD_C_D 
    {
        public final BigInteger gcd;
        public final BigInteger c;
        public final BigInteger d;
        private CalGCD_C_D(final BigInteger gcd, final BigInteger c, final BigInteger d) 
        {
            this.gcd = gcd;
            this.c = c;
            this.d = d;
        }
    }

      public void actionPerformed(ActionEvent e) 
      { 
           
        if (e.getSource() == calgcd) 
            {                
                String data1; 
                BigInteger no_a = new BigInteger(ta.getText());
                BigInteger no_b = new BigInteger(tb.getText());
                System.out.println("eea(240, 46) = " + cal(no_a, no_b));
                CalGCD_C_D as;
                as = cal(no_a, no_b); 
                data1 = "" + as.gcd;
                tgcd.setText(data1); 
            }

            if (e.getSource() == cal1) 
            {                
                String data1,data2; 
                BigInteger no_a = new BigInteger(ta.getText());
                BigInteger no_b = new BigInteger(tb.getText());
                System.out.println("eea(240, 46) = " + cal(no_a, no_b));
                CalGCD_C_D as;
                as = cal(no_a, no_b); 
                data1 = "" + as.c;
                data2 = "" + as.d;
                tc.setText(data1);
                td.setText(data2); 
            }

           }
 
} 

public class ExtendedEuclideanAlgorithm 
{
    public static void main(final String[] args)  throws Exception 
    {
        ExtendedEuclideanAlgorithmFrame e= new ExtendedEuclideanAlgorithmFrame();       
    }
}