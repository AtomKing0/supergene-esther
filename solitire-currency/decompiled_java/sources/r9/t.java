package r9;

import java.util.concurrent.CancellationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface t<E> {
    void cancel(@Nullable CancellationException cancellationException);

    @Nullable
    Object e(@NotNull z8.d<? super h<? extends E>> dVar);

    @NotNull
    Object h();

    @NotNull
    f<E> iterator();

    @Nullable
    Object s(@NotNull z8.d<? super E> dVar);
}
