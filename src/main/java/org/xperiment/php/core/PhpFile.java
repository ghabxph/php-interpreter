package org.xperiment.php.core;

import org.xperiment.php.core.token.Lexer;
import org.xperiment.php.core.token.abs.Token;
import org.xperiment.php.core.token.exception.UnexpectedTokenException;
import org.xperiment.php.core.token.line.Line;
import org.xperiment.php.core.token.line.Lines;
import org.xperiment.php.exception.PhpFileException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * (Class) PHP Script File
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class PhpFile {

    /**
     * Location of PHP Script File
     */
    private String scriptFile;

    /**
     * Plaintext file contents of the PHP Script
     */
    private String scriptContent = "";

    /**
     * Raw lines
     */
    private List<Line> lines;

    /**
     * Raw lines container
     */
    private Lines linesContainer;

    /**
     * Whether file exist or not
     */
    private boolean fileLoaded = false;

    /**
     * Tokens
     */
    private final List<Token> tokens = new ArrayList<>();

    /**
     * Constructor
     *
     * @param scriptFile  Path of PHP Script
     */
    public PhpFile(String scriptFile) {

        this.scriptFile = scriptFile;
    }

    /**
     * @return  Returns the raw lines
     */
    public List<Line> lines() {

        lines = (lines != null) ? lines : linesContainer().lines();
        return lines;
    }

    /**
     * @return  True if file is loaded without problems. Otherwise, false
     */
    public boolean fileLoaded() {
        return fileLoaded;
    }

    /**
     * @return  Returns the file location of the script
     */
    public String scriptFile() {
        return scriptFile;
    }

    /**
     * @return  Returns the parsed token in the file
     */
    public List<Token> tokens() {
        return tokens;
    }

    /**
     * @return  Returns the raw script content
     */
    public String scriptContent() {
        return scriptContent;
    }

    /**
     * Loads PHP File
     */
    public void load() throws PhpFileException, UnexpectedTokenException {
        (new Lexer()).tokenize(loadScript().linesContainer().copy().lines(), lines().iterator(), tokens());
    }

    /**
     * Loads script to memory
     */
    private PhpFile loadScript() throws PhpFileException {

        fileLoaded = false;
        try {
            scriptContent = new String(Files.readAllBytes(Paths.get(scriptFile)));
            fileLoaded = true;
        } catch (Exception e) {
            throw new PhpFileException("Something went wrong: " + e.getMessage());
        }
        return this;
    }

    /**
     * @return  Returns the Lines (Lines Container) instance
     */
    private Lines linesContainer() {
        linesContainer = (linesContainer == null) ? new Lines(this) : linesContainer;
        return linesContainer;
    }
}
