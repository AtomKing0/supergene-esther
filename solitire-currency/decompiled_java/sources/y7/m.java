package y7;

import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: HttpClientPlugin.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface m<TConfig, TPlugin> {
    void a(@NotNull TPlugin tplugin, @NotNull s7.a aVar);

    @NotNull
    TPlugin b(@NotNull h9.l<? super TConfig, k0> lVar);

    @NotNull
    g8.a<TPlugin> getKey();
}
