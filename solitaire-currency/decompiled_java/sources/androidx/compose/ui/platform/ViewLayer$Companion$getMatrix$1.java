package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.View;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ViewLayer.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class ViewLayer$Companion$getMatrix$1 extends kotlin.jvm.internal.v implements h9.p<View, Matrix, v8.k0> {
    public static final ViewLayer$Companion$getMatrix$1 INSTANCE = new ViewLayer$Companion$getMatrix$1();

    ViewLayer$Companion$getMatrix$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ v8.k0 mo4invoke(View view, Matrix matrix) {
        invoke2(view, matrix);
        return v8.k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull View view, @NotNull Matrix matrix) {
        kotlin.jvm.internal.t.i(view, "view");
        kotlin.jvm.internal.t.i(matrix, "matrix");
        matrix.set(view.getMatrix());
    }
}
