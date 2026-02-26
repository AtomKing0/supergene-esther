package ga;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TlsVersion.kt */
/* JADX INFO: loaded from: classes5.dex */
public enum g0 {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f26071b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f26078a;

    /* JADX INFO: compiled from: TlsVersion.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @NotNull
        public final g0 a(@NotNull String javaName) {
            kotlin.jvm.internal.t.i(javaName, "javaName");
            int iHashCode = javaName.hashCode();
            if (iHashCode != 79201641) {
                if (iHashCode != 79923350) {
                    switch (iHashCode) {
                        case -503070503:
                            if (javaName.equals("TLSv1.1")) {
                                return g0.TLS_1_1;
                            }
                            break;
                        case -503070502:
                            if (javaName.equals("TLSv1.2")) {
                                return g0.TLS_1_2;
                            }
                            break;
                        case -503070501:
                            if (javaName.equals("TLSv1.3")) {
                                return g0.TLS_1_3;
                            }
                            break;
                    }
                } else if (javaName.equals("TLSv1")) {
                    return g0.TLS_1_0;
                }
            } else if (javaName.equals("SSLv3")) {
                return g0.SSL_3_0;
            }
            throw new IllegalArgumentException(kotlin.jvm.internal.t.r("Unexpected TLS version: ", javaName));
        }
    }

    g0(String str) {
        this.f26078a = str;
    }

    @NotNull
    public final String c() {
        return this.f26078a;
    }
}
