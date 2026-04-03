package z9;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SerializationExceptions.kt */
/* JADX INFO: loaded from: classes5.dex */
public class i extends IllegalArgumentException {
    public i(@Nullable String str) {
        super(str);
    }

    public i(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }
}
