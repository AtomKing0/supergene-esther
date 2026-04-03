package ga;

import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Protocol.kt */
/* JADX INFO: loaded from: classes5.dex */
public enum a0 {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f25934b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f25942a;

    /* JADX INFO: compiled from: Protocol.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final a0 a(@NotNull String protocol) throws IOException {
            kotlin.jvm.internal.t.i(protocol, "protocol");
            a0 a0Var = a0.HTTP_1_0;
            if (!kotlin.jvm.internal.t.d(protocol, a0Var.f25942a)) {
                a0Var = a0.HTTP_1_1;
                if (!kotlin.jvm.internal.t.d(protocol, a0Var.f25942a)) {
                    a0Var = a0.H2_PRIOR_KNOWLEDGE;
                    if (!kotlin.jvm.internal.t.d(protocol, a0Var.f25942a)) {
                        a0Var = a0.HTTP_2;
                        if (!kotlin.jvm.internal.t.d(protocol, a0Var.f25942a)) {
                            a0Var = a0.SPDY_3;
                            if (!kotlin.jvm.internal.t.d(protocol, a0Var.f25942a)) {
                                a0Var = a0.QUIC;
                                if (!kotlin.jvm.internal.t.d(protocol, a0Var.f25942a)) {
                                    throw new IOException(kotlin.jvm.internal.t.r("Unexpected protocol: ", protocol));
                                }
                            }
                        }
                    }
                }
            }
            return a0Var;
        }
    }

    a0(String str) {
        this.f25942a = str;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.f25942a;
    }
}
