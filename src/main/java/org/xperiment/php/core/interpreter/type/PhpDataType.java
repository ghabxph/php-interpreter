package org.xperiment.php.core.interpreter.type;

/**
 * (Class) PhpDataType
 *
 * @author ghabxph [me@ghabxph.info]
 */
public abstract class PhpDataType {

    private static final Class[] dataTypes = {
            PhpArray.class,
            PhpBoolean.class,
            PhpFloat.class,
            PhpInteger.class,
            PhpNull.class,
            PhpObject.class,
            PhpResource.class,
            PhpString.class
    };

    /**
     * Determines data type
     *
     * @return  Returns PHP Data Type Instance
     */
    public abstract PhpDataType determineType();

    public static PhpDataType setValue(String value) {
        for(Class dataType : dataTypes) {
            dataType
        }
    }
}
