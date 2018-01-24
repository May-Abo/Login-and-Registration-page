package com.test.daoimplemenatation;

import com.test.beans.Country;
import com.test.beans.UserLog;
import com.test.beans.UserWeb;
import com.test.util.Constants;
import com.test.daointerface.DaoInterface;
import com.test.util.JbdcConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoImplementation implements DaoInterface {

    @Override
    public UserWeb getUser(String id) {

        UserWeb u = null;
        Connection connection = JbdcConnection.openConnection();
        PreparedStatement stm = null;
        String sql = "SELECT User_Name, First_Name, Last_Name , Email, Password, Country, PhoneNumber FROM UserWeb WHERE ID=?";

        try {

            stm = connection.prepareStatement(sql);

            stm.setString(1, id);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {

                String userName = rs.getString(1);

                String firstName = rs.getString(2);

                String lastName = rs.getString(3);

                String email = rs.getString(4);

                String password = rs.getString(5);

                String country = getUserCountryName(rs.getString(6));

                String phoneNumber = rs.getString(7);

                u = new UserWeb(userName, firstName, lastName, email, password, country, phoneNumber);

            }

        } catch (Exception ex) {

            ex.printStackTrace();
            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {

                stm.close();

            } catch (Exception ex) {

                Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);

            }

            JbdcConnection.closeConnection(connection);

        }

        return u;
    }

    @Override
    public UserWeb logInValidation(String userName, String password) {

        UserWeb u = null;
        Connection connection = JbdcConnection.openConnection();
        PreparedStatement stm = null;
        String sql = "SELECT Id, User_Name, First_Name, Last_Name , Email, Password, Status, Country, PhoneNumber FROM UserWeb WHERE User_Name=? and Password=? ";

        try {

            stm = connection.prepareStatement(sql);

            stm.setString(1, userName);
            stm.setString(2, password);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {

                String id = rs.getString(1);

                String userName1 = rs.getString(2);

                String firstName = rs.getString(3);

                String lastName = rs.getString(4);

                String email = rs.getString(5);

                String password1 = rs.getString(6);

                String status = rs.getString(7);

                String country = getUserCountryName(rs.getString(8));

                String phoneNumber = rs.getString(9);

                u = new UserWeb(id, userName1, firstName, lastName, email, password1, status, country, phoneNumber);

            }

        } catch (Exception ex) {

            ex.printStackTrace();
            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {

                stm.close();

            } catch (Exception ex) {

                Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);

            }

            JbdcConnection.closeConnection(connection);

        }
        return u;
    }

    @Override
    public int checkUserEmail(String email) {
        Connection connection = JbdcConnection.openConnection();
        PreparedStatement stm = null;
        int result = 0;
        String sql = "SELECT 1 FROM UserWeb WHERE email =?";

        try {

            stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                result = 1;
            }

        } catch (Exception ex) {
            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
            } catch (Exception ex) {
                Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
            JbdcConnection.openConnection();
        }

        return result;
    }

    @Override
    public int addUser(UserWeb u) {

        Connection connection = JbdcConnection.openConnection();
        PreparedStatement stm = null;
        int result = 0;
        String sql = "INSERT INTO UserWeb (User_Name, First_Name , Last_Name , Email, Password, Country, PhoneNumber) VALUES (?,?,?,?,?,?,?)";

        try {

            stm = connection.prepareStatement(sql);
            stm.setString(1, u.getUserName());
            stm.setString(2, u.getFirstName());
            stm.setString(3, u.getLastName());
            stm.setString(4, u.getEmail());
            stm.setString(5, u.getPassword());
            stm.setString(6, getUserCountryId(u.getCountry()));
            stm.setString(7, u.getPhoneNumber());

            result = stm.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
            } catch (Exception ex) {
                Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
            JbdcConnection.closeConnection(connection);
        }

        return result;
    }

    @Override
    public int updateUser(UserWeb u) {
        Connection connection = JbdcConnection.openConnection();
        PreparedStatement stm = null;
        int result = 0;
        String sql = "UPDATE UserWeb SET User_Name = ? ,  First_Name = ? , Last_Name = ?, Email = ?, Password = ?, Country=?, PhoneNumber=? WHERE Id = ? ";

        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, u.getUserName());
            stm.setString(2, u.getFirstName());
            stm.setString(3, u.getLastName());
            stm.setString(4, u.getEmail());
            stm.setString(5, u.getPassword());
            stm.setString(6, getUserCountryId(u.getCountry()));
            stm.setString(7, u.getPhoneNumber());
            stm.setString(8, u.getId());

            result = stm.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
            } catch (Exception ex) {
                Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
            JbdcConnection.closeConnection(connection);
        }
        return result;
    }

    @Override
    public int deleteUser(String id) {
        Connection connection = JbdcConnection.openConnection();
        int result = 0;
        PreparedStatement stm = null;
        String sql = "UPDATE UserWeb SET Status = ? WHERE ID = ?";

        try {

            stm = connection.prepareStatement(sql);
            stm.setInt(1, Constants.INACTIVEUSER);
            stm.setString(2, id);

            result = stm.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
            } catch (Exception ex) {
                Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
            JbdcConnection.closeConnection(connection);
        }
        return result;
    }

    @Override
    public Vector getAllUserWeb() {
        Vector v = new Vector();
        Connection connection = JbdcConnection.openConnection();
        PreparedStatement stm = null;
        UserWeb u = null;
        String sql = "SELECT Id, User_Name , First_Name, Last_Name, Email, Password, Country, PhoneNumber FROM UserWeb";

        try {
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String userNname = rs.getString(2);
                String firstName = rs.getString(3);
                String lastName = rs.getString(4);
                String email = rs.getString(5);
                String password = rs.getString(6);
                String country = getUserCountryName(rs.getString(7));
                String phoneNumber = rs.getString(8);

                u = new UserWeb(id, userNname, firstName, lastName, email, password, "", country, phoneNumber);
                v.add(u);
            }

        } catch (Exception ex) {
            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
            } catch (Exception ex) {
                Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
            JbdcConnection.closeConnection(connection);
        }

        return v;
    }

    @Override
    public int addUserLogInfo(UserLog u) {
        Connection connection = JbdcConnection.openConnection();
        PreparedStatement stm = null;
        int result = 0;
        String sql = "INSERT INTO UserLog (User_Name, Ip_Address , Operation, Time) VALUES (?,?,?,sysdate())";

        try {

            stm = connection.prepareStatement(sql);
            stm.setString(1, u.getUserName());
            stm.setString(2, u.getIpAddress());
            stm.setString(3, u.getOperation());


            result = stm.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
            } catch (Exception ex) {
                Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
            JbdcConnection.closeConnection(connection);
        }

        return result;
    }

    @Override
    public String getUserCountryId(String country) {

        Connection connection = JbdcConnection.openConnection();
        PreparedStatement stm = null;
        String sql = "SELECT Id FROM country WHERE Country=?";
        String id = null;
        try {

            stm = connection.prepareStatement(sql);

            stm.setString(1, country);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {

                id = rs.getString(1);

            }

        } catch (Exception ex) {

            ex.printStackTrace();
            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {

                stm.close();

            } catch (Exception ex) {

                Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);

            }

            JbdcConnection.closeConnection(connection);

        }

        return id;
    }

    @Override
    public String getUserCountryName(String id) {
        Connection connection = JbdcConnection.openConnection();
        PreparedStatement stm = null;
        String sql = "SELECT Country FROM country WHERE Id=?";
        String country = null;
        try {

            stm = connection.prepareStatement(sql);

            stm.setString(1, id);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {

                country = rs.getString(1);

            }

        } catch (Exception ex) {

            ex.printStackTrace();
            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {

                stm.close();

            } catch (Exception ex) {

                Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);

            }

            JbdcConnection.closeConnection(connection);

        }

        return country;
    }

    @Override
    public ArrayList getAllCountryNames() {

        ArrayList al = new ArrayList();
        Connection connection = JbdcConnection.openConnection();
        PreparedStatement stm = null;
        Country countryName = null;
        String sql = "SELECT Id, Country FROM country";

        try {
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String country = rs.getString(2);

                countryName = new Country(id, country);
                al.add(countryName);
            }

        } catch (Exception ex) {
            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
            } catch (Exception ex) {
                Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
            JbdcConnection.closeConnection(connection);
        }

        return al;
    }
}
