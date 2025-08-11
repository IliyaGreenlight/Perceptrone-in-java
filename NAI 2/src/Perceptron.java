import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Perceptron {
    private Vector weights;
    private double threshold;
    private double learningRate;

    public Perceptron(double learningRate) {
        this.learningRate = learningRate;
        this.threshold = Math.random()/5;
    }

    public void train(String path, int epochs){
        List<String> data = DataReader.readDataset(path);
        TreeMap<String, double[]> setup = Parser.parse(data.get(0));
        this.weights = new Vector(setup.get(setup.firstKey()).length);
        int counter;
        for (int i = 0; i < epochs; i++) {
            counter = 0;
            Collections.shuffle(data);
            for (int j = 0; j < data.size(); j++) {
                TreeMap<String, double[]> iris = Parser.parse(data.get(j));
                if (trainIteration(iris.firstKey(), iris.get(iris.firstKey()))){
                    counter++;
                }
            }
            System.out.println("Epoch: " + (i+1) + " Precision: " + ((counter * 1.)/ data.size()));
        }
    }

    private boolean trainIteration(String res, double[] input){
        //Iris-versicolor = 1
        //Iris-virginica = 0
        int d;
        if (res.equals("Iris-versicolor") || res.equals("1"))
            d = 1;
        else d = 0;

        boolean itRes = true;
        int y = 0;
        Vector x = new Vector(input);
        double sum = this.weights.dotProduct(x);

        if (sum>threshold){
            y = 1;
            if (d == 0){
                itRes= false;
                this.weights.setParameters(
                    this.weights.add(
                        x.multiply(
                            (
                                (d-y)*learningRate)
                        )
                    ).getParameters()
                );
            }
        } else {
            y = 0;
            if (d == 1){
                itRes = false;
                this.weights.setParameters(
                    this.weights.add(
                        x.multiply(
                            (
                                (d-y)*learningRate)
                        )
                    ).getParameters()
                );
            }
        }

        this.threshold = this.threshold - (d-y) * learningRate;
        return itRes;
    }

    public boolean classify(String input){
        String[] raw = input.split(",");
        double[] data = new double[raw.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = Double.parseDouble(raw[i]);
        }
        Vector vx = new Vector(data);
        double sum = this.weights.dotProduct(vx);
        if (sum>threshold){
            return true;
        } else return false;
    }
}
