package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
final class ModalBottomSheetState$Companion$Saver$2 extends v implements l<ModalBottomSheetValue, ModalBottomSheetState> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ l<ModalBottomSheetValue, Boolean> $confirmStateChange;
    final /* synthetic */ boolean $skipHalfExpanded;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ModalBottomSheetState$Companion$Saver$2(AnimationSpec<Float> animationSpec, boolean z10, l<? super ModalBottomSheetValue, Boolean> lVar) {
        super(1);
        this.$animationSpec = animationSpec;
        this.$skipHalfExpanded = z10;
        this.$confirmStateChange = lVar;
    }

    @Override // h9.l
    @Nullable
    public final ModalBottomSheetState invoke(@NotNull ModalBottomSheetValue it) {
        t.i(it, "it");
        return new ModalBottomSheetState(it, this.$animationSpec, this.$skipHalfExpanded, this.$confirmStateChange);
    }
}
