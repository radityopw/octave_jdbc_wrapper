package com.radityopw.wrapper.immutable;

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