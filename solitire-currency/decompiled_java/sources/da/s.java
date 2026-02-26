package da;

import java.util.Collection;
import java.util.Iterator;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CollectionSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class s<E, C extends Collection<? extends E>, B> extends r<E, C, B> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(@NotNull KSerializer<E> element) {
        super(element, null);
        kotlin.jvm.internal.t.i(element, "element");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Iterator<E> d(@NotNull C c10) {
        kotlin.jvm.internal.t.i(c10, "<this>");
        return c10.iterator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public int e(@NotNull C c10) {
        kotlin.jvm.internal.t.i(c10, "<this>");
        return c10.size();
    }
}
