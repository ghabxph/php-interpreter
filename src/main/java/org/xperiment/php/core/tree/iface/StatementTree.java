package org.xperiment.php.core.tree.iface;

/**
 * (Interface) StatementTree
 *     - Classifies statements
 *
 * @author ghabxph [me@ghabxph.info]
 */
public interface StatementTree extends Tree {

    /**
     * Sets the next statement from token
     *
     * @param nextStatement Next statement
     */
    void nextStatement(StatementTree nextStatement);

    /**
     * Pointer to next statement
     *
     * @return  Returns the next statement
     */
    StatementTree nextStatement();

    /**
     * Executes the statement
     *
     * @return  Returns this instance, along with the viable status
     */
    StatementTree execute();
}
