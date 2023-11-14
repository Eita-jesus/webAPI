package senac.java.Services.Servidor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {


    public Connection conectar(){
        Connection conexao = null;
        try{

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://116DE150263/SQLEXPRESS:1433;database=pi;";
//            String usuario = "SENACRJEDU/116128412023.1";
//            String senha = "Senac@12841";
              String usuario = "teste";
              String senha = "123456";



            conexao = DriverManager.getConnection(connectionUrl, usuario,senha);

            if (conexao != null){
//                System.out.println("Conexão realizada com sucesso");
                    return conexao;
            }

        }catch (ClassNotFoundException | SQLException e){
            System.out.println("O erro foi " + e );

        }finally {
            try {
                if (conexao != null && !conexao.isClosed()){
                    conexao.close();
                }
            }catch (SQLException e){
                System.out.println("O erro do SQL foi" + e);
            }
        }
        return conexao;

    }
}
