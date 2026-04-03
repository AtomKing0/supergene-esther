package o9;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SequenceBuilder.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class i<T> {
    @Nullable
    public abstract Object a(T t10, @NotNull z8.d<? super k0> dVar);

    @Nullable
    public abstract Object c(@NotNull Iterator<? extends T> it, @NotNull z8.d<? super k0> dVar);

    @Nullable
    public final Object e(@NotNull g<? extends T> gVar, @NotNull z8.d<? super k0> dVar) {
        Object objC = c(gVar.iterator(), dVar);
        return objC == a9.d.e() ? objC : k0.f35197a;
    }
}
