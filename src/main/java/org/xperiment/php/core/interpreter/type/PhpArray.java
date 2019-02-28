package org.xperiment.php.core.interpreter.type;

/**
 * (Class) PhpArray
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class PhpArray extends PhpDataType {

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
