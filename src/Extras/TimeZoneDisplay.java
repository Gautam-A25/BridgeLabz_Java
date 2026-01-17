import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneDisplay {

    public static ZonedDateTime getTimeForZone(String zone) {
        return ZonedDateTime.now(ZoneId.of(zone));
    }

    public static void main(String[] args) {
        ZonedDateTime gmtTime = getTimeForZone("GMT");
        ZonedDateTime istTime = getTimeForZone("Asia/Kolkata");
        ZonedDateTime pstTime = getTimeForZone("America/Los_Angeles");

        System.out.println(gmtTime);
        System.out.println(istTime);
        System.out.println(pstTime);
    }
}
