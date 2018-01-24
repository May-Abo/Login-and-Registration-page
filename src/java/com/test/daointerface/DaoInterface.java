
package com.test.daointerface;

import com.test.beans.UserLog;
import com.test.beans.UserWeb;
import java.util.ArrayList;
import java.util.Vector;

public interface DaoInterface {
    
    public UserWeb getUser(String id);
    public UserWeb logInValidation(String userName, String password);
    public int checkUserEmail(String email);
    public int addUser(UserWeb u);
    public int updateUser(UserWeb u);
    public int deleteUser(String id);
    public Vector getAllUserWeb();
    public int addUserLogInfo(UserLog u);
    public String getUserCountryId(String country);
    public String getUserCountryName(String id);
    public ArrayList getAllCountryNames ();
}
