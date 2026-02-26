package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.InspectorInfo;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PainterModifierKt$paint$$inlined$debugInspectorInfo$1 extends v implements l<InspectorInfo, k0> {
    final /* synthetic */ Alignment $alignment$inlined;
    final /* synthetic */ float $alpha$inlined;
    final /* synthetic */ ColorFilter $colorFilter$inlined;
    final /* synthetic */ ContentScale $contentScale$inlined;
    final /* synthetic */ Painter $painter$inlined;
    final /* synthetic */ boolean $sizeToIntrinsics$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PainterModifierKt$paint$$inlined$debugInspectorInfo$1(Painter painter, boolean z10, Alignment alignment, ContentScale contentScale, float f10, ColorFilter colorFilter) {
        super(1);
        this.$painter$inlined = painter;
        this.$sizeToIntrinsics$inlined = z10;
        this.$alignment$inlined = alignment;
        this.$contentScale$inlined = contentScale;
        this.$alpha$inlined = f10;
        this.$colorFilter$inlined = colorFilter;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("paint");
        inspectorInfo.getProperties().set("painter", this.$painter$inlined);
        inspectorInfo.getProperties().set("sizeToIntrinsics", Boolean.valueOf(this.$sizeToIntrinsics$inlined));
        inspectorInfo.getProperties().set("alignment", this.$alignment$inlined);
        inspectorInfo.getProperties().set("contentScale", this.$contentScale$inlined);
        inspectorInfo.getProperties().set("alpha", Float.valueOf(this.$alpha$inlined));
        inspectorInfo.getProperties().set("colorFilter", this.$colorFilter$inlined);
    }
}
