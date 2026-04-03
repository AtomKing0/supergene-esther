package androidx.core.util;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidXConsumer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidXConsumerKt {
    @NotNull
    public static final <T> Consumer<T> asAndroidXConsumer(@NotNull z8.d<? super T> dVar) {
        return new AndroidXContinuationConsumer(dVar);
    }
}
