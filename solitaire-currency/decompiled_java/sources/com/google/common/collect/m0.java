package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: MultimapBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m0<K0, V0> {

    /* JADX INFO: compiled from: MultimapBuilder.java */
    class a extends e<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f10111a;

        a(int i10) {
            this.f10111a = i10;
        }

        @Override // com.google.common.collect.m0.e
        <K, V> Map<K, Collection<V>> c() {
            return t0.c(this.f10111a);
        }
    }

    /* JADX INFO: compiled from: MultimapBuilder.java */
    class b extends e<K0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f10112a;

        b(Comparator comparator) {
            this.f10112a = comparator;
        }

        @Override // com.google.common.collect.m0.e
        <K extends K0, V> Map<K, Collection<V>> c() {
            return new TreeMap(this.f10112a);
        }
    }

    /* JADX INFO: compiled from: MultimapBuilder.java */
    private static final class c<V> implements e5.u<List<V>>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f10113a;

        c(int i10) {
            this.f10113a = k.b(i10, "expectedValuesPerKey");
        }

        @Override // e5.u
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<V> get() {
            return new ArrayList(this.f10113a);
        }
    }

    /* JADX INFO: compiled from: MultimapBuilder.java */
    public static abstract class d<K0, V0> extends m0<K0, V0> {
        d() {
            super(null);
        }

        public abstract <K extends K0, V extends V0> i0<K, V> e();
    }

    /* JADX INFO: compiled from: MultimapBuilder.java */
    public static abstract class e<K0> {

        /* JADX INFO: compiled from: MultimapBuilder.java */
        class a extends d<K0, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f10114a;

            a(int i10) {
                this.f10114a = i10;
            }

            @Override // com.google.common.collect.m0.d
            public <K extends K0, V> i0<K, V> e() {
                return n0.b(e.this.c(), new c(this.f10114a));
            }
        }

        e() {
        }

        public d<K0, Object> a() {
            return b(2);
        }

        public d<K0, Object> b(int i10) {
            k.b(i10, "expectedValuesPerKey");
            return new a(i10);
        }

        abstract <K extends K0, V> Map<K, Collection<V>> c();
    }

    private m0() {
    }

    /* synthetic */ m0(a aVar) {
        this();
    }

    public static e<Object> a() {
        return b(8);
    }

    public static e<Object> b(int i10) {
        k.b(i10, "expectedKeys");
        return new a(i10);
    }

    public static e<Comparable> c() {
        return d(s0.d());
    }

    public static <K0> e<K0> d(Comparator<K0> comparator) {
        e5.o.j(comparator);
        return new b(comparator);
    }
}
