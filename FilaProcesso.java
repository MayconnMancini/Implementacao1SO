package util;

import Entidades.Processo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FilaProcesso {
    
    private List<Processo> processos = new ArrayList<>();
    
    public void insere(Processo p){
     this.processos.add(p);
    }
    
    public Processo remove(){
        if(vazia()){
            return null;
        }
        return this.processos.remove(0);
    }
    
    public boolean vazia(){
        return this.processos.size() == 0;
    }

    public List<Processo> getProcessos() {
        return processos;
    }
    
    
    
}
