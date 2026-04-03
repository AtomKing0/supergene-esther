package a8;

import e8.p0;
import e8.q;
import e8.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface b extends q, o0 {

    /* JADX INFO: compiled from: HttpRequest.kt */
    public static final class a {
        @NotNull
        public static z8.g a(@NotNull b bVar) {
            return bVar.R().getCoroutineContext();
        }
    }

    @NotNull
    t7.b R();

    @NotNull
    g8.b getAttributes();

    @NotNull
    z8.g getCoroutineContext();

    @NotNull
    t getMethod();

    @NotNull
    p0 getUrl();
}
