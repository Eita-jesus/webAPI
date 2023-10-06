package senac.java.Services.Servidor;

import com.sun.net.httpserver.*;
import senac.java.Domain.Users;

import com.sun.net.httpserver.HttpServer; //Cria um servidor
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress; // Interface de comunicação de texto



public class ServidorZeus {
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";


    public void servidorZeus() throws IOException {


        HttpServer server = HttpServer.create(new InetSocketAddress(3000),
                0);

        server.createContext("/API/teste",new UserHandrer());

        server.setExecutor(null);
        System.out.println(ANSI_RED_BACKGROUND + "Servidor Iniciado! "+ ANSI_RESET);
        System.out.println();
        server.start();

    }

//    public static void called(HttpExchange exchange)throws IOException{
//
//        if ("GET".equals(exchange.getRequestMethod())) {
//
//            String response = "Olá eu sou um teste" ;
//            exchange.sendResponseHeaders(200, response.getBytes().length);
//
//            OutputStream os = exchange.getResponseBody();
//            os.write(response.getBytes());
//            os.close();
//
//        } else {
//
//            String response = "Metodo implementado";
//            exchange.sendResponseHeaders(400, response.getBytes().length);
//
//            OutputStream os = exchange.getResponseBody();
//            os.write(response.getBytes());
//            os.close();
//        }
//    }


    public static void enviarResponse(HttpExchange exchange, String response)
            throws IOException {

        if ("GET".equals(exchange.getRequestMethod())) {

            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());

            os.close();

        }
    }

    class UserHandrer implements HttpHandler{

        //Static e void não podem ser usados em implementes
        @Override
        public void handle(HttpExchange exchange) throws IOException{
            String responde = "Essa e a rota de usuário";
                    enviarResponse(exchange, responde);
        }

    }

}

