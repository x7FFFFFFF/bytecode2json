package asm.json.common.printer;

import java.io.PrintWriter;

/**
 * Created on 07.04.2018.
 */
public class LinePrinter implements ILinePrinter {


    private final PrintWriter out;
    private final StringBuilder buffer;
    private  int indentCount;
    private final int indentWidth;
    private final int tabColumn;
    private  boolean pendingNewline;

    public LinePrinter(PrintWriter out, int indentCount, int indentWidth, int tabColumn, boolean pendingNewline) {
        this.out = out;
        this.indentCount = indentCount;
        this.indentWidth = indentWidth;
        this.tabColumn = tabColumn;
        this.pendingNewline = pendingNewline;


        buffer = new StringBuilder();
    }

    @Override
    public void print(String s) {
        if (pendingNewline) {
            println();
            pendingNewline = false;
        }
        if (s == null)
            s = "null";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '\n':
                    println();
                    break;
                default:
                    if (buffer.length() == 0)
                        indent();
                    buffer.append(c);
            }
        }

    }

    @Override
    public void println() {
        out.println(buffer);
        buffer.setLength(0);
    }

    @Override
    public void println(String s) {
        print(s);
        println();
    }

    @Override
    public void printlnf(String s, Object... args) {
        println(String.format(s, args));
    }

    @Override
    public void indent(int delta) {
        indentCount += delta;
    }

    @Override
    public void tab() {
        if (buffer.length() == 0)
            indent();
        space(indentCount * indentWidth + tabColumn - buffer.length());
    }

    private void indent() {
        space(indentCount * indentWidth);
    }

    private void space(int n) {
        for (int i = 0; i < n; i++)
            buffer.append(' ');
    }

}
