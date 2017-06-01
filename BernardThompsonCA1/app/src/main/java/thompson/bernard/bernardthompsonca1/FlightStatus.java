package thompson.bernard.bernardthompsonca1;

/**
 * Created by bonjo1983 on 20/02/2017.
 */

public class FlightStatus {

    public String flightNo;
    public String destination;
    public String time;
    public String status;
    public int airlineImg;

    public FlightStatus(String flightNo, String destination, String time, String status, int airlineImg){

        this.flightNo = flightNo;
        this.destination = destination;
        this.time = time;
        this.status = status;
        this.airlineImg = airlineImg;
    }
}
