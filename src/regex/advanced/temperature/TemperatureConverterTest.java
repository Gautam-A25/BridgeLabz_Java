package javacollectionstreams.regex.advanced.temperature;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    // Creating TemperatureConverter object
    TemperatureConverter converter = new TemperatureConverter();

    // Test Celsius to Fahrenheit conversion
    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(98.6, converter.celsiusToFahrenheit(37), 0.1);
    }

    // Test Fahrenheit to Celsius conversion
    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0, converter.fahrenheitToCelsius(32), 0.1);
    }
}
