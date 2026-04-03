package q;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v.i;
import v.j;
import z8.d;

/* JADX INFO: compiled from: Interceptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface b {

    /* JADX INFO: compiled from: Interceptor.kt */
    public interface a {
        @NotNull
        i getRequest();

        @NotNull
        w.i getSize();
    }

    @Nullable
    Object a(@NotNull a aVar, @NotNull d<? super j> dVar);
}
