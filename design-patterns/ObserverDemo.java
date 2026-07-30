
import java.util.*;


interface Youtube {
    public void addUsers(User a);
    public void delUsers(User a);
    public void notifyAll(String msg);
}

class User {
    String name;
    String email;

    User(String name, String email) {
        this.email=email;
        this.name=name;
    }

    void notification(String a) {
        System.out.println(a);
    }

}

class TSeries implements Youtube {

    List<User> users = new ArrayList<>();

    @Override
    public void addUsers(User a) {
        users.add(a);

    }

    @Override
    public void delUsers(User a) {
        users.remove(a);
    }

    @Override
    public void notifyAll(String msg) {

        for(User a : users) {
            a.notification(msg);
        }
        
    }



}

class ObserverDemo {
    public static void main(String[] args) {

        User a = new User("Mira", "mira@gmail");
        User b = new User("Sia", "sia@gmail");
        User c = new User("Shreya", "shreya@gmail");

        Youtube x = new TSeries();
        x.addUsers(a);
        x.addUsers(b);

        x.notifyAll("hey, new video uploaded!");

        x.delUsers(a);
        x.notifyAll("hey, user a is removed!");
}
}