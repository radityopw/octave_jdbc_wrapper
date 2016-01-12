package com.radityopw.wrapper.immutable;

import java.util.LinkedList;

/**
 *
 * @author radity
 */
public class EmptyJDBCWrapperResult extends JDBCWrapperResult {
    public EmptyJDBCWrapperResult(){
        super(new LinkedList(),false,"");
        empty = true;
    }
}