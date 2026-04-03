package androidx.compose.ui.platform;

import android.graphics.Matrix;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RenderNodeLayer.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class RenderNodeLayer$Companion$getMatrix$1 extends kotlin.jvm.internal.v implements h9.p<DeviceRenderNode, Matrix, v8.k0> {
    public static final RenderNodeLayer$Companion$getMatrix$1 INSTANCE = new RenderNodeLayer$Companion$getMatrix$1();

    RenderNodeLayer$Companion$getMatrix$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ v8.k0 mo4invoke(DeviceRenderNode deviceRenderNode, Matrix matrix) {
        invoke2(deviceRenderNode, matrix);
        return v8.k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull DeviceRenderNode rn, @NotNull Matrix matrix) {
        kotlin.jvm.internal.t.i(rn, "rn");
        kotlin.jvm.internal.t.i(matrix, "matrix");
        rn.getMatrix(matrix);
    }
}
