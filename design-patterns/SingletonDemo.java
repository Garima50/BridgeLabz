
class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {

        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    void print(){
        System.out.println("hello singleton!");
    }
}

 public class SingletonDemo {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        s.print();


    }
 }