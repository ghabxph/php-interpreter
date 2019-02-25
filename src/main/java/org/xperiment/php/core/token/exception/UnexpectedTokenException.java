package org.xperiment.php.core.token.exception;

import org.xperiment.php.core.token.line.Line;

/**
 * (Class) UnexpectedTokenException
 *     - Syntax Error
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class UnexpectedTokenException extends Exception {

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public UnexpectedTokenException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public UnexpectedTokenException(String message) {
        super(message);
    }

    public UnexpectedTokenException(Line currentLine, String errToken, int lineNumber, String message) {
        super(
            "Error:\n" +
                currentLine.lineNumber() + ": " + currentLine.toString() + "\n" +
                message + ": " + errToken + " at line: #" + lineNumber
        );
    }
}
