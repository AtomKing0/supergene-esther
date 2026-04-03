package androidx.compose.foundation;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: renamed from: androidx.compose.foundation.BorderKt$border-ziNgDLE$$inlined$debugInspectorInfo$1, reason: invalid class name */
/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BorderKt$borderziNgDLE$$inlined$debugInspectorInfo$1 extends v implements h9.l<InspectorInfo, k0> {
    final /* synthetic */ Brush $brush$inlined;
    final /* synthetic */ Shape $shape$inlined;
    final /* synthetic */ float $width$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BorderKt$borderziNgDLE$$inlined$debugInspectorInfo$1(float f10, Brush brush, Shape shape) {
        super(1);
        this.$width$inlined = f10;
        this.$brush$inlined = brush;
        this.$shape$inlined = shape;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName(OutlinedTextFieldKt.BorderId);
        inspectorInfo.getProperties().set("width", Dp.m3671boximpl(this.$width$inlined));
        if (this.$brush$inlined instanceof SolidColor) {
            inspectorInfo.getProperties().set("color", Color.m1588boximpl(((SolidColor) this.$brush$inlined).m1867getValue0d7_KjU()));
            inspectorInfo.setValue(Color.m1588boximpl(((SolidColor) this.$brush$inlined).m1867getValue0d7_KjU()));
        } else {
            inspectorInfo.getProperties().set("brush", this.$brush$inlined);
        }
        inspectorInfo.getProperties().set("shape", this.$shape$inlined);
    }
}
