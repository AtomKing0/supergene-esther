package androidx.compose.ui.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.geometry.Rect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: RelocationRequester.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
public final class RelocationRequester {
    public static final int $stable = 0;

    public static /* synthetic */ Object bringIntoView$default(RelocationRequester relocationRequester, Rect rect, z8.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            rect = null;
        }
        return relocationRequester.bringIntoView(rect, dVar);
    }

    @Nullable
    public final Object bringIntoView(@Nullable Rect rect, @NotNull z8.d<? super k0> dVar) {
        return k0.f35197a;
    }
}
