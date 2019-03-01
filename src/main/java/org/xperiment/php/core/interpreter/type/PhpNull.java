package org.xperiment.php.core.interpreter.type;

/**
 * (Class) PhpNull
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class PhpNull extends PhpObject {

    /**
     * Constructor
     * - Sets the first chain
     *
     * @param firstChain First chain
     */
    PhpNull(PhpDataType firstChain) {
        super(firstChain);
    }

    /**
     * @return  If value matches this type, this will return true
     */
    protected boolean valueMatchesThisType() {
        return (value().toLowerCase().equals("null"));
    }
}
