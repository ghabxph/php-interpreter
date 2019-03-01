package org.xperiment.php.core.interpreter.type;

/**
 * (Class) PhpObject
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class PhpObject extends PhpDataType {

    /**
     * Constructor
     * - Sets the first chain
     *
     * @param firstChain First chain
     */
    PhpObject(PhpDataType firstChain) {
        super(firstChain);
    }

    /**
     * @return  If value matches this type, this will return true
     */
    protected boolean valueMatchesThisType() {
        return false;
    }
}
