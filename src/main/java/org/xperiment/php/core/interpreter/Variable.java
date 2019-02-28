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
        this.setValue(value);
    }

    /**
     * Sets variable value
     *
     * @param   value Value of variable to put
     * @return  Returns the desired data type
     */
    public PhpDataType setValue(String value) {
        data = PhpDataType.generateNewInstance().setValueAndDetermineType(value);
        return data;q
    }
}
