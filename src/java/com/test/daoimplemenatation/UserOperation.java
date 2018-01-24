package com.test.daoimplemenatation;


import com.test.util.JbdcConnection;
import com.test.util.Constants;
import com.test.beans.UserWeb;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserOperation {

//    public ArrayList getUserWebPR(String type, String id) {
//        ArrayList a = new ArrayList();
//        Connection connection = TestConstants.openConnection();
//        CallableStatement cs = null;
//        UserWeb u = null;
//        String sql = "CALL getUserWebPR (?,?)";
//
//        try {
//            cs = connection.prepareCall(sql);
//            cs.setInt(1, Integer.parseInt(type));
//            cs.setInt(2, Integer.parseInt(id));
//            ResultSet re = cs.executeQuery();
//
//            while (re.next()) {
//
//                String id1 = re.getString(1);
//
//                String firstname = re.getString(2);
//
//                String lastname = re.getString(3);
//
//                String email = re.getString(4);
//
//                String address = re.getString(5);
//
//                u = new UserWeb(id1, firstname, lastname, email, address);
//
//                a.add(u);
//            }
//
//        } catch (Exception ex) {
//            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                cs.close();
//            } catch (Exception ex) {
//                Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            TestConstants.openConnection();
//        }
//
//        return a;
//
//    }
//    
//    public int addDeleteUpdateUserPR(String type, UserWeb u) {
//        Connection connection = TestConstants.openConnection();
//        CallableStatement cs = null;
//        int result = 0;
//        String sql = "CALL Add_Delete_UPdate_Procedure (?,?,?,?,?,?,?)";
////CREATE DEFINER=`root`@`localhost` PROCEDURE `Add_Delete_UPdate_Procedure`(in p_Type int, in p_Id int, in p_FirstName varchar(500), in p_LasttName varchar(500), in p_Email varchar(500), in p_Address varchar(500))
//
//        try {
//            cs = connection.prepareCall(sql);
//            cs.setInt(1, Integer.parseInt(type));
//            cs.setInt(2, Integer.parseInt(u.getId()));
//            cs.setString(3, u.getFname());
//            cs.setString(4, u.getLname());
//            cs.setString(5, u.getEmail());
//            cs.setString(6, u.getAddress());
//            cs.registerOutParameter(7, java.sql.Types.VARCHAR);
//            result = cs.executeUpdate();
//
//            System.out.println("   My Operation From SP is    - - - - - " + cs.getString(7));
//            System.out.println(" END SP   ");
//
//        } catch (Exception ex) {
//            Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                cs.close();
//            } catch (Exception ex) {
//                Logger.getLogger(UserOperation.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            TestConstants.openConnection();
//        }
//        return result;
//    }



}
