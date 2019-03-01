package org.xperiment.php.core.interpreter.type;

/**
 * (Class) PhpString
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class PhpString extends PhpDataType {

    /**
     * Constructor
     * - Sets the first chain
     *
     * @param firstChain First chain
     */
    PhpString(PhpDataType firstChain) {
        super(firstChain);
    }

    /**
     * @return  If value matches this type, this will return true
     */
    protected boolean valueMatchesThisType() {
        return ((value().indexOf('"') == 0 || value().indexOf('\'') == 0) && (value().lastIndexOf('"') == value().length() - 1 || value().lastIndexOf('\'') == value().length() - 1));
    }
}
