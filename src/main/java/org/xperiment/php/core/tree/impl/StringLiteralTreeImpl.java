package org.xperiment.php.core.tree.impl;

import org.xperiment.php.core.token.abs.Token;
import org.xperiment.php.core.token.impl.TokenString;
import org.xperiment.php.core.tree.iface.StringLiteralTree;

/**
 * (Class) StringLiteralTreeImpl
 * - Class responsible for ...
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class StringLiteralTreeImpl implements StringLiteralTree {

    /**
     * Token instance for this string
     */
    private TokenString token;

    /**
     * String value
     */
    private String value;

    /**
     * Type of quote
     */
    private String quote;

    /**
     * Sets token instance for this tree
     *
     * @param token Token instance for this tree
     */
    @Override
    public void token(Token token) {
        this.token = (TokenString)token;

    }

    /**
     * @return Returns token instance of this tree
     */
    @Override
    public Token token() {
        return token;
    }

    /**
     * Value of literal
     *
     * @return  Returns the value of literal
     */
    @Override
    public String value() {
        return value;
    }

    /**
     * Sets value of literal
     *
     * @param value Value of literal to set
     */
    @Override
    public void value(String value) {

        this.quote = value.substring(0, 1);
        if (this.quote.equals("\"")) {
            value = value
                    .replace("\\r", "\r")
                    .replace("\\n", "\n")
                    .replace("\\t", "\t");
        }

        this.value = value;
    }

    /**
     * Returns the string value
     *
     * @return Returns the unquoted string value
     */
    @Override
    public String stringValue() {
        return value.substring(1, value.length() - 1);
    }

    /**
     * Type of quote
     * - Either " or '
     *
     * @return Returns the type of quote, which is either single (') or double (") quote
     */
    @Override
    public String quote() {
        return quote;
    }
}
