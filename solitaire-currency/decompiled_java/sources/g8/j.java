package g8;

import java.util.Collections;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CollectionsJvm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    @NotNull
    public static final <T> Set<T> a(@NotNull Set<? extends T> set) {
        kotlin.jvm.internal.t.i(set, "<this>");
        Set<T> setUnmodifiableSet = Collections.unmodifiableSet(set);
        kotlin.jvm.internal.t.h(setUnmodifiableSet, "unmodifiableSet(this)");
        return setUnmodifiableSet;
    }
}
