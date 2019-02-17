package org.xperiment.php.core.token;

import org.xperiment.php.core.token.abs.Token;
import org.xperiment.php.core.token.exception.UnexpectedTokenException;
import org.xperiment.php.core.token.impl.*;
import org.xperiment.php.core.token.line.Line;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * (Class) Lexer
 *     - Class responsible for tokenizing file
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class Lexer {

    /**
     * PHP Open Tags
     */
    private final Class[] openTags = {
            TokenTagOpenFull.class,
            TokenTagOpenShort.class,
            TokenTagOpenShort2.class,
            TokenTagOpenShortEcho.class,
            TokenTagOpenShortEcho2.class
    };

    /**
     * PHP Tokens
     */
    private final Class[] phpTokens = {
            TokenTagClose.class,
            TokenTagClose2.class,
            TokenEcho.class,
            TokenString.class,
            TokenSemicolon.class
    };

    /**
     * Latest open tag
     */
    private TokenTagOpen openTag;

    /**
     * Current line
     */
    private Line currentLine;

    /**
     * Generates sequential token list from PHP Script
     *
     * @param linesClone  Clone of Lines instance used for making stack of lines
     * @param iterator    Iterator that iterates through entire PHP Lines
     * @param tokens      Token list
     */
    public void tokenize(List<Line> linesClone, Iterator<Line> iterator, List<Token> tokens) throws UnexpectedTokenException {

        Stack<Line> linesToRead = prepareLinesToRead(linesClone);

        while(iterator.hasNext()) {
            Token token = tokenize(openTags, linesToRead, iterator, tokens, true);
            this.openTag = (token instanceof TokenTagOpen) ? (TokenTagOpen)token : null;
            tokenize(linesToRead, iterator, tokens);
        }
    }

    private Token tokenize(Stack<Line> linesToRead, Iterator<Line> iterator, List<Token> tokens) throws UnexpectedTokenException {
        return tokenize(this.phpTokens, linesToRead, iterator, tokens, false);
    }

    private Token tokenize(Class[] phpTokens, Stack<Line> linesToRead,Iterator<Line> iterator, List<Token> tokens, boolean exitIfHasMatch) throws UnexpectedTokenException {

        Token token = null;
        String remainingToken = "";

        do {
            currentLine = (currentLine == null && iterator.hasNext()) ? iterator.next() : currentLine;
            if (currentLine == null) {
                continue;
            }
            for (Class phpToken : phpTokens) {
                try {
                    token = ((Token) phpToken.getDeclaredConstructor(Line.class, Stack.class, Iterator.class, List.class).newInstance(currentLine, linesToRead, iterator, tokens)).consume();
                    if (token.hasMatch() && exitIfHasMatch) {
                        return token;
                    }
                    if (closingTag(token)) {
                        return token;
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
            if (remainingToken.equals(linesToRead.peek().toString()) && !remainingToken.isEmpty()) {
                throw new UnexpectedTokenException(
                        "Error:\n" +
                        currentLine.lineNumber() + ": " + currentLine.toString() + "\n" +
                        "Unexpected token: " + linesToRead.peek().toString() + " at line: #" + linesToRead.peek().lineNumber()
                );
            }
            remainingToken = linesToRead.peek().toString();
            if (linesToRead.peek().toString().isEmpty()) {
                linesToRead.pop();
            }
        } while (!remainingToken.isEmpty() || hasNext(iterator));
        return token;
    }

    /**
     * Checks whether iterator has elements left
     *
     * @param   iterator  Iterator instance
     * @return  Returns true if there are elements left
     */
    private boolean hasNext(Iterator<Line> iterator) {

        if (iterator.hasNext()) {
            currentLine = iterator.next();
            return true;
        }
        return false;
    }

    /**
     * Checks whether given token is a closing tag
     *
     * @param   token  Closing tag token
     * @return  Returns true if it is a proper closing tag, matching with its respective open tag
     */
    private boolean closingTag(Token token) {

        if (!token.hasMatch() || openTag == null || !(token instanceof TokenTagClose)) {
            return false;
        }

        return ((openTag instanceof TokenTagOpenShort2 || openTag instanceof TokenTagOpenShortEcho2) && token instanceof TokenTagClose2) ||
               ((openTag instanceof TokenTagOpenFull || openTag instanceof TokenTagOpenShort || openTag instanceof TokenTagOpenShortEcho) && !(token instanceof TokenTagClose2));
    }

    /**
     * Prepares the lines to be read (as stack)
     *
     * @return  Stack of lines, to be read by parser
     */
    private Stack<Line> prepareLinesToRead(List<Line> lines) {

        Stack<Line> linesToRead = new Stack<>();
        for (int i = lines.size() - 1; i >= 0; i--) {
            linesToRead.push(trimLine(lines.get(i)));
        }
        return linesToRead;
    }

    /**
     * Trims the line
     *   - Removes trailing whitespaces
     *
     * @param   line  Line to trim
     * @return  Returns trimmed line
     */
    private Line trimLine(Line line) {
        return line.setLine(line.lineNumber(), line.toString().trim());
    }
}
