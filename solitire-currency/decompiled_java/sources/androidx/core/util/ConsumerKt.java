package androidx.core.util;

import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlatformConsumer.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public final class ConsumerKt {
    @RequiresApi(24)
    @NotNull
    public static final <T> java.util.function.Consumer<T> asConsumer(@NotNull z8.d<? super T> dVar) {
        return new ContinuationConsumer(dVar);
    }
}
