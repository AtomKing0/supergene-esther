package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AndroidSelectionHandles.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidSelectionHandles_androidKt$SelectionHandle$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ ResolvedTextDirection $direction;
    final /* synthetic */ boolean $handlesCrossed;
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ long $position;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AndroidSelectionHandles_androidKt$SelectionHandle$2(long j10, boolean z10, ResolvedTextDirection resolvedTextDirection, boolean z11, Modifier modifier, p<? super Composer, ? super Integer, k0> pVar, int i10) {
        super(2);
        this.$position = j10;
        this.$isStartHandle = z10;
        this.$direction = resolvedTextDirection;
        this.$handlesCrossed = z11;
        this.$modifier = modifier;
        this.$content = pVar;
        this.$$changed = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        AndroidSelectionHandles_androidKt.m754SelectionHandle8fL75g(this.$position, this.$isStartHandle, this.$direction, this.$handlesCrossed, this.$modifier, this.$content, composer, this.$$changed | 1);
    }
}
