package org.xperiment.php.core.token.impl;

import org.xperiment.php.core.token.abs.Token;
import org.xperiment.php.core.token.exception.UnexpectedTokenException;
import org.xperiment.php.core.token.line.Line;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * (Class) TokenComma
 *   - Comma token, that separates arguments in a function
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class TokenComma extends Token {

    /**
     * Constructor
     * - Initializes line where token resides
     *
     * @param line        Line where token resides
     * @param linesToRead Line where token resides0
     * @param iterator    Single iterator object
     * @param tokens      Tokens
     */
    public TokenComma(Line line, Stack<Line> linesToRead, Iterator<Line> iterator, List<Token> tokens) {
        super(line, linesToRead, iterator, tokens);
    }

    /**
     * Check if token matches certain criteria
     *
     * @return Returns true if the line contains the matching token.
     */
    @Override
    protected boolean tokenMatches() {
        String token = ",";
        if (linesToRead().peek().toString().indexOf(token) != 0) {
            return false;
        }
        tokenPosition = linesToRead().peek().toString().indexOf(token) + token.length();
        return true;
    }

    /**
     * Travels to next valid token
     *
     * @throws UnexpectedTokenException Throws UnexpectedTokenException if next token is not an expected token
     */
    @Override
    public void next() throws UnexpectedTokenException {
        if (nextToken() instanceof TokenSemicolon) {
            throw new UnexpectedTokenException(line(), linesToRead().peek().toString(), linesToRead().peek().lineNumber(), "Expecting a parameter value next to ',' character");
        }
        nextToken().next();
    }
}
