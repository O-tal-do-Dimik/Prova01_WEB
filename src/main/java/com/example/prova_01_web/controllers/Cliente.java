package com.example.prova_01_web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
@RequestMapping("/cliente")
public class Cliente {

    private final String CONSULTA = "SELECT * FROM COMIDAS";

    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {


        var writer = response.getWriter();
        var id = request.getParameter("id");

        if(id != null){
            RequestDispatcher encaminhar = request.getRequestDispatcher("/adicionarCarrinho");
            encaminhar.forward(request, response);
        }


        Connection conexao = null;
        try {
            conexao = ConectaBanco.getConnection();

        } catch (SQLException | URISyntaxException ex) {
            response.getWriter().append("Connection Failed! Check output console");
        }

        if (conexao == null) {
            response.getWriter().append("A conexão com o banco falhou!");
        }

        PreparedStatement chamaBanco =(PreparedStatement)  conexao.prepareStatement(CONSULTA);
        ResultSet resultbanco = chamaBanco.executeQuery();

        response.setContentType("text/html");
        response.getWriter().append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "Restaurante Chines Cansado\n" +
                "\n" +
                "<table border=\"1\"><tr>\n" +
                "        <td>Id</td>\n" +
                "        <td>Produto</td>\n" +
                "        <td>Preço</td>\n" +
                "        <td>Descrição</td>\n" +
                "        <td>Validade</td>\n" +
                "        <td>Calorias</td>\n" +
                "        <td>Carrinho</td>\n" +
                "    </tr>");
//
//        while(resultbanco.next())
//        {
//            response.getWriter().append("    <tr>\n" +
//                    "        <td>"+resultbanco.getInt("ID")+"</td>\n" +
//                    "        <td>"+resultbanco.getString("NAME")+"</td>\n" +
//                    "        <td>"+resultbanco.getDouble("PRECO")+"</td>\n" +
//                    "        <td>"+resultbanco.getString("DESCRICAO")+"</td>\n" +
//                    "        <td>"+resultbanco.getString("VALIDADE")+"</td>\n" +
//                    "        <td>"+resultbanco.getDouble("CALORIAS")+"</td>\n" +
//                    "        <td><form action='/cliente' method='GET' id='add_carrinho_"+resultbanco.getInt("ID")+"'><input type='hidden' name='id' id='id' value='"+resultbanco.getInt("ID")+"'/><a href='#' onClick='document.getElementById(\"add_carrinho_"+resultbanco.getInt("ID")+"\").submit();'>Adicionar</a></form></td>\n" +
//                    "    </tr>");
//
//        }
//
//        response.getWriter().append("</table>\n" +
//                "\n" +
//                "<a href='/verCarrinho'> Ver Carrinho </a>\n" +
//                "</body>\n" +
//                "</html>");
//
    }



}
