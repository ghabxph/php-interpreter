package org.xperiment.php.tree.interfaces;

import java.util.List;

/**
 * (Interface) PhpFileTree
 *
 * @author ghabxph [me@ghabxph.info]
 */
public interface PhpFileTree {

    public List<PhpScriptTree> getPhpScripts();

    public String getFileContents();
}

