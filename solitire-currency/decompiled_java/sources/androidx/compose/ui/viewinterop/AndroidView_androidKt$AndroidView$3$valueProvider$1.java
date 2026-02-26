package androidx.compose.ui.viewinterop;

import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.ui.node.Ref;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidView.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidView_androidKt$AndroidView$3$valueProvider$1 extends v implements h9.a<SparseArray<Parcelable>> {
    final /* synthetic */ Ref<ViewFactoryHolder<T>> $viewFactoryHolderRef;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidView_androidKt$AndroidView$3$valueProvider$1(Ref<ViewFactoryHolder<T>> ref) {
        super(0);
        this.$viewFactoryHolderRef = ref;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final SparseArray<Parcelable> invoke() {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        Object value = this.$viewFactoryHolderRef.getValue();
        t.f(value);
        View typedView$ui_release = ((ViewFactoryHolder) value).getTypedView$ui_release();
        if (typedView$ui_release != null) {
            typedView$ui_release.saveHierarchyState(sparseArray);
        }
        return sparseArray;
    }
}
