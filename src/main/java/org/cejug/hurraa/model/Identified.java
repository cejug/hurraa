package org.cejug.hurraa.model;

public interface Identified<T extends Long> {

    public T getId();

    public void setId(T id);

}
