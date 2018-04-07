package asm.json.common.printer;

import java.io.PrintWriter;

public class LinePrinterBuilder {
    private PrintWriter out;
    private int indentCount;
    private int indentWidth;
    private int tabColumn;
    private boolean pendingNewline;

    public LinePrinterBuilder setOut(PrintWriter out) {
        this.out = out;
        return this;
    }

    public LinePrinterBuilder setIndentCount(int indentCount) {
        this.indentCount = indentCount;
        return this;
    }

    public LinePrinterBuilder setIndentWidth(int indentWidth) {
        this.indentWidth = indentWidth;
        return this;
    }

    public LinePrinterBuilder setTabColumn(int tabColumn) {
        this.tabColumn = tabColumn;
        return this;
    }

    public LinePrinterBuilder setPendingNewline(boolean pendingNewline) {
        this.pendingNewline = pendingNewline;
        return this;
    }

    public LinePrinter build() {
        return new LinePrinter(out, indentCount, indentWidth, tabColumn, pendingNewline);
    }

    public LinePrinter buildTest() {
        return new LinePrinter(new PrintWriter(System.out, true), 0, 4, 4, true);
    }
}