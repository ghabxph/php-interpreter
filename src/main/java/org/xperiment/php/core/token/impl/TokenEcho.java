package org.xperiment.php.core.token.impl;

import org.xperiment.php.core.token.abs.Token;
import org.xperiment.php.core.token.exception.UnexpectedTokenException;
import org.xperiment.php.core.token.line.Line;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * (Token) Echo Token
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class TokenEcho extends Token {

    /**
     * Constructor
     * - Initializes line where token resides
     *
     * @param line        Line where token resides
     * @param linesToRead Line where token resides
     * @param iterator    Single iterator object
     * @param tokens      Tokens
     */
    public TokenEcho(Line line, Stack<Line> linesToRead, Iterator<Line> iterator, List<Token> tokens) {
        super(line, linesToRead, iterator, tokens);
    }

    /**
     * Travels to next valid token
     *
     * @throws UnexpectedTokenException Throws UnexpectedTokenException if next token is not an expected token
     */
    @Override
    public void next() throws UnexpectedTokenException {

    }

    /**
     * Check if token matches certain criteria
     *
     * @return Returns true if the line contains the matching token.
     */
    @Override
    protected boolean tokenMatches() {
        String token = "echo";
        if (linesToRead().peek().toString().indexOf(token) != 0) {
            return false;
        }
        tokenPosition = linesToRead().peek().toString().indexOf(token) + token.length();
        return true;
    }
}
