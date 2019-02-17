package org.xperiment.php.core.token.line;

import org.xperiment.php.core.PhpFile;

import java.util.ArrayList;
import java.util.List;

/**
 * (Class) Lines Container
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class Lines {

    /**
     * PHP File
     */
    private PhpFile file;

    /**
     * Stack string, delimitered by EOL (\crlf, \lf, \cr)
     */
    private String stack;

    /**
     * Lines
     */
    private final List<Line> lines = new ArrayList<>();

    /**
     * Line number
     */
    private int lineNumber = 0;

    /**
     * Constructor
     *   - Sets PHP File and separates it per line
     *
     * @param file  File to parse
     */
    public Lines(PhpFile file) {

        this.file = file;
        this.stack = file.scriptContent();
        this.initializeLines();
    }

    /**
     * @return  Returns a copy of this instance.
     */
    public Lines copy() {
        return new Lines(file);
    }

    /**
     * @return  Returns lines
     */
    public List<Line> lines() {
        return lines;
    }

    /**
     * @return  Returns the PHP File associated in this instance
     */
    public PhpFile file() {
        return file;
    }

    /**
     * Pops the string stack
     *
     * @return  Returns the popped string stack
     */
    private String pop() {

        if (stack.isEmpty()) {
            return null;
        }

        lineNumber++;
        String pop = stack.substring(0, (new EOL(stack)).afterEolPos());
        stack = stack.substring(pop.length());
        return pop;
    }

    /**
     * Initializes lines
     */
    private void initializeLines() {

        for (String strLine = pop(); strLine != null; strLine = pop()) {
            Line line = new Line(file()).setLine(lineNumber, strLine);
            if (!lines.isEmpty()) {
                Line prevLine = lines.get(lines.size() - 1);
                line = prevLine.setNextLine(line).nextLine();
            }
            lines.add(line);
        }
    }
}
