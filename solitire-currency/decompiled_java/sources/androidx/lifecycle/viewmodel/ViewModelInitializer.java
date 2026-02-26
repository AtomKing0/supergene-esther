package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InitializerViewModelFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelInitializer<T extends ViewModel> {

    @NotNull
    private final Class<T> clazz;

    @NotNull
    private final l<CreationExtras, T> initializer;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelInitializer(@NotNull Class<T> clazz, @NotNull l<? super CreationExtras, ? extends T> initializer) {
        t.i(clazz, "clazz");
        t.i(initializer, "initializer");
        this.clazz = clazz;
        this.initializer = initializer;
    }

    @NotNull
    public final Class<T> getClazz$lifecycle_viewmodel_release() {
        return this.clazz;
    }

    @NotNull
    public final l<CreationExtras, T> getInitializer$lifecycle_viewmodel_release() {
        return this.initializer;
    }
}
