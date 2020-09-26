import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation") // @ManagedBean JavaServerFaces
@ManagedBean(name = "calculatorBean", eager = true) // javax:javaee-api:8.0.1
@SessionScoped
public class CalculatorBean implements Serializable {

private ArrayList<Double> numbers = new ArrayList<>();
    private ArrayList<String> historia = new ArrayList<>();
    private double promedio = 0;
    private double devEstandar = 0;
    private double varianza = 0;
    private double moda = 0;

    public CalculatorBean(){
    }

    /**
     * Ingresar la cadena web
     */
    public void setNumbersWeb(String numbersWeb){
        calcularValores(numbersWeb);
    }

    /**
     * Obtener los numeros ingresados por el usuario
     */
    public ArrayList<Double> getNumbers(){
        return numbers;
    }

    /**
     * Ingresar array de numeros
     */
    public void setNumbers(ArrayList<Double> numbers){
        this.numbers = numbers;
    }

    /**
     * Obtener el promedio
     */
    public double getPromedio(){
        return promedio;
    }

    /**
     * Obtener la Desviacion Estandar
     */
    public double getDevEstandar(){
        return promedio;
    }

    /**
     * Obtener la varianza
     */
    public double getVarianza(){
        return varianza;
    }

    /**
     * Obtener la moda
     */
    public double getModa() {
        return moda;
    }

    /**
     * Cantidad de datos Ingresados por el usuario
     */
    public int getCantNumbers(){
        return this.numbers.size();
    }

    /**
     * Promedio de los numeros
     */
    public double calculateMean(ArrayList<Double> numbers){
        this.numbers = numbers;
        double prom = 0;
        for(Double i : this.numbers){
            prom += i;
        }
        promedio = prom/this.numbers.size();
        return promedio;
    }

    /**
     * Desviacion Estandar
     */
    public double calculateStanderdDeviation(ArrayList<Double> numbers){
        this.numbers = numbers;
        devEstandar = Math.sqrt(calculateVariance(this.numbers));
        return devEstandar;
    }

    /**
     * Varianza
     */
    public double calculateVariance(ArrayList<Double> numbers){
        this.numbers = numbers;
        double promedio = calculateMean(this.numbers);
        double sumatoria = 0;
        for (Double i : this.numbers){
            sumatoria += Math.pow((i - promedio), 2);
        }
        varianza = sumatoria/this.numbers.size();
        return varianza;
    }

    /**
     * Moda
     */
    public double calculateMode(ArrayList<Double> numbers){
        this.numbers = numbers;
        int maximoNumRepe = 0;
        moda = 0;
        int repe=0;
        for (Double i : this.numbers){
            for(Double j : this.numbers){
                if (i == j){
                    repe ++;
                }
                if (repe>maximoNumRepe){
                    moda = i;
                    maximoNumRepe = repe;
                }
            }
        }
        return moda;
    }

    /**
     * Resetear Calculadora
     */
    public void restart(){
        this.numbers = new ArrayList<>();
        this.historia = new ArrayList<>();
        this.promedio = 0;
        this.devEstandar = 0;
        this.varianza = 0;
        this.moda = 0;
    }

    /**
     * Convertir la cadena entrante en dobles
     */
    public ArrayList<Double> stringToDouble(String lista) {
        String[] ListaDobles = lista.trim().split(";");
        ArrayList<Double> listaConvertida = new ArrayList<>();
        for (int i= 0; i<ListaDobles.length; i++){
            Double conver = Double.parseDouble(ListaDobles[i]);
            listaConvertida.add(conver);
        }
        return listaConvertida;
    }

    /**
     * Calcular todos los valores web
     */
    public void calcularValores(String lista){
        this.numbers = stringToDouble(lista);
        calculateMean(numbers);
        calculateStanderdDeviation(numbers);
        calculateVariance(numbers);
        calculateMode(numbers);
        historia.add(lista);
    }

    /**
     * Obtener las listas de los intentos
     */
    public ArrayList<String> getHistoria(){
        return historia;
    }
}