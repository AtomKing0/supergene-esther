package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ViewModelProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n {
    static {
        ViewModelProvider.Factory.Companion companion = ViewModelProvider.Factory.Companion;
    }

    @NotNull
    public static ViewModel a(ViewModelProvider.Factory factory, @NotNull Class modelClass) {
        t.i(modelClass, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    @NotNull
    public static ViewModel b(ViewModelProvider.Factory factory, @NotNull Class modelClass, @NotNull CreationExtras extras) {
        t.i(modelClass, "modelClass");
        t.i(extras, "extras");
        return factory.create(modelClass);
    }

    @NotNull
    public static ViewModelProvider.Factory c(@NotNull ViewModelInitializer<?>... viewModelInitializerArr) {
        return ViewModelProvider.Factory.Companion.from(viewModelInitializerArr);
    }
}
