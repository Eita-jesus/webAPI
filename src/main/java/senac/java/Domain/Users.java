package senac.java.Domain;

import org.json.JSONObject;

import java.util.List;

public class Users {

        public  int id = 0;
        public  String uname = "";
        public  String lastName = "";
        public  int age = 0;
        public  String address = "";
        public  String email = "";
        public  String password = "";
        public  String cpf = "";

        //Vamos precisar criar um construtor, contudo dentro da model
        public Users(){

        }
        public Users(String name, String lastName, int age, String address, String email, String password, String cpf){
                this.uname = name;
                this.lastName = lastName;
                this.age = age;
                this.address = address;
                this.email = email;
                this.password = password;
                this.cpf = cpf;

        }

        public String getUname(){
            return uname;
        }
        public void setUname(String uname){this.uname = uname;}
        public String getLastName(){
                return lastName;
        }
        public void setLastName(String lastName){
                this.lastName = lastName;
        }
        public int getAge(){
                return age;
        }
        public void setAge(int age){
             this.age = age;
        }
        public String getAddress(){return address;}
        public void setAddress(String address){
                this.address = address;
        }
        public String getEmail(){return email;}
        public void setEmail(){
                this.email = email;
        }
        public String getPassword(){return password;}
        public void setPassword(){
                this.password = password;
        }
        public String getCPF(){
                return cpf;
        }
        public void setCPF(){
                this.cpf = cpf;
        }


        //Esse método é para a criação de um Json

        public JSONObject toJson(){
                JSONObject json = new JSONObject();
                json.put("name", uname);
                json.put("last_name", lastName);
                json.put("age",age);
                json.put("address",address);
                json.put("email",email);
                json.put("password", password);
                json.put("cpf",cpf);

                return json;

        }

        public static Users getusets (int index, List<Users>usersList){

//                List<Users> users = new ArrayList<>();
//                 users = usersList;

                if (index >= 0 && index < usersList.size()){
                        return usersList.get(index);

                }else {
                        return null;
                }
        }


        //esse metodo vai ser exclusivamente para passagem de dados
        public static List<Users> getAllUsers(List<Users>usersList){


             return usersList;
        }

}
