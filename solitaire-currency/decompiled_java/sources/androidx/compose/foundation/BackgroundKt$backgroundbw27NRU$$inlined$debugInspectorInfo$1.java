package androidx.compose.foundation;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: renamed from: androidx.compose.foundation.BackgroundKt$background-bw27NRU$$inlined$debugInspectorInfo$1, reason: invalid class name */
/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BackgroundKt$backgroundbw27NRU$$inlined$debugInspectorInfo$1 extends v implements h9.l<InspectorInfo, k0> {
    final /* synthetic */ long $color$inlined;
    final /* synthetic */ Shape $shape$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundKt$backgroundbw27NRU$$inlined$debugInspectorInfo$1(long j10, Shape shape) {
        super(1);
        this.$color$inlined = j10;
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
        inspectorInfo.setName("background");
        inspectorInfo.setValue(Color.m1588boximpl(this.$color$inlined));
        inspectorInfo.getProperties().set("color", Color.m1588boximpl(this.$color$inlined));
        inspectorInfo.getProperties().set("shape", this.$shape$inlined);
    }
}
