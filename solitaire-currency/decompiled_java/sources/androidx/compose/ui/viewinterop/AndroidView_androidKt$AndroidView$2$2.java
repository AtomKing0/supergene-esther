package androidx.compose.ui.viewinterop;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Density;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AndroidView.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidView_androidKt$AndroidView$2$2 extends v implements p<LayoutNode, Density, k0> {
    final /* synthetic */ Ref<ViewFactoryHolder<T>> $viewFactoryHolderRef;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidView_androidKt$AndroidView$2$2(Ref<ViewFactoryHolder<T>> ref) {
        super(2);
        this.$viewFactoryHolderRef = ref;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(LayoutNode layoutNode, Density density) {
        invoke2(layoutNode, density);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull LayoutNode set, @NotNull Density it) {
        t.i(set, "$this$set");
        t.i(it, "it");
        Object value = this.$viewFactoryHolderRef.getValue();
        t.f(value);
        ((ViewFactoryHolder) value).setDensity(it);
    }
}
