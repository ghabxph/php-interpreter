package org.xperiment.php.core.tree.iface;

/**
 * (Interface) LiteralTree
 *
 * @author ghabxph [me@ghabxph.info]
 */
public interface LiteralTree extends Tree {

    /**
     * Value of literal
     *
     * @return  Returns the value of literal
     */
    String value();

    /**
     * Sets value of literal
     *
     * @param value  Value of literal to set
     */
    void value(String value);
}

