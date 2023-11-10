package senac.java.Services.Servidor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLServer {
    public void conectar(){
        Connection conexao = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDrives");

            String url = "jdbc:sqlserver://localhost:1433; databaseName=SEU_NOME_BANCO";
            String usuario = "SENACRJEDU\116128412023.1";
            String senha = "senac@12841";


            conexao = DriverManager.getConnection(url, usuario, senha);

            if (conexao!= null){
                System.out.println("Conexão realizada com sucesso");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("O erro foi " + e);
            throw new RuntimeException(e);

        }finally {
            try{
                if (conexao != null && !conexao.isClosed()){
                    conexao.close();
                }
            }catch (SQLException e){
                System.out.println("O erro no Finally foi" + e );
            }
        }



    }

}
