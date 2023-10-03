
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {


        int numero;
        String agencia, nomeCliente;
        double saldo;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do cliente");
        nomeCliente = scanner.next();
        System.out.println("Informe o número da agência");
        agencia = scanner.next();
        System.out.println("Informe o número da conta");
        numero = scanner.nextInt();
        System.out.println("Informe o saldo");
        saldo = scanner.nextDouble();

        System.out.println("Olá "+nomeCliente+", \nobrigado por criar uma conta em nosso banco," +
                "\nsua agência é "+agencia+", \nconta "+numero+" \ne seu saldo: R$"+saldo+" já " +
                "está disponível para saque.");


    }
}
