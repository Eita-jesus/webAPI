package senac.java.Domain;

import org.json.JSONObject;

public class Users {

        public static int id = 0;
        public static String name = "";
        public static String lastName = "";
        public static int age = 0;
        public static String address = "";
        public static String email = "";
        public static String password = "";
        public static String cpf = "";

        //Vamos precisar criar um construtor, contudo dentro da model
        public Users(){

        }
        public Users(String name, String lastName, int age, String address, String email, String password, String cpf){
                this.name = name;
                this.lastName = lastName;
                this.age = age;
                this.address = address;
                this.email = email;
                this.password = password;
                this.cpf = cpf;

        }

        public String getName(){
            return name;
        }
        public void setName(String name){this.name = name;}
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
        public String getEmail(){
                return email;
        }
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
                json.put("name",name);
                json.put("last_name", lastName);
                json.put("age",age);
                json.put("address",address);
                json.put("email",email);
                json.put("password", password);
                json.put("cpf",cpf);

                return json;

        }


}
