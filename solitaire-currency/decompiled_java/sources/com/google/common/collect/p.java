package com.google.common.collect;

import java.util.Comparator;

/* JADX INFO: compiled from: ComparisonChain.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final p f10118a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final p f10119b = new b(-1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final p f10120c = new b(1);

    /* JADX INFO: compiled from: ComparisonChain.java */
    class a extends p {
        a() {
            super(null);
        }

        @Override // com.google.common.collect.p
        public p d(int i10, int i11) {
            return k(g5.e.e(i10, i11));
        }

        @Override // com.google.common.collect.p
        public p e(long j10, long j11) {
            return k(g5.g.a(j10, j11));
        }

        @Override // com.google.common.collect.p
        public <T> p f(T t10, T t11, Comparator<T> comparator) {
            return k(comparator.compare(t10, t11));
        }

        @Override // com.google.common.collect.p
        public p g(boolean z10, boolean z11) {
            return k(g5.a.a(z10, z11));
        }

        @Override // com.google.common.collect.p
        public p h(boolean z10, boolean z11) {
            return k(g5.a.a(z11, z10));
        }

        @Override // com.google.common.collect.p
        public int i() {
            return 0;
        }

        p k(int i10) {
            return i10 < 0 ? p.f10119b : i10 > 0 ? p.f10120c : p.f10118a;
        }
    }

    private p() {
    }

    /* synthetic */ p(a aVar) {
        this();
    }

    public static p j() {
        return f10118a;
    }

    public abstract p d(int i10, int i11);

    public abstract p e(long j10, long j11);

    public abstract <T> p f(T t10, T t11, Comparator<T> comparator);

    public abstract p g(boolean z10, boolean z11);

    public abstract p h(boolean z10, boolean z11);

    public abstract int i();

    /* JADX INFO: compiled from: ComparisonChain.java */
    private static final class b extends p {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f10121d;

        b(int i10) {
            super(null);
            this.f10121d = i10;
        }

        @Override // com.google.common.collect.p
        public int i() {
            return this.f10121d;
        }

        @Override // com.google.common.collect.p
        public p d(int i10, int i11) {
            return this;
        }

        @Override // com.google.common.collect.p
        public p e(long j10, long j11) {
            return this;
        }

        @Override // com.google.common.collect.p
        public p g(boolean z10, boolean z11) {
            return this;
        }

        @Override // com.google.common.collect.p
        public p h(boolean z10, boolean z11) {
            return this;
        }

        @Override // com.google.common.collect.p
        public <T> p f(T t10, T t11, Comparator<T> comparator) {
            return this;
        }
    }
}
