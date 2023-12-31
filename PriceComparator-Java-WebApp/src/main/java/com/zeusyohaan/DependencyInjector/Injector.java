package com.zeusyohaan.DependencyInjector;
import com.zeusyohaan.Data.SqlData;
import com.zeusyohaan.Manager.userManager;

public class Injector {
    public static SqlData buildVegDataSQL(){return new SqlData();}
    public static userManager buildUserManager(){return new userManager();}
}
