package senac.java;

import com.sun.net.httpserver.HttpServer; //Cria um servidor
import com.sun.net.httpserver.HttpHandler; //
import com.sun.net.httpserver.HttpExchange; //
import java.io.IOException; //
import senac.java.Services.Servidor.ServidorZeus;
import senac.java.Views.Presentation;

import org.json.JSONObject;


public class Main {
public static ServidorZeus TesteServerZeus = new ServidorZeus();

    public static void main(String[] args) throws IOException{

//        ServidorZeus.servidorZeus();
        TesteServerZeus.servidorZeus();

        Presentation.showOptions();

   }
}