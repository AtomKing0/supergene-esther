package androidx.fragment.app;

import androidx.lifecycle.ViewModelStoreOwner;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentViewModelLazyKt$viewModels$owner$4 extends kotlin.jvm.internal.v implements h9.a<ViewModelStoreOwner> {
    final /* synthetic */ h9.a<ViewModelStoreOwner> $ownerProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewModelLazyKt$viewModels$owner$4(h9.a<? extends ViewModelStoreOwner> aVar) {
        super(0);
        this.$ownerProducer = aVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final ViewModelStoreOwner invoke() {
        return this.$ownerProducer.invoke();
    }
}
