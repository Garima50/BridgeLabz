
class AmulFactory {

    public static Milk getProduct(String s){

        if(s.equalsIgnoreCase("cheese")){
            return new Cheese();
        }

        return null;
        
    }

}
interface Milk {
    void taste();
    
}

class Cheese implements Milk {
    public void taste(){
        System.out.println("cheesy taste!");
    }
}

class Buttermilk implements Milk {
    public void taste(){
        System.out.println("ButterMilky taste!");
    }
}

class Ghee implements Milk {
    public void taste(){
        System.out.println("healthy ghee!");
    }
}

class IceCream implements Milk {
    public void taste(){
        System.out.println("Icy ice cream!");
    }
}


public class FactoryDemo{
    public static void main(String[] args) {
        Milk x = AmulFactory.getProduct("cheese");
        x.taste();
        
    }
}