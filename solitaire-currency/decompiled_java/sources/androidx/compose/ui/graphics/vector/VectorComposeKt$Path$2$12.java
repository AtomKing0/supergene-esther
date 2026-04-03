package androidx.compose.ui.graphics.vector;

import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: VectorCompose.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorComposeKt$Path$2$12 extends v implements p<PathComponent, Float, k0> {
    public static final VectorComposeKt$Path$2$12 INSTANCE = new VectorComposeKt$Path$2$12();

    VectorComposeKt$Path$2$12() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(PathComponent pathComponent, Float f10) {
        invoke(pathComponent, f10.floatValue());
        return k0.f35197a;
    }

    public final void invoke(@NotNull PathComponent set, float f10) {
        t.i(set, "$this$set");
        set.setTrimPathStart(f10);
    }
}
