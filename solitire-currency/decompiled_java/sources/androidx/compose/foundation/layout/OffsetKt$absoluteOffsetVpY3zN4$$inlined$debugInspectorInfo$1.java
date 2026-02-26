package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import io.sentry.protocol.ViewHierarchyNode;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: renamed from: androidx.compose.foundation.layout.OffsetKt$absoluteOffset-VpY3zN4$$inlined$debugInspectorInfo$1, reason: invalid class name */
/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OffsetKt$absoluteOffsetVpY3zN4$$inlined$debugInspectorInfo$1 extends v implements h9.l<InspectorInfo, k0> {
    final /* synthetic */ float $x$inlined;
    final /* synthetic */ float $y$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OffsetKt$absoluteOffsetVpY3zN4$$inlined$debugInspectorInfo$1(float f10, float f11) {
        super(1);
        this.$x$inlined = f10;
        this.$y$inlined = f11;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("absoluteOffset");
        inspectorInfo.getProperties().set(ViewHierarchyNode.JsonKeys.X, Dp.m3671boximpl(this.$x$inlined));
        inspectorInfo.getProperties().set(ViewHierarchyNode.JsonKeys.Y, Dp.m3671boximpl(this.$y$inlined));
    }
}
