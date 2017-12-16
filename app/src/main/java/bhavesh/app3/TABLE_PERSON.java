package bhavesh.app3;

public class TABLE_PERSON {

    private String name;
    private String num;
    private String email;
    private String pswd;

    public TABLE_PERSON(){
    }

    public TABLE_PERSON(String name, String num, String email, String pswd) {
        this.name = name;
        this.num = num;
        this.email = email;
        this.pswd = pswd;
    }

    public void setName(String name) { this.name = name; }

    public void setNum(String num) {
        this.num = num;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public String getEmail() {
        return email;
    }

    public String getPswd() {
        return pswd;
    }

}