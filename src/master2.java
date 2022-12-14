import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class master2 {
    public static void main(String[] args) {
        while(true){
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));
            for (int i = 0; i < 20; i++) {System.out.println("\u001B[38;2;232;255;109m");}
            Scanner sc = new Scanner(System.in);
            String word = setword();
            int lifescore = 11;
            String tryGame = "|";
            boolean win = false;
            for (int i = 0; i < 20; i++) {System.out.println();}
            String searshView = "";
            int difficulty = 2;
            if (word.length()>3) {difficulty = defDificulty();}
            if (difficulty == 1){
                searshView += (word.charAt(0));
                searshView += ("_".repeat(word.length() - 2));
                searshView += (word.substring(word.length() - 1));
                if (!word.substring(1,word.length()-1).contains(word.substring(0,1))){
                    tryGame+= word.charAt(0)+"|";
                }
                if (!word.substring(1,word.length()-1).contains(word.substring(word.length()-1))){
                    tryGame += word.charAt(word.length()-1)+"|";
                }
            }
            else {searshView += ("_".repeat(word.length()));}
            System.out.println(searshView);
            String tryword;
            while (true) {
                String choix = "";
                while (!(choix.equals("lettre")||choix.equals("mot"))){
                    System.out.println("souhaitez vous incérer un (mot) ou une (lettre)?");
                    choix = sc.nextLine().toLowerCase();
                }
                while (true) {
                    System.out.println("incerez vottre mot ou lettre:");
                    tryword = sc.nextLine().toUpperCase();
                    if (tryword.equals("/QUIT")||tryword.equals("/RESTART")){
                        break;
                    }
                    if (choix.equals("lettre")) {
                        if (tryword.length() == 1) {
                            break;
                        } else {System.out.println("vous n'avez pas inséré une lettre.");}
                    }
                    if (choix.equals("mot")){
                        if (word.length()==tryword.length()){
                            break;
                        }
                        else {System.out.println("le mot que vous avez inséré n'as pas le bon nombre de lettre.");}
                    }
                }
                for (int i = 0; i < 20; i++) {System.out.println();}

                if (tryword.equals("/QUIT")||tryword.equals("/RESTART")){
                    break;
                }
                if (!tryGame.contains("|"+tryword+"|")) {
                    tryGame += tryword+"|";
                    if (choix.equals("lettre")) {
                        if (word.contains(tryword)) {
                            for (int i = 0; i < word.length(); i++) {
                                if (tryword.equals(word.substring(i, i + 1))) {
                                    searshView = searshView.substring(0, i) + tryword + searshView.substring(i + 1);
                                }
                            }
                        } else {
                            lifescore--;
                        }
                    } else {
                        if (word.equals(tryword)) {
                            searshView = word;
                        } else {
                            lifescore--;
                        }
                    }
                }
                System.out.println(searshView);
                drawman(lifescore);
                System.out.print("déja utilisé:\n");
                System.out.println(tryGame);
                System.out.println();
                if (!searshView.contains("_")){win = true;break;}
                if (lifescore == 0){break;}
            }
            if (tryword.equals("/QUIT")){break;}
            if (win){System.out.println("bravo, vous avez trouvé le bon mot qui était "+word+" !!!");}
            else {System.out.println("malheureusement vous êtes mort à chercher ce mot en vain,\n d'ailleurs ce mot était "+word+".");}
            System.out.println("voulez vous refaire une partie ??\n(appuie sur enter pour recommencer, et sur n'importe quelle touche pour stopper.)");
            String retry = sc.nextLine();
            if (!retry.equals("")){break;}
        }
    }
    private static String setword(){
        Scanner sc = new Scanner(System.in);
        String wordRandomized = randomWord();
        String multiplayer;
        if (wordRandomized !=null) {
            System.out.println("souhaitez vous jouer en solo ou en multijoueur ?\n (s) pour solo et\n (m) pour multijoueur.");
            multiplayer = sc.nextLine().toLowerCase();
            while (!(multiplayer.equals("s") || multiplayer.equals("m"))) {
                System.out.println("ce mode de jeu n'est pas existant\nsouhaitez vous jouer en solo ou en multijoueur ?\n (s) pour solo et\n (m) pour multijoueur.");
                multiplayer = sc.nextLine().toLowerCase();
            }
        }else {
            multiplayer = "m";
        }
        String word;
        if (multiplayer.equals("s")) {
            word = wordRandomized;
        } else {
            while (true) {
                word = "";
                while (word.isBlank()||word.contains("_")) {
                    System.out.println("rentrez un mot");
                    word = sc.nextLine().toUpperCase();
                }
                System.out.println("vous avez choisit le mot : " + word + "\nconfirmez vous ?\n(v)confrmer\n(F)redéfinir");
                String confirm = sc.nextLine().toLowerCase();
                if ("v".equals(confirm)){
                    break;
                }
            }
        }
        return word;
    }
    private static int defDificulty(){
        Scanner sc = new Scanner(System.in);
        System.out.println("sélectionnez votre difficulté (1) ou (2) :\n1:avec la 1ère et dre lettre\n2:aucune lettre n'est dévoilé");
        int result;
        while(true) {
            while (!sc.hasNextInt(3)) {
                System.out.println("le niveau de difficulté demmandé n'existe pas,\nsélectionnez votre difficulté (1) ou (2) :");
                sc.nextLine();
            }
            result = sc.nextInt();
            if (result!=0&&!(result>2)){
                break;
            }
            else{
                System.out.println("le niveau de difficulté demmandé n'existe pas,\nsélectionnez votre difficulté (1) ou (2) :");
            }
        }
        return result;
    }
    private static void drawman(int lifescore){
        String[] draw = {
                """
                             ________
                             |/     |
                             |    \\ O /
                             |     \\|/
                             |      |
                             |     / \\
                        _____|_____""".indent(1),
                """
                             ________
                             |/     |
                             |    \\ O /
                             |     \\|/
                             |      |
                             |       \\
                        _____|_____""".indent(1),
                """
                             ________
                             |/     |
                             |    \\ O /
                             |     \\|/
                             |      |
                             |
                        _____|_____""".indent(1),
                """
                             ________
                             |/     |
                             |      O /
                             |      |/
                             |      |
                             |
                        _____|_____""".indent(1),
                """
                             ________
                             |/     |
                             |      O
                             |      |
                             |      |
                             |
                        _____|_____""".indent(1),
                """
                             ________
                             |/     |
                             |      O
                             |
                             |
                             |
                        _____|_____""".indent(1),
                """
                             ________
                             |/     |
                             |
                             |
                             |
                             |
                        _____|_____""".indent(1),
                """
                             ________
                             |/
                             |
                             |
                             |
                             |
                        _____|_____""".indent(1),
                """

                             |/
                             |
                             |
                             |
                             |
                        _____|_____""".indent(1),
                """
                             
                             |
                             |
                             |
                             |
                             |
                        _____|_____""".indent(1),
                """
                       
                       
                       
                       
                       
                       
                        ___________""".indent(1),
                " \n\n\n\n\n\n\n"
        };
        System.out.println(draw[lifescore]);
    }
    private static String randomWord(){
        String result = null;
        try {
            URL url = new URL("https://www.motsqui.com/mots-aleatoires.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
            BufferedReader responceRequest = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String responceLine;
            String content = "";
            while ((responceLine = responceRequest.readLine()) != null) {
                content += responceLine;
            }
            responceRequest.close();
            result = content.substring(content.indexOf("><b>") + 4, content.indexOf("><b>") + 4 + content.substring(content.indexOf("><b>") + 4).indexOf(">") - 3).toUpperCase();
        }
        catch (IOException ignored) {}
        return result;
    }
}
