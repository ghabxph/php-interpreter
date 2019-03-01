package org.xperiment.php.core.interpreter;

import org.junit.Test;
import org.xperiment.php.core.PhpFile;
import org.xperiment.php.core.interpreter.type.*;

import static org.junit.Assert.*;

/**
 * (TEST) Tests PhpVariable
 *   - From this we test different data types
 *   - We test:
 *       * Array
 *         - Not yet available for now
 *       * Boolean
 *       * Float
 *       * Integer
 *       * Null
 *       * Object
 *          - Not yet available for now
 *       * Resource
 *          - Not yet available for now
 *       * String
 */
public class PhpVariableTest {

    @Test
    public void getType() {
        assertTrue(((new PhpVariable("someVariable", "true")).getType() instanceof PhpBoolean));
        assertTrue(((new PhpVariable("someVariable", "FalSe")).getType() instanceof PhpBoolean));
        assertTrue(((new PhpVariable("someVariable", "5.2")).getType() instanceof PhpFloat));
        assertTrue(((new PhpVariable("someVariable", "52")).getType() instanceof PhpInteger));
        assertTrue(((new PhpVariable("someVariable", "-194712")).getType() instanceof PhpInteger));
        assertTrue(((new PhpVariable("someVariable", "null")).getType() instanceof PhpNull));
        assertTrue(((new PhpVariable("someVariable", "null")).getType() instanceof PhpObject));
        assertTrue(((new PhpVariable("someVariable", "\'Some cute string\'")).getType() instanceof PhpString));
        assertTrue(((new PhpVariable("someVariable", "\'Double quoted string\'")).getType() instanceof PhpString));
    }
}