package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.ScrollState;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.compose.material.ScrollableTabData$onLaidOut$1$1", f = "TabRow.kt", l = {475}, m = "invokeSuspend")
final class ScrollableTabData$onLaidOut$1$1 extends l implements p<o0, d<? super k0>, Object> {
    final /* synthetic */ int $calculatedOffset;
    int label;
    final /* synthetic */ ScrollableTabData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollableTabData$onLaidOut$1$1(ScrollableTabData scrollableTabData, int i10, d<? super ScrollableTabData$onLaidOut$1$1> dVar) {
        super(2, dVar);
        this.this$0 = scrollableTabData;
        this.$calculatedOffset = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        return new ScrollableTabData$onLaidOut$1$1(this.this$0, this.$calculatedOffset, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            ScrollState scrollState = this.this$0.scrollState;
            int i11 = this.$calculatedOffset;
            AnimationSpec<Float> animationSpec = TabRowKt.ScrollableTabRowScrollSpec;
            this.label = 1;
            if (scrollState.animateScrollTo(i11, animationSpec, this) == objE) {
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
        return ((ScrollableTabData$onLaidOut$1$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
