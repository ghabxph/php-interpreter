package org.xperiment.php.core.token.impl;

import org.xperiment.php.core.token.abs.Token;
import org.xperiment.php.core.token.line.Line;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * (Token) PHP Close Tag (%)
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class TokenTagClose2 extends TokenTagClose {

    /**
     * Constructor
     * - Initializes line where token resides
     *
     * @param line        Line where token resides
     * @param linesToRead Line where token resides
     * @param iterator    Single iterator object
     * @param tokens      Tokens
     */
    public TokenTagClose2(Line line, Stack<Line> linesToRead, Iterator<Line> iterator, List<Token> tokens) {
        super(line, linesToRead, iterator, tokens);
    }

    /**
     * Check if token matches certain criteria
     *
     * @return Returns true if the line contains the matching token.
     */
    @Override
    protected boolean tokenMatches() {
        String token = "%>";
        tokenPosition = linesToRead().peek().toString().indexOf(token) + token.length();
        return linesToRead().peek().toString().contains(token);
    }
}
