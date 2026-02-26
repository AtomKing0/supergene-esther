package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import h9.l;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldImplKt$CommonDecorationBox$3$1$1 extends v implements l<Size, k0> {
    final /* synthetic */ float $labelProgress;
    final /* synthetic */ MutableState<Size> $labelSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$CommonDecorationBox$3$1$1(float f10, MutableState<Size> mutableState) {
        super(1);
        this.$labelProgress = f10;
        this.$labelSize = mutableState;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Size size) {
        m1206invokeuvyYCjk(size.m1441unboximpl());
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke-uvyYCjk, reason: not valid java name */
    public final void m1206invokeuvyYCjk(long j10) {
        float fM1436getWidthimpl = Size.m1436getWidthimpl(j10) * this.$labelProgress;
        float fM1433getHeightimpl = Size.m1433getHeightimpl(j10) * this.$labelProgress;
        if (Size.m1436getWidthimpl(this.$labelSize.getValue().m1441unboximpl()) == fM1436getWidthimpl) {
            if (Size.m1433getHeightimpl(this.$labelSize.getValue().m1441unboximpl()) == fM1433getHeightimpl) {
                return;
            }
        }
        this.$labelSize.setValue(Size.m1424boximpl(SizeKt.Size(fM1436getWidthimpl, fM1433getHeightimpl)));
    }
}
