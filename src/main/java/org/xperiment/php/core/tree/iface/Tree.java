package org.xperiment.php.core.tree.iface;

import org.xperiment.php.core.token.abs.Token;

/**
 * (Interface) Tree
 *
 * @author ghabxph [me@ghabxph.info]
 */
public interface Tree {

    /**
     * Sets token instance for this tree
     *
     * @param token  Token instance for this tree
     */
    void token(Token token);

    /**
     * @return  Returns token instance of this tree
     */
    Token token();
}

