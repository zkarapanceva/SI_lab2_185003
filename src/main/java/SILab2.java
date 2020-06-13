import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public boolean function (User user, List<String> allUsers) {
        if (user!=null) {   //1
            if (user.getUsername()!=null && user.getEmail()!=null && !allUsers.contains(user.getUsername())) {  //3     //condition 1
                boolean atChar = false, dotChar = false;    //4
                for (int i=0;i<user.getEmail().length();i++) {  //5.1 5.2 5.3
                    if (user.getEmail().charAt(i)=='@') //6     //condition 2
                        atChar = true;  //7
                    if (atChar && user.getEmail().charAt(i)=='.') { //8     //condition 3
                        dotChar = true; //9
                    }
                }
                if (atChar && dotChar) {    //10    //condition 4
                    return true;    //11
                }
            }
        }
        return false;   //2
    }//12
}