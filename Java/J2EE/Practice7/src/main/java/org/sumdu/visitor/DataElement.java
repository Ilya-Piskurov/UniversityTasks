package org.sumdu.visitor;

public interface DataElement {
    void acceptOperation(DataElementVisitor visitor);
}
