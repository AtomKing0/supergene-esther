package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Brush;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: VectorCompose.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorComposeKt$Path$2$4 extends v implements p<PathComponent, Brush, k0> {
    public static final VectorComposeKt$Path$2$4 INSTANCE = new VectorComposeKt$Path$2$4();

    VectorComposeKt$Path$2$4() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(PathComponent pathComponent, Brush brush) {
        invoke2(pathComponent, brush);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull PathComponent set, @Nullable Brush brush) {
        t.i(set, "$this$set");
        set.setFill(brush);
    }
}
