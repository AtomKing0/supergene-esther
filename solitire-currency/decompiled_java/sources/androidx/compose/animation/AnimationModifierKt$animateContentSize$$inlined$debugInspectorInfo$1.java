package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.platform.InspectorInfo;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationModifierKt$animateContentSize$$inlined$debugInspectorInfo$1 extends v implements l<InspectorInfo, k0> {
    final /* synthetic */ FiniteAnimationSpec $animationSpec$inlined;
    final /* synthetic */ p $finishedListener$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimationModifierKt$animateContentSize$$inlined$debugInspectorInfo$1(FiniteAnimationSpec finiteAnimationSpec, p pVar) {
        super(1);
        this.$animationSpec$inlined = finiteAnimationSpec;
        this.$finishedListener$inlined = pVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("animateContentSize");
        inspectorInfo.getProperties().set("animationSpec", this.$animationSpec$inlined);
        inspectorInfo.getProperties().set("finishedListener", this.$finishedListener$inlined);
    }
}
