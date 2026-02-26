package androidx.compose.ui.util;

import android.os.Trace;
import h9.a;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidTrace.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidTrace_androidKt {
    public static final <T> T trace(@NotNull String sectionName, @NotNull a<? extends T> block) {
        t.i(sectionName, "sectionName");
        t.i(block, "block");
        Trace.beginSection(sectionName);
        try {
            return block.invoke();
        } finally {
            r.b(1);
            Trace.endSection();
            r.a(1);
        }
    }
}
