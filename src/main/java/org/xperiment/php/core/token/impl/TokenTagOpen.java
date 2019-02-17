package org.xperiment.php.core.token.impl;

import org.xperiment.php.core.token.abs.Token;
import org.xperiment.php.core.token.exception.UnexpectedTokenException;
import org.xperiment.php.core.token.line.Line;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * (Token) PHP Open Tag Token
 *
 * @author ghabxph [me@ghabxph.info]
 */
public abstract class TokenTagOpen extends Token {

    /**
     * Constructor
     * - Initializes line where token resides
     *
     * @param line        Line where token resides
     * @param linesToRead Line where token resides
     * @param iterator    Single iterator object
     * @param tokens      Tokens
     */
    public TokenTagOpen(Line line, Stack<Line> linesToRead, Iterator<Line> iterator, List<Token> tokens) {
        super(line, linesToRead, iterator, tokens);
    }

    /**
     * @return  Returns the open tag token
     */
    protected abstract String token();

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
     * @return  Returns true if the line contains the matching token.
     */
    protected boolean tokenMatches() {
        tokenPosition = linesToRead().peek().toString().indexOf(token()) + token().length();
        return linesToRead().peek().toString().contains(token());
    }
}
