package org.xperiment.php.core.interpreter.type;

/**
 * (Class) PhpArray
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class PhpArray extends PhpDataType {

    /**
     * @return  If value matches this type, this will return true
     */
    protected boolean valueMatchesThisType() {
        return false;
    }
}
