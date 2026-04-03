package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Overscroll.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OverscrollKt {
    @ExperimentalFoundationApi
    @NotNull
    public static final Modifier overscroll(@NotNull Modifier modifier, @NotNull OverscrollEffect overscrollEffect) {
        t.i(modifier, "<this>");
        t.i(overscrollEffect, "overscrollEffect");
        return modifier.then(overscrollEffect.getEffectModifier());
    }
}
