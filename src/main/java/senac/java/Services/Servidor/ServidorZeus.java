package senac.java.Services.Servidor;


import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import senac.java.Controllers.ProductController;
import senac.java.Controllers.ProductsCardsControler;
import senac.java.Controllers.SalesPersonController;
import senac.java.Controllers.UserController;
import com.sun.net.httpserver.HttpServer; //Cria um servidor
import senac.java.Domain.Users;

import java.io.IOException;
import java.net.InetSocketAddress; // Interface de comunicação de texto



public class ServidorZeus {
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";


    public void servidorZeus() throws IOException {
        Users users = new Users();

        HttpServer server = HttpServer.create(new InetSocketAddress(4000),
                0);


        HttpHandler userHandler = new UserController.UserHandler();
        HttpHandler SalesPersonHandler = new SalesPersonController.SalesPensonHandler();
        HttpHandler productHandler = new ProductController.Produts();
        HttpHandler productCardsHandler = new ProductsCardsControler.ProductsCards();



        server.createContext("/api/usuario", exchange -> {
            ConfigureCorsheaders(exchange);
            userHandler.handle(exchange);

        });
        server.createContext("/api/vendedor", exchange -> {
            ConfigureCorsheaders(exchange);
            SalesPersonHandler.handle(exchange);
        });
        server.createContext( "/api/produtos", exchange -> {
            ConfigureCorsheaders(exchange);
            productHandler.handle(exchange);
        });

        server.setExecutor(null);
        System.out.println(ANSI_RED_BACKGROUND + "Servidor Iniciado! "+ ANSI_RESET);
        System.out.println();
        server.start();
    }

    private void ConfigureCorsheaders(HttpExchange exchange){

        Headers headers = exchange.getResponseHeaders();
        String resquestOrigin = exchange.getRequestHeaders().getFirst("Origin");

        if(resquestOrigin != null){
            headers.set("Access-Control-Allow-Origin",resquestOrigin);
        }

        headers.set("Access-Control-Allow-Origin","*");
        headers.set("Access-Control-Allow-Methods","GET,POST,OPTIONS,PUT,DELETE");
        headers.set("Access-Control-Allow-Headers","Content-Type");
        headers.set("Access-Control-Max-Age","3600");

    }
}

