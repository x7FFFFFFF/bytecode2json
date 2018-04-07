package asm.json.common.printer;

/**
 * Created on 07.04.2018.
 */
public interface ILinePrinter {
    void print(String s);

    void println();

    void println(String s);

    void  printlnf(String s, Object... args);

    void indent(int delta);

    void tab();
}
