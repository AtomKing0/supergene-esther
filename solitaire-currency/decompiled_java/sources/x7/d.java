package x7;

import g8.z;
import h9.l;
import io.ktor.utils.io.e;
import java.net.SocketTimeoutException;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TimeoutExceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: compiled from: TimeoutExceptions.kt */
    static final class a extends v implements l<Throwable, Throwable> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a8.d f36220g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(a8.d dVar) {
            super(1);
            this.f36220g = dVar;
        }

        @Override // h9.l
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(@Nullable Throwable th) {
            return (th != null ? z.a(th) : null) instanceof SocketTimeoutException ? y7.z.b(this.f36220g, th) : th;
        }
    }

    @NotNull
    public static final io.ktor.utils.io.c a(@NotNull a8.d request) {
        t.i(request, "request");
        return e.d(false, new a(request), 1, null);
    }
}
