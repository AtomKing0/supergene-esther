package androidx.compose.ui.node;

import androidx.compose.ui.draw.DrawCacheModifier;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: DrawEntity.kt */
/* JADX INFO: loaded from: classes.dex */
final class DrawEntity$updateCache$1 extends v implements h9.a<k0> {
    final /* synthetic */ DrawEntity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DrawEntity$updateCache$1(DrawEntity drawEntity) {
        super(0);
        this.this$0 = drawEntity;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        DrawCacheModifier drawCacheModifier = this.this$0.cacheDrawModifier;
        if (drawCacheModifier != null) {
            drawCacheModifier.onBuildCache(this.this$0.buildCacheParams);
        }
        this.this$0.invalidateCache = false;
    }
}
