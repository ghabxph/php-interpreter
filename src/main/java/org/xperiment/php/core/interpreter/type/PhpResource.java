package org.xperiment.php.core.interpreter.type;

/**
 * (Class) PhpResource
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class PhpResource extends PhpDataType {

    /**
     * Constructor
     * - Sets the first chain
     *
     * @param firstChain First chain
     */
    PhpResource(PhpDataType firstChain) {
        super(firstChain);
    }

    /**
     * @return  If value matches this type, this will return true
     */
    protected boolean valueMatchesThisType() {
        // Not sure bout this yet...
        return false;
    }
}
