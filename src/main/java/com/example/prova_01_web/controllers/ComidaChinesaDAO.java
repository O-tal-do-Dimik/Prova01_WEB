package com.example.prova_01_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComidaChinesaDAO {


    private  final  String INSERINDO = "INSERT INTO COMIDAS (ID,NAME,PRECO,DESCRICAO,VALIDADE,CALORIAS)VALUES (?,?,?,?,?,?)";

    Connection conexao = null;

    public ComidaChinesaDAO(){

        try {
            conexao = ConectaBanco.getConnection();
        } catch (SQLException | URISyntaxException ex) {
            System.out.println("conexao falhou cheque o console");
        }

        if (conexao != null) {
            System.out.println("conexao realizada");

        } else {
            System.out.println("conexao falhou com o banco");

        }
    }

    public int inclusao(ComidaChinesa comida){
        try{

            PreparedStatement instrucao = conexao.prepareStatement(INSERINDO);
            instrucao.setInt(1, comida.getid());
            instrucao.setString(2, comida.getnome());
            instrucao.setDouble(3,comida.getpreco());
            instrucao.setString(4,comida.getdescricao());
            instrucao.setString(5,comida.getvalidade());
            instrucao.setDouble(6,comida.getcalorias());
            instrucao.execute();
            conexao.close();

            return 1;
        }catch(Exception e){
            System.out.println("Erro na inclusão: "+e.getMessage());
            return 0;
        }
    }

}
