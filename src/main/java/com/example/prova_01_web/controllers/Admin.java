package com.example.prova_01_web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping ("/admin")
public class Admin {

    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.getWriter().append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\n" +
                "    Cadastro de Produtos\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action='/cadastra' method='post'>\n" +
                "    <div>\n" +
                "        <label>Numero de Identificação:</label>\n" +
                "        <input type='text' id='id' name='id'  />\n" +
                "    </div>\n" +
                "    <div>\n" +
                "        <label>Nome:</label>\n" +
                "        <input type=\"text\" id=\"nome\" name='nome' \"nome\" />\n" +
                "    </div>\n" +
                "    <div>\n" +
                "        <label>Preço:</label>\n" +
                "        <input type=\"number\" id=\"preco\" name = 'preco' />\n" +
                "    </div>\n" +
                "    <div>\n" +
                "        <label>Descrição:</label>\n" +
                "        <textarea id=\"descricao\" name = 'descricao'></textarea>\n" +
                "    </div>\n" +
                "    <div>\n" +
                "        <label>Validade:</label>\n" +
                "        <input type=\"text\" id=\"validade\" name = 'validade' />\n" +
                "    </div>\n" +
                "    <div>\n" +
                "        <label>Calorias:</label>\n" +
                "        <input type=\"number\" id=\"calorias\" name = 'calorias' />\n" +
                "    </div>\n" +
                "    <button type = \"submit \">Cadastrar</button>\n" +
                "</form>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy|HH:mm:ss");

        Cookie cookie = new Cookie("Visita", dtf.format(LocalDateTime.now()));
        cookie.setMaxAge(60*60*24); //24 hour
        response.addCookie(cookie);


    }
}
