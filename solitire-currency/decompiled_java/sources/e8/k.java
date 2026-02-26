package e8;

import g8.t;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface k extends g8.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f25257a = a.f25258a;

    /* JADX INFO: compiled from: Headers.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f25258a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private static final k f25259b = e.f25233c;

        private a() {
        }

        @NotNull
        public final k a() {
            return f25259b;
        }
    }

    /* JADX INFO: compiled from: Headers.kt */
    public static final class b {
        public static void a(@NotNull k kVar, @NotNull h9.p<? super String, ? super List<String>, v8.k0> body) {
            kotlin.jvm.internal.t.i(body, "body");
            t.a.a(kVar, body);
        }

        @Nullable
        public static String b(@NotNull k kVar, @NotNull String name) {
            kotlin.jvm.internal.t.i(name, "name");
            return t.a.b(kVar, name);
        }
    }
}
