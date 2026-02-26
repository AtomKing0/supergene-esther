package ra;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StandardAndroidSocketAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class n extends h {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f33437j = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final Class<? super SSLSocketFactory> f33438h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final Class<?> f33439i;

    /* JADX INFO: compiled from: StandardAndroidSocketAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public static /* synthetic */ m b(a aVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return aVar.a(str);
        }

        @Nullable
        public final m a(@NotNull String packageName) {
            t.i(packageName, "packageName");
            try {
                Class<?> cls = Class.forName(t.r(packageName, ".OpenSSLSocketImpl"));
                Class<?> cls2 = Class.forName(t.r(packageName, ".OpenSSLSocketFactoryImpl"));
                Class<?> paramsClass = Class.forName(t.r(packageName, ".SSLParametersImpl"));
                t.h(paramsClass, "paramsClass");
                return new n(cls, cls2, paramsClass);
            } catch (Exception e10) {
                qa.j.f33228a.g().k("unable to load android socket classes", 5, e10);
                return null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull Class<? super SSLSocket> sslSocketClass, @NotNull Class<? super SSLSocketFactory> sslSocketFactoryClass, @NotNull Class<?> paramClass) {
        super(sslSocketClass);
        t.i(sslSocketClass, "sslSocketClass");
        t.i(sslSocketFactoryClass, "sslSocketFactoryClass");
        t.i(paramClass, "paramClass");
        this.f33438h = sslSocketFactoryClass;
        this.f33439i = paramClass;
    }
}
