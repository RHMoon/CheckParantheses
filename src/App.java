import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        String str = "{(aku}"; // input to be checked

        char[] OpenParanthesesSearch = {'{','[','('};
        char[] CloseParanthesesSearch = {'}',']',')'};
        Integer [] OpenCounter = {0,0,0};
        Integer [] CloseCounter = {0,0,0};
        Integer [] noBracket = {0,0,0};
        boolean parant = true;
        boolean parantOrder = true;
        String Msg = "";

        int index = 0;
        // checking and count open adn close parantheses
        while (parantOrder) {
            char chr = str.charAt(index);
            for(int j=0; j<OpenParanthesesSearch.length; j++){
                if(OpenParanthesesSearch[j] == chr){
                    OpenCounter[j]++;      
                }
                if(CloseParanthesesSearch[j] == chr){
                    CloseCounter[j]++;      
                }
                // if the order wrong, stop the loop
                if (CloseCounter[j]>OpenCounter[j]) {
                    parantOrder=false;
                    Msg = "Wrong parentheses order";
                }
            }
            index++;
            // if index exceed, stop the loop
            if (index>str.length()-1) {
                parantOrder=false;
            }
        }

        // System.out.println("Open Para:" + Arrays.deepToString(OpenCounter));
        // System.out.println("Close Para:" + Arrays.deepToString(CloseCounter));

        // check if it is complete parantheses
        if (Arrays.equals(OpenCounter,noBracket)&&Arrays.equals(CloseCounter,noBracket)) {
            parant=false;
            Msg = "There is no parentheses";
        } else {
            if (Arrays.equals(CloseCounter,OpenCounter)) {
                parant=true;
            } else {
                parant=false;
                if (Msg=="") {
                    Msg = "There is unbalance parentheses";       
                }
            } 
        }

        System.out.println("String: "+str);
        System.out.println("Parantheses: "+parant);
        if (Msg=="") {
            
        } else {
            System.out.println("Error: "+Msg);
        }
    }
}