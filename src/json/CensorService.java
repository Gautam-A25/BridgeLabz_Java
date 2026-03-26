package json;

public class CensorService{
    public static String maskTeam(String team){
        String[] words = team.split(" ");

        if(words.length > 1){
            return words[0] + " ***";
        }

        return "***";
    }

    public static String redactPlayer() {
        return "REDACTED";
    }
}