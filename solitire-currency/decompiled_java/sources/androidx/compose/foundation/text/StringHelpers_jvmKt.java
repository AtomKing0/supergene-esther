package androidx.compose.foundation.text;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StringHelpers.jvm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StringHelpers_jvmKt {
    @NotNull
    public static final StringBuilder appendCodePointX(@NotNull StringBuilder sb, int i10) {
        t.i(sb, "<this>");
        StringBuilder appendCodePointX = sb.appendCodePoint(i10);
        t.h(appendCodePointX, "appendCodePointX");
        return appendCodePointX;
    }
}
