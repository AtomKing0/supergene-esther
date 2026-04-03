package androidx.compose.material;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.State;
import com.ironsource.mediationsdk.logger.IronSourceError;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
final class RangeSliderLogic {

    @NotNull
    private final MutableInteractionSource endInteractionSource;

    @NotNull
    private final State<p<Boolean, Float, k0>> onDrag;

    @NotNull
    private final State<Float> rawOffsetEnd;

    @NotNull
    private final State<Float> rawOffsetStart;

    @NotNull
    private final MutableInteractionSource startInteractionSource;

    /* JADX INFO: renamed from: androidx.compose.material.RangeSliderLogic$captureThumb$1, reason: invalid class name */
    /* JADX INFO: compiled from: Slider.kt */
    @f(c = "androidx.compose.material.RangeSliderLogic$captureThumb$1", f = "Slider.kt", l = {IronSourceError.ERROR_IS_INSTANCE_INIT_EXCEPTION}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ boolean $draggingStart;
        final /* synthetic */ Interaction $interaction;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z10, Interaction interaction, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$draggingStart = z10;
            this.$interaction = interaction;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return RangeSliderLogic.this.new AnonymousClass1(this.$draggingStart, this.$interaction, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                MutableInteractionSource mutableInteractionSourceActiveInteraction = RangeSliderLogic.this.activeInteraction(this.$draggingStart);
                Interaction interaction = this.$interaction;
                this.label = 1;
                if (mutableInteractionSourceActiveInteraction.emit(interaction, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RangeSliderLogic(@NotNull MutableInteractionSource startInteractionSource, @NotNull MutableInteractionSource endInteractionSource, @NotNull State<Float> rawOffsetStart, @NotNull State<Float> rawOffsetEnd, @NotNull State<? extends p<? super Boolean, ? super Float, k0>> onDrag) {
        t.i(startInteractionSource, "startInteractionSource");
        t.i(endInteractionSource, "endInteractionSource");
        t.i(rawOffsetStart, "rawOffsetStart");
        t.i(rawOffsetEnd, "rawOffsetEnd");
        t.i(onDrag, "onDrag");
        this.startInteractionSource = startInteractionSource;
        this.endInteractionSource = endInteractionSource;
        this.rawOffsetStart = rawOffsetStart;
        this.rawOffsetEnd = rawOffsetEnd;
        this.onDrag = onDrag;
    }

    @NotNull
    public final MutableInteractionSource activeInteraction(boolean z10) {
        return z10 ? this.startInteractionSource : this.endInteractionSource;
    }

    public final void captureThumb(boolean z10, float f10, @NotNull Interaction interaction, @NotNull o0 scope) {
        t.i(interaction, "interaction");
        t.i(scope, "scope");
        this.onDrag.getValue().mo4invoke(Boolean.valueOf(z10), Float.valueOf(f10 - (z10 ? this.rawOffsetStart : this.rawOffsetEnd).getValue().floatValue()));
        k.d(scope, null, null, new AnonymousClass1(z10, interaction, null), 3, null);
    }

    public final int compareOffsets(float f10) {
        return Float.compare(Math.abs(this.rawOffsetStart.getValue().floatValue() - f10), Math.abs(this.rawOffsetEnd.getValue().floatValue() - f10));
    }

    @NotNull
    public final MutableInteractionSource getEndInteractionSource() {
        return this.endInteractionSource;
    }

    @NotNull
    public final State<p<Boolean, Float, k0>> getOnDrag() {
        return this.onDrag;
    }

    @NotNull
    public final State<Float> getRawOffsetEnd() {
        return this.rawOffsetEnd;
    }

    @NotNull
    public final State<Float> getRawOffsetStart() {
        return this.rawOffsetStart;
    }

    @NotNull
    public final MutableInteractionSource getStartInteractionSource() {
        return this.startInteractionSource;
    }
}
