package com.radityopw.wrapper.immutable;

/**
 *
 * @author radity
 */
public class EmptyJDBCWrapperResultElement extends JDBCWrapperResultElement{

    public EmptyJDBCWrapperResultElement() {
        super("");
        empty = true;
    }
    
}
