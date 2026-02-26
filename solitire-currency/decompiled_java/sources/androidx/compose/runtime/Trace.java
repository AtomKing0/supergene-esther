package androidx.compose.runtime;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ActualAndroid.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Trace {

    @NotNull
    public static final Trace INSTANCE = new Trace();

    private Trace() {
    }

    @Nullable
    public final Object beginSection(@NotNull String name) {
        t.i(name, "name");
        android.os.Trace.beginSection(name);
        return null;
    }

    public final void endSection(@Nullable Object obj) {
        android.os.Trace.endSection();
    }
}
