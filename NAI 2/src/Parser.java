import java.util.TreeMap;

public abstract class Parser {
    public static TreeMap<String, double[]> parse(String rawData){
        TreeMap<String, double[]> data = new TreeMap<>();
        String[] irisStringData = rawData.split(",");
        double[] irisMeasures = new double[irisStringData.length-1];
        for (int i = 0; i < irisStringData.length-1; i++) {
            irisMeasures[i] = Double.parseDouble(irisStringData[i]);
        }
        data.put(irisStringData[irisStringData.length-1], irisMeasures);
        return data;
    }
}
