package da;

import java.util.HashSet;
import java.util.Set;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CollectionSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h0<E> extends s<E, Set<? extends E>, HashSet<E>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final SerialDescriptor f24576b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(@NotNull KSerializer<E> eSerializer) {
        super(eSerializer);
        kotlin.jvm.internal.t.i(eSerializer, "eSerializer");
        this.f24576b = new g0(eSerializer.getDescriptor());
    }

    @Override // da.r, kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.f24576b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public HashSet<E> a() {
        return new HashSet<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int b(@NotNull HashSet<E> hashSet) {
        kotlin.jvm.internal.t.i(hashSet, "<this>");
        return hashSet.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull HashSet<E> hashSet, int i10) {
        kotlin.jvm.internal.t.i(hashSet, "<this>");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.r
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public void n(@NotNull HashSet<E> hashSet, int i10, E e10) {
        kotlin.jvm.internal.t.i(hashSet, "<this>");
        hashSet.add(e10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public HashSet<E> k(@NotNull Set<? extends E> set) {
        kotlin.jvm.internal.t.i(set, "<this>");
        HashSet<E> hashSet = set instanceof HashSet ? (HashSet) set : null;
        return hashSet == null ? new HashSet<>(set) : hashSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public Set<E> l(@NotNull HashSet<E> hashSet) {
        kotlin.jvm.internal.t.i(hashSet, "<this>");
        return hashSet;
    }
}
