package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.runtime.State;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidParagraphIntrinsics.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class TypefaceDirtyTracker {

    @NotNull
    private final Object initial;

    @NotNull
    private final State<Object> resolveResult;

    public TypefaceDirtyTracker(@NotNull State<? extends Object> resolveResult) {
        t.i(resolveResult, "resolveResult");
        this.resolveResult = resolveResult;
        this.initial = resolveResult.getValue();
    }

    @NotNull
    public final Object getInitial() {
        return this.initial;
    }

    @NotNull
    public final State<Object> getResolveResult() {
        return this.resolveResult;
    }

    @NotNull
    public final Typeface getTypeface() {
        return (Typeface) this.initial;
    }

    public final boolean isStaleResolvedFont() {
        return this.resolveResult.getValue() != this.initial;
    }
}
