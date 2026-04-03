package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: renamed from: androidx.compose.material.ComposableSingletons$ScaffoldKt$lambda-2$1, reason: invalid class name */
/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposableSingletons$ScaffoldKt$lambda2$1 extends v implements p<Composer, Integer, k0> {
    public static final ComposableSingletons$ScaffoldKt$lambda2$1 INSTANCE = new ComposableSingletons$ScaffoldKt$lambda2$1();

    ComposableSingletons$ScaffoldKt$lambda2$1() {
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
