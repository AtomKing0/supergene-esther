package qa;

import ga.a0;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Jdk8WithJettyBootPlatform.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e extends j {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public static final b f33214i = new b(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final Method f33215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final Method f33216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final Method f33217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final Class<?> f33218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final Class<?> f33219h;

    /* JADX INFO: compiled from: Jdk8WithJettyBootPlatform.kt */
    private static final class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final List<String> f33220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f33221b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private String f33222c;

        public a(@NotNull List<String> protocols) {
            t.i(protocols, "protocols");
            this.f33220a = protocols;
        }

        @Nullable
        public final String a() {
            return this.f33222c;
        }

        public final boolean b() {
            return this.f33221b;
        }

        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(@NotNull Object proxy, @NotNull Method method, @Nullable Object[] objArr) throws Throwable {
            t.i(proxy, "proxy");
            t.i(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (t.d(name, "supports") && t.d(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (t.d(name, "unsupported") && t.d(Void.TYPE, returnType)) {
                this.f33221b = true;
                return null;
            }
            if (t.d(name, "protocols")) {
                if (objArr.length == 0) {
                    return this.f33220a;
                }
            }
            if ((t.d(name, "selectProtocol") || t.d(name, "select")) && t.d(String.class, returnType) && objArr.length == 1) {
                Object obj = objArr[0];
                if (obj instanceof List) {
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                    }
                    List list = (List) obj;
                    int size = list.size();
                    if (size >= 0) {
                        int i10 = 0;
                        while (true) {
                            int i11 = i10 + 1;
                            Object obj2 = list.get(i10);
                            if (obj2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            String str = (String) obj2;
                            if (this.f33220a.contains(str)) {
                                this.f33222c = str;
                                return str;
                            }
                            if (i10 == size) {
                                break;
                            }
                            i10 = i11;
                        }
                    }
                    String str2 = this.f33220a.get(0);
                    this.f33222c = str2;
                    return str2;
                }
            }
            if ((!t.d(name, "protocolSelected") && !t.d(name, "selected")) || objArr.length != 1) {
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
            Object obj3 = objArr[0];
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            this.f33222c = (String) obj3;
            return null;
        }
    }

    /* JADX INFO: compiled from: Jdk8WithJettyBootPlatform.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k kVar) {
            this();
        }

        @Nullable
        public final j a() {
            String jvmVersion = System.getProperty("java.specification.version", "unknown");
            try {
                t.h(jvmVersion, "jvmVersion");
                if (Integer.parseInt(jvmVersion) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                Class<?> cls2 = Class.forName(t.r("org.eclipse.jetty.alpn.ALPN", "$Provider"), true, null);
                Class<?> clientProviderClass = Class.forName(t.r("org.eclipse.jetty.alpn.ALPN", "$ClientProvider"), true, null);
                Class<?> serverProviderClass = Class.forName(t.r("org.eclipse.jetty.alpn.ALPN", "$ServerProvider"), true, null);
                Method putMethod = cls.getMethod("put", SSLSocket.class, cls2);
                Method getMethod = cls.getMethod("get", SSLSocket.class);
                Method removeMethod = cls.getMethod("remove", SSLSocket.class);
                t.h(putMethod, "putMethod");
                t.h(getMethod, "getMethod");
                t.h(removeMethod, "removeMethod");
                t.h(clientProviderClass, "clientProviderClass");
                t.h(serverProviderClass, "serverProviderClass");
                return new e(putMethod, getMethod, removeMethod, clientProviderClass, serverProviderClass);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }
    }

    public e(@NotNull Method putMethod, @NotNull Method getMethod, @NotNull Method removeMethod, @NotNull Class<?> clientProviderClass, @NotNull Class<?> serverProviderClass) {
        t.i(putMethod, "putMethod");
        t.i(getMethod, "getMethod");
        t.i(removeMethod, "removeMethod");
        t.i(clientProviderClass, "clientProviderClass");
        t.i(serverProviderClass, "serverProviderClass");
        this.f33215d = putMethod;
        this.f33216e = getMethod;
        this.f33217f = removeMethod;
        this.f33218g = clientProviderClass;
        this.f33219h = serverProviderClass;
    }

    @Override // qa.j
    public void b(@NotNull SSLSocket sslSocket) {
        t.i(sslSocket, "sslSocket");
        try {
            this.f33217f.invoke(null, sslSocket);
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to remove ALPN", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to remove ALPN", e11);
        }
    }

    @Override // qa.j
    public void e(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List<? extends a0> protocols) {
        t.i(sslSocket, "sslSocket");
        t.i(protocols, "protocols");
        try {
            this.f33215d.invoke(null, sslSocket, Proxy.newProxyInstance(j.class.getClassLoader(), new Class[]{this.f33218g, this.f33219h}, new a(j.f33228a.b(protocols))));
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to set ALPN", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to set ALPN", e11);
        }
    }

    @Override // qa.j
    @Nullable
    public String h(@NotNull SSLSocket sslSocket) {
        t.i(sslSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f33216e.invoke(null, sslSocket));
            if (invocationHandler == null) {
                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
            a aVar = (a) invocationHandler;
            if (!aVar.b() && aVar.a() == null) {
                j.l(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (aVar.b()) {
                return null;
            }
            return aVar.a();
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to get ALPN selected protocol", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to get ALPN selected protocol", e11);
        }
    }
}
