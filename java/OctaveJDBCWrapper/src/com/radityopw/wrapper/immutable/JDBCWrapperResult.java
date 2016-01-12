package com.radityopw.wrapper.immutable;

import java.util.List;

/**
 *
 * @author radity
 */
public class JDBCWrapperResult {

    private final List<JDBCWrapperResultRow> data;
    private final boolean error;
    private final String errorMessage;
    protected boolean empty;

    public JDBCWrapperResult(List<JDBCWrapperResultRow> data){
        this.data = data;
        this.error = false;
        this.errorMessage = "";
        this.empty = false;
    }
    
    public JDBCWrapperResult(List<JDBCWrapperResultRow> data, boolean isError, String errorMessage) {
        this.data = data;
        this.error = isError;
        this.errorMessage = errorMessage;
        this.empty = false;
        if(this.error){
            this.empty = true;
        }
    }

    public int totalData() {
        return data.size();
    }

    public boolean isError() {
        return error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public JDBCWrapperResultRow getData(int index) {
        return data.get(index);
    }
    
    public boolean isEmpty(){
        return empty;
    }

}