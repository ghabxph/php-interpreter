package org.xperiment.php.core.interpreter.type;

/**
 * (Class) PhpFloat
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class PhpFloat extends PhpDataType {

    /**
     * Constructor
     * - Sets the first chain
     *
     * @param firstChain First chain
     */
    public PhpFloat(PhpDataType firstChain) {
        super(firstChain);
    }

    /**
     * Determines data type
     * - Should run nextType() if data type is not appropriate
     *
     * @param value Value of variable
     * @return Returns the appropriate data type
     */
    @Override
    public PhpDataType setValueAndDetermineType(String value) {
        return nextType(nextType);
    }
}
