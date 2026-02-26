package androidx.compose.ui.modifier;

import androidx.compose.ui.platform.InspectorInfo;
import com.ironsource.v8;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModifierLocalProviderKt$modifierLocalProvider$$inlined$debugInspectorInfo$1 extends v implements l<InspectorInfo, k0> {
    final /* synthetic */ ProvidableModifierLocal $key$inlined;
    final /* synthetic */ h9.a $value$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModifierLocalProviderKt$modifierLocalProvider$$inlined$debugInspectorInfo$1(ProvidableModifierLocal providableModifierLocal, h9.a aVar) {
        super(1);
        this.$key$inlined = providableModifierLocal;
        this.$value$inlined = aVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("modifierLocalProvider");
        inspectorInfo.getProperties().set(v8.h.W, this.$key$inlined);
        inspectorInfo.getProperties().set("value", this.$value$inlined);
    }
}
