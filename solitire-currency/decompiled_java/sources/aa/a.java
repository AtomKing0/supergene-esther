package aa;

import da.b1;
import da.c2;
import da.d1;
import da.e2;
import da.g2;
import da.i2;
import da.j2;
import da.l0;
import da.o;
import da.p0;
import da.q1;
import da.u0;
import da.v0;
import da.v1;
import da.w;
import da.w1;
import da.x;
import da.z1;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.q0;
import kotlin.jvm.internal.s0;
import kotlin.jvm.internal.t;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.c;
import kotlinx.serialization.internal.d;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.f;
import kotlinx.serialization.internal.g;
import kotlinx.serialization.internal.h;
import kotlinx.serialization.internal.i;
import kotlinx.serialization.internal.j;
import kotlinx.serialization.internal.k;
import kotlinx.serialization.internal.l;
import org.jetbrains.annotations.NotNull;
import q9.b;
import v8.a0;
import v8.b0;
import v8.c0;
import v8.d0;
import v8.e0;
import v8.f0;
import v8.h0;
import v8.i0;
import v8.k0;
import v8.s;

/* JADX INFO: compiled from: BuiltinSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a {
    @NotNull
    public static final KSerializer<Short> A(@NotNull q0 q0Var) {
        t.i(q0Var, "<this>");
        return v1.f24640a;
    }

    @NotNull
    public static final KSerializer<String> B(@NotNull s0 s0Var) {
        t.i(s0Var, "<this>");
        return w1.f24648a;
    }

    @NotNull
    public static final KSerializer<b> C(@NotNull b.a aVar) {
        t.i(aVar, "<this>");
        return x.f24650a;
    }

    @NotNull
    public static final KSerializer<a0> D(@NotNull a0.a aVar) {
        t.i(aVar, "<this>");
        return c2.f24556a;
    }

    @NotNull
    public static final KSerializer<c0> E(@NotNull c0.a aVar) {
        t.i(aVar, "<this>");
        return e2.f24564a;
    }

    @NotNull
    public static final KSerializer<e0> F(@NotNull e0.a aVar) {
        t.i(aVar, "<this>");
        return g2.f24572a;
    }

    @NotNull
    public static final KSerializer<h0> G(@NotNull h0.a aVar) {
        t.i(aVar, "<this>");
        return i2.f24583a;
    }

    @NotNull
    public static final KSerializer<k0> H(@NotNull k0 k0Var) {
        t.i(k0Var, "<this>");
        return j2.f24588b;
    }

    @NotNull
    public static final <T, E extends T> KSerializer<E[]> a(@NotNull KClass<T> kClass, @NotNull KSerializer<E> elementSerializer) {
        t.i(kClass, "kClass");
        t.i(elementSerializer, "elementSerializer");
        return new q1(kClass, elementSerializer);
    }

    @NotNull
    public static final KSerializer<boolean[]> b() {
        return kotlinx.serialization.internal.a.f30014c;
    }

    @NotNull
    public static final KSerializer<byte[]> c() {
        return kotlinx.serialization.internal.b.f30015c;
    }

    @NotNull
    public static final KSerializer<char[]> d() {
        return c.f30016c;
    }

    @NotNull
    public static final KSerializer<double[]> e() {
        return d.f30017c;
    }

    @NotNull
    public static final KSerializer<float[]> f() {
        return e.f30018c;
    }

    @NotNull
    public static final KSerializer<int[]> g() {
        return f.f30019c;
    }

    @NotNull
    public static final <T> KSerializer<List<T>> h(@NotNull KSerializer<T> elementSerializer) {
        t.i(elementSerializer, "elementSerializer");
        return new da.f(elementSerializer);
    }

    @NotNull
    public static final KSerializer<long[]> i() {
        return g.f30020c;
    }

    @NotNull
    public static final <K, V> KSerializer<Map.Entry<K, V>> j(@NotNull KSerializer<K> keySerializer, @NotNull KSerializer<V> valueSerializer) {
        t.i(keySerializer, "keySerializer");
        t.i(valueSerializer, "valueSerializer");
        return new v0(keySerializer, valueSerializer);
    }

    @NotNull
    public static final <K, V> KSerializer<Map<K, V>> k(@NotNull KSerializer<K> keySerializer, @NotNull KSerializer<V> valueSerializer) {
        t.i(keySerializer, "keySerializer");
        t.i(valueSerializer, "valueSerializer");
        return new p0(keySerializer, valueSerializer);
    }

    @NotNull
    public static final <K, V> KSerializer<s<K, V>> l(@NotNull KSerializer<K> keySerializer, @NotNull KSerializer<V> valueSerializer) {
        t.i(keySerializer, "keySerializer");
        t.i(valueSerializer, "valueSerializer");
        return new d1(keySerializer, valueSerializer);
    }

    @NotNull
    public static final KSerializer<short[]> m() {
        return h.f30021c;
    }

    @NotNull
    public static final <A, B, C> KSerializer<v8.x<A, B, C>> n(@NotNull KSerializer<A> aSerializer, @NotNull KSerializer<B> bSerializer, @NotNull KSerializer<C> cSerializer) {
        t.i(aSerializer, "aSerializer");
        t.i(bSerializer, "bSerializer");
        t.i(cSerializer, "cSerializer");
        return new z1(aSerializer, bSerializer, cSerializer);
    }

    @NotNull
    public static final KSerializer<b0> o() {
        return i.f30022c;
    }

    @NotNull
    public static final KSerializer<d0> p() {
        return j.f30023c;
    }

    @NotNull
    public static final KSerializer<f0> q() {
        return k.f30024c;
    }

    @NotNull
    public static final KSerializer<i0> r() {
        return l.f30025c;
    }

    @NotNull
    public static final <T> KSerializer<T> s(@NotNull KSerializer<T> kSerializer) {
        t.i(kSerializer, "<this>");
        return kSerializer.getDescriptor().b() ? kSerializer : new b1(kSerializer);
    }

    @NotNull
    public static final KSerializer<Boolean> t(@NotNull kotlin.jvm.internal.d dVar) {
        t.i(dVar, "<this>");
        return da.h.f24574a;
    }

    @NotNull
    public static final KSerializer<Byte> u(@NotNull kotlin.jvm.internal.e eVar) {
        t.i(eVar, "<this>");
        return da.j.f24585a;
    }

    @NotNull
    public static final KSerializer<Character> v(@NotNull kotlin.jvm.internal.g gVar) {
        t.i(gVar, "<this>");
        return o.f24603a;
    }

    @NotNull
    public static final KSerializer<Double> w(@NotNull kotlin.jvm.internal.l lVar) {
        t.i(lVar, "<this>");
        return w.f24642a;
    }

    @NotNull
    public static final KSerializer<Float> x(@NotNull m mVar) {
        t.i(mVar, "<this>");
        return da.c0.f24548a;
    }

    @NotNull
    public static final KSerializer<Integer> y(@NotNull kotlin.jvm.internal.s sVar) {
        t.i(sVar, "<this>");
        return l0.f24594a;
    }

    @NotNull
    public static final KSerializer<Long> z(@NotNull kotlin.jvm.internal.w wVar) {
        t.i(wVar, "<this>");
        return u0.f24629a;
    }
}
