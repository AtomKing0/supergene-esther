package androidx.compose.ui.viewinterop;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Ref;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: AndroidView.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidView_androidKt$AndroidView$2$5<T> extends v implements p<LayoutNode, l<? super T, ? extends k0>, k0> {
    final /* synthetic */ Ref<ViewFactoryHolder<T>> $viewFactoryHolderRef;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidView_androidKt$AndroidView$2$5(Ref<ViewFactoryHolder<T>> ref) {
        super(2);
        this.$viewFactoryHolderRef = ref;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(LayoutNode layoutNode, Object obj) {
        invoke(layoutNode, (l) obj);
        return k0.f35197a;
    }

    public final void invoke(@NotNull LayoutNode set, @NotNull l<? super T, k0> it) {
        t.i(set, "$this$set");
        t.i(it, "it");
        ViewFactoryHolder<T> value = this.$viewFactoryHolderRef.getValue();
        t.f(value);
        value.setUpdateBlock(it);
    }
}
