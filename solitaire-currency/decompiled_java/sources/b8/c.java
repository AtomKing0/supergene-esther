package b8;

import e8.q;
import e8.u;
import e8.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c implements q, o0 {
    @NotNull
    public abstract t7.b R();

    @NotNull
    public abstract io.ktor.utils.io.g c();

    @NotNull
    public abstract j8.b d();

    @NotNull
    public abstract j8.b e();

    @NotNull
    public abstract v f();

    @NotNull
    public abstract u g();

    @NotNull
    public String toString() {
        return "HttpResponse[" + e.e(this).getUrl() + ", " + f() + ']';
    }
}
