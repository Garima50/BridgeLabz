public class Inheritance {
    
    public static void main(String[] args) {
        // Student s1 = new Student();
        // no need to create parent class object
        child c1 = new child();
        c1.students();
        c1.dsa();
        c1.java();
    }
}

class Student {
    void students(){
        System.out.println("70 students");
    }
    void dsa(){
        System.out.println("dsa");
    }
}

class child extends Student {
    void java(){
        System.out.println("java");
    }
}
