package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ExperimentalComposeUiApi;
import h9.l;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: PointerInteropFilter.android.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
public final class RequestDisallowInterceptTouchEvent implements l<Boolean, k0> {
    public static final int $stable = 8;

    @Nullable
    private PointerInteropFilter pointerInteropFilter;

    @Nullable
    public final PointerInteropFilter getPointerInteropFilter$ui_release() {
        return this.pointerInteropFilter;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return k0.f35197a;
    }

    public final void setPointerInteropFilter$ui_release(@Nullable PointerInteropFilter pointerInteropFilter) {
        this.pointerInteropFilter = pointerInteropFilter;
    }

    public void invoke(boolean z10) {
        PointerInteropFilter pointerInteropFilter = this.pointerInteropFilter;
        if (pointerInteropFilter == null) {
            return;
        }
        pointerInteropFilter.setDisallowIntercept$ui_release(z10);
    }
}
