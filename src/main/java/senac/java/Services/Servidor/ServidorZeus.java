package senac.java.Services.Servidor;


import senac.java.Controllers.ProductController;
import senac.java.Controllers.SalesPersonController;
import senac.java.Controllers.UserController;
import com.sun.net.httpserver.HttpServer; //Cria um servidor
import java.io.IOException;
import java.net.InetSocketAddress; // Interface de comunicação de texto



public class ServidorZeus {
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";


    public static void servidorZeus() throws IOException {


        HttpServer server = HttpServer.create(new InetSocketAddress(3000),
                0);

        server.createContext("/api/usuario",new UserController.UserHandler());
        server.createContext("/api/vendedor", new SalesPersonController.SalesPensonHandler());
        server.createContext( "/api/produtos", new ProductController.Produts());

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





}

