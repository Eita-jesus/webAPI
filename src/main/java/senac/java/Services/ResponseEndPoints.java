package senac.java.Services;

import com.sun.net.httpserver.HttpExchange;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;

public class ResponseEndPoints {

    public static void enviarResponse(HttpExchange exchange, String response, Integer statusCode)
            throws IOException {



            exchange.sendResponseHeaders(statusCode, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();


    }

    public static void enviarResponseJson(HttpExchange exchange, JSONObject response, Integer statusCode) throws IOException{

        exchange.getResponseHeaders().set("Content-Type", "application/json");

        byte[] responseByte = response.toString().getBytes("UTF-8");

        exchange.sendResponseHeaders(statusCode, responseByte.length);


        OutputStream os = exchange.getResponseBody();
        os.write(responseByte);
        os.close();


    }




}
