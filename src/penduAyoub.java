import java.util.Scanner;

public class penduAyoub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 20; i++) {System.out.println();}
        while (true){
            String mot;
             while (true) {
                 mot = "";
                 while (mot.isBlank()) {
                     System.out.println("veuillez inserrer le mot à faire deviner:");
                     mot = sc.nextLine();
                 }
                 System.out.println("vous avez choisit le mot " + mot + " \n(v) pour valider, \n redeffinir par défault.");
                 String validation = sc.nextLine().toLowerCase();
                 if (validation.equals("v")) {break;}
             }
             String view = ""+mot.charAt(0);
             for (int i = 0; i < mot.length()-2; i++) {view+="_";}
             view += mot.charAt(mot.length()-1);

             int vie = 11;
             boolean win = false;
             String[] historic = new String[11+mot.length()];
             int historicPlace = 0;
             for (int i = 0; i < 20; i++) {System.out.println();}

            while (true){
                 String motOuLettre = "";
                 while (!(motOuLettre.equals("m")||motOuLettre.equals("l"))){
                     System.out.println("vous souhaitez incerer un mot ou une lettre?\n(m)pour un mot\n(l)pour une lettre");
                     motOuLettre = sc.nextLine();
                 }
                 for (int i = 0; i < 20; i++) {System.out.println();}
                 String essai = "";
                 while (essai.isBlank()){
                     System.out.println("écris ton mot ou ta lettre");
                     essai = sc.nextLine();
                 }
                 if (motOuLettre.equals("l")){
                     if (essai.length()==1) {
                         historic[historicPlace]=essai;
                         historicPlace++;
                         if (toStringTable(historic).contains(essai)) {
                             for (int i = 0; i <mot.length() ; i++) {
                                 if (mot.charAt(i)==essai.charAt(0)){
                                     view = view.substring(0,i)+essai+view.substring(i+1);
                                 }
                             }
                         }
                         else {vie--;}
                     }
                     else {System.out.println("attention ce que vous avez rentré n'est pas une lettre.");}
                 }
                 else {
                     if (mot.length()==essai.length()){
                         historic[historicPlace]=essai;
                         historicPlace++;
                         if (mot.equals(essai)){
                             view = essai;
                         }
                         else{vie--;}
                     }
                     else {System.out.println("attention le mot choisit n'as pas la bonne taille.");}
                 }
                 System.out.println(view+"\nnopmbre de vie restante: "+vie+"\nnombre de lettres dans le mot: "+mot.length()+"\nhistorique essais: "+toStringTable(historic));
                 if (!view.contains("_")){win = true;break;}
                 else if (vie == 0){break;}
             }
             System.out.println("une nouvelle partie, (oui) pour recommencer");
             String retry = sc.nextLine();
             if (!retry.equals("oui")){break;}
        }
    }
    private static String toStringTable(String[] table){
        String text = "|";
        for (String value:table) {
            if (value!=null) {text += value + "|";}
        }
        return text;
    }
}
