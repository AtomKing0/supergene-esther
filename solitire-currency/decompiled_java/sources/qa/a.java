package qa;

import android.annotation.SuppressLint;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import ga.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ra.l;
import ra.m;

/* JADX INFO: compiled from: Android10Platform.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final C0662a f33198e = new C0662a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f33199f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<m> f33200d;

    /* JADX INFO: renamed from: qa.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Android10Platform.kt */
    public static final class C0662a {
        private C0662a() {
        }

        public /* synthetic */ C0662a(k kVar) {
            this();
        }

        @Nullable
        public final j a() {
            if (b()) {
                return new a();
            }
            return null;
        }

        public final boolean b() {
            return a.f33199f;
        }
    }

    static {
        f33199f = j.f33228a.h() && Build.VERSION.SDK_INT >= 29;
    }

    public a() {
        List listP = v.p(ra.c.f33411a.a(), new l(ra.h.f33419f.d()), new l(ra.k.f33433a.a()), new l(ra.i.f33427a.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listP) {
            if (((m) obj).isSupported()) {
                arrayList.add(obj);
            }
        }
        this.f33200d = arrayList;
    }

    @Override // qa.j
    @NotNull
    public ta.c c(@NotNull X509TrustManager trustManager) {
        t.i(trustManager, "trustManager");
        ra.d dVarA = ra.d.f33412d.a(trustManager);
        return dVarA == null ? super.c(trustManager) : dVarA;
    }

    @Override // qa.j
    public void e(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List<? extends a0> protocols) {
        Object next;
        t.i(sslSocket, "sslSocket");
        t.i(protocols, "protocols");
        Iterator<T> it = this.f33200d.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((m) next).a(sslSocket)) {
                    break;
                }
            }
        }
        m mVar = (m) next;
        if (mVar == null) {
            return;
        }
        mVar.c(sslSocket, str, protocols);
    }

    @Override // qa.j
    @Nullable
    public String h(@NotNull SSLSocket sslSocket) {
        Object next;
        t.i(sslSocket, "sslSocket");
        Iterator<T> it = this.f33200d.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((m) next).a(sslSocket)) {
                break;
            }
        }
        m mVar = (m) next;
        if (mVar == null) {
            return null;
        }
        return mVar.b(sslSocket);
    }

    @Override // qa.j
    @SuppressLint({"NewApi"})
    public boolean j(@NotNull String hostname) {
        t.i(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }
}
