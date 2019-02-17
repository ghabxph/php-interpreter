package org.xperiment.php;

import org.junit.Test;
import org.xperiment.php.core.PhpFile;
import org.xperiment.php.core.token.exception.UnexpectedTokenException;
import org.xperiment.php.exception.PhpFileException;

public class PhpFileTest {

    private PhpFile file = new PhpFile("src/test/resources/php/snippet/sample.php");

    @Test
    public void loadScript() throws PhpFileException, UnexpectedTokenException {
        file.load();
    }
}