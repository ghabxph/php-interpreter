package org.xperiment.php.core.token.impl;

import org.xperiment.php.core.token.abs.Token;
import org.xperiment.php.core.token.abs.TokenTagOpen;
import org.xperiment.php.core.token.line.Line;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * (Token) PHP Short Open Tag
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class TokenTagOpenShort extends TokenTagOpen {

    /**
     * Constructor
     * - Initializes line where token resides
     *
     * @param line        Line where token resides
     * @param linesToRead Line where token resides
     * @param iterator    Single iterator object
     * @param tokens      Tokens
     */
    public TokenTagOpenShort(Line line, Stack<Line> linesToRead, Iterator<Line> iterator, List<Token> tokens) {
        super(line, linesToRead, iterator, tokens);
    }

    /**
     * @return Returns the open tag token
     */
    @Override
    protected String token() {
        return "<?";
    }
}
