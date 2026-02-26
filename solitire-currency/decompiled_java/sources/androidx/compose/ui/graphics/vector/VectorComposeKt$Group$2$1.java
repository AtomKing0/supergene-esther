package androidx.compose.ui.graphics.vector;

import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: VectorCompose.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorComposeKt$Group$2$1 extends v implements p<GroupComponent, String, k0> {
    public static final VectorComposeKt$Group$2$1 INSTANCE = new VectorComposeKt$Group$2$1();

    VectorComposeKt$Group$2$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(GroupComponent groupComponent, String str) {
        invoke2(groupComponent, str);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull GroupComponent set, @NotNull String it) {
        t.i(set, "$this$set");
        t.i(it, "it");
        set.setName(it);
    }
}
