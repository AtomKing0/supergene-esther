package com.ironsource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface ob<T> {

    public static final class a<T> implements ob<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final ArrayList<T> f14222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final ArrayList<T> f14223b;

        public a(@NotNull ArrayList<T> a10, @NotNull ArrayList<T> b10) {
            kotlin.jvm.internal.t.i(a10, "a");
            kotlin.jvm.internal.t.i(b10, "b");
            this.f14222a = a10;
            this.f14223b = b10;
        }

        @Override // com.ironsource.ob
        public boolean contains(T t10) {
            return this.f14222a.contains(t10) || this.f14223b.contains(t10);
        }

        @Override // com.ironsource.ob
        public int size() {
            return this.f14222a.size() + this.f14223b.size();
        }

        @Override // com.ironsource.ob
        @NotNull
        public List<T> value() {
            return kotlin.collections.d0.A0(this.f14222a, this.f14223b);
        }
    }

    public static final class b<T> implements ob<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final ob<T> f14224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final Comparator<T> f14225b;

        public b(@NotNull ob<T> collection, @NotNull Comparator<T> comparator) {
            kotlin.jvm.internal.t.i(collection, "collection");
            kotlin.jvm.internal.t.i(comparator, "comparator");
            this.f14224a = collection;
            this.f14225b = comparator;
        }

        @Override // com.ironsource.ob
        public boolean contains(T t10) {
            return this.f14224a.contains(t10);
        }

        @Override // com.ironsource.ob
        public int size() {
            return this.f14224a.size();
        }

        @Override // com.ironsource.ob
        @NotNull
        public List<T> value() {
            return kotlin.collections.d0.I0(this.f14224a.value(), this.f14225b);
        }
    }

    public static final class c<T> implements ob<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f14226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final List<T> f14227b;

        public c(@NotNull ob<T> collection, int i10) {
            kotlin.jvm.internal.t.i(collection, "collection");
            this.f14226a = i10;
            this.f14227b = collection.value();
        }

        @NotNull
        public final List<T> a() {
            int size = this.f14227b.size();
            int i10 = this.f14226a;
            if (size <= i10) {
                return kotlin.collections.v.l();
            }
            List<T> list = this.f14227b;
            return list.subList(i10, list.size());
        }

        @NotNull
        public final List<T> b() {
            List<T> list = this.f14227b;
            return list.subList(0, n9.o.j(list.size(), this.f14226a));
        }

        @Override // com.ironsource.ob
        public boolean contains(T t10) {
            return this.f14227b.contains(t10);
        }

        @Override // com.ironsource.ob
        public int size() {
            return this.f14227b.size();
        }

        @Override // com.ironsource.ob
        @NotNull
        public List<T> value() {
            return this.f14227b;
        }
    }

    boolean contains(T t10);

    int size();

    @NotNull
    List<T> value();
}
