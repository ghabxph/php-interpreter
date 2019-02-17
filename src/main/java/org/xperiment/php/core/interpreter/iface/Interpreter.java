package org.xperiment.php.core.interpreter.iface;

import org.xperiment.php.core.interpreter.exception.InterpreterException;
import org.xperiment.php.exception.PhpFileException;

/**
 * (Interface) Interpreter
 *
 * @author ghabxph [me@ghabxph.info]
 */
public interface Interpreter {

    /**
     * Interpreter
     *
     * @param   script  Script to load
     * @return  Returns another object
     */
    public Object interpret (Object script) throws InterpreterException;
}

