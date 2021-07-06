package com.example.prova_01_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping ("/verCarrinho")
public class verCarrinho {

    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {



        HttpSession session=request.getSession();
        ArrayList<ComidaChinesa> carrinho = (ArrayList<ComidaChinesa>) session.getAttribute("carrinho");

        if(session.getAttribute("carrinho") != null){
            response.setContentType("text/html");
            response.getWriter().append("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "Carrinho de Compras\n" +
                    "\n" +
                    "<table border=\"1\"><tr>\n" +
                    "        <td>Id</td>\n" +
                    "        <td>Produto</td>\n" +
                    "        <td>Preço</td>\n" +
                    "        <td>Descrição</td>\n" +
                    "        <td>Validade</td>\n" +
                    "        <td>Calorias</td>\n" +
                    "    </tr>");

            for(ComidaChinesa comida : carrinho)
            {
                response.getWriter().append("    <tr>\n" +
                        "        <td>"+comida.getid()+"</td>\n" +
                        "        <td>"+comida.getnome()+"</td>\n" +
                        "        <td>"+comida.getpreco()+"</td>\n" +
                        "        <td>"+comida.getdescricao()+"</td>\n" +
                        "        <td>"+comida.getvalidade()+"</td>\n" +
                        "        <td>"+comida.getcalorias()+"</td>\n" +
                        "    </tr>");

            }

            response.getWriter().append("</table>\n" +
                    "\n" +
                    "<a href='/finalizarCompra'>Finalizar Compra </a>\n" +
                    "</body>\n" +
                    "</html>");
        }else{
            response.sendRedirect("/cliente");
        }


    }

}
