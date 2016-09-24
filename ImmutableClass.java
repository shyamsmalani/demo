package com.shyammalani;


final public class ImmutableClass {
    final private String immutableVariable;
    final private MutableClass mutableVariable;

    public ImmutableClass(String immutableVariable, MutableClass mutableVariable) {
        this.immutableVariable = immutableVariable;
        this.mutableVariable = mutableVariable;
    }

    public String getImmutableVariable() {
        return immutableVariable;
    }

    public MutableClass getMutableVariable() throws CloneNotSupportedException {
            return mutableVariable.clone();
    }
}

class MutableClass implements Cloneable{
    @Override
    protected MutableClass clone() throws CloneNotSupportedException {
        return this.clone();
    }
}