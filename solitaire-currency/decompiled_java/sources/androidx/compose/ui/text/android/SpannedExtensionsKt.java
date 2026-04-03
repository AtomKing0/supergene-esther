package androidx.compose.ui.text.android;

import android.text.Spanned;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SpannedExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SpannedExtensionsKt {
    public static final boolean hasSpan(@NotNull Spanned spanned, @NotNull Class<?> clazz) {
        t.i(spanned, "<this>");
        t.i(clazz, "clazz");
        return spanned.nextSpanTransition(-1, spanned.length(), clazz) != spanned.length();
    }

    public static final boolean hasSpan(@NotNull Spanned spanned, @NotNull Class<?> clazz, int i10, int i11) {
        t.i(spanned, "<this>");
        t.i(clazz, "clazz");
        return spanned.nextSpanTransition(i10 - 1, i11, clazz) != i11;
    }
}
