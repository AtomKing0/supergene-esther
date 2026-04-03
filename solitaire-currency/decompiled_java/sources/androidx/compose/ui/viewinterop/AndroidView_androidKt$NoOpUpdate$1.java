package androidx.compose.ui.viewinterop;

import android.view.View;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AndroidView.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidView_androidKt$NoOpUpdate$1 extends v implements l<View, k0> {
    public static final AndroidView_androidKt$NoOpUpdate$1 INSTANCE = new AndroidView_androidKt$NoOpUpdate$1();

    AndroidView_androidKt$NoOpUpdate$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull View view) {
        t.i(view, "$this$null");
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(View view) {
        invoke2(view);
        return k0.f35197a;
    }
}
