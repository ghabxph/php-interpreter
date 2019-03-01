package org.xperiment.php.core.interpreter.type;

import java.util.regex.Pattern;

/**
 * (Class) PhpInteger
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class PhpInteger extends PhpDataType {

    /**
     * Constructor
     * - Sets the first chain
     *
     * @param firstChain First chain
     */
    PhpInteger(PhpDataType firstChain) {
        super(firstChain);
    }

    /**
     * @return  If value matches this type, this will return true
     */
    protected boolean valueMatchesThisType() {
        return Pattern.compile("^(0|[-]?[1-9][0-9]*)$").matcher(value()).find();
    }
}
