package androidx.compose.ui.node;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: DrawEntity.kt */
/* JADX INFO: loaded from: classes.dex */
final class DrawEntity$Companion$onCommitAffectingDrawEntity$1 extends v implements l<DrawEntity, k0> {
    public static final DrawEntity$Companion$onCommitAffectingDrawEntity$1 INSTANCE = new DrawEntity$Companion$onCommitAffectingDrawEntity$1();

    DrawEntity$Companion$onCommitAffectingDrawEntity$1() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(DrawEntity drawEntity) {
        invoke2(drawEntity);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull DrawEntity drawEntity) {
        t.i(drawEntity, "drawEntity");
        if (drawEntity.isValid()) {
            drawEntity.invalidateCache = true;
            drawEntity.getLayoutNodeWrapper().invalidateLayer();
        }
    }
}
