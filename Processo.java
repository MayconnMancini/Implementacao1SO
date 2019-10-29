package Entidades;

public class Processo {
    
    private int id;
    private int tempo_entrada;
    private int tempo_execucao;
    private int prioridade;
    private int tempo_comeco_execucao;
    private int tempo_terminou_execucao;
    private int tempoExecucao;
    

    public Processo() {
    }
    
   
    public Processo(int id, int tempo_entrada, int tempo_execucao, int prioridade) {
        this.id = id;
        this.tempo_entrada = tempo_entrada;
        this.tempo_execucao = tempo_execucao;
        this.prioridade = prioridade;
        this.tempo_comeco_execucao = -1;
        this.tempo_terminou_execucao= -1;
        this.tempoExecucao = this.tempo_execucao;
        
    }

    public int getTempo_comeco_execucao() {
        return tempo_comeco_execucao;
    }

    public void setTempo_comeco_execucao(int tempo_comeco_execucao) {
        this.tempo_comeco_execucao = tempo_comeco_execucao;
    }

    public int getTempo_terminou_execucao() {
        return tempo_terminou_execucao;
    }

    public void setTempo_terminou_execucao(int tempo_terminou_execucao) {
        this.tempo_terminou_execucao = tempo_terminou_execucao;
    }

    public int getTempoExecucao() {
        return tempoExecucao;
    }

    public void setTempoExecucao(int tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTempo_entrada() {
        return tempo_entrada;
    }

    public void setTempo_entrada(int tempo_entrada) {
        this.tempo_entrada = tempo_entrada;
    }

    public int getTempo_execucao() {
        return tempo_execucao;
    }

    public void setTempo_execucao(int tempo_execucao) {
        this.tempo_execucao = tempo_execucao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "Processo{" + "id=" + id + ", tempo_entrada=" + tempo_entrada + ", tempo_execucao=" + tempo_execucao + ", prioridade=" + prioridade + ", tempo_comeco_execucao=" + tempo_comeco_execucao + ", tempo_terminou_execucao=" + tempo_terminou_execucao + ", tempoExecucao=" + tempoExecucao + '}';
    }

   
   
    
    
}
