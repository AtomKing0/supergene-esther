package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: renamed from: androidx.compose.foundation.layout.PaddingKt$padding-qDBjuR0$$inlined$debugInspectorInfo$1, reason: invalid class name */
/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PaddingKt$paddingqDBjuR0$$inlined$debugInspectorInfo$1 extends v implements h9.l<InspectorInfo, k0> {
    final /* synthetic */ float $bottom$inlined;
    final /* synthetic */ float $end$inlined;
    final /* synthetic */ float $start$inlined;
    final /* synthetic */ float $top$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaddingKt$paddingqDBjuR0$$inlined$debugInspectorInfo$1(float f10, float f11, float f12, float f13) {
        super(1);
        this.$start$inlined = f10;
        this.$top$inlined = f11;
        this.$end$inlined = f12;
        this.$bottom$inlined = f13;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("padding");
        inspectorInfo.getProperties().set(TtmlNode.START, Dp.m3671boximpl(this.$start$inlined));
        inspectorInfo.getProperties().set("top", Dp.m3671boximpl(this.$top$inlined));
        inspectorInfo.getProperties().set(TtmlNode.END, Dp.m3671boximpl(this.$end$inlined));
        inspectorInfo.getProperties().set("bottom", Dp.m3671boximpl(this.$bottom$inlined));
    }
}
