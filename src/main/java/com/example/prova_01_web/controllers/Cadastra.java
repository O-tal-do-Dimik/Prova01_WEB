package com.example.prova_01_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
@RequestMapping("/cadastra")
public class Cadastra {

    private String INSERINDO = "" ;
    @PostMapping
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        var writer = response.getWriter();
        var id = request.getParameter("id");
        var name = request.getParameter("nome");
        var preco = request.getParameter("preco");
        var descri = request.getParameter("descricao");
        var vali = request.getParameter("validade");
        var calo = request.getParameter("calorias");



        Connection conexao = null;
        try {
            conexao = ConectaBanco.getConnection();
        } catch (SQLException | URISyntaxException ex) {
            response.getWriter().append("Connection Failed! Check output console");
        }

        if (conexao == null) {
            response.getWriter().append("A conexão com o banco falhou!");
        }



        INSERINDO = "INSERT INTO COMIDAS (ID,NAME,PRECO,DESCRICAO,VALIDADE,CALORIAS)VALUES ("+id+",'"+name+"',"+preco+",'"+descri+"','"+vali+"',"+calo+")";
        PreparedStatement  insert =(PreparedStatement)  conexao.prepareStatement(INSERINDO);
        boolean rs = insert.execute();

        response.sendRedirect("/admin");
    }

}
