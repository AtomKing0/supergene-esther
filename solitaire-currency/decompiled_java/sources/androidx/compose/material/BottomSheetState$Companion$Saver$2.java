package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class BottomSheetState$Companion$Saver$2 extends v implements l<BottomSheetValue, BottomSheetState> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ l<BottomSheetValue, Boolean> $confirmStateChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BottomSheetState$Companion$Saver$2(AnimationSpec<Float> animationSpec, l<? super BottomSheetValue, Boolean> lVar) {
        super(1);
        this.$animationSpec = animationSpec;
        this.$confirmStateChange = lVar;
    }

    @Override // h9.l
    @Nullable
    public final BottomSheetState invoke(@NotNull BottomSheetValue it) {
        t.i(it, "it");
        return new BottomSheetState(it, this.$animationSpec, this.$confirmStateChange);
    }
}
