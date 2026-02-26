package na;

import ga.u;
import java.io.IOException;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import ua.e;

/* JADX INFO: compiled from: HeadersReader.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final C0633a f31741c = new C0633a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final e f31742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f31743b;

    /* JADX INFO: renamed from: na.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HeadersReader.kt */
    public static final class C0633a {
        private C0633a() {
        }

        public /* synthetic */ C0633a(k kVar) {
            this();
        }
    }

    public a(@NotNull e source) {
        t.i(source, "source");
        this.f31742a = source;
        this.f31743b = 262144L;
    }

    @NotNull
    public final u a() throws IOException {
        u.a aVar = new u.a();
        while (true) {
            String strB = b();
            if (strB.length() == 0) {
                return aVar.f();
            }
            aVar.c(strB);
        }
    }

    @NotNull
    public final String b() throws IOException {
        String strY = this.f31742a.y(this.f31743b);
        this.f31743b -= (long) strY.length();
        return strY;
    }
}
