package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ColumnScopeInstance$weight$$inlined$debugInspectorInfo$1 extends v implements h9.l<InspectorInfo, k0> {
    final /* synthetic */ boolean $fill$inlined;
    final /* synthetic */ float $weight$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColumnScopeInstance$weight$$inlined$debugInspectorInfo$1(float f10, boolean z10) {
        super(1);
        this.$weight$inlined = f10;
        this.$fill$inlined = z10;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("weight");
        inspectorInfo.setValue(Float.valueOf(this.$weight$inlined));
        inspectorInfo.getProperties().set("weight", Float.valueOf(this.$weight$inlined));
        inspectorInfo.getProperties().set("fill", Boolean.valueOf(this.$fill$inlined));
    }
}
