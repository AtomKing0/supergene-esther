package androidx.compose.foundation.text;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextStyle;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MaxLinesHeightModifierKt$maxLinesHeight$$inlined$debugInspectorInfo$1 extends v implements l<InspectorInfo, k0> {
    final /* synthetic */ int $maxLines$inlined;
    final /* synthetic */ TextStyle $textStyle$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxLinesHeightModifierKt$maxLinesHeight$$inlined$debugInspectorInfo$1(int i10, TextStyle textStyle) {
        super(1);
        this.$maxLines$inlined = i10;
        this.$textStyle$inlined = textStyle;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("maxLinesHeight");
        inspectorInfo.getProperties().set("maxLines", Integer.valueOf(this.$maxLines$inlined));
        inspectorInfo.getProperties().set("textStyle", this.$textStyle$inlined);
    }
}
