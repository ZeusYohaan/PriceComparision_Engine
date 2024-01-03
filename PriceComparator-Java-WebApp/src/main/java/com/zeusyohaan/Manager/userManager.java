package com.zeusyohaan.Manager;
import com.zeusyohaan.Data.SqlData;
import com.zeusyohaan.Data.loginData;
import com.zeusyohaan.DependencyInjector.Injector;
import java.util.*;
public class userManager {
    public boolean checkLoginDetails(loginData userDetails){
        List<loginData> loginData = Injector.buildVegDataSQL().getLoginDataDB();

        for(loginData items : loginData){
            if(items.getPassword().equals(userDetails.getPassword()) || items.getUserName().equals(userDetails.getUserName())){
                return true;
            }
        }
        return false;
    }

    public void changeLoginCredentials(){}

    public static void main(String[] args) {
        loginData loginData = new loginData();
        loginData.setUserName("admin");
        loginData.setPassword("admin");
        userManager userManager = new userManager();
        userManager.checkLoginDetails(loginData);
    }

}
