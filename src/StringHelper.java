public class StringHelper {
    // Retorna a unidade de medida da temperatura
    public String checkUnitOfMeasure(char unit){
        return switch (unit){
            case 'C' -> "ºC";
            case 'F' -> "ºF";
            case 'K' -> "K";
            default -> "";
        };
    }

    // Retorna o nome da unidade de medida da temperatura
    public String checkUnitOfMeasureName(char unit){
        return switch (unit){
            case 'C' -> "Celcius";
            case 'F' -> "Fahrenheit";
            case 'K' -> "Kelvin";
            default -> "";
        };
    }
}
