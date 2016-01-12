package com.radityopw.wrapper;

import com.radityopw.wrapper.immutable.EmptyJDBCWrapperResultElement;
import com.radityopw.wrapper.immutable.EmptyJDBCWrapperResultRow;
import com.radityopw.wrapper.immutable.ErrorJDBCWrapperResult;
import com.radityopw.wrapper.immutable.JDBCWrapperResult;
import com.radityopw.wrapper.immutable.JDBCWrapperResultElement;
import com.radityopw.wrapper.immutable.JDBCWrapperResultRow;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author radity
 */
public class OctaveJDBCWrapper {
    
    private final String driver;
    private final String url;
    private final String user;
    private final String pass;
    private Connection con;
    

    public OctaveJDBCWrapper(String driver,String url, String user, String pass) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }
    
    private void connect() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        con = DriverManager.getConnection(url,user, pass);
        con.setAutoCommit(true);
    }
    
    private void close() throws SQLException{
        con.close();
        con = null;
    }
        
    public boolean execute(String sql){
        boolean result = false;
        Statement stmt = null;
        try {
            connect();
            
            stmt = con.createStatement();
            result = stmt.execute(sql);
            stmt.close();
                     
            
            if(con != null && !con.isClosed()) close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OctaveJDBCWrapper.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return result;
    }
    
    public JDBCWrapperResult executeQuery(String sql){
        JDBCWrapperResult result = new ErrorJDBCWrapperResult("Query Not Running");
        Statement stmt = null;
        try {
            connect();
            
            stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            List<JDBCWrapperResultRow> data = new LinkedList();
            
            while(rs.next()){
                List<JDBCWrapperResultElement> row = new LinkedList();
                for(int i=1;i<=cols;i++){
                    row.add(new JDBCWrapperResultElement(rs.getString(i)));
                }
                JDBCWrapperResultRow wrapperRow = new JDBCWrapperResultRow(row);
                data.add(wrapperRow);
            }
            
            rs.close();
            
            stmt.close();
                     
            if(con != null && !con.isClosed()) close();
            
            result = new JDBCWrapperResult(data);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OctaveJDBCWrapper.class.getName()).log(Level.SEVERE, null, ex);
            result = new ErrorJDBCWrapperResult(ex.getMessage());
        } 
        return result;
    }
    
    public JDBCWrapperResultElement oneValQuery(String sql){
        JDBCWrapperResultElement result = new EmptyJDBCWrapperResultElement();
        
        JDBCWrapperResultRow data = oneRowQuery(sql);
        
        if(data != null && !data.isEmpty()){
            result = data.getData(0);
        }
        
        return result;
    }
    
    public JDBCWrapperResultRow oneRowQuery(String sql){
        JDBCWrapperResultRow result = new EmptyJDBCWrapperResultRow();
        
        JDBCWrapperResult executeQuery = executeQuery(sql);
        if(!executeQuery.isError()){
            result = executeQuery.getData(0);
        }
        
        return result;
    }
}