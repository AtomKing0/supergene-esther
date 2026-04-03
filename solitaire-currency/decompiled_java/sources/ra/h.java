package ra;

import ga.a0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import ra.l;

/* JADX INFO: compiled from: AndroidSocketAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public class h implements m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f33419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final l.a f33420g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Class<? super SSLSocket> f33421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Method f33422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Method f33423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Method f33424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Method f33425e;

    /* JADX INFO: compiled from: AndroidSocketAdapter.kt */
    public static final class a {

        /* JADX INFO: renamed from: ra.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AndroidSocketAdapter.kt */
        public static final class C0667a implements l.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f33426a;

            C0667a(String str) {
                this.f33426a = str;
            }

            @Override // ra.l.a
            public boolean a(@NotNull SSLSocket sslSocket) {
                t.i(sslSocket, "sslSocket");
                String name = sslSocket.getClass().getName();
                t.h(name, "sslSocket.javaClass.name");
                return q.K(name, t.r(this.f33426a, "."), false, 2, null);
            }

            @Override // ra.l.a
            @NotNull
            public m b(@NotNull SSLSocket sslSocket) {
                t.i(sslSocket, "sslSocket");
                return h.f33419f.b(sslSocket.getClass());
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final h b(Class<? super SSLSocket> cls) {
            Class<? super SSLSocket> superclass = cls;
            while (superclass != null && !t.d(superclass.getSimpleName(), "OpenSSLSocketImpl")) {
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    throw new AssertionError(t.r("No OpenSSLSocketImpl superclass of socket of type ", cls));
                }
            }
            t.f(superclass);
            return new h(superclass);
        }

        @NotNull
        public final l.a c(@NotNull String packageName) {
            t.i(packageName, "packageName");
            return new C0667a(packageName);
        }

        @NotNull
        public final l.a d() {
            return h.f33420g;
        }
    }

    static {
        a aVar = new a(null);
        f33419f = aVar;
        f33420g = aVar.c("com.google.android.gms.org.conscrypt");
    }

    public h(@NotNull Class<? super SSLSocket> sslSocketClass) throws NoSuchMethodException {
        t.i(sslSocketClass, "sslSocketClass");
        this.f33421a = sslSocketClass;
        Method declaredMethod = sslSocketClass.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        t.h(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f33422b = declaredMethod;
        this.f33423c = sslSocketClass.getMethod("setHostname", String.class);
        this.f33424d = sslSocketClass.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.f33425e = sslSocketClass.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // ra.m
    public boolean a(@NotNull SSLSocket sslSocket) {
        t.i(sslSocket, "sslSocket");
        return this.f33421a.isInstance(sslSocket);
    }

    @Override // ra.m
    @Nullable
    public String b(@NotNull SSLSocket sslSocket) {
        t.i(sslSocket, "sslSocket");
        if (!a(sslSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f33424d.invoke(sslSocket, new Object[0]);
            if (bArr == null) {
                return null;
            }
            return new String(bArr, p9.d.f32952b);
        } catch (IllegalAccessException e10) {
            throw new AssertionError(e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if ((cause instanceof NullPointerException) && t.d(((NullPointerException) cause).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError(e11);
        }
    }

    @Override // ra.m
    public void c(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List<? extends a0> protocols) {
        t.i(sslSocket, "sslSocket");
        t.i(protocols, "protocols");
        if (a(sslSocket)) {
            try {
                this.f33422b.invoke(sslSocket, Boolean.TRUE);
                if (str != null) {
                    this.f33423c.invoke(sslSocket, str);
                }
                this.f33425e.invoke(sslSocket, qa.j.f33228a.c(protocols));
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                throw new AssertionError(e11);
            }
        }
    }

    @Override // ra.m
    public boolean isSupported() {
        return qa.b.f33201f.b();
    }
}
