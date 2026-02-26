package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AndroidSelectionHandles.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidSelectionHandles_androidKt$HandlePopup$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ HandleReferencePoint $handleReferencePoint;
    final /* synthetic */ long $position;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AndroidSelectionHandles_androidKt$HandlePopup$1(long j10, HandleReferencePoint handleReferencePoint, p<? super Composer, ? super Integer, k0> pVar, int i10) {
        super(2);
        this.$position = j10;
        this.$handleReferencePoint = handleReferencePoint;
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
        AndroidSelectionHandles_androidKt.m753HandlePopupULxng0E(this.$position, this.$handleReferencePoint, this.$content, composer, this.$$changed | 1);
    }
}
