import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Vector {
    private double[] parameters;


    public Vector(double... parameters) {
        this.parameters = parameters;
    }

    public void setParameters(double[] parameters) {
        this.parameters = parameters;
    }

    public Vector(int paramNum) {
        this.parameters = new double[paramNum];
        Arrays.fill(parameters, 0.00001);
    }

    public double dotProduct(Vector vector) {
        if (vector.parameters.length == parameters.length) {
            double result = 0;

            for (int i = 0; i < parameters.length; i++) {
                result += vector.parameters[i] * parameters[i];
            }

            return result;
        } else {
            return 0.0;
        }
    }

    public Vector add(Vector vector) {
        if (vector.parameters.length == parameters.length) {
            for (int i = 0; i < parameters.length; i++) {
                parameters[i] += vector.parameters[i];
            }
        }
        return this;
    }

    public Vector multiply(double number) {
        double[] newParameters = new double[this.parameters.length];

        for (int i = 0; i < parameters.length; i++) {
            newParameters[i] = parameters[i] * number;
        }

        return new Vector(newParameters);
    }

    public double distance(Vector vector) {
        if (vector.parameters.length != parameters.length) {
            return -1;
        }

        double result = 0;

        for (int i = 0; i < parameters.length; i++) {
            result += Math.pow(parameters[i] - vector.parameters[i], 2);
        }

        return Math.sqrt(result);
    }

    public double length() {
        double result = 0;

        for (double parameter : parameters) {
            result += Math.pow(parameter, 2);
        }

        return Math.sqrt(result);
    }

    public double[] getParameters() {
        return parameters;
    }
}
