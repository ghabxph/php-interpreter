package org.xperiment.php.core.token.impl;

import org.xperiment.php.core.token.abs.Token;
import org.xperiment.php.core.token.exception.UnexpectedTokenException;
import org.xperiment.php.core.token.line.Line;
import org.xperiment.php.core.tree.iface.StringLiteralTree;
import org.xperiment.php.core.tree.impl.StringLiteralTreeImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (Token) String Token
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class TokenString extends Token {

    /**
     * Constructor
     * - Initializes line where token resides
     *
     * @param line        Line where token resides
     * @param linesToRead Line where token resides
     * @param iterator    Single iterator object
     * @param tokens      Tokens
     */
    public TokenString(Line line, Stack<Line> linesToRead, Iterator<Line> iterator, List<Token> tokens) {
        super(line, linesToRead, iterator, tokens, new StringLiteralTreeImpl());
    }

    /**
     * Check if token matches certain criteria
     *
     * @return Returns true if the line contains the matching token.
     */
    @Override
    protected boolean tokenMatches() {
        Matcher stringToken = Pattern.compile("((\")[^\"]*(\")|(')[^']*('))").matcher(linesToRead().peek().toString());
        boolean stringTokenExists = stringToken.find() && stringToken.start() == 0;
        if (stringTokenExists) {
            tokenPosition = stringToken.end();
            ((StringLiteralTree)tree).value(stringToken.group());
        }
        return stringTokenExists;
    }

    /**
     * Travels to next valid token
     *
     * @throws UnexpectedTokenException Throws UnexpectedTokenException if next token is not an expected token
     */
    @Override
    public void next() throws UnexpectedTokenException {
        throw new UnexpectedTokenException(line(), linesToRead().peek().toString(), linesToRead().peek().lineNumber(), "Unexpected string");
    }
}
