package com.radityopw.wrapper.immutable;

import java.util.List;

/**
 *
 * @author radity
 */
public class JDBCWrapperResultRow {
    
    private final List<String> data;
    
    protected boolean empty;

    public JDBCWrapperResultRow(List<String> data) {
        this.data = data;
        this.empty = false;
    }
    
    public int totalData(){
        return data.size();
    }
    
        
    public String getData(int index){
        return data.get(index);
    }
    
    public boolean isEmpty(){
        return empty;
    }
}