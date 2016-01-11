package com.radityopw.wrapper;

import java.util.LinkedList;

/**
 *
 * @author radity
 */
public class EmptyJDBCWrapperResultRow extends JDBCWrapperResultRow {
    public EmptyJDBCWrapperResultRow(){
        super(new LinkedList());
        empty = true;
    }
}