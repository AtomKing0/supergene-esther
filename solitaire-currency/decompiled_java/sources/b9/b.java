package b9;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EnumEntries.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b {
    @NotNull
    public static final <E extends Enum<E>> a<E> a(@NotNull E[] entries) {
        t.i(entries, "entries");
        return new c(entries);
    }
}
