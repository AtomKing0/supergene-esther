package androidx.compose.ui.platform;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: androidx.compose.ui.platform.ComposableSingletons$Wrapper_androidKt$lambda-1$1, reason: invalid class name */
/* JADX INFO: compiled from: Wrapper.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposableSingletons$Wrapper_androidKt$lambda1$1 extends kotlin.jvm.internal.v implements h9.p<Composer, Integer, v8.k0> {
    public static final ComposableSingletons$Wrapper_androidKt$lambda1$1 INSTANCE = new ComposableSingletons$Wrapper_androidKt$lambda1$1();

    ComposableSingletons$Wrapper_androidKt$lambda1$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ v8.k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return v8.k0.f35197a;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i10) {
        if ((i10 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        }
    }
}
