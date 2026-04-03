package com.google.common.collect;

/* JADX INFO: compiled from: ForwardingObject.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u {
    protected u() {
    }

    protected abstract Object delegate();

    public String toString() {
        return delegate().toString();
    }
}
