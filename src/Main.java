import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    private static String nomClient;
    private static Socket soc = null;

    private static ObjectInputStream ois;

    private static ObjectOutputStream oos;
    private static InputStreamReader is = null;
    private BufferedReader bfr = null;
    private static OutputStream os = null;
    private static PrintWriter pw = null;

    public static void main(String[] args) {
        System.out.println("**************** DEMARRAGE DU CLIENT ****************");
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisir un identfiant");
         nomClient = sc.nextLine();
         go();
    }

    public static void go() {
        try {
            connexionClient();
            conversation();
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void connexionClient() throws IOException {
        soc = new Socket("localhost", 4000);
        ois = new ObjectInputStream(soc.getInputStream());
        oos = new ObjectOutputStream(soc.getOutputStream());
        Client cl = new Client(nomClient);
        oos.writeObject(cl);
    }

    private static void conversation() throws IOException, ClassNotFoundException, InterruptedException {
        int i=1;
        while(true){
            System.out.println("************* DEBUT DE LA CONVERSATION *************");
            List<String>litDestinataire = new ArrayList<>();
            Trame trame = new Trame( "message - " +i, nomClient,litDestinataire,true);
            oos.writeObject(trame);
            Trame retour = (Trame) ois.readObject();
            System.out.println(retour.toString());
            i++;
            Thread.sleep(1000);
        }
    }
}

