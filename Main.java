
import Entidades.Processo;
import java.util.ArrayList;
import java.util.List;
import util.FilaProcesso;

public class Main {

    public static void Verificafila() {

        int i = 1;
        System.out.println("Verifiquei a fila n: " + 1);
        i++;
    }

    public static Processo Escalonador(FilaProcesso fila_pronto, Processo cpu) {

        if (cpu == null) {  // nao tem processo no cpu
            return fila_pronto.remove();  // retorna o primeiro processo da fila de pronto p/ cpu

        } else { // quando existe processo na cpu

            if (cpu.getTempo_execucao() == 0) { // processo terminou a execucao.
                return fila_pronto.remove(); // pegou o processo do comeco da fila e colocou na cpu
            }

            // quando existir troca de contexto
            fila_pronto.insere(cpu); // retirou o processo da cpu e colocou no fim da lista de pronto

            return fila_pronto.remove(); // pegou o processo do comeco da fila e colocou na cpu

        }

    }

    public static void Ciclo(FilaProcesso fila_pronto) {
        List<Processo> processosExecutados = new ArrayList<>();
        int ciclo = 0;
        int trocaDeContexto = 0;
        int quantum = 4;  // quantum
        Processo cpu = null;     // cpu está ociosa

        Verificafila();         // verifica se tem processo para entrar pra fila de pronto.
        cpu = Escalonador(fila_pronto, cpu); // chama o escalonador. o msm retornará um processo para cpu.
        cpu.setTempo_comeco_execucao(ciclo);
        System.out.println("Adicionei o primeiro processo na cpu");
        System.out.println(cpu);
        System.out.println("");

        do {                            // ira executar até acabar os processos da lista de processos;
            System.out.println("Entrei no loop principal");
            while (quantum > 0) {       // executa o processo até acabar seu quantum
                System.out.println("Entrei no looping quatum");
                System.out.println("Processo: " + cpu.getId() + " Tempo de Execucao: " + cpu.getTempo_execucao());

                System.out.println();

               // if (cpu.getTempo_execucao() > 0) { // verifica se acabou o tempo de execucao do processo
                    cpu.setTempo_execucao(cpu.getTempo_execucao() - 1); // executou 1 ciclo e diminuiu o tempo de execucao do processo; 
                    System.out.print("Diminui o contador de tempo do processo: ");
                    System.out.println(cpu.getTempo_execucao());
                    cpu.setTempo_terminou_execucao(ciclo);
             //   }
                
                ciclo++;
                quantum--;
                Verificafila();
            }
            if (cpu.getTempo_execucao() == 0) {
                
                System.out.println("salvei o processo");
                
                processosExecutados.add(cpu); // salva os processos executados em uma lista
            }

            cpu = Escalonador(fila_pronto, cpu); // quantum = 0; troca de processo da cpu

            System.out.println("Mudei pra outro processo");
            System.out.println(cpu);
            ciclo++;
            quantum = 4;

        } while (cpu != null);

        System.out.println("-------------------------");

        for (Processo p : processosExecutados) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {

        ArrayList<Processo> lista_processos = new ArrayList<>();

        lista_processos.add(new Processo(0, 0, 4, 1));
        lista_processos.add(new Processo(1, 1, 4, 1));
        lista_processos.add(new Processo(2, 2, 4, 1));
        lista_processos.add(new Processo(3, 3, 4, 2));

        FilaProcesso fila_pronto = new FilaProcesso();

        fila_pronto.insere(lista_processos.get(0));
        fila_pronto.insere(lista_processos.get(1));
        fila_pronto.insere(lista_processos.get(2));
        fila_pronto.insere(lista_processos.get(3));

        for (Processo p : lista_processos) {
            System.out.println(p);
        }

        System.out.println("------------------------------");

        for (Processo p : fila_pronto.getProcessos()) {
            System.out.println(p);
        }

        System.out.println("Entrei no ciclo\n");

        Ciclo(fila_pronto);

    }

}
