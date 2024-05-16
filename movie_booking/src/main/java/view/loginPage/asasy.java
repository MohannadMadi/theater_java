package view.loginPage;

import com.google.firebase.auth.FirebaseAuth;

public class asasy {

    public static void main(String[] args) {
        IDandPasswords idandPasswords = new IDandPasswords();

        LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());

    }
}