package da;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d1<K, V> extends n0<K, V, v8.s<? extends K, ? extends V>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final SerialDescriptor f24558c;

    /* JADX INFO: compiled from: Tuples.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.l<ba.a, v8.k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ KSerializer<K> f24559g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ KSerializer<V> f24560h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
            super(1);
            this.f24559g = kSerializer;
            this.f24560h = kSerializer2;
        }

        public final void a(@NotNull ba.a buildClassSerialDescriptor) {
            kotlin.jvm.internal.t.i(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            ba.a.b(buildClassSerialDescriptor, "first", this.f24559g.getDescriptor(), null, false, 12, null);
            ba.a.b(buildClassSerialDescriptor, "second", this.f24560h.getDescriptor(), null, false, 12, null);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(ba.a aVar) {
            a(aVar);
            return v8.k0.f35197a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d1(@NotNull KSerializer<K> keySerializer, @NotNull KSerializer<V> valueSerializer) {
        super(keySerializer, valueSerializer, null);
        kotlin.jvm.internal.t.i(keySerializer, "keySerializer");
        kotlin.jvm.internal.t.i(valueSerializer, "valueSerializer");
        this.f24558c = ba.h.b("kotlin.Pair", new SerialDescriptor[0], new a(keySerializer, valueSerializer));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.n0
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public K a(@NotNull v8.s<? extends K, ? extends V> sVar) {
        kotlin.jvm.internal.t.i(sVar, "<this>");
        return sVar.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.n0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public V b(@NotNull v8.s<? extends K, ? extends V> sVar) {
        kotlin.jvm.internal.t.i(sVar, "<this>");
        return sVar.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.n0
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public v8.s<K, V> c(K k10, V v10) {
        return v8.y.a(k10, v10);
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.f24558c;
    }
}
