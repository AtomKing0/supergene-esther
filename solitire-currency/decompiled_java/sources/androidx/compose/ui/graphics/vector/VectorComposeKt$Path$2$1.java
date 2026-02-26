package androidx.compose.ui.graphics.vector;

import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: VectorCompose.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorComposeKt$Path$2$1 extends v implements p<PathComponent, String, k0> {
    public static final VectorComposeKt$Path$2$1 INSTANCE = new VectorComposeKt$Path$2$1();

    VectorComposeKt$Path$2$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(PathComponent pathComponent, String str) {
        invoke2(pathComponent, str);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull PathComponent set, @NotNull String it) {
        t.i(set, "$this$set");
        t.i(it, "it");
        set.setName(it);
    }
}
