package org.xperiment.php.core.interpreter;

import org.xperiment.php.core.interpreter.type.PhpDataType;

/**
 * (Class) Variable
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class Variable {

    /**
     * Name of variable
     */
    public final String name;

    /**
     * Data Type (plus value)
     */
    private PhpDataType data;

    /**
     * Constructor
     *
     * @param name   Sets the name of variable
     */
    public Variable(String name) {
        this.name = name;
    }

    /**
     * Constructor
     *
     * @param name   Sets the name of variable
     * @param value  Sets the value of variable
     */
    public Variable(String name, String value) {
        this.name = name;
        setVariableValue(value);
    }

    public PhpDataType setValue(String value) {

    }
}
