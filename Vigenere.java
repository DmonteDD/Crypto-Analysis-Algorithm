public class Vigenere{
    static String encodedMessage = "OOFWGTXYE - FKVY MHIULX WTOGLE TH AMBELFS MV XAIAAPL, KQSDAAPL,ZQROLD AGK YUVO YOKL - FONJT NXHDLR LHEKF MSILOT HM PABSK LBMQ IG AADTF’E MHKQRG DAREK. FEVOZOEVSY BZ BOPLDEW UAT CBET UF EIEPOOG JTIIZ MNW LXEVADIVPFY, UBF BR ATE VYQAMPHIMF MNW PZGXUGIMF AF VVYPNAQR LJUEGAUSMZ IHH ADAGZXAML EOVPQTR’Z ZEXKE AGK IAGAE IGAA PKVPUVAE TAHF CTUUMIYAVX IATA ZACBLFY TUP TAL QCHUAMR";
         
        final static double freq[] = {
            0.08167, 0.01492, 0.02782, 0.04253, 0.12702, 0.02228, 0.02015,
            0.06094, 0.06966, 0.00153, 0.00772, 0.04025, 0.02406, 0.06749,
            0.07507, 0.01929, 0.00095, 0.05987, 0.06327, 0.09056, 0.02758,
            0.00978, 0.02360, 0.00150, 0.01974, 0.00074
        };
         
         
        public static void main(String[] args) {
            int lenghtOfEncodedMessage = encodedMessage.length();
            char[] encoded = new char [lenghtOfEncodedMessage] ;
            char[] key =  new char [lenghtOfEncodedMessage] ;
         
            encodedMessage.getChars(0, lenghtOfEncodedMessage, encoded, 0);
            int txt[] = new int[lenghtOfEncodedMessage];
            int len = 0, j;
         
            double fit, best_fit = 1e100;
         
            for (j = 0; j < lenghtOfEncodedMessage; j++)
                if (Character.isUpperCase(encoded[j]))
                    txt[len++] = encoded[j] - 'A';
         
            j=4;
            fit = freq_every_nth(txt, len, j, key);
                System.out.printf("%f, key length: %2d ", fit, j);
                System.out.print(key);

         /*           String skey = String.copyValueOf(key);
        String enc = encrypt(encodedMessage, skey);
        System.out.println(enc);
        System.out.println(decrypt(enc, skey));        
            */
        }
         
         
            static String decrypt(String text, final String key) {
                String res = "";
                text = text.toUpperCase();
                for (int i = 0, j = 0; i < text.length(); i++) {
                    char c = text.charAt(i);
                    if (c < 'A' || c > 'Z') continue;
                    res += (char)((c - key.charAt(j) + 26) % 26 + 'A');
                    j = ++j % key.length();
                }
                return res;
            }
         

            static String encrypt(String text, final String key) {
                String res = "";
                text = text.toUpperCase();
                for (int i = 0, j = 0; i < text.length(); i++) {
                    char c = text.charAt(i);
                    if (c < 'A' || c > 'Z') continue;
                    res += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
                    j = ++j % key.length();
                }
                return res;
            }
         


        static int best_match(final double []a, final double []b) {
            double sum = 0, fit, d, best_fit = 1e100;
            int i, rotate, best_rotate = 0;
            for (i = 0; i < 26; i++)
                sum += a[i];
            for (rotate = 0; rotate < 26; rotate++) {
                fit = 0;
                for (i = 0; i < 26; i++) {
                    d = a[(i + rotate) % 26] / sum - b[i];
                    fit += d * d / b[i];
                }
         
                if (fit < best_fit) {
                    best_fit = fit;
                    best_rotate = rotate;
                }
            }
         
            return best_rotate;
        }
         
        static double freq_every_nth(final int []msg, int len, int interval, char[] key) {
            double sum, d, ret;
            double  [] accu = new double [26];
            double  [] out = new double [26];
            int i, j, rot;
         
            for (j = 0; j < interval; j++) {
                for (i = 0; i < 26; i++)
                    out[i] = 0;
                for (i = j; i < len; i += interval)
                    out[msg[i]]++;
            rot = best_match(out, freq);
            try{
                    key[j] = (char)(rot + 'A');
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
                for (i = 0; i < 26; i++)
                    accu[i] += out[(i + rot) % 26];
            }
         
            for (i = 0, sum = 0; i < 26; i++)
                sum += accu[i];
         
            for (i = 0, ret = 0; i < 26; i++) {
                d = accu[i] / sum - freq[i];
                ret += d * d / freq[i];
            }
         
            key[interval] = '\0';
            return ret;
        }
         
        }


