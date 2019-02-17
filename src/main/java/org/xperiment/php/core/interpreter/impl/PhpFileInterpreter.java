package org.xperiment.php.core.interpreter.impl;

import org.xperiment.php.core.PhpFile;
import org.xperiment.php.core.interpreter.exception.InterpreterException;
import org.xperiment.php.core.interpreter.iface.Interpreter;

import java.util.List;

/**
 * (Class) PhpFileInterpreter
 * - Class responsible for ...
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class PhpFileInterpreter implements Interpreter {

    /**
     * PHP Scripts
     */
    private List<ScriptInterpreter> scripts;

    /**
     * Interpreter
     *
     * @param script Script to load
     * @return Returns another object
     */
    @Override
    public List<ScriptInterpreter> interpret(Object script) throws InterpreterException {

        if (!(script instanceof PhpFile)) {
            throw new InterpreterException("Invalid usage of PhpFileInterpreter instance. Must pass PhpFile instance.");
        }

        try {
            return parse(((PhpFile)script).scriptContent());
        } catch (Exception e) {
            throw new InterpreterException("Something went wrong: " + e.getMessage());
        }
    }

    /**
     * Returns PHP Scripts
     *
     * @return  Scripts stored in this instance
     */
    public List<ScriptInterpreter> getScripts() {
        return scripts;
    }

    /**
     * Parses PHP Script File
     *
     * @param rawScript  Raw script to parse
     * @return  Returns the PHP Scripts
     */
    private List<ScriptInterpreter> parse(String rawScript) {
        return getScripts();
    }
}
