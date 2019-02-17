package org.xperiment.php.exception;

/**
 * (Exception) PhpFileException
 *     - Exception to be thrown in anything is related to php file
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class PhpFileException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public PhpFileException(String message) {
        super(message);
    }
}
