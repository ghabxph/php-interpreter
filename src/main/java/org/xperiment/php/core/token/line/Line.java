package org.xperiment.php.core.token.line;

import org.xperiment.php.core.PhpFile;

/**
 * (Class) Line
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class Line {

    /**
     * PHP File
     */
    private final PhpFile file;

    /**
     * Current line number
     */
    private int lineNumber;

    /**
     * String within the line
     */
    private String text;

    /**
     * Next line
     */
    private Line nextLine;

    /**
     * Previous line
     */
    private Line prevLine;

    /**
     * Constructor
     *
     * @param file  PHP File
     */
    Line(PhpFile file) {
        this.file = file;
    }

    /**
     * Sets the line number and text within this line
     *
     * @param   lineNumber  Line number location
     * @param   text        String within this line
     * @return  Returns this instance
     */
    public Line setLine(int lineNumber, String text) {

        this.lineNumber = lineNumber;
        this.text = text;
        return this;
    }

    /**
     * @return  String in the line
     */
    public String toString() {
        return text;
    }

    /**
     * @return  Returns PHP File
     */
    public PhpFile file() {
        return file;
    }

    /**
     * @return  Returns the line number
     */
    public int lineNumber() {
        return lineNumber;
    }

    /**
     * @return  Returns next line
     */
    public Line nextLine() {
        return nextLine;
    }

    /**
     * @return  Returns previous line
     */
    public Line prevLine() {
        return prevLine;
    }

    /**
     * Sets the next line
     *
     * @param   nextLine  Next line instance
     * @return  Return this instance
     */
    public Line setNextLine(Line nextLine) {
        this.nextLine = nextLine;
        return this.nextLine.setPreviousLine(this);
    }

    /**
     * Sets previous line
     *
     * @param   prevLine  Previous line instance
     * @return  Returns the previous line instance
     */
    private Line setPreviousLine(Line prevLine) {
        this.prevLine = prevLine;
        return prevLine();
    }
}
