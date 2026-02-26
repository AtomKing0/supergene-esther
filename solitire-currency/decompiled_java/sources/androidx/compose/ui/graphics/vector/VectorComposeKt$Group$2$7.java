package androidx.compose.ui.graphics.vector;

import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: VectorCompose.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorComposeKt$Group$2$7 extends v implements p<GroupComponent, Float, k0> {
    public static final VectorComposeKt$Group$2$7 INSTANCE = new VectorComposeKt$Group$2$7();

    VectorComposeKt$Group$2$7() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(GroupComponent groupComponent, Float f10) {
        invoke(groupComponent, f10.floatValue());
        return k0.f35197a;
    }

    public final void invoke(@NotNull GroupComponent set, float f10) {
        t.i(set, "$this$set");
        set.setTranslationX(f10);
    }
}
