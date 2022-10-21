public class ArrayArithmetics {
    Double[] array;


    public ArrayArithmetics(Double[] array) {
        this.array = array;
    }

    public Double findArraySum(Double[] array){
        Double arraySum = 0.0;
        for (int i = 0; i < this.array.length; i++){
            arraySum += this.array[i];
        }
        return arraySum;
    }

    public Double findArrayAverage(){
        return findArraySum(this.array)/ this.array.length;
    }
}
