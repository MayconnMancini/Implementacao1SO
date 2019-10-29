package Entidades;

import util.FilaProcesso;


public class Escalonador {
    
    private int trocaContexto;

    public Escalonador() {
    }

    public int getTrocaContexto() {
        return trocaContexto;
    }

    public void setTrocaContexto(int trocaContexto) {
        this.trocaContexto = trocaContexto;
    }
    
   
    
    public Processo escalonar(FilaProcesso fila_pronto, Processo cpu) {

        if (cpu == null) {  // nao tem processo no cpu
            return fila_pronto.remove();  // retorna o primeiro processo da fila de pronto p/ cpu

        } else { // quando existe processo na cpu

            if (cpu.getTempo_execucao() == 0) { // processo terminou a execucao.
                return fila_pronto.remove(); // pegou o processo do comeco da fila e colocou na cpu
            }

            // quando existir troca de contexto
            fila_pronto.insere(cpu); // retirou o processo da cpu e colocou no fim da lista de pronto
            this.trocaContexto = this.trocaContexto + 1;
            return fila_pronto.remove(); // pegou o processo do comeco da fila e colocou na cpu

        }

    }
    
    
}
