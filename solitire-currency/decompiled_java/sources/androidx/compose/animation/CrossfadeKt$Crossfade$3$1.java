package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Crossfade.kt */
/* JADX INFO: loaded from: classes.dex */
final class CrossfadeKt$Crossfade$3$1<T> extends v implements l<T, Boolean> {
    final /* synthetic */ Transition<T> $this_Crossfade;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CrossfadeKt$Crossfade$3$1(Transition<T> transition) {
        super(1);
        this.$this_Crossfade = transition;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.l
    @NotNull
    public final Boolean invoke(T t10) {
        return Boolean.valueOf(!t.d(t10, this.$this_Crossfade.getTargetState()));
    }
}
