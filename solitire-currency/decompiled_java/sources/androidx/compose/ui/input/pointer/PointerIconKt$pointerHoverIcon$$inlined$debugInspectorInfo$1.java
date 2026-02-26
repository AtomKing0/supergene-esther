package androidx.compose.ui.input.pointer;

import androidx.compose.ui.platform.InspectorInfo;
import com.ironsource.v8;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PointerIconKt$pointerHoverIcon$$inlined$debugInspectorInfo$1 extends v implements l<InspectorInfo, k0> {
    final /* synthetic */ PointerIcon $icon$inlined;
    final /* synthetic */ boolean $overrideDescendants$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointerIconKt$pointerHoverIcon$$inlined$debugInspectorInfo$1(PointerIcon pointerIcon, boolean z10) {
        super(1);
        this.$icon$inlined = pointerIcon;
        this.$overrideDescendants$inlined = z10;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("pointerHoverIcon");
        inspectorInfo.getProperties().set(v8.h.H0, this.$icon$inlined);
        inspectorInfo.getProperties().set("overrideDescendants", Boolean.valueOf(this.$overrideDescendants$inlined));
    }
}
