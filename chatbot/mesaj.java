import java.util.Scanner; 
import java.util.Vector; 
import java.io.FileReader;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class mesaj
{
   public static void logareUserName(String fraza)
   {     
       System.out.println(fraza);
       Scanner scanner = new Scanner(System.in);
      String username = scanner.nextLine();
       System.out.println("Numele tau de utilizator este " + username);
       //return String;
   }
   public static void logareEmail(String fraza)
   {     
       System.out.println(fraza);
       Scanner scanner = new Scanner(System.in);
      String username = scanner.nextLine();
       System.out.println("E-mail-ul tau este " + username);
    }
    public static String IntroducereDate(String fraza)
   {     
       System.out.println(fraza);
       Scanner scanner = new Scanner(System.in);
       String DateIntroduse = scanner.nextLine();
       return DateIntroduse;
    }
    public static Vector<String> DesparteFraza(String DateIntroduse)
    {
    String cuvant = new String();
    Vector<String> cuvinteProp = new Vector<String>();
    for(int i=0; i<DateIntroduse.length(); i++)
       {
           if((DateIntroduse.charAt(i)==' ')||(DateIntroduse.charAt(i)=='\t')||(DateIntroduse.charAt(i)==',')||(DateIntroduse.charAt(i)==';')||(DateIntroduse.charAt(i)=='.')||(DateIntroduse.charAt(i)==':'))
           {
                cuvinteProp.add(cuvant);
                cuvant = "";
           }
           else
                cuvant=cuvant + DateIntroduse.charAt(i);
       }
       cuvinteProp.add(cuvant);
       return cuvinteProp;
    }
    public static String citireFisier(Vector<String> cuvinteProp){
        File file = new File("D:\\Program Files (x86)\\BlueJ\\Proiecte\\chatbot\\domnitorii.txt");
        String linieDeReturnat = "null";
        try{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();       
        Vector<String> linii = new Vector<String>();
        Vector<String> linieInCuvinte = new Vector<String>();
        int contorActual=0;
        int contor = 0;
        int k=0;
        while (line != null) {
            line = br.readLine();
            contorActual = 0;
            for(int i=0; i<cuvinteProp.size(); i++)
            {
                if(line.toUpperCase().contains(cuvinteProp.elementAt(i).toUpperCase()))
                    contorActual++;   
            }
            if(contorActual > contor)
                {
                    linieDeReturnat = line;
                    contor = contorActual;
                }
        }
        br.close();
        // String everything = sb.toString();
    }
    catch (Exception e){}
    return linieDeReturnat;
    }
    
    public static String cautaAniDomnie(String linie, String in){
        String anDomnie=new String();
        Vector<String> elementeLinie = DesparteFraza(linie);
        boolean anInceput = false;
        boolean anSfarsit = false;
        
        for(int i=0; i<elementeLinie.size(); i++)
        {
            if((elementeLinie.elementAt(i).toUpperCase().contains("DOMNIE"))||(elementeLinie.elementAt(i).toUpperCase().contains("DOMNIT")))
                anInceput=true;            
            if((anInceput==true)&&((elementeLinie.elementAt(i).contains("1"))||(elementeLinie.elementAt(i).contains("2"))||(elementeLinie.elementAt(i).contains("3"))||(elementeLinie.elementAt(i).contains("4"))||(elementeLinie.elementAt(i).contains("5"))||(elementeLinie.elementAt(i).contains("6"))||(elementeLinie.elementAt(i).contains("7"))||(elementeLinie.elementAt(i).contains("8"))||(elementeLinie.elementAt(i).contains("9"))))
               {
                   if(elementeLinie.elementAt(i).length() >= 3)
                   {
                        anDomnie = anDomnie + elementeLinie.elementAt(i);
                        if(anDomnie.length()<=4)
                        {
                            anSfarsit = true;
                            anDomnie = anDomnie + " ";
                            continue;
                        }
                        else
                            return anDomnie;
                   }
                }
            if((anSfarsit==true)&&((elementeLinie.elementAt(i).contains("1"))||(elementeLinie.elementAt(i).contains("2"))||(elementeLinie.elementAt(i).contains("3"))||(elementeLinie.elementAt(i).contains("4"))||(elementeLinie.elementAt(i).contains("5"))||(elementeLinie.elementAt(i).contains("6"))||(elementeLinie.elementAt(i).contains("7"))||(elementeLinie.elementAt(i).contains("8"))||(elementeLinie.elementAt(i).contains("9"))))
                {
                    if(elementeLinie.elementAt(i).length() >= 3)
                    {
                        anDomnie = anDomnie + " " + elementeLinie.elementAt(i);
                        return anDomnie;
                    }
                }
        }
        return "Date inexistente";
    }
       public static String cautaAniLupta(String linie){
        String anLupta=new String();
        Vector<String> elementeLinie = DesparteFraza(linie); 
        boolean dataLupta = false;
        for(int i=0; i<elementeLinie.size(); i++)
        {

                if((dataLupta==true)&&((elementeLinie.elementAt(i).contains("1"))||(elementeLinie.elementAt(i).contains("2"))||(elementeLinie.elementAt(i).contains("3"))||(elementeLinie.elementAt(i).contains("4"))||(elementeLinie.elementAt(i).contains("5"))||(elementeLinie.elementAt(i).contains("6"))||(elementeLinie.elementAt(i).contains("7"))||(elementeLinie.elementAt(i).contains("8"))||(elementeLinie.elementAt(i).contains("9"))))
               { 
                anLupta = anLupta + elementeLinie.elementAt(i);
                return anLupta;
                }
               if((elementeLinie.elementAt(i).toUpperCase().contains("LUPTAT"))||(elementeLinie.elementAt(i).toUpperCase().contains("LUPTA")))
                    dataLupta = true;
            }
        return "Date inexistente";
    }

    public static void main(String[] args)
    {   
    logareUserName("Introduce numele tau de utilizator: ");
    logareEmail("Introduce e-mail-ul tau: ");
    boolean sesiuneaContinua = true;
    while(sesiuneaContinua == true)
    {
        String date_citite = IntroducereDate("Cu ce va pot ajuta?");
        if(date_citite.toUpperCase().contains("ATAT PENTRU MOMENT"))
            break;
        Vector<String> cuvinteDespartite = DesparteFraza(date_citite);
        String raspuns = citireFisier(cuvinteDespartite);
        String rezultatIntrebare = new String();
        boolean cat = false;
        boolean domnie = false;
        bolean lupta = false;
        String in = new String();
        for(int i=0; i<cuvinteDespartite.size(); i++)
        {
            if(cuvinteDespartite.elementAt(i).toUpperCase().contains("CAT"))
                cat = true;
            if(cuvinteDespartite.elementAt(i).toUpperCase().contains("IN"))
                if(cuvinteDespartite.elementAt(i+1).toUpperCase().contains("TAR"))
                    in = in + cuvinteDespartite.elementAt(i+1) + " " + cuvinteDespartite.elementAt(i+2);
                else
                    in = in + cuvinteDespartite.elementAt(i+1);
            if(cuvinteDespartite.elementAt(i).toUpperCase().contains("DOMNIE")||cuvinteDespartite.elementAt(i).toUpperCase().contains("DOMNIT"))
                {
                    domnie = true;
                }
             else
                if((cuvinteDespartite.elementAt(i).toUpperCase().contains("LUPTAT"))||(cuvinteDespartite.elementAt(i).toUpperCase().contains("LUPTA")))
                {
                    lupta = true;
                }
        }
        if(domnie == true)
            rezultatIntrebare=cautaAniDomnie(raspuns, in);
        else
            if(lupta == true)
                rezultatIntrebare=cautaAniLupta(raspuns);
        if(cat == true)
        {
            String[] ani = rezultatIntrebare.split(" |\\-");
            rezultatIntrebare = Integer.toString(Integer.valueOf(ani[1])-Integer.valueOf(ani[0]));
        }
        System.out.println(rezultatIntrebare);
    }
}
 }

