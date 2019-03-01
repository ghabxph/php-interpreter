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
    private PhpDataType nextType;

    /**
     * Data type of instance
     *   - Use typeof to determine exact data type
     */
    protected PhpDataType type;

    /**
     * Value of certain data type
     */
    private String value;

    /**
     * @return  If value matches this type, this will return true
     */
    protected abstract boolean valueMatchesThisType();

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
     * Generates new instance of PhpDataType
     *   - Returns first chain (PhpArray)
     *
     * @return  Returns instance of first chain (PhpArray)
     */
    public static PhpDataType newInstance() {
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

    /**
     * Sets next chained data type
     *
     * @param   nextType  Next type to put in chain
     * @return  Returns next chain
     */
    PhpDataType nextType(PhpDataType nextType) {
        this.nextType = nextType;
        return this.nextType;
    }

    /**
     * Sets value
     *
     * @param   value  Value to set
     * @return  Returns appropriate data type instance
     */
    public PhpDataType value(String value) {
        this.value = value;
        this.type = firstChain.determineType();
        return type();
    }

    /**
     * @return  Returns value of data type
     */
    public String value() {
        return value;
    }

    /**
     * @return Returns data type
     */
    public PhpDataType type() {
        return type;
    }

    /**
     * Returns this instance, if this instance's value matches the condition
     * specified by this instance.
     *
     * Proceeds to next instance if it the condition is not met.
     *
     * @return  Returns the appropriate data type
     */
    private PhpDataType determineType() {

        // Initially set value first.
        value = firstChain.value();

        if (valueMatchesThisType()) {
            return this;
        }
        return (nextType == null) ? null : nextType.determineType();
    }
}
