package senac.java.Services;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class ResponseEndPoints {

    public static void enviarResponse(HttpExchange exchange, String response)
            throws IOException {

        if ("GET".equals(exchange.getRequestMethod())) {

            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());

            os.close();
        }else if ("POST".equals(exchange.getRequestMethod())){
            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());

        }else if("PUT".equals(exchange.getRequestMethod())){
            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());

        }else if("DELETE".equals(exchange.getRequestMethod())){

            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());

        }else {

            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());

        }

    }





}
