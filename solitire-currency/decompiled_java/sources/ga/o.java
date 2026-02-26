package ga;

import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Credentials.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f26185a = new o();

    private o() {
    }

    @NotNull
    public static final String a(@NotNull String username, @NotNull String password, @NotNull Charset charset) {
        kotlin.jvm.internal.t.i(username, "username");
        kotlin.jvm.internal.t.i(password, "password");
        kotlin.jvm.internal.t.i(charset, "charset");
        return kotlin.jvm.internal.t.r("Basic ", ua.f.f34755d.c(username + ':' + password, charset).a());
    }
}
