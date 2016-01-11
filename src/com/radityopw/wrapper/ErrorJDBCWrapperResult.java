package com.radityopw.wrapper;

import java.util.LinkedList;

/**
 *
 * @author radity
 */
public class ErrorJDBCWrapperResult extends JDBCWrapperResult {
    public ErrorJDBCWrapperResult(String errorMessage){
        super(new LinkedList(),true,errorMessage);
    }
}
