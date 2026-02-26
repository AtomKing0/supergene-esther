package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: OnBackPressedDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcherKt {
    @NotNull
    public static final OnBackPressedCallback addCallback(@NotNull OnBackPressedDispatcher onBackPressedDispatcher, @Nullable LifecycleOwner lifecycleOwner, final boolean z10, @NotNull final h9.l<? super OnBackPressedCallback, k0> onBackPressed) {
        t.i(onBackPressedDispatcher, "<this>");
        t.i(onBackPressed, "onBackPressed");
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(z10) { // from class: androidx.activity.OnBackPressedDispatcherKt$addCallback$callback$1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                onBackPressed.invoke(this);
            }
        };
        if (lifecycleOwner != null) {
            onBackPressedDispatcher.addCallback(lifecycleOwner, onBackPressedCallback);
        } else {
            onBackPressedDispatcher.addCallback(onBackPressedCallback);
        }
        return onBackPressedCallback;
    }

    public static /* synthetic */ OnBackPressedCallback addCallback$default(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean z10, h9.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lifecycleOwner = null;
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return addCallback(onBackPressedDispatcher, lifecycleOwner, z10, lVar);
    }
}
