package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: renamed from: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1, reason: invalid class name */
/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AlignmentLineKt$paddingFrom4j6BHR0$$inlined$debugInspectorInfo$1 extends v implements h9.l<InspectorInfo, k0> {
    final /* synthetic */ float $after$inlined;
    final /* synthetic */ AlignmentLine $alignmentLine$inlined;
    final /* synthetic */ float $before$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlignmentLineKt$paddingFrom4j6BHR0$$inlined$debugInspectorInfo$1(AlignmentLine alignmentLine, float f10, float f11) {
        super(1);
        this.$alignmentLine$inlined = alignmentLine;
        this.$before$inlined = f10;
        this.$after$inlined = f11;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("paddingFrom");
        inspectorInfo.getProperties().set("alignmentLine", this.$alignmentLine$inlined);
        inspectorInfo.getProperties().set(TtmlNode.ANNOTATION_POSITION_BEFORE, Dp.m3671boximpl(this.$before$inlined));
        inspectorInfo.getProperties().set(TtmlNode.ANNOTATION_POSITION_AFTER, Dp.m3671boximpl(this.$after$inlined));
    }
}
