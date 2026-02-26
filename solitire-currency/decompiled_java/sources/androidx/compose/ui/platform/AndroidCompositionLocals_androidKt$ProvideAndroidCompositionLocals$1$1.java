package androidx.compose.ui.platform;

import android.content.res.Configuration;
import androidx.compose.runtime.MutableState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidCompositionLocals.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1 extends kotlin.jvm.internal.v implements h9.l<Configuration, v8.k0> {
    final /* synthetic */ MutableState<Configuration> $configuration$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1(MutableState<Configuration> mutableState) {
        super(1);
        this.$configuration$delegate = mutableState;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(Configuration configuration) {
        invoke2(configuration);
        return v8.k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Configuration it) {
        kotlin.jvm.internal.t.i(it, "it");
        this.$configuration$delegate.setValue(it);
    }
}
