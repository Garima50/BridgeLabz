

class BankUser {

    String name;
    String bankName;
    Long accNumber;
    String pancard;
    String spouse;
    String dl;
    int passport;
    Long aadhar;

    public BankUser(String name, String bankName, Long accNumber, String pancard, String spouse, String dl, int passport, Long aadhar) {
        this.name = name;
        this.bankName = bankName;
        this.accNumber = accNumber;
        this.pancard = pancard;
        this.spouse = spouse;
        this.dl = dl;
        this.passport = passport;
        this.aadhar = aadhar;
    }

    public String toString(){
        return name + " " + bankName + " " + accNumber +
         " " + pancard + " " + spouse +" " + dl + " " + passport + " " + aadhar;
    }

    static class UserBuilder {
        String name;
        String bankName;
        Long accNumber;
        String pancard;
        String spouse;
        String dl;
        int passport;
        Long aadhar;

        public UserBuilder setName(String name){
            this.name = name;
            return this;
        }

        public UserBuilder setBankName(String bankName){
            this.bankName = bankName;
            return this;
        }

        public UserBuilder setAccNumber(Long accNumber){
            this.accNumber = accNumber;
            return this;
        }
        public UserBuilder setPancard(String p){
            this.pancard = pancard;
            return this;
        }

        public UserBuilder setSpouse(String spouse){
            this.spouse = spouse;
            return this;
        }
        public UserBuilder setDl(String dl){
            this.dl = dl;
            return this;
        }
        public UserBuilder setPassport(int passport){
            this.passport = passport;
            return this;
        }
        public UserBuilder setAadhar(Long aadhar){
            this.aadhar = aadhar;
            return this;
        }

        public BankUser build(){
            return new BankUser(name, bankName, accNumber, pancard, spouse, dl, passport, aadhar);
        }


    }
}



public class BuilderDemo {
    public static void main(String[] args) {
        BankUser u = new BankUser("jiya", null, 78858l,
                null, null, null, 745, 89l);

        BankUser b = new BankUser.UserBuilder().setName("Garima").setBankName("sbi").setDl("abc").build();
        System.out.println(b);



    }
}
