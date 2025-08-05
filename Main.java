import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            double a = lerNumero(scanner, "Insira o primeiro valor: ");
            double b = lerNumero(scanner, "Insira o segundo valor: ");
            int operacao = lerOperacao(scanner);

            double resultado = calcular(a, b, operacao);
            if (!Double.isNaN(resultado)) {
                System.out.println("Resultado: " + resultado);
            }

            System.out.print("Deseja fazer outra operação? (s/n): ");
            char continuar = scanner.next().toLowerCase().charAt(0);
            if (continuar != 's') break;
        }

        scanner.close();
        System.out.println("Encerrando a calculadora.");
    }

    static double lerNumero(Scanner scanner, String mensagem) {
        while (true) {
            System.out.println(mensagem);
            if (scanner.hasNextDouble()){
                return scanner.nextDouble();
            } else {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.next();
            }
        }
    }

    static int lerOperacao(Scanner scanner) {
        System.out.println("Operações disponíveis:");
        System.out.println("1 = Soma");
        System.out.println("2 = Subtração");
        System.out.println("3 = Multiplicação");
        System.out.println("4 = Divisão");
        System.out.println("5 = Potência");
        System.out.println("6 = Raiz quadrada (apenas do primeiro valor)");
        System.out.println("7 = Porcentagem");
        System.out.print("Escolha a operação (1-7): ");
        return scanner.nextInt();
    }

    static double calcular(double a, double b, int op) {
        switch (op) {
            case 1: return a + b;
            case 2: return a - b;
            case 3: return a * b;
            case 4:
                if (b == 0) {
                    System.out.println("Erro: divisão por zero.");
                    return Double.NaN;
                }
                return a / b;
            case 5: return potencia(a, b);
            case 6:
                if (a < 0) {
                    System.out.println("Erro: não é possível calcular a raiz de número negativo.");
                    return Double.NaN;
                }
                return Math.sqrt(a);
            case 7: return (a / 100) * b;
            default:
                System.out.println("Opção inválida");
                return Double.NaN;
        }
    }

    static double potencia(double a, double b) {
        double c = 1;
        for (int i = 0; i < b; i++) {
            c *= a;
        }
        return c;
    }
}
