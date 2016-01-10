/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.radityopw.wrapper;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author radity
 */
public class JDBCWrapperResultRow {
    
    private final List<String> data;

    public JDBCWrapperResultRow(List<String> data) {
        this.data = data;
    }
    
    public int totalData(){
        return data.size();
    }
    
        
    public String getData(int index){
        return data.get(index);
    }
}
