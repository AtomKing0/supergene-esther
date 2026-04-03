package androidx.compose.foundation.text;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: renamed from: androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt$lambda-1$1, reason: invalid class name */
/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposableSingletons$CoreTextFieldKt$lambda1$1 extends v implements q<p<? super Composer, ? super Integer, ? extends k0>, Composer, Integer, k0> {
    public static final ComposableSingletons$CoreTextFieldKt$lambda1$1 INSTANCE = new ComposableSingletons$CoreTextFieldKt$lambda1$1();

    ComposableSingletons$CoreTextFieldKt$lambda1$1() {
        super(3);
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(p<? super Composer, ? super Integer, ? extends k0> pVar, Composer composer, Integer num) {
        invoke((p<? super Composer, ? super Integer, k0>) pVar, composer, num.intValue());
        return k0.f35197a;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public final void invoke(@NotNull p<? super Composer, ? super Integer, k0> innerTextField, @Nullable Composer composer, int i10) {
        t.i(innerTextField, "innerTextField");
        if ((i10 & 14) == 0) {
            i10 |= composer.changed(innerTextField) ? 4 : 2;
        }
        if ((i10 & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            innerTextField.mo4invoke(composer, Integer.valueOf(i10 & 14));
        }
    }
}
