package androidx.compose.foundation.text;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AndroidCursorHandle.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidCursorHandle_androidKt$CursorHandle$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ Modifier $modifier;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AndroidCursorHandle_androidKt$CursorHandle$1(p<? super Composer, ? super Integer, k0> pVar, Modifier modifier, int i10) {
        super(2);
        this.$content = pVar;
        this.$modifier = modifier;
        this.$$dirty = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i10) {
        if ((i10 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (this.$content == null) {
            composer.startReplaceableGroup(1275643833);
            AndroidCursorHandle_androidKt.DefaultCursorHandle(this.$modifier, composer, (this.$$dirty >> 3) & 14);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1275643903);
            this.$content.mo4invoke(composer, Integer.valueOf((this.$$dirty >> 6) & 14));
            composer.endReplaceableGroup();
        }
    }
}
