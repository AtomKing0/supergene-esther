package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import h9.p;
import h9.q;
import h9.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldTransitionScope$Transition$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ t<Float, Color, Color, Float, Composer, Integer, k0> $content;
    final /* synthetic */ q<InputPhase, Composer, Integer, Color> $contentColor;
    final /* synthetic */ long $focusedTextStyleColor;
    final /* synthetic */ InputPhase $inputState;
    final /* synthetic */ boolean $showLabel;
    final /* synthetic */ TextFieldTransitionScope $tmp0_rcvr;
    final /* synthetic */ long $unfocusedTextStyleColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TextFieldTransitionScope$Transition$1(TextFieldTransitionScope textFieldTransitionScope, InputPhase inputPhase, long j10, long j11, q<? super InputPhase, ? super Composer, ? super Integer, Color> qVar, boolean z10, t<? super Float, ? super Color, ? super Color, ? super Float, ? super Composer, ? super Integer, k0> tVar, int i10) {
        super(2);
        this.$tmp0_rcvr = textFieldTransitionScope;
        this.$inputState = inputPhase;
        this.$focusedTextStyleColor = j10;
        this.$unfocusedTextStyleColor = j11;
        this.$contentColor = qVar;
        this.$showLabel = z10;
        this.$content = tVar;
        this.$$changed = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        this.$tmp0_rcvr.m1216TransitionDTcfvLk(this.$inputState, this.$focusedTextStyleColor, this.$unfocusedTextStyleColor, this.$contentColor, this.$showLabel, this.$content, composer, this.$$changed | 1);
    }
}
