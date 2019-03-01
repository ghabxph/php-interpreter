package org.xperiment.php.core.interpreter.type;

/**
 * (Class) PhpBoolean
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class PhpBoolean extends PhpDataType {

    /**
     * Constructor
     * - Sets the first chain
     *
     * @param firstChain First chain
     */
    PhpBoolean(PhpDataType firstChain) {
        super(firstChain);
    }

    /**
     * @return  If value matches this type, this will return true
     */
    protected boolean valueMatchesThisType() {
        return value().toLowerCase().equals("true") || value().toLowerCase().contains("false");
    }
}
