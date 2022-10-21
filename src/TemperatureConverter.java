import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Quantas temperaturas gostaria de converter?");

        //TODO: IMPLEMENTAR TRY CATCH
        int numTemp = input.nextInt();

        System.out.println("Agora escolha duas unidades de temperatura:");
        System.out.println("C: Celcius [ºC]");
        System.out.println("F: Fahrenheit [ºF]");
        System.out.println("K: Kelvin [K]");
        System.out.print("Unidade de origem (C, F ou K):");

        //TODO: Implementar para não validar String
        char unidadeOrigem = input.next().charAt(0);

        while(unidadeOrigem != 'C' && unidadeOrigem != 'F' && unidadeOrigem != 'K'){
            System.out.print("Favor digitar uma unidade de origem (C, F ou K):");
            unidadeOrigem = input.next().charAt(0);
        }

        System.out.print("Unidade desejada (C, F ou K):");
        char unidadeDesejada = input.next().charAt(0);

        while(unidadeDesejada != 'C' && unidadeDesejada != 'F' && unidadeDesejada != 'K'){
            System.out.print("Favor digitar uma unidade de origem (C, F ou K):");
            unidadeDesejada = input.next().charAt(0);
        }

        // Classe que possui métodos de apoio para facilitar a construção de strings.
        StringHelper stringHelper = new StringHelper();

        System.out.println("Agora insira " + numTemp + " temperaturas (em " + stringHelper.checkUnitOfMeasureName(unidadeOrigem) + "):");

        // Obtém as temperaturas de Entrada
        Double[] temperaturasEntrada = new Double[numTemp];
        Double tempInserida = 0.0;
        for (int i = 0; i < numTemp; i++){
            //TODO: IMPLEMENTAR TRY CATCH
            tempInserida = input.nextDouble();
            temperaturasEntrada[i] = tempInserida;
        }

        // Concatenador que irá criar a String na qual irá verificar qual tipo
        // de conversão o usuário escolheu
        StringBuilder conversorEscolhidoBuilder = new StringBuilder();
        conversorEscolhidoBuilder.append(unidadeOrigem).append(unidadeDesejada);
        String conversorEscolhido = conversorEscolhidoBuilder.toString();

        TemperatureConverterCalculator tempConvCalc = new TemperatureConverterCalculator();

        // Realiza a conversão das temperaturas
        System.out.println(conversorEscolhido);
        Double[] temperaturasConvertidas = switch (conversorEscolhido) {
            // Celsius -> Celcius
            case "CC" -> tempConvCalc.celciusToCelcius(temperaturasEntrada);
            // Celsius -> Fahrenheit
            case "CF" -> tempConvCalc.celciusToFahrenheit(temperaturasEntrada);
            // Celsius -> Kelvin
            case "CK" -> tempConvCalc.celciusToKelvin(temperaturasEntrada);
            // Fahrenheit -> Fahrenheit
            case "FF" -> tempConvCalc.fahrenheitToFahrenheit(temperaturasEntrada);
            // Fahrenheit -> Celcius
            case "FC" -> tempConvCalc.fahrenheitToCelcius(temperaturasEntrada);
            // Fahrenheit -> Kelvin
            case "FK" -> tempConvCalc.fahrenheitToKelvin(temperaturasEntrada);
            // Kelvin -> Kelvin
            case "KK" -> tempConvCalc.kelvinToKelvin(temperaturasEntrada);
            // Kelvin -> Celcius
            case "KC" -> tempConvCalc.kelvinToCelcius(temperaturasEntrada);
            // Kelvin -> Fahrenheit
            case "KF" -> tempConvCalc.kelvinToFahrenheit(temperaturasEntrada);
            default -> new Double[numTemp];
        };

        // Imprime todas as temperaturas escolhidas e suas respectivas conversões.
        for (int j = 0; j < temperaturasEntrada.length; j++){
            System.out.println(temperaturasEntrada[j] + stringHelper.checkUnitOfMeasure(unidadeOrigem) + " para " + stringHelper.checkUnitOfMeasureName(unidadeDesejada) + " = " + temperaturasConvertidas[j] + stringHelper.checkUnitOfMeasure(unidadeDesejada));
        }

        ArrayArithmetics dadosTemperaturasEntrada = new ArrayArithmetics(temperaturasEntrada);
        ArrayArithmetics dadosTemperaturasConvertidas = new ArrayArithmetics(temperaturasConvertidas);
        System.out.print("Média das temperaturas de entrada: " + dadosTemperaturasEntrada.findArrayAverage() + stringHelper.checkUnitOfMeasure(unidadeOrigem));
        System.out.print("Média das temperaturas convertidas: " + dadosTemperaturasConvertidas.findArrayAverage() + stringHelper.checkUnitOfMeasure(unidadeDesejada));
    }
}