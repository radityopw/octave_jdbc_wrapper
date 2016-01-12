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

    public JDBCWrapperResult(List<JDBCWrapperResultRow> data, boolean isError, String errorMessage) {
        this.data = data;
        this.error = isError;
        this.errorMessage = errorMessage;

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