/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author carlos.vieira
 */
public class Tarefa {
    private int id;
    private String urgencia;
    private String titulo;
    private boolean concluido;

    public Tarefa(int id, String titulo, String urgencia, boolean concluido) {
        this.id = id;
        this.titulo = titulo;
        this.urgencia = urgencia;
        this.concluido = concluido;
    }
    
    public Tarefa(String titulo, String urgencia, boolean concluido) {
        this.titulo = titulo;
        this.urgencia = urgencia;
        this.concluido = concluido;
    }
    
    public Tarefa() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUrgencia() {
        return urgencia;
    }
    
    public void setUrgencia(String urgencia){
        this.urgencia = urgencia;
    }
      
    public String gettitulo() {
        return titulo;
    }

    public void settitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public String getTitulo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
