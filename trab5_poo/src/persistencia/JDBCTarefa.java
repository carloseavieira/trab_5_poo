/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;
import modelo.Tarefa;

/**
 *
 * @author carlos.vieira
 */
public class JDBCTarefa {
   
Connection conexao;

    public JDBCTarefa(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirTarefa(Tarefa t){
        String sql = "insert into tarefa(concluido, urgencia, titulo) values (?, ?, ?)";
        PreparedStatement ps;

        try {
            ps = this.conexao.prepareStatement(sql);
            ps.setBoolean(1, t.isConcluido());
            ps.setString(2, t.getUrgencia());
            ps.setString(3, t.getTitulo());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
           
        }

    }
    
    public ArrayList<Tarefa> listarTarefas(){
        ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
        String sql = "select * from tarefa";
        
         try {
            Statement declaração = conexao.createStatement();
            ResultSet resposta = declaração.executeQuery(sql);
            
            while(resposta.next()) {
                int id = resposta.getInt("id");
                String titulo = resposta.getString("titulo");
                String urgencia = resposta.getString("urgencia");
                boolean concluido = resposta.getBoolean("concluido");
                
                Tarefa t = new Tarefa(id, titulo, urgencia, concluido);
                tarefas.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return tarefas;
    }
    
    public void atualizarTarefa(Tarefa t){
        String sql = "update tarefa set titulo = ?, urgencia = ?, concluido = ? where id = ?";
        PreparedStatement ps;
        
        try {
            ps = this.conexao.prepareStatement(sql);
            ps.setString(1, t.getTitulo());
            ps.setString(2, t.getUrgencia());
            ps.setBoolean(3, t.isConcluido());
            ps.setInt(4, t.getId());
            ps.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public Tarefa buscarPorId(String id) {
        Tarefa t = new Tarefa();
        String sql = "select * from tarefa where id ="   +id;
        
        try {
            Statement declaração = conexao.createStatement();
            ResultSet resposta = declaração.executeQuery(sql);
            
            while(resposta.next()) {
                String titulo = resposta.getString("titulo");
                String urgencia = resposta.getString("urgencia");
                boolean concluido = resposta.getBoolean("concluido");
                
                t = new Tarefa(titulo, urgencia, concluido);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return t;
    }
}
