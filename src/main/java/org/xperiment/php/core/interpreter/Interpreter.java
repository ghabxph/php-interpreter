package org.xperiment.php.core.interpreter;

import org.xperiment.php.core.PhpFile;
import org.xperiment.php.core.token.exception.UnexpectedTokenException;
import org.xperiment.php.exception.PhpFileException;

import java.util.HashMap;
import java.util.Map;

/**
 * (Class) PHP Interpreter
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class Interpreter {

    /**
     * Singleton instance
     */
    private static final Interpreter instance = new Interpreter();

    /**
     * Php Files
     */
    private static final Map<String, PhpFile> phpFiles = new HashMap<>();

    /**
     * Executes PHP File
     *
     * @param phpFile  PHP File to run
     * @return  Returns singleton instance of this class
     */
    public Interpreter run(String phpFile) throws PhpFileException, UnexpectedTokenException {
        phpFiles.put(phpFile, (new PhpFile(phpFile)).load());


        return this;
    }
}
