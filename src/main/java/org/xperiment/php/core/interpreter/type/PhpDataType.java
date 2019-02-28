package org.xperiment.php.core.interpreter.type;

/**
 * (Class) PhpDataType
 *
 * @author ghabxph [me@ghabxph.info]
 */
public abstract class PhpDataType {

    /**
     * First chain (Chain of Responsibility Pattern)
     */
    private final PhpDataType firstChain;

    /**
     * Next chained data type
     */
    protected PhpDataType nextType;

    /**
     * Value of certain data type
     */
    protected String value;

    /**
     * Constructor
     *   - firstChain value is this instance
     */
    public PhpDataType() {
        this.firstChain = this;
    }

    /**
     * Constructor
     *   - Sets the first chain
     *
     * @param firstChain  First chain
     */
    public PhpDataType(PhpDataType firstChain) {
        this.firstChain = firstChain;
    }

    /**
     * Sets next chained data type
     *
     * @param   nextType  Next type to put in chain
     * @return  Returns next chain
     */
    public PhpDataType nextType(PhpDataType nextType) {
        this.nextType = nextType;
        return this.nextType;
    }

    /**
     * Determines data type
     *   - Should run nextType() if data type is not appropriate
     *
     * @param   value  Value of variable
     * @return  Returns the appropriate data type
     */
    public abstract PhpDataType setValueAndDetermineType(String value);

    /**
     * Generates new instance of PhpDataType
     *   - Returns first chain (PhpArray)
     *
     * @return  Returns instance of first chain (PhpArray)
     */
    public static PhpDataType generateNewInstance() {
        PhpDataType type = new PhpArray();
        type.nextType(new PhpBoolean(type))
                .nextType(new PhpFloat(type))
                .nextType(new PhpInteger(type))
                .nextType(new PhpNull(type))
                .nextType(new PhpObject(type))
                .nextType(new PhpResource(type))
                .nextType(new PhpString(type));
        return type;
    }
}
