package com.bumptech.glide;

import com.bumptech.glide.k;

/* JADX INFO: compiled from: TransitionOptions.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class k<CHILD extends k<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m1.c<? super TranscodeType> f8243a = m1.a.b();

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    final m1.c<? super TranscodeType> c() {
        return this.f8243a;
    }
}
