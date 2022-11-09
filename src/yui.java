import java.util.Random;
import java.util.Scanner;
public class yui {
    public static char[] star;
    public static void main (String args[])
    {
        char game[];
        Scanner input = new Scanner(System.in);



        boolean retryDefineWord = true;
        Scanner sc = new Scanner(System.in);
        String word = "";
        while (retryDefineWord) {
            word = "";
            while (word.isBlank()) {
                System.out.println("rentrez un mot");
                word = sc.nextLine().toUpperCase();
            }
            System.out.println("vous avez choisit le mot : " + word + "\nconfirmez vous ?\n(v)confrmer\n(f)redÃ©finir");
            String confirm = sc.nextLine();
            if ("v".equals(confirm)) {
                retryDefineWord = false;
            }
        }



        int count = word.length();
        char[] CharArr=word.toCharArray();
        char[] star = word.toCharArray();
        for(int i=0;i<star.length;i++)
        {
            star[i] = '*';
            System.out.print(star[i]);
        }

        for (int i=1; i<=3; i++)
        {
            System.out.printf ("\nrentrez une lettre:");
            char letter= (input.next().toUpperCase().charAt(0));

            for (int j=0;j<CharArr.length; j++)
            {
                if(letter == star[j])
                {
                    System.out.println("Ce ");
                }
                else
                {
                    if(letter==CharArr[j])
                    {
                        star[j]=letter;
                        i--;
                        System.out.printf("CORRECT GUESS!\n");
                    }
                }
            }
            System.out.print(star);
            switch(i+0)
            {
                case 1: System.err.printf("Strike 1\n");
                    break;
                case 2: System.err.printf("Strike 2\n");
                    break;
                case 3: System.err.printf("Strike 3\n");
                    System.err.printf("You're out!!! The word is Not_Matched\n");
                    break;
            }

            System.out.printf("\n");
            if((new String(word)).equals(new String(star)))
            {
                System.err.printf("Winner Winner, Chicken Dinner!\n");
                break;
            }
        }
    }
}