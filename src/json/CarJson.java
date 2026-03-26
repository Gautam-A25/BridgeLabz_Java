package json;

import com.fasterxml.jackson.databind.ObjectMapper;
class Car {
    public String brand;
    public int year;
}

public class  CarJson{
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        car.brand = "Toyota";
        car.year = 2022;

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(car);

        System.out.println(json);
    }
}
