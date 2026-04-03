package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: classes.dex */
final class SwipeableState$Companion$Saver$2<T> extends v implements l<T, SwipeableState<T>> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ l<T, Boolean> $confirmStateChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SwipeableState$Companion$Saver$2(AnimationSpec<Float> animationSpec, l<? super T, Boolean> lVar) {
        super(1);
        this.$animationSpec = animationSpec;
        this.$confirmStateChange = lVar;
    }

    @Override // h9.l
    @Nullable
    public final SwipeableState<T> invoke(@NotNull T it) {
        t.i(it, "it");
        return new SwipeableState<>(it, this.$animationSpec, this.$confirmStateChange);
    }
}
