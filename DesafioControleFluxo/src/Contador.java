import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {

        Scanner terminal = new Scanner(System.in);
        System.out.println("Digite o primeiro parâmetro");
        int parametroUm = terminal.nextInt();
        System.out.println("Digite o segundo parâmetro");
        int paramentroDois = terminal.nextInt();

        try {
            contar(parametroUm, paramentroDois);

        }catch (ParametrosInvalidosException e){
            System.out.println(e.getMessage());
        }

    }
    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException{
        if(parametroUm>parametroDois) {
            throw new ParametrosInvalidosException();
        }
        int contagem = parametroDois - parametroUm;

        for(int i=0; i<contagem; i++){
            int numero = i+1;
            System.out.println("Imprimindo o número: " + numero);
        }
    }


}