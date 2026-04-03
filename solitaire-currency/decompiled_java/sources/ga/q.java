package ga;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Dns.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f26193a = a.f26195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final q f26194b = new a.C0566a();

    /* JADX INFO: compiled from: Dns.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f26195a = new a();

        /* JADX INFO: renamed from: ga.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Dns.kt */
        private static final class C0566a implements q {
            @Override // ga.q
            @NotNull
            public List<InetAddress> a(@NotNull String hostname) throws UnknownHostException {
                kotlin.jvm.internal.t.i(hostname, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(hostname);
                    kotlin.jvm.internal.t.h(allByName, "getAllByName(hostname)");
                    return kotlin.collections.p.o0(allByName);
                } catch (NullPointerException e10) {
                    UnknownHostException unknownHostException = new UnknownHostException(kotlin.jvm.internal.t.r("Broken system behaviour for dns lookup of ", hostname));
                    unknownHostException.initCause(e10);
                    throw unknownHostException;
                }
            }
        }

        private a() {
        }
    }

    @NotNull
    List<InetAddress> a(@NotNull String str) throws UnknownHostException;
}
