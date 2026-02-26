package da;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CollectionSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class p0<K, V> extends x0<K, V, Map<K, ? extends V>, LinkedHashMap<K, V>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final SerialDescriptor f24610c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(@NotNull KSerializer<K> kSerializer, @NotNull KSerializer<V> vSerializer) {
        super(kSerializer, vSerializer, null);
        kotlin.jvm.internal.t.i(kSerializer, "kSerializer");
        kotlin.jvm.internal.t.i(vSerializer, "vSerializer");
        this.f24610c = new o0(kSerializer.getDescriptor(), vSerializer.getDescriptor());
    }

    @Override // da.x0, kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.f24610c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public LinkedHashMap<K, V> a() {
        return new LinkedHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int b(@NotNull LinkedHashMap<K, V> linkedHashMap) {
        kotlin.jvm.internal.t.i(linkedHashMap, "<this>");
        return linkedHashMap.size() * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull LinkedHashMap<K, V> linkedHashMap, int i10) {
        kotlin.jvm.internal.t.i(linkedHashMap, "<this>");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public Iterator<Map.Entry<K, V>> d(@NotNull Map<K, ? extends V> map) {
        kotlin.jvm.internal.t.i(map, "<this>");
        return map.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int e(@NotNull Map<K, ? extends V> map) {
        kotlin.jvm.internal.t.i(map, "<this>");
        return map.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public LinkedHashMap<K, V> k(@NotNull Map<K, ? extends V> map) {
        kotlin.jvm.internal.t.i(map, "<this>");
        LinkedHashMap<K, V> linkedHashMap = map instanceof LinkedHashMap ? (LinkedHashMap) map : null;
        return linkedHashMap == null ? new LinkedHashMap<>(map) : linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public Map<K, V> l(@NotNull LinkedHashMap<K, V> linkedHashMap) {
        kotlin.jvm.internal.t.i(linkedHashMap, "<this>");
        return linkedHashMap;
    }
}
