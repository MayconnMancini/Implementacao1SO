package aplicacao;

import Entidades.Escalonador;
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

    public static void Ciclo(FilaProcesso fila_pronto) {
        Escalonador rr = new Escalonador();
        int tCpuOcioso = 0;
        List<Processo> processosExecutados = new ArrayList<>();
        int ciclo = 0;

        int quantum = 4;            // quantum
        Processo cpu = null;        // cpu está ociosa

        Verificafila();              // verifica se tem processo para entrar pra fila de pronto.
        cpu = rr.escalonar(fila_pronto, cpu); // chama o escalonador. o msm retornará um processo para cpu.
        tCpuOcioso++;
        ciclo++;

        cpu.setTempo_comeco_execucao(ciclo);  // salva o tempo de inicio da execucao

        System.out.println("Adicionei o primeiro processo na cpu");
        System.out.println(cpu);
        System.out.println("");

        do {                            // ira executar até acabar os processos da lista de processos;

            System.out.println("Entrei no loop principal");
            System.out.println("ciclo: " + ciclo);
            
            if (cpu.getTempo_comeco_execucao() == -1) {         // verifica se o processo nunca foi executado
                cpu.setTempo_comeco_execucao(ciclo);            // salva o tempo de inicio da execucao
            }
            
            while (quantum > 0) {       // executa o processo até acabar seu quantum
                System.out.println("Entrei no looping quatum");
                System.out.println("Processo: " + cpu.getId() + " Tempo de Execucao: " + cpu.getTempo_execucao());

                System.out.println();

                if (cpu.getTempo_execucao() > 0) {
                    cpu.setTempo_execucao(cpu.getTempo_execucao() - 1); // executou 1 ciclo e diminuiu o tempo de execucao do processo; 
                    System.out.print("Diminui o contador de tempo do processo: ");
                    System.out.println(cpu.getTempo_execucao());
                    //cpu.setTempo_terminou_execucao(ciclo);
                }
                ciclo++;
                quantum--;
                Verificafila();
            }
            System.out.println("Cilco: " + ciclo);

            if (cpu.getTempo_execucao() == 0) {

                System.out.println("salvei o processo");
                cpu.setTempo_terminou_execucao(ciclo);
                processosExecutados.add(cpu); // salva os processos executados em uma lista
            }

            cpu = rr.escalonar(fila_pronto, cpu);; // quantum = 0; troca de processo da cpu
            tCpuOcioso++;
            System.out.println("Mudei pra outro processo");
            System.out.println(cpu);
            ciclo++;
            quantum = 4;     

        } while (cpu != null);

        System.out.println("-------------------------");

        for (Processo p : processosExecutados) {
            System.out.println(p);
        }

        System.out.println("TEmpo Ocioso de CPU: " + tCpuOcioso);
        System.out.println("Ciclo: " + ciclo);
        System.out.println("Troca de contexto: " + rr.getTrocaContexto());

    }

    public static void main(String[] args) {

        ArrayList<Processo> lista_processos = new ArrayList<>();

        lista_processos.add(new Processo(0, 0, 6, 1)); 
        lista_processos.add(new Processo(1, 1, 5, 1)); 
        lista_processos.add(new Processo(2, 2, 9, 1)); 
        lista_processos.add(new Processo(3, 3, 8, 2)); 

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
