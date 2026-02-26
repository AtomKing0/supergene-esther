package androidx.compose.runtime;

import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: renamed from: androidx.compose.runtime.ComposableSingletons$RecomposerKt$lambda-1$1, reason: invalid class name */
/* JADX INFO: compiled from: Recomposer.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposableSingletons$RecomposerKt$lambda1$1 extends v implements p<Composer, Integer, k0> {
    public static final ComposableSingletons$RecomposerKt$lambda1$1 INSTANCE = new ComposableSingletons$RecomposerKt$lambda1$1();

    ComposableSingletons$RecomposerKt$lambda1$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i10) {
        if ((i10 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        }
    }
}
