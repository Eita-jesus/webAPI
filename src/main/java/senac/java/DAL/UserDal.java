package senac.java.DAL;
import senac.java.Services.Servidor.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UserDal {

    public void inserUsuario(String unome,int age, String address,String email,String password, String cpf ) throws SQLException{

        String sql = "INSERT INTO dbo.Users (unome, age, address, email, password, cpf)VALUEs(?,?,?,?,?,?)" ;

        Conexao conexao = new Conexao();

        try(PreparedStatement statement = conexao.conectar().prepareStatement(sql)){
            statement.setString(1,unome);
            statement.setInt(1,age);
            statement.setString(1,address);
            statement.setString(1,email);
            statement.setString(1,password);
            statement.setString(1,cpf);

            int linhasAfetadas = statement.executeUpdate();

            System.out.println("Foram modificadas" + linhasAfetadas + "no banco de dados");

        }catch (SQLException e){
            System.out.println("O erro na inserçãoi de dados foi" + e);
        }
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
