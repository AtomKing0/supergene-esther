package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HasDefaultViewModelProviderFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public interface HasDefaultViewModelProviderFactory {
    @NotNull
    CreationExtras getDefaultViewModelCreationExtras();

    @NotNull
    ViewModelProvider.Factory getDefaultViewModelProviderFactory();
}
