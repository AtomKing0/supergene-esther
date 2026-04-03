package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import java.util.Iterator;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
final class Transition$totalDurationNanos$2 extends v implements h9.a<Long> {
    final /* synthetic */ Transition<S> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Transition$totalDurationNanos$2(Transition<S> transition) {
        super(0);
        this.this$0 = transition;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final Long invoke() {
        Iterator<T> it = ((Transition) this.this$0)._animations.iterator();
        long jMax = 0;
        while (it.hasNext()) {
            jMax = Math.max(jMax, ((Transition.TransitionAnimationState) it.next()).getDurationNanos$animation_core_release());
        }
        Iterator<T> it2 = ((Transition) this.this$0)._transitions.iterator();
        while (it2.hasNext()) {
            jMax = Math.max(jMax, ((Transition) it2.next()).getTotalDurationNanos());
        }
        return Long.valueOf(jMax);
    }
}
