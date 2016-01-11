/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.radityopw.wrapper;

import java.util.List;

/**
 *
 * @author radity
 */
public class JDBCWrapperResult {
    
    private final List<JDBCWrapperResultRow> data;
    private final boolean isError;
    private final String errorMessage;


    public JDBCWrapperResult(List<JDBCWrapperResultRow> data, boolean isError, String errorMessage) {
        this.data = data;
        this.isError = isError;
        this.errorMessage = errorMessage;
        
    }

    public int totalData(){
        return data.size();
    }
    
    public boolean isError(){
        return isError;
    }
    
    public String getErrorMessage(){
        return errorMessage;
    }
    
    public JDBCWrapperResultRow getData(int index){
        return data.get(index);
    }
    
    
    
}
