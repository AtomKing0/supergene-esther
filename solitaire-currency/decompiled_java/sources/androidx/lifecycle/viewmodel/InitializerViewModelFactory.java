package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.n;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InitializerViewModelFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InitializerViewModelFactory implements ViewModelProvider.Factory {

    @NotNull
    private final ViewModelInitializer<?>[] initializers;

    public InitializerViewModelFactory(@NotNull ViewModelInitializer<?>... initializers) {
        t.i(initializers, "initializers");
        this.initializers = initializers;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* synthetic */ ViewModel create(Class cls) {
        return n.a(this, cls);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> modelClass, @NotNull CreationExtras extras) {
        t.i(modelClass, "modelClass");
        t.i(extras, "extras");
        T t10 = null;
        for (ViewModelInitializer<?> viewModelInitializer : this.initializers) {
            if (t.d(viewModelInitializer.getClazz$lifecycle_viewmodel_release(), modelClass)) {
                T tInvoke = viewModelInitializer.getInitializer$lifecycle_viewmodel_release().invoke(extras);
                t10 = tInvoke instanceof ViewModel ? tInvoke : null;
            }
        }
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException("No initializer set for given class " + modelClass.getName());
    }
}
