package org.xperiment.php.core.token.abs;

import org.xperiment.php.core.token.exception.UnexpectedTokenException;
import org.xperiment.php.core.token.line.Line;
import org.xperiment.php.core.tree.iface.Tree;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * (Class) Token
 *
 * @author ghabxph [me@ghabxph.info]
 */
public abstract class Token {

    /**
     * Current Line
     */
    private Line line;

    /**
     * Lines to read
     */
    private final Stack<Line> linesToRead;

    /**
     * Current line being read
     */
    private final Iterator<Line> iterator;

    /**
     * Tokens
     */
    private final List<Token> tokens;

    /**
     * Tree
     */
    protected final Tree tree;

    /**
     * Has token match?
     */
    private boolean hasMatch;

    /**
     * Next Token
     */
    private Token nextToken;

    /**
     * Token position
     */
    protected int tokenPosition;

    /**
     * Constructor
     *   - Initializes line where token resides
     *
     * @param line         Line where token resides
     * @param linesToRead  Line where token resides0
     * @param iterator     Single iterator object
     * @param tokens       Tokens
     */
    public Token(Line line, Stack<Line> linesToRead, Iterator<Line> iterator, List<Token> tokens) {
        this.line = line;
        this.linesToRead = linesToRead;
        this.iterator = iterator;
        this.tokens = tokens;
        this.tree = null;
    }

    /**
     * Constructor
     *   - Initializes line where token resides
     *
     * @param line         Line where token resides
     * @param linesToRead  Line where token resides0
     * @param iterator     Single iterator object
     * @param tokens       Tokens
     * @param tree         Tree
     */
    protected Token(Line line, Stack<Line> linesToRead, Iterator<Line> iterator, List<Token> tokens, Tree tree) {
        this.line = line;
        this.linesToRead = linesToRead;
        this.iterator = iterator;
        this.tokens = tokens;
        this.tree = tree;
    }

    /**
     * Consumes the token found within the line, and updates the linesToRead stack
     *
     * @return  Returns this instance
     */
    public Token consume() {

        hasMatch = tokenMatches();

        if (!(hasMatch())) {
            return this;
        }

        linesToRead().peek().setLine(linesToRead().peek().lineNumber(), linesToRead().peek().toString().substring(tokenPosition).trim());

        if (tokens.size() > 0) {
            tokens.get(tokens.size() - 1).nextToken = this;
        }
        tokens.add(this);

        return this;
    }

    /**
     * Check if token matches certain criteria
     *
     * @return  Returns true if the line contains the matching token.
     */
    protected abstract boolean tokenMatches();

    /**
     * Travels to next valid token
     *
     * @throws UnexpectedTokenException  Throws UnexpectedTokenException if next token is not an expected token
     */
    public abstract void next() throws UnexpectedTokenException;

    /**
     * @return  Returns instance of next token
     */
    public Token nextToken() {
        return nextToken;
    }

    /**
     * @return  Returns result of tokenMatches() method
     */
    public boolean hasMatch() {
        return hasMatch;
    }

    /**
     * @return  Line where token resides
     */
    public Line line() {
        return line;
    }

    /**
     * @return  Interconnected Tokens
     */
    public List<Token> tokens() {
        return tokens;
    }

    /**
     * @return  Returns tree instance
     */
    public Tree tree() {
        return tree;
    }

    /**
     * @return  Lines to read
     */
    protected Stack<Line> linesToRead() {
        return linesToRead;
    }

    /**
     * @return  Returns the current line being read
     */
    protected Iterator<Line> iterator() {
        return iterator;
    }

    /**
     * Sets new line instance
     *
     * @param   line  Line instance to set
     * @return  Always return true
     */
    protected boolean line(Line line) {
        this.line = line;
        return true;
    }
}
