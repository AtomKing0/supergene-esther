package androidx.core.os;

import android.os.Trace;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Trace.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TraceKt {
    public static final <T> T trace(@NotNull String str, @NotNull h9.a<? extends T> aVar) {
        Trace.beginSection(str);
        try {
            return aVar.invoke();
        } finally {
            r.b(1);
            Trace.endSection();
            r.a(1);
        }
    }
}
