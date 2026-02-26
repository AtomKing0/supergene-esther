package androidx.compose.runtime;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Trace.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TraceKt {
    public static final <T> T trace(@NotNull String sectionName, @NotNull h9.a<? extends T> block) {
        t.i(sectionName, "sectionName");
        t.i(block, "block");
        Trace trace = Trace.INSTANCE;
        Object objBeginSection = trace.beginSection(sectionName);
        try {
            T tInvoke = block.invoke();
            r.b(1);
            trace.endSection(objBeginSection);
            r.a(1);
            return tInvoke;
        } catch (Throwable th) {
            r.b(1);
            Trace.INSTANCE.endSection(objBeginSection);
            r.a(1);
            throw th;
        }
    }
}
