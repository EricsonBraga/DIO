import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.sql.SQLOutput;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Java");
        curso1.setDescricao("Descrição curso java");
        curso1.setCargahoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("javascript");
        curso2.setDescricao("descrição curso javascript");
        curso2.setCargahoraria(4);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria de Java");
        mentoria1.setDescricao("descrição de mentoria java");
        mentoria1.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição bootcamp...");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria1);

        Dev dev1 = new Dev();
        dev1.setNome("Gui");
        dev1.inscreverBootcamp(bootcamp);
        System.out.println("Gui");
        System.out.println("Inscrito: " +dev1.getConteudosInscritos());
        dev1.progredir();
        dev1.progredir();
        System.out.println("Inscrito: " +dev1.getConteudosInscritos());
        System.out.println("Concluídos: " +dev1.getConteudosFinalizados());
        System.out.println("Total XP: " +dev1.calcularTotalXP());

        System.out.println("------------------ \n");

        Dev dev2 = new Dev();
        dev2.setNome("Dods");
        dev2.inscreverBootcamp(bootcamp);
        System.out.println("Dods");
        System.out.println("Inscrito: " +dev2.getConteudosInscritos());
        dev2.progredir();
        dev2.progredir();
        dev2.progredir();
        System.out.println("Inscrito: " +dev2.getConteudosInscritos());
        System.out.println("Concluídos: " +dev2.getConteudosFinalizados());
        System.out.println("Total XP: " +dev2.calcularTotalXP());

        System.out.println("------------------ \n");

        System.out.println("Bootcamp: " +bootcamp.getNome()+
                        "\nDevs inscritos: " +bootcamp.getDevsInscritos());










    }
}