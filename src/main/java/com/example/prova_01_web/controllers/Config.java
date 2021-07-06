package com.example.prova_01_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Controller
@RequestMapping ("/config")
public class Config {

    private final String CRIAR =  "CREATE TABLE COMIDAS(ID INT NOT NULL,NAME CHAR(100) NOT NULL,PRECO DOUBLE PRECISION ,DESCRICAO CHAR(500),VALIDADE CHAR(100),CALORIAS DOUBLE PRECISION, PRIMARY KEY(ID))";

    private final String DELETA = "DROP TABLE IF EXISTS COMIDAS";



    private  String INSERINDO = "INSSCRICAO,VALIDADE,CALORIAS)VALUES (1,'Yakisoba',32.75,'A refeicao e uma mistura de macarrao com carnes e alguns legumes','consumir em ate 3 dias',1123.4)";


    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        Connection conexao = null;
        try {
            conexao = ConectaBanco.getConnection();
        } catch (SQLException | URISyntaxException ex) {
            response.getWriter().append("Connection Failed! Check output console");
        }

        if (conexao == null) {
            response.getWriter().append("A conexão com o banco falhou!");
        }





        PreparedStatement ps =(PreparedStatement)  conexao.prepareStatement(DELETA);
        boolean rs = ps.execute();




        ps =(PreparedStatement)  conexao.prepareStatement(CRIAR);
        rs = ps.execute();


        ps =(PreparedStatement)  conexao.prepareStatement(INSERINDO);
        rs = ps.execute();

        INSERINDO = "INSERT INTO COMIDAS (ID,NAME,PRECO,DESCRICAO,VALIDADE,CALORIAS)VALUES (2,'Yakisoba',32.75,'A refeicao e uma mistura de macarrao com carnes e alguns legumes','consumir em ate 3 dias',1123.4)";
        ps =(PreparedStatement)  conexao.prepareStatement(INSERINDO);
        rs = ps.execute();

        INSERINDO = "INSERT INTO COMIDAS (ID,NAME,PRECO,DESCRICAO,VALIDADE,CALORIAS)VALUES (3,'Dan Dan Mian',11.90,'macarrao com carne de porco, pimentas vermelhas, acelga, molho de soja claro e cebolinha','consumir em ate 3 dias',234.4)";
        ps =(PreparedStatement)  conexao.prepareStatement(INSERINDO);
        rs = ps.execute();

        INSERINDO = "INSERT INTO COMIDAS (ID,NAME,PRECO,DESCRICAO,VALIDADE,CALORIAS)VALUES (4,'Zongzi',10.50,'arroz glutinoso com gengibre pimenta e molho de soja','consumir em ate 3 dias',725.4)";
        ps =(PreparedStatement)  conexao.prepareStatement(INSERINDO);
        rs = ps.execute();

        INSERINDO = "INSERT INTO COMIDAS (ID,NAME,PRECO,DESCRICAO,VALIDADE,CALORIAS)VALUES (5,'Tian bu la',17.50,'Prato feito de pasta de peixe frita','consumir em ate 3 dias',87.7)";
        ps =(PreparedStatement)  conexao.prepareStatement(INSERINDO);
        rs = ps.execute();

        INSERINDO = "INSERT INTO COMIDAS (ID,NAME,PRECO,DESCRICAO,VALIDADE,CALORIAS)VALUES (6,'Pato a Pequim',52.50, 'Pato assado diferencia-se por receber variados temperos e molhos específicos, alem de ser preparado em fornos especiais e ser servido com crepes especificamente finos.','consumir em ate 3 dias',3334.54)";
        ps =(PreparedStatement)  conexao.prepareStatement(INSERINDO);
        rs = ps.execute();

        response.getWriter().append("ok");

        try {
            assert conexao != null;
            conexao.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }






    }

}
