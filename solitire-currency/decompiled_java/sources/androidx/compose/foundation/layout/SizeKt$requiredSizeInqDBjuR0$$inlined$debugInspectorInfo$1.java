package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: renamed from: androidx.compose.foundation.layout.SizeKt$requiredSizeIn-qDBjuR0$$inlined$debugInspectorInfo$1, reason: invalid class name */
/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SizeKt$requiredSizeInqDBjuR0$$inlined$debugInspectorInfo$1 extends v implements h9.l<InspectorInfo, k0> {
    final /* synthetic */ float $maxHeight$inlined;
    final /* synthetic */ float $maxWidth$inlined;
    final /* synthetic */ float $minHeight$inlined;
    final /* synthetic */ float $minWidth$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SizeKt$requiredSizeInqDBjuR0$$inlined$debugInspectorInfo$1(float f10, float f11, float f12, float f13) {
        super(1);
        this.$minWidth$inlined = f10;
        this.$minHeight$inlined = f11;
        this.$maxWidth$inlined = f12;
        this.$maxHeight$inlined = f13;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("requiredSizeIn");
        inspectorInfo.getProperties().set("minWidth", Dp.m3671boximpl(this.$minWidth$inlined));
        inspectorInfo.getProperties().set("minHeight", Dp.m3671boximpl(this.$minHeight$inlined));
        inspectorInfo.getProperties().set("maxWidth", Dp.m3671boximpl(this.$maxWidth$inlined));
        inspectorInfo.getProperties().set("maxHeight", Dp.m3671boximpl(this.$maxHeight$inlined));
    }
}
