package org.xperiment.php.core.tree.abs;

import org.xperiment.php.core.tree.iface.StatementTree;

/**
 * (Class) StatementTreeImpl
 * - Class responsible for ...
 *
 * @author ghabxph [me@ghabxph.info]
 */
public abstract class StatementTreeImpl extends TreeImpl implements StatementTree{

    /**
     * Pointer to next statement
     */
    private StatementTree nextStatement;

    /**
     * Sets the next statement from token
     *
     * @param nextStatement Next statement
     */
    @Override
    public void nextStatement(StatementTree nextStatement) {
        this.nextStatement = nextStatement;
    }

    /**
     * Pointer to next statement
     *
     * @return Returns the next statement
     */
    @Override
    public StatementTree nextStatement() {
        return nextStatement;
    }
}
