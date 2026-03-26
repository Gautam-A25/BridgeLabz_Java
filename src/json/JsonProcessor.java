package json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonProcessor{
    public static void processJson() throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        Match[] matches = mapper.readValue(new File("matches.json"), Match[].class);

        for(Match m : matches){

            m.team1 = CensorService.maskTeam(m.team1);
            m.team2 = CensorService.maskTeam(m.team2);
            m.player_of_match = CensorService.redactPlayer();
        }

        mapper.writeValue(new File("censored_matches.json"), matches);
    }
}
