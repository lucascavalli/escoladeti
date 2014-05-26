

package br.unicesumar.escoladeti.types;

public enum Sexo {
    
     M('M'),
    F('F');
    
    public char tipo() {
        return tipo;
    }
     
    private final char tipo;
    
    private Sexo (char tipo){
        this.tipo = tipo;
    }
    
}
