import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String pathT = "iris_perceptron\\training.txt";
        String path = "example2\\train.txt";
        double alpha = 0.1;
        int epochs = 29;

        Perceptron p = new Perceptron(alpha);
        p.train(path, epochs);

        while (true) {
            System.out.println("1. Enter observation\n2. EXIT");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    System.out.println("Enter an iris you'd like to test: ");
                    String s = sc.next();
                    if (p.classify(s))
                        System.out.println("Iris-versicolor");
                    else System.out.println("Iris-virginica");
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }
}