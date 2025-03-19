public class Items {
    int price = 0;
    int amount = 0;
    public Items(int price , int amount){
        this.price = price;
        this.amount = amount;
    }
    public int getPrice(){
        return price;
    }
    public int getAmount(){
        return amount;
    }
    public void setPrice(int amt){
        price = amt;
    }
    public void setAmount(int amt2){
        amount = amt2;
    }
    public void getItemName(){
        System.out.println("Item");
    }
}
