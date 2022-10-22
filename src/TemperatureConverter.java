import java.util.Scanner;
import java.util.InputMismatchException;
public class TemperatureConverter {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Quantas temperaturas gostaria de converter?");

        Integer numTemp = 0;

        do {
            while (!input.hasNextInt()){
                System.out.println("Favor escolher um valor INTEIRO maior que zero: ");
                input.next();
            }
            numTemp = input.nextInt();
            if(numTemp <= 0){
                System.out.println("Favor escolher um valor INTEIRO maior que zero: ");
            }
        } while (numTemp <= 0);

//        do {
//            try {
//                numTemp = input.nextInt();
//            } catch (Exception exception) {
//                System.out.println("Erro no valor de entrada : " + exception);
//                System.out.print("Favor escolher um valor Inteiro maior que zero: ");
//            }
//        } while (!input.hasNextInt());




        System.out.println("Agora escolha duas unidades de temperatura:");
        System.out.println("C: Celcius [ºC]");
        System.out.println("F: Fahrenheit [ºF]");
        System.out.println("K: Kelvin [K]");
        System.out.print("Unidade de origem (C, F ou K):");


        //TODO: Implementar para não validar String
        char unidadeOrigem = input.next().charAt(0);

        while(unidadeOrigem != 'C' && unidadeOrigem != 'F' && unidadeOrigem != 'K'){
            System.out.print("Favor digitar uma unidade de origem (C, F ou K): ");
            unidadeOrigem = input.next().charAt(0);
        }

        System.out.print("Unidade desejada (C, F ou K):");
        char unidadeDesejada = input.next().charAt(0);

        while(unidadeDesejada != 'C' && unidadeDesejada != 'F' && unidadeDesejada != 'K'){
            System.out.print("Favor digitar uma unidade de origem (C, F ou K): ");
            unidadeDesejada = input.next().charAt(0);
        }

        // Classe que possui métodos de apoio para facilitar a construção de strings.
        StringHelper stringHelper = new StringHelper();

        System.out.println("Agora insira " + numTemp + " temperaturas (em " + stringHelper.checkUnitOfMeasureName(unidadeOrigem) + "): ");

        // Obtém as temperaturas de Entrada
        Double[] temperaturasEntrada = new Double[numTemp];
        Double tempInserida = 0.0;
        for (int i = 0; i < numTemp; i++){

            System.out.print("Temperatura " + String.valueOf(i+1) + ": ");//tempInserida = input.nextDouble();
            while (!input.hasNextDouble()){
                System.out.println("Favor escolher um valor Numérico para a temperatura "+ String.valueOf(i+1) + ": ");
                input.next();
            }
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
//            System.out.println(temperaturasEntrada[j] + stringHelper.checkUnitOfMeasure(unidadeOrigem) + " para " +
//                    stringHelper.checkUnitOfMeasureName(unidadeDesejada) + " = " + temperaturasConvertidas[j] +
//                    stringHelper.checkUnitOfMeasure(unidadeDesejada));

            System.out.printf("%.3f" + stringHelper.checkUnitOfMeasure(unidadeOrigem) +
                    " para " + stringHelper.checkUnitOfMeasureName(unidadeDesejada) +
                    " = %.3f" + stringHelper.checkUnitOfMeasure(unidadeDesejada) + "\n", temperaturasEntrada[j], temperaturasConvertidas[j]);
        }

        ArrayArithmetics dadosTemperaturasEntrada = new ArrayArithmetics(temperaturasEntrada);
        ArrayArithmetics dadosTemperaturasConvertidas = new ArrayArithmetics(temperaturasConvertidas);
        System.out.printf("Média das temperaturas de entrada: %.3f" + stringHelper.checkUnitOfMeasure(unidadeOrigem)+"\n",dadosTemperaturasEntrada.findArrayAverage());
        System.out.printf("Média das temperaturas convertidas: %.3f" + stringHelper.checkUnitOfMeasure(unidadeDesejada),dadosTemperaturasConvertidas.findArrayAverage());
    }
}