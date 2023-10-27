package senac.java.Domain;

import org.json.JSONObject;

import java.util.List;

public class Stores {

    public static int id = 0;
    public static String address = "";
    public static String city = "";
    public static String state = "";
    public static String country = "";
    public static String cnpj = "";
    public static String phoneNumber = "";
    public static String email = "";

    public Stores(){};

    public Stores(String address, String city, String state, String country, String CNPJ, String phoneNumber, String email){
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.cnpj = cnpj;
        this.phoneNumber = phoneNumber;
        this.email = email;


    }

    public  String getAddress() {return address;}
    public  String getCity() {return city;}
    public  String getState() {return state;}
    public  String getCountry() {return country;}
    public  String getCNPJ() {return cnpj;}
    public  String getPhoneNumber() {return phoneNumber;}
    public  String getEmail() {return email;}

    public  void setAddress(String address) {Stores.address = address;}
    public  void setCity(String city) {Stores.city = city;}
    public  void setState(String state) {Stores.state = state;}
    public  void setCountry(String country) {Stores.country = country;}
    public  void setCNPJ(String CNPJ) {Stores.cnpj = cnpj;}
    public  void setPhoneNumber(String phoneNumber) {Stores.phoneNumber = phoneNumber;}
    public  void setEmail(String email) {Stores.email = email;}


    public JSONObject toJson(){
            JSONObject json = new JSONObject();

            json.put("address",address);
            json.put("city",city);
            json.put("state",state);
            json.put("country",country);
            json.put("cnpj",cnpj);
            json.put("phoneNumber",phoneNumber);
            json.put("email",email);

            return json;
    }

    public  JSONObject ArrayToJson(List<Stores>storesList){
        JSONObject json = new JSONObject();
        if (!storesList.isEmpty()){
            var keyJson =0;
            for(Stores stores : storesList){
                JSONObject jsonFor = new JSONObject();

                jsonFor.put("address", stores.getAddress());
                jsonFor.put("city",stores.getCity());
                jsonFor.put("state",stores.getState());
                jsonFor.put("country",stores.getCountry());
                jsonFor.put("cnpj",stores.getCNPJ());
                jsonFor.put("phoneNumber",stores.getPhoneNumber());
                jsonFor.put("email",stores.getEmail());

                keyJson ++;

                json.put(String.valueOf(keyJson),jsonFor);
                System.out.println("================================================================");

            }
            return json;
        }else{
            return null;
        }
    }

    public static Stores getStores (int index,List<Stores>storesList){
        if (index >= 0 && index < storesList.size()){
            return  storesList.get(index);
        }else{
            return null;
        }
    }

    public static List<Stores> getAllStores(List<Stores>storesList){
        return storesList;
    }

}
