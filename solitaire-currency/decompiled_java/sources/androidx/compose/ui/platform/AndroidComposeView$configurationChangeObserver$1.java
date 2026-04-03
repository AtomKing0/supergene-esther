package androidx.compose.ui.platform;

import android.content.res.Configuration;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidComposeView.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidComposeView$configurationChangeObserver$1 extends kotlin.jvm.internal.v implements h9.l<Configuration, v8.k0> {
    public static final AndroidComposeView$configurationChangeObserver$1 INSTANCE = new AndroidComposeView$configurationChangeObserver$1();

    AndroidComposeView$configurationChangeObserver$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Configuration it) {
        kotlin.jvm.internal.t.i(it, "it");
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(Configuration configuration) {
        invoke2(configuration);
        return v8.k0.f35197a;
    }
}
