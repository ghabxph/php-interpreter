package org.xperiment.php.core.token.line;

/**
 * (Class) EOL
 *
 * @author ghabxph [me@ghabxph.info]
 */
public class EOL {

    /**
     * String to find EOL
     */
    private String str;

    /**
     * EOL
     */
    private String EOL;

    /**
     * EOL Position
     */
    private int position;

    /**
     * Constructor
     *
     * @param str  String to look for EOL character
     */
    public EOL(String str) {
        this.str = str;
        findEol();
    }

    /**
     * Finds EOL
     */
    private void findEol() {

        int LF = str.indexOf("\n");
        int CR = str.indexOf("\r");
        int CRLF = str.indexOf("\r\n");

        if (LF == -1 && CR == -1 && CRLF == -1) {
            position = str.length();
            EOL = "";
        } else if (LF < CR || CR == -1) {
            position = LF;
            EOL = "\n";
        } else if (CR == CRLF) {
            position = CRLF;
            EOL = "\r\n";
        } else {
            position = CR;
            EOL = "\r";
        }
    }

    /**
     * @return  Returns position after EOL
     */
    public int afterEolPos() {
        return position + EOL().length();
    }

    /**
     * @return  Returns EOL Character
     */
    public String EOL() {
        return EOL;
    }
}
