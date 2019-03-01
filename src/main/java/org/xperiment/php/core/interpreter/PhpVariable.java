package org.xperiment.php.core.interpreter;

import org.xperiment.php.core.interpreter.type.PhpDataType;

/**
 * (Class) PhpVariable
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class PhpVariable {

    /**
     * Name of variable
     */
    private final String name;

    /**
     * Data Type (plus value)
     */
    private PhpDataType type;

    /**
     * Constructor
     *
     * @param name   Sets the name of variable
     */
    public PhpVariable(String name) {
        this.name = name;
    }

    /**
     * Constructor
     *
     * @param name   Sets the name of variable
     * @param value  Sets the value of variable
     */
    public PhpVariable(String name, String value) {
        this(name);
        this.setValue(value);
    }

    /**
     * Sets variable value
     *
     * @param   value Value of variable to put
     */
    public void setValue(String value) {
        type = PhpDataType.newInstance().value(value);
    }

    /**
     * @return  Returns appropriate data type instance
     */
    public PhpDataType getType() {
        return type;
    }

    /**
     * @return  Returns variable name
     */
    public String name() {
        return name;
    }
}
