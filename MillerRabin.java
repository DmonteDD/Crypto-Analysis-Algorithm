import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.util.Random; 
import java.math.BigInteger; 

class MillerRabinFrame extends JFrame implements ActionListener
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
      private JLabel lmr;
      private JLabel lgcd;
      
      private JTextField ta;
      private JTextField tb;
      private JTextField tc; 
      private JTextField td;
      private JTextField tgcd;
      private JButton calgcd; 
      private JButton cal1;
      private JButton cal2;
      private JButton calmr;
      
      public MillerRabinFrame() 
      { 
          setTitle("Miller-Rabin"); 
          setBounds(5, 5, 550, 330); 
          setDefaultCloseOperation(EXIT_ON_CLOSE); 
          setResizable(false); 
          c = getContentPane(); 
          c.setLayout(null); 
    
          title = new JLabel("Miller-Rabin Primality Simulator"); 
          title.setFont(new Font("Arial", Font.PLAIN, 18)); 
          title.setSize(400, 30); 
          title.setLocation(140, 10); 
          c.add(title); 
      
          la = new JLabel(" Enter large positive random number a where |a| = 1024 bits"); 
          la.setFont(new Font("Arial", Font.PLAIN, 16)); 
          la.setSize(500, 30); 
          la.setLocation(20, 80); 
          c.add(la); 

          ta = new JTextField(); 
          ta.setFont(new Font("Arial", Font.PLAIN, 15)); 
          ta.setSize(500, 20); 
          ta.setLocation(20, 110); 
          c.add(ta);

          calmr = new JButton("Find Prime"); 
          calmr.setFont(new Font("Arial", Font.PLAIN, 15)); 
          calmr.setSize(150, 20); 
          calmr.setLocation(200, 140); 
          calmr.addActionListener(this); 
          c.add(calmr);

          lb = new JLabel(" Output"); 
          lb.setFont(new Font("Arial", Font.PLAIN, 16)); 
          lb.setSize(500, 20); 
          lb.setLocation(20, 170); 
          c.add(lb); 

          tb = new JTextField(); 
          tb.setFont(new Font("Arial", Font.PLAIN, 15)); 
          tb.setSize(500, 20); 
          tb.setLocation(20, 200); 
          c.add(tb);
  
          setVisible(true); 
      } 
    
    public CalGCD_C_D cal(final BigInteger a, final BigInteger b) 
    {
        CalGCD_C_D obj;   
        if (b.equals(BigInteger.ZERO)) 
        {
            obj = new CalGCD_C_D(a, BigInteger.ONE, BigInteger.ZERO);
            return obj;
        } 
        else 
        {
            CalGCD_C_D extension = cal(b, a.mod(b));
            obj = new CalGCD_C_D(extension.gcd, extension.d, extension.c.subtract(a.divide(b).multiply(extension.d)));
            return obj;
        }
    }
    class CalGCD_C_D 
    {
        public final BigInteger gcd;
        public final BigInteger c;
        public final BigInteger d;
        CalGCD_C_D(final BigInteger gcd, final BigInteger c, final BigInteger d) 
        {
            this.gcd = gcd;
            this.c = c;
            this.d = d;
        }
    }

      public void actionPerformed(ActionEvent e) 
      { 
        start : if (e.getSource() == calmr) 
            {                
                int flag = 0;
                String data1;
                String kstring="",qstring="",numstring="",prev=""; 
		        BigInteger k = BigInteger.ZERO;
                Random r_no = new Random();
                BigInteger no_a = new BigInteger(ta.getText());
                if(no_a.equals(BigInteger.ONE)) //If no is 1 , output prime
                {
                    data1="Input is 1 : Output is 1 : Hence Prime";
                    tb.setText(data1);
                    flag = 1;
                    break start;
                }                
                if (no_a.equals(BigInteger.valueOf(2L)) ) //If no is 2 , output prime
                {
                    data1="Input is 2 : Output is 1 : Hence Prime";
                    tb.setText(data1);
                    flag =1; 
                    break start;
                    //break;                                  
                }
                if(no_a.equals(BigInteger.valueOf(3L))) //If no is 3, output prime
                {
                    data1="Input is 3 : Output is 1 : Hence Prime";
                    tb.setText(data1);
                    flag = 1;
                    break start;
                   // break;
                }
                if(no_a.mod(BigInteger.valueOf(2L)).equals(BigInteger.ZERO)) //If no is divisible by 2 , output not prime	
                {
                    data1="Even No : Output is 0 : Hence not Prime";
                    tb.setText(data1);
                    flag = 1;
                    break start;
                    //break; 
                }
                // Find (n-1) =  (2^k) * m;
                //(n-1) = q 
                BigInteger q = no_a.subtract(BigInteger.ONE);
                System.out.println(" Initial q = " +q);
                while(q.mod(BigInteger.valueOf(2L)).equals(BigInteger.ZERO))
                {
                    q = q.shiftRight(1);
                    System.out.println("q= " +q); 
                    k = k.add(BigInteger.ONE);
                    System.out.println("k= " +k);
                }
                int num;
                if(no_a.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))>0)
                {
                    num=r_no.nextInt(Integer.MAX_VALUE-2-2+1)+2;
                    System.out.println("num1= " +num);
                }
                else
                {
                    num=r_no.nextInt(no_a.intValue()-2-2+1)+2;
                    System.out.println("num= " +num);
                }
                BigInteger a = BigInteger.valueOf((long)num);
                System.out.println("a = " +a);
                kstring=k.toString();
                qstring=q.toString();
                numstring=a.toString();
                if(a.modPow(q, no_a).equals(BigInteger.ONE))
                {
                    data1=" Output is 1 : Hence Prime";
                    tb.setText(data1);
                    break start;
                }
		        
                for(int j=0;BigInteger.valueOf((long)j).compareTo(k) < 0;j++)
                {
                    System.out.println("Here");
			        if(a.modPow(BigInteger.valueOf((long)2).pow(j).multiply(q),no_a).equals(no_a.subtract(BigInteger.ONE)))
                    {
                        data1=" Output is 1 : Hence Prime";
                        tb.setText(data1);
                        break start;
                    }
                }
                data1=" Output is 0 : Hence not Prime";
                tb.setText(data1);
                break start;
            }
           }
 
} 

public class MillerRabin 
{
    public static void main(final String[] args)  throws Exception 
    {
        MillerRabinFrame e= new MillerRabinFrame();       
    }
}