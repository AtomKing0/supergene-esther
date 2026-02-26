package androidx.compose.ui.graphics.vector;

import h9.p;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: VectorCompose.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorComposeKt$Group$2$9 extends v implements p<GroupComponent, List<? extends PathNode>, k0> {
    public static final VectorComposeKt$Group$2$9 INSTANCE = new VectorComposeKt$Group$2$9();

    VectorComposeKt$Group$2$9() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(GroupComponent groupComponent, List<? extends PathNode> list) {
        invoke2(groupComponent, list);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull GroupComponent set, @NotNull List<? extends PathNode> it) {
        t.i(set, "$this$set");
        t.i(it, "it");
        set.setClipPathData(it);
    }
}
