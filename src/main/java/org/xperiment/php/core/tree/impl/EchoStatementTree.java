package org.xperiment.php.core.tree.impl;

import org.xperiment.php.core.tree.abs.StatementTreeImpl;
import org.xperiment.php.core.tree.iface.StatementTree;
import org.xperiment.php.core.tree.iface.StringLiteralTree;

import java.util.ArrayList;
import java.util.List;

/**
 * (Class) EchoStatementTree
 * - Class responsible for ...
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class EchoStatementTree extends StatementTreeImpl {

    /**
     * String parameters
     */
    private final List<StringLiteralTree> args = new ArrayList<>();

    /**
     * Adds argument to echo statement
     *
     * @param args  String parameter to add
     */
    public void args(StringLiteralTree args) {
        this.args.add(args);
    }


    /**
     * Executes the statement
     *
     * @return Returns this instance, along with the viable status
     */
    @Override
    public StatementTree execute() {

        for (StringLiteralTree arg : args) {
            System.out.print(arg.stringValue());
        }
        return null;
    }
}
