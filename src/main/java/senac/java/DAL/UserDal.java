package senac.java.DAL;
import senac.java.Services.Servidor.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UserDal {

    //Essa classe vai fazer a conexão com o banco de dados
    public Connection conectar(){
        Connection conexao = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String connectionUrl = "jdbc:sqlserver://116DE150263/SQLEXPRESS:1433;database=pi;";
            String usuario = "SENACRJEDU/116128412023.1";
            String senha = "Senac@12841";

            conexao = DriverManager.getConnection(connectionUrl,usuario,senha);

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

// abaixo temos o CRUD
    public int inserUsuario(String unome,int age, String address,String email,String password, String cpf ) throws SQLException{

        String sql = "INSERT INTO dbo.Users (unome, age, address, email, password, cpf)VALUEs(?,?,?,?,?,?)" ;// Essa colunas devem seguir a mesma ordem da tabela isso para organizar mas esse order deve ser a mesma do try
        int linhasAfetadas = 0;
        Connection conexao = conectar();

        try(PreparedStatement statement = conexao.prepareStatement(sql)){
            statement.setString(1,unome);
            statement.setInt(1,age);
            statement.setString(1,address);
            statement.setString(1,email);
            statement.setString(1,password);
            statement.setString(1,cpf);

            linhasAfetadas = statement.executeUpdate();

            System.out.println("Foram modificadas" + linhasAfetadas + "no banco de dados");

            conexao.close();
            return linhasAfetadas;

        }catch (SQLException e){
            System.out.println("O erro na inserçãoi de dados foi" + e);
            conexao.close();
        }
        conexao.close();
        return linhasAfetadas;
    }
    public void listarusuario(Connection conexao)throws SQLException{

        String sql = "SELECT * FROM dbo.Users ";

        try(PreparedStatement statement = conexao.prepareStatement(sql)){

            ResultSet result = statement.executeQuery();

            System.out.println("Listagem dos usuários");

            while (result.next()){
                int id = result.getInt("id");
                String unome = result.getNString("unome");
                String age = result.getNString("age");
                String address = result.getNString("address");
                String email = result.getNString("email");
                String password = result.getNString("password");
                String cpf = result.getNString("cpf");


                System.out.println("id:" +id);
                System.out.println("id:" +unome);
                System.out.println("id:" +age);
                System.out.println("id:" +address);
                System.out.println("id:" +password);
                System.out.println("id:" +cpf);

            }
        }catch (SQLException e){
            System.out.println("Erro na listagem de dados foi" + e);
        }

    }


    public void atualizarUsario(Connection conexao, String unome,String age, String address,String email,String password, String cpf, int id)throws SQLException{
        String sql = "UPDATE dbo.Users SET unome = ? , age = ?, address = ?, email = ?, password = ?, cpf = ?, where id = ?";

        try (PreparedStatement statement = conexao.prepareStatement(sql)){
            statement.setString(1,unome);
            statement.setString(2,age);
            statement.setString(3,address);
            statement.setString(4,email);
            statement.setString(5,password);
            statement.setString(6,cpf);

            statement.setInt(7,id);

            int linhasAfetadas = statement.executeUpdate();
            System.out.println("Foram modificadas" + linhasAfetadas + "no banco de dados");

        }catch (SQLException e){
            System.out.println("O erro na atualização de dados foi " + e);
        }
    }


    public void excluirUsuario(Connection conexao, int id) throws SQLException{
        String sql = "DELETE FROM Users WHERE id = ?";
        try(PreparedStatement statement = conexao.prepareStatement(sql)){
            statement.setInt(1,id);

            int linhasAfetadas = statement.executeUpdate();
            System.out.println("Foram modificado" + linhasAfetadas + "no banco de dados");

        }catch (SQLException e ) {

            System.out.println("O erro na exclusão de dados foi" + e);

            }
    }

}
