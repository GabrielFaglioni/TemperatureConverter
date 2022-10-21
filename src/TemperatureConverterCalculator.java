public class TemperatureConverterCalculator {

    // ================ CELCIUS TO ... CONVERTER ================
    public Double celciusToCelcius(Double tempCelcius){
        return tempCelcius;
    }
    public Double celciusToFahrenheit(Double tempCelcius){
        return (tempCelcius * 1.8 + 32);
    }
    public Double celciusToKelvin(Double tempCelcius){
        return tempCelcius + 273.15;
    }

    // ================ FAHRENHEIT TO ... CONVERTER ================
    public Double fahrenheitToFahrenheit(Double tempFahrenheit){
        return tempFahrenheit;
    }
    public Double fahrenheitToCelcius(Double tempFahrenheit){
        return (tempFahrenheit - 32) * (5.0/9.0);
    }
    public Double fahrenheitToKelvin(Double tempFahrenheit){
        return celciusToKelvin(fahrenheitToCelcius(tempFahrenheit));
    }

    // ================ KELVIN TO ... CONVERTER ================
    public Double kelvinToKelvin(Double tempKelvin){
        return tempKelvin;
    }
    public Double kelvinToCelcius(Double tempKelvin){
        return tempKelvin - 273.15;
    }
    public Double kelvinToFahrenheit(Double tempKelvin){
        return celciusToFahrenheit(kelvinToCelcius(tempKelvin));
    }

    // =============================================================================
    // =============================== ARRAY METHODS ===============================
    // =============================================================================

    // ================ CELCIUS TO ... CONVERTER ================
    public Double[] celciusToCelcius(Double[] tempCelciusInputArray){
        Double[] tempCelciusArray = new Double[tempCelciusInputArray.length];

        for (int i = 0; i < tempCelciusInputArray.length; i++){
            tempCelciusArray[i] = celciusToCelcius(tempCelciusInputArray[i]);
        }

        return tempCelciusArray;
    }

    public Double[] celciusToFahrenheit(Double[] tempCelciusArray){
        Double[] tempFahrenheitArray = new Double[tempCelciusArray.length];

        for (int i = 0; i < tempCelciusArray.length; i++){
            tempFahrenheitArray[i] = celciusToFahrenheit(tempCelciusArray[i]);
        }

        return tempFahrenheitArray;
    }

    public Double[] celciusToKelvin(Double[] tempCelciusArray){
        Double[] tempKelvinArray = new Double[tempCelciusArray.length];

        for (int i = 0; i < tempCelciusArray.length; i++){
            tempKelvinArray[i] = celciusToKelvin(tempCelciusArray[i]);
        }

        return tempKelvinArray;
    }

    // ================ FAHRENHEIT TO ... CONVERTER ================
    public Double[] fahrenheitToFahrenheit(Double[] tempFahrenheitInputArray){
        Double[] tempFahrenheitArray = new Double[tempFahrenheitInputArray.length];

        for (int i = 0; i < tempFahrenheitInputArray.length; i++){
            tempFahrenheitArray[i] = fahrenheitToFahrenheit(tempFahrenheitInputArray[i]);
        }

        return tempFahrenheitArray;
    }

    public Double[] fahrenheitToCelcius(Double[] tempFahrenheitArray){
        Double[] tempCelciusArray = new Double[tempFahrenheitArray.length];

        for (int i = 0; i < tempFahrenheitArray.length; i++){
            tempCelciusArray[i] = fahrenheitToCelcius(tempFahrenheitArray[i]);
        }

        return tempCelciusArray;
    }

    public Double[] fahrenheitToKelvin(Double[] tempFahrenheitArray){
        Double[] tempKelvinArray = new Double[tempFahrenheitArray.length];

        for (int i = 0; i < tempFahrenheitArray.length; i++){
            tempKelvinArray[i] = fahrenheitToKelvin(tempFahrenheitArray[i]);
        }

        return tempKelvinArray;
    }

    // ================ KELVIN TO ... CONVERTER ================
    public Double[] kelvinToKelvin(Double[] tempKelvinInputArray){
        Double[] tempKelvinArray = new Double[tempKelvinInputArray.length];

        for (int i = 0; i < tempKelvinInputArray.length; i++){
            tempKelvinArray[i] = kelvinToKelvin(tempKelvinInputArray[i]);
        }

        return tempKelvinArray;
    }

    public Double[] kelvinToCelcius(Double[] tempKelvinArray){
        Double[] tempCelciusArray = new Double[tempKelvinArray.length];

        for (int i = 0; i < tempKelvinArray.length; i++){
            tempCelciusArray[i] = kelvinToCelcius(tempKelvinArray[i]);
        }

        return tempCelciusArray;
    }

    public Double[] kelvinToFahrenheit(Double[] tempKelvinArray){
        Double[] tempFahrenheitArray = new Double[tempKelvinArray.length];

        for (int i = 0; i < tempKelvinArray.length; i++){
            tempFahrenheitArray[i] = kelvinToFahrenheit(tempKelvinArray[i]);
        }

        return tempFahrenheitArray;
    }
}
