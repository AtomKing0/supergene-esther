package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class BackdropScaffoldState$Companion$Saver$2 extends v implements l<BackdropValue, BackdropScaffoldState> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ l<BackdropValue, Boolean> $confirmStateChange;
    final /* synthetic */ SnackbarHostState $snackbarHostState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BackdropScaffoldState$Companion$Saver$2(AnimationSpec<Float> animationSpec, l<? super BackdropValue, Boolean> lVar, SnackbarHostState snackbarHostState) {
        super(1);
        this.$animationSpec = animationSpec;
        this.$confirmStateChange = lVar;
        this.$snackbarHostState = snackbarHostState;
    }

    @Override // h9.l
    @Nullable
    public final BackdropScaffoldState invoke(@NotNull BackdropValue it) {
        t.i(it, "it");
        return new BackdropScaffoldState(it, this.$animationSpec, this.$confirmStateChange, this.$snackbarHostState);
    }
}
