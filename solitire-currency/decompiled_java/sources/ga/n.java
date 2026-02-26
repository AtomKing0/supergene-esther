package ga;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CookieJar.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f26182a = a.f26184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final n f26183b = new a.C0565a();

    /* JADX INFO: compiled from: CookieJar.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f26184a = new a();

        /* JADX INFO: renamed from: ga.n$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CookieJar.kt */
        private static final class C0565a implements n {
            @Override // ga.n
            public void a(@NotNull v url, @NotNull List<m> cookies) {
                kotlin.jvm.internal.t.i(url, "url");
                kotlin.jvm.internal.t.i(cookies, "cookies");
            }

            @Override // ga.n
            @NotNull
            public List<m> b(@NotNull v url) {
                kotlin.jvm.internal.t.i(url, "url");
                return kotlin.collections.v.l();
            }
        }

        private a() {
        }
    }

    void a(@NotNull v vVar, @NotNull List<m> list);

    @NotNull
    List<m> b(@NotNull v vVar);
}
