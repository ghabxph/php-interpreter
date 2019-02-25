package org.xperiment.php.core.tree.iface;

/**
 * (Interface) StringLiteralTree
 *
 * @author ghabxph [me@ghabxph.info]
 */
public interface StringLiteralTree extends LiteralTree {

    /**
     * Returns the string value
     *
     * @return Returns the unquoted string value
     */
    String stringValue();


    /**
     * Type of quote
     *   - Either " or '
     *
     * @return  Returns the type of quote, which is either single (') or double (") quote
     */
    String quote();
}
