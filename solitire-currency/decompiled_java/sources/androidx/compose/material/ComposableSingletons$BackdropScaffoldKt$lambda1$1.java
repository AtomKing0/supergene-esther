package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: renamed from: androidx.compose.material.ComposableSingletons$BackdropScaffoldKt$lambda-1$1, reason: invalid class name */
/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposableSingletons$BackdropScaffoldKt$lambda1$1 extends v implements q<SnackbarHostState, Composer, Integer, k0> {
    public static final ComposableSingletons$BackdropScaffoldKt$lambda1$1 INSTANCE = new ComposableSingletons$BackdropScaffoldKt$lambda1$1();

    ComposableSingletons$BackdropScaffoldKt$lambda1$1() {
        super(3);
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(SnackbarHostState snackbarHostState, Composer composer, Integer num) {
        invoke(snackbarHostState, composer, num.intValue());
        return k0.f35197a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull SnackbarHostState it, @Nullable Composer composer, int i10) {
        t.i(it, "it");
        if ((i10 & 14) == 0) {
            i10 |= composer.changed(it) ? 4 : 2;
        }
        if ((i10 & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            SnackbarHostKt.SnackbarHost(it, null, null, composer, i10 & 14, 6);
        }
    }
}
