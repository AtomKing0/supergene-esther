package ga;

import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Authenticator.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f25943a = a.f25946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f25944b = new a.C0561a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final b f25945c = new ia.a(null, 1, null);

    /* JADX INFO: compiled from: Authenticator.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f25946a = new a();

        /* JADX INFO: renamed from: ga.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Authenticator.kt */
        private static final class C0561a implements b {
            @Override // ga.b
            @Nullable
            public b0 a(@Nullable f0 f0Var, @NotNull d0 response) {
                kotlin.jvm.internal.t.i(response, "response");
                return null;
            }
        }

        private a() {
        }
    }

    @Nullable
    b0 a(@Nullable f0 f0Var, @NotNull d0 d0Var) throws IOException;
}
