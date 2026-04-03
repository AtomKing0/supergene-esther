package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import h9.l;
import h9.p;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
final class SliderKt$rangeSliderPressDragModifier$1$1$1$1$finishInteraction$success$1 extends v implements l<PointerInputChange, k0> {
    final /* synthetic */ i0 $draggingStart;
    final /* synthetic */ boolean $isRtl;
    final /* synthetic */ State<p<Boolean, Float, k0>> $onDrag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SliderKt$rangeSliderPressDragModifier$1$1$1$1$finishInteraction$success$1(State<? extends p<? super Boolean, ? super Float, k0>> state, i0 i0Var, boolean z10) {
        super(1);
        this.$onDrag = state;
        this.$draggingStart = i0Var;
        this.$isRtl = z10;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(PointerInputChange pointerInputChange) {
        invoke2(pointerInputChange);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull PointerInputChange it) {
        t.i(it, "it");
        float fM1367getXimpl = Offset.m1367getXimpl(PointerEventKt.positionChange(it));
        p<Boolean, Float, k0> value = this.$onDrag.getValue();
        Boolean boolValueOf = Boolean.valueOf(this.$draggingStart.f29826a);
        if (this.$isRtl) {
            fM1367getXimpl = -fM1367getXimpl;
        }
        value.mo4invoke(boolValueOf, Float.valueOf(fM1367getXimpl));
    }
}
