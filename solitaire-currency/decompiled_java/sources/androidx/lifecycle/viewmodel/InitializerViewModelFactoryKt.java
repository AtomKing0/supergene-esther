package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import h9.l;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: InitializerViewModelFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InitializerViewModelFactoryKt {
    public static final /* synthetic */ <VM extends ViewModel> void initializer(InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder, l<? super CreationExtras, ? extends VM> initializer) {
        t.i(initializerViewModelFactoryBuilder, "<this>");
        t.i(initializer, "initializer");
        t.o(4, "VM");
        initializerViewModelFactoryBuilder.addInitializer(o0.b(ViewModel.class), initializer);
    }

    @NotNull
    public static final ViewModelProvider.Factory viewModelFactory(@NotNull l<? super InitializerViewModelFactoryBuilder, k0> builder) {
        t.i(builder, "builder");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        builder.invoke(initializerViewModelFactoryBuilder);
        return initializerViewModelFactoryBuilder.build();
    }
}
