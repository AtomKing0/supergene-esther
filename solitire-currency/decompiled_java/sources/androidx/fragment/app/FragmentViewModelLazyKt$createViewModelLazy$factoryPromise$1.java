package androidx.fragment.app;

import androidx.lifecycle.ViewModelProvider;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes.dex */
final class FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1 extends kotlin.jvm.internal.v implements h9.a<ViewModelProvider.Factory> {
    final /* synthetic */ Fragment $this_createViewModelLazy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(Fragment fragment) {
        super(0);
        this.$this_createViewModelLazy = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final ViewModelProvider.Factory invoke() {
        ViewModelProvider.Factory defaultViewModelProviderFactory = this.$this_createViewModelLazy.getDefaultViewModelProviderFactory();
        kotlin.jvm.internal.t.h(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
