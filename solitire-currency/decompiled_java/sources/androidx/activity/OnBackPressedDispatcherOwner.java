package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OnBackPressedDispatcherOwner.kt */
/* JADX INFO: loaded from: classes.dex */
public interface OnBackPressedDispatcherOwner extends LifecycleOwner {
    @NotNull
    OnBackPressedDispatcher getOnBackPressedDispatcher();
}
