package da;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CollectionSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class r0<E> extends s<E, Set<? extends E>, LinkedHashSet<E>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final SerialDescriptor f24617b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(@NotNull KSerializer<E> eSerializer) {
        super(eSerializer);
        kotlin.jvm.internal.t.i(eSerializer, "eSerializer");
        this.f24617b = new q0(eSerializer.getDescriptor());
    }

    @Override // da.r, kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.f24617b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public LinkedHashSet<E> a() {
        return new LinkedHashSet<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int b(@NotNull LinkedHashSet<E> linkedHashSet) {
        kotlin.jvm.internal.t.i(linkedHashSet, "<this>");
        return linkedHashSet.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull LinkedHashSet<E> linkedHashSet, int i10) {
        kotlin.jvm.internal.t.i(linkedHashSet, "<this>");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.r
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public void n(@NotNull LinkedHashSet<E> linkedHashSet, int i10, E e10) {
        kotlin.jvm.internal.t.i(linkedHashSet, "<this>");
        linkedHashSet.add(e10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public LinkedHashSet<E> k(@NotNull Set<? extends E> set) {
        kotlin.jvm.internal.t.i(set, "<this>");
        LinkedHashSet<E> linkedHashSet = set instanceof LinkedHashSet ? (LinkedHashSet) set : null;
        return linkedHashSet == null ? new LinkedHashSet<>(set) : linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public Set<E> l(@NotNull LinkedHashSet<E> linkedHashSet) {
        kotlin.jvm.internal.t.i(linkedHashSet, "<this>");
        return linkedHashSet;
    }
}
