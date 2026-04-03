package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.StrokeCap;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: VectorCompose.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorComposeKt$Path$2$10 extends v implements p<PathComponent, StrokeCap, k0> {
    public static final VectorComposeKt$Path$2$10 INSTANCE = new VectorComposeKt$Path$2$10();

    VectorComposeKt$Path$2$10() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(PathComponent pathComponent, StrokeCap strokeCap) {
        m2124invokeCSYIeUk(pathComponent, strokeCap.m1884unboximpl());
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke-CSYIeUk, reason: not valid java name */
    public final void m2124invokeCSYIeUk(@NotNull PathComponent set, int i10) {
        t.i(set, "$this$set");
        set.m2109setStrokeLineCapBeK7IIE(i10);
    }
}
