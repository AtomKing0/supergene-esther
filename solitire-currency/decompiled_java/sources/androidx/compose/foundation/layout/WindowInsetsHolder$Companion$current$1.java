package androidx.compose.foundation.layout;

import android.view.View;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WindowInsets.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class WindowInsetsHolder$Companion$current$1 extends v implements h9.l<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ WindowInsetsHolder $insets;
    final /* synthetic */ View $view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowInsetsHolder$Companion$current$1(WindowInsetsHolder windowInsetsHolder, View view) {
        super(1);
        this.$insets = windowInsetsHolder;
        this.$view = view;
    }

    @Override // h9.l
    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
        t.i(DisposableEffect, "$this$DisposableEffect");
        this.$insets.incrementAccessors(this.$view);
        final WindowInsetsHolder windowInsetsHolder = this.$insets;
        final View view = this.$view;
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.layout.WindowInsetsHolder$Companion$current$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                windowInsetsHolder.decrementAccessors(view);
            }
        };
    }
}
