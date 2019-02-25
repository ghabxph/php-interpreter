package org.xperiment.php.core.token.impl;

import org.xperiment.php.core.token.abs.Token;
import org.xperiment.php.core.token.exception.UnexpectedTokenException;
import org.xperiment.php.core.token.line.Line;
import org.xperiment.php.core.tree.iface.StatementTree;
import org.xperiment.php.core.tree.iface.StringLiteralTree;
import org.xperiment.php.core.tree.impl.EchoStatementTree;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * (Token) Echo Token
 *   See: http://php.net/manual/en/function.echo.php
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
        super(line, linesToRead, iterator, tokens, new EchoStatementTree());
    }

    /**
     * Travels to next valid token
     *
     * @throws UnexpectedTokenException Throws UnexpectedTokenException if next token is not an expected token
     */
    @Override
    public void next() throws UnexpectedTokenException {

        EchoStatementTree tree = (EchoStatementTree)this.tree;
        Token nextToken = nextToken();
        do {
            // Skip if token is comma
            if (nextToken instanceof TokenComma) {
                nextToken = nextToken.nextToken();
                continue;
            }

            // Throw exception if parameter given is non-string
            if (!(nextToken.tree() instanceof StringLiteralTree)) {
                throw new UnexpectedTokenException("Unexpected Token: " + nextToken().toString());
            }

            // Adds information to echo token
            tree.args((StringLiteralTree)nextToken.tree());
            nextToken = nextToken.nextToken();
        } while (!(nextToken instanceof TokenSemicolon));

        // Do nothing, if there's no more token
        if (nextToken.nextToken() == null) {
            return;
        }

        // Proceed to next token if token is close tag
        if (nextToken.nextToken() instanceof TokenTagClose) {
            nextToken.nextToken().next();
            return;
        }

        // Throw error if next token is not a statement
        if (!(nextToken.nextToken().tree() instanceof StatementTree)) {
            throw new UnexpectedTokenException("Expecting a statement next to this echo statement.");
        }

        tree.nextStatement((StatementTree)nextToken.nextToken().tree());
        nextToken.nextToken().next();
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
