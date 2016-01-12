package com.radityopw.wrapper.immutable;

/**
 *
 * @author radity
 */
public class JDBCWrapperResultElement {
    
    private final String value;
    protected boolean empty;

    public JDBCWrapperResultElement(String value) {
        this.value = value;
        this.empty = false;
    }
    
    public String value(){
        return value;
    }
    
    public boolean isEmpty(){
        return empty;
    }
    
}
