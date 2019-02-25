package org.xperiment.php.core.tree.abs;

import org.xperiment.php.core.token.abs.Token;
import org.xperiment.php.core.tree.iface.Tree;

/**
 * (Class) TreeImpl
 * - Class responsible for ...
 *
 * @author ghabxph [me@ghabxph.info]
 */
public abstract class TreeImpl implements Tree {

    /**
     * Token associated in this tree instance
     */
    private Token token;

    /**
     * Sets token instance for this tree
     *
     * @param token Token instance for this tree
     */
    @Override
    public void token(Token token) {
        this.token = token;
    }

    /**
     * @return Returns token instance of this tree
     */
    @Override
    public Token token() {
        return token;
    }
}
