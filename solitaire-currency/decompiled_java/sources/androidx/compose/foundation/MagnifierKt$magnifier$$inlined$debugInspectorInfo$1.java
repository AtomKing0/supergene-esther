package androidx.compose.foundation;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MagnifierKt$magnifier$$inlined$debugInspectorInfo$1 extends v implements h9.l<InspectorInfo, k0> {
    final /* synthetic */ h9.l $magnifierCenter$inlined;
    final /* synthetic */ h9.l $sourceCenter$inlined;
    final /* synthetic */ MagnifierStyle $style$inlined;
    final /* synthetic */ float $zoom$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagnifierKt$magnifier$$inlined$debugInspectorInfo$1(h9.l lVar, h9.l lVar2, float f10, MagnifierStyle magnifierStyle) {
        super(1);
        this.$sourceCenter$inlined = lVar;
        this.$magnifierCenter$inlined = lVar2;
        this.$zoom$inlined = f10;
        this.$style$inlined = magnifierStyle;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName(MagnifierKt.isPlatformMagnifierSupported$default(0, 1, null) ? "magnifier" : "magnifier (not supported)");
        inspectorInfo.getProperties().set("sourceCenter", this.$sourceCenter$inlined);
        inspectorInfo.getProperties().set("magnifierCenter", this.$magnifierCenter$inlined);
        inspectorInfo.getProperties().set("zoom", Float.valueOf(this.$zoom$inlined));
        inspectorInfo.getProperties().set(TtmlNode.TAG_STYLE, this.$style$inlined);
    }
}
