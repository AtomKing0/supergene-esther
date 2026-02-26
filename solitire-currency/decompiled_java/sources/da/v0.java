package da;

import ba.j;
import com.ironsource.v8;
import java.util.Map;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class v0<K, V> extends n0<K, V, Map.Entry<? extends K, ? extends V>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final SerialDescriptor f24635c;

    /* JADX INFO: compiled from: Tuples.kt */
    private static final class a<K, V> implements Map.Entry<K, V>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final K f24636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final V f24637b;

        public a(K k10, V v10) {
            this.f24636a = k10;
            this.f24637b = v10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.t.d(getKey(), aVar.getKey()) && kotlin.jvm.internal.t.d(getValue(), aVar.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f24636a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f24637b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return ((getKey() == null ? 0 : getKey().hashCode()) * 31) + (getValue() != null ? getValue().hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @NotNull
        public String toString() {
            return "MapEntry(key=" + getKey() + ", value=" + getValue() + ')';
        }
    }

    /* JADX INFO: compiled from: Tuples.kt */
    static final class b extends kotlin.jvm.internal.v implements h9.l<ba.a, v8.k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ KSerializer<K> f24638g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ KSerializer<V> f24639h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
            super(1);
            this.f24638g = kSerializer;
            this.f24639h = kSerializer2;
        }

        public final void a(@NotNull ba.a buildSerialDescriptor) {
            kotlin.jvm.internal.t.i(buildSerialDescriptor, "$this$buildSerialDescriptor");
            ba.a.b(buildSerialDescriptor, v8.h.W, this.f24638g.getDescriptor(), null, false, 12, null);
            ba.a.b(buildSerialDescriptor, "value", this.f24639h.getDescriptor(), null, false, 12, null);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(ba.a aVar) {
            a(aVar);
            return v8.k0.f35197a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(@NotNull KSerializer<K> keySerializer, @NotNull KSerializer<V> valueSerializer) {
        super(keySerializer, valueSerializer, null);
        kotlin.jvm.internal.t.i(keySerializer, "keySerializer");
        kotlin.jvm.internal.t.i(valueSerializer, "valueSerializer");
        this.f24635c = ba.h.c("kotlin.collections.Map.Entry", j.c.f2323a, new SerialDescriptor[0], new b(keySerializer, valueSerializer));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.n0
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public K a(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.t.i(entry, "<this>");
        return entry.getKey();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.n0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public V b(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.t.i(entry, "<this>");
        return entry.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.n0
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map.Entry<K, V> c(K k10, V v10) {
        return new a(k10, v10);
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.f24635c;
    }
}
