package org.xperiment.php.core;

import org.xperiment.php.core.token.abs.Token;
import org.xperiment.php.core.token.exception.UnexpectedTokenException;

import java.util.List;

/**
 * (Class) Grammarian
 *     - Class responsible for validating syntax grammar after tokenization
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class Grammarian {

    private final List<Token> tokens;

    /**
     * Constructor
     *   - Sets token
     *
     * @param tokens  Tokens needed for further analysis
     */
    Grammarian(List<Token> tokens) {
        this.tokens = tokens;
    }

    /**
     * Validates syntax grammar
     *
     * @return  Returns result grammar
     * @throws UnexpectedTokenException  If syntax error occurs this exception shall be thrown
     */
    Grammarian validateGrammar() throws UnexpectedTokenException {

        // Do nothing if there are no tokens
        if (this.tokens.size() == 0) {
            return this;
        }

        this.tokens.get(0).next();
        return this;
    }
}
