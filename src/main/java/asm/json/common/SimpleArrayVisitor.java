package asm.json.common;

import asm.json.common.printer.ILinePrinter;

public abstract class SimpleArrayVisitor implements IVisitElement, IVisitArray {
    protected final ILinePrinter printer;
    private final String name;
    protected int counter;



    public SimpleArrayVisitor(ILinePrinter lp, String name) {
        this.printer = lp;
        this.name = name;
    }


    @Override
    public void visitStart() {
            printer.println("{");
            printer.indent(1);
    }

    @Override
    public void visitEnd() {
        printer.indent(-1);
        printer.println("},");
    }

    @Override
    public void visitStartArray() {
        printer.printlnf("%s:[", name);
        printer.indent(1);
    }

    @Override
    public void visitEndArray() {
        printer.indent(-1);
        printer.println("],");
    }
}