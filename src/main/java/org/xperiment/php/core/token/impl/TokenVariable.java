package org.xperiment.php.core.token.impl;

import org.xperiment.php.core.token.abs.Token;
import org.xperiment.php.core.token.exception.UnexpectedTokenException;
import org.xperiment.php.core.token.line.Line;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * (Class) TokenVariable
 * - Class responsible for ...
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class TokenVariable extends Token {

    /**
     * Constructor
     * - Initializes line where token resides
     *
     * @param line        Line where token resides
     * @param linesToRead Line where token resides0
     * @param iterator    Single iterator object
     * @param tokens      Tokens
     */
    public TokenVariable(Line line, Stack<Line> linesToRead, Iterator<Line> iterator, List<Token> tokens) {
        super(line, linesToRead, iterator, tokens);
    }

    /**
     * Check if token matches certain criteria
     *
     * @return Returns true if the line contains the matching token.
     */
    @Override
    protected boolean tokenMatches() {
        return false;
    }

    /**
     * Travels to next valid token
     *
     * @throws UnexpectedTokenException Throws UnexpectedTokenException if next token is not an expected token
     */
    @Override
    public void next() throws UnexpectedTokenException {

    }
}
