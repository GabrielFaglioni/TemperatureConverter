public class StringHelper {
    public String checkUnitOfMeasure(char unit){
        return switch (unit){
            case 'C' -> "ºC";
            case 'F' -> "ºF";
            case 'K' -> "K";
            default -> "";
        };
    }

    public String checkUnitOfMeasureName(char unit){
        return switch (unit){
            case 'C' -> "Celcius";
            case 'F' -> "Fahrenheit";
            case 'K' -> "Kelvin";
            default -> "";
        };
    }
}
