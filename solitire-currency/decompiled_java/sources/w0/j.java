package w0;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import o1.k;
import p1.a;

/* JADX INFO: compiled from: SafeKeyGenerator.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o1.g<r0.f, String> f35313a = new o1.g<>(1000);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pools.Pool<b> f35314b = p1.a.d(10, new a());

    /* JADX INFO: compiled from: SafeKeyGenerator.java */
    class a implements a.d<b> {
        a() {
        }

        @Override // p1.a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* JADX INFO: compiled from: SafeKeyGenerator.java */
    private static final class b implements a.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MessageDigest f35316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final p1.c f35317b = p1.c.a();

        b(MessageDigest messageDigest) {
            this.f35316a = messageDigest;
        }

        @Override // p1.a.f
        @NonNull
        public p1.c c() {
            return this.f35317b;
        }
    }

    private String a(r0.f fVar) {
        b bVar = (b) o1.j.d(this.f35314b.acquire());
        try {
            fVar.b(bVar.f35316a);
            return k.s(bVar.f35316a.digest());
        } finally {
            this.f35314b.release(bVar);
        }
    }

    public String b(r0.f fVar) {
        String strG;
        synchronized (this.f35313a) {
            strG = this.f35313a.g(fVar);
        }
        if (strG == null) {
            strG = a(fVar);
        }
        synchronized (this.f35313a) {
            this.f35313a.k(fVar, strG);
        }
        return strG;
    }
}
