package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.PathFillType;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: VectorCompose.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorComposeKt$Path$2$3 extends v implements p<PathComponent, PathFillType, k0> {
    public static final VectorComposeKt$Path$2$3 INSTANCE = new VectorComposeKt$Path$2$3();

    VectorComposeKt$Path$2$3() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(PathComponent pathComponent, PathFillType pathFillType) {
        m2125invokepweu1eQ(pathComponent, pathFillType.m1823unboximpl());
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke-pweu1eQ, reason: not valid java name */
    public final void m2125invokepweu1eQ(@NotNull PathComponent set, int i10) {
        t.i(set, "$this$set");
        set.m2108setPathFillTypeoQ8Xj4U(i10);
    }
}
