package senac.java.Domain;

import org.json.JSONObject;

import java.util.List;

public class ProductsCards {
    public static int id;


    public static String pName = "";
    public static String pPrice = "";
    public static String imagemcelular = "";

    public ProductsCards(){}


    public ProductsCards(String pName, String pPrice, String imagemcelular){
        this.imagemcelular = imagemcelular;
        this.pName = pName;
        this.pPrice = pPrice;
    }

    public static String getImagemcelular() {return imagemcelular;}
    public static String getpName() {return pName;}
    public static String getpPrice() {return pPrice;}

    public static void setImagemcelular(String imagemcelular) {ProductsCards.imagemcelular = imagemcelular;}
    public static void setpName(String pName) {ProductsCards.pName = pName;}
    public static void setpPrice(String pPrice) {ProductsCards.pPrice = pPrice;}




    public JSONObject toJson(){
        JSONObject json = new JSONObject();

        json.put("imagemcelular",imagemcelular);
        json.put("pName",pName);
        json.put("pPrice",pPrice);

       return json;
    }

    public JSONObject arrayToJson(List<ProductsCards>productsCardsList) {

        JSONObject json = new JSONObject();

        if (!productsCardsList.isEmpty()) {
            var keyJson = 0;

            for (ProductsCards productsCards : productsCardsList) {
                JSONObject jsonFor = new JSONObject();

                jsonFor.put("imagemcelular", imagemcelular);
                json.put("pName", pName);
                json.put("pPrice", pPrice);

                keyJson++;
                json.put(String.valueOf(keyJson), jsonFor);
                System.out.println("================================================================");

            }
            return json;

        } else {
            return null;
        }
    }

    public static ProductsCards getProducts(int index, List <ProductsCards> productsCardsList){

        if (index >= 0 && index < productsCardsList.size()){

            return productsCardsList.get(index);

        }else {
            return null;
        }
    }

    public static List<ProductsCards>  getAllProductsCard (List<ProductsCards>productsCardsList){
        return productsCardsList;

    }




}
