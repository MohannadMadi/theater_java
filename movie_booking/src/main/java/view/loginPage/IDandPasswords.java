package view.loginPage;

import java.util.HashMap;
public class IDandPasswords {

    HashMap<String,String> logininfo = new HashMap<String,String>();

    IDandPasswords(){

        logininfo.put("3wes","3wes");
        logininfo.put("mohannad","123");
        logininfo.put("hodaelborm","abc123");
    }

    public HashMap getLoginInfo(){
        return logininfo;
    }
}