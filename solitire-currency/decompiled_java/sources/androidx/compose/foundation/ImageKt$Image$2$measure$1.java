package androidx.compose.foundation;

import androidx.compose.ui.layout.Placeable;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Image.kt */
/* JADX INFO: loaded from: classes.dex */
final class ImageKt$Image$2$measure$1 extends v implements h9.l<Placeable.PlacementScope, k0> {
    public static final ImageKt$Image$2$measure$1 INSTANCE = new ImageKt$Image$2$measure$1();

    ImageKt$Image$2$measure$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }
}
