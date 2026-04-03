package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.StrokeJoin;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: VectorCompose.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorComposeKt$Path$2$9 extends v implements p<PathComponent, StrokeJoin, k0> {
    public static final VectorComposeKt$Path$2$9 INSTANCE = new VectorComposeKt$Path$2$9();

    VectorComposeKt$Path$2$9() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(PathComponent pathComponent, StrokeJoin strokeJoin) {
        m2126invokekLtJ_vA(pathComponent, strokeJoin.m1894unboximpl());
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke-kLtJ_vA, reason: not valid java name */
    public final void m2126invokekLtJ_vA(@NotNull PathComponent set, int i10) {
        t.i(set, "$this$set");
        set.m2110setStrokeLineJoinWw9F2mQ(i10);
    }
}
