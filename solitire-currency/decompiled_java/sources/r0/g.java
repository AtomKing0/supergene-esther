package r0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.security.MessageDigest;

/* JADX INFO: compiled from: Option.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final b<Object> f33248e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f33249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b<T> f33250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f33251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile byte[] f33252d;

    /* JADX INFO: compiled from: Option.java */
    public interface b<T> {
        void a(@NonNull byte[] bArr, @NonNull T t10, @NonNull MessageDigest messageDigest);
    }

    private g(@NonNull String str, @Nullable T t10, @NonNull b<T> bVar) {
        this.f33251c = o1.j.b(str);
        this.f33249a = t10;
        this.f33250b = (b) o1.j.d(bVar);
    }

    @NonNull
    public static <T> g<T> a(@NonNull String str, @Nullable T t10, @NonNull b<T> bVar) {
        return new g<>(str, t10, bVar);
    }

    @NonNull
    private static <T> b<T> b() {
        return (b<T>) f33248e;
    }

    @NonNull
    private byte[] d() {
        if (this.f33252d == null) {
            this.f33252d = this.f33251c.getBytes(f.f33247a);
        }
        return this.f33252d;
    }

    @NonNull
    public static <T> g<T> e(@NonNull String str) {
        return new g<>(str, null, b());
    }

    @NonNull
    public static <T> g<T> f(@NonNull String str, @NonNull T t10) {
        return new g<>(str, t10, b());
    }

    @Nullable
    public T c() {
        return this.f33249a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f33251c.equals(((g) obj).f33251c);
        }
        return false;
    }

    public void g(@NonNull T t10, @NonNull MessageDigest messageDigest) {
        this.f33250b.a(d(), t10, messageDigest);
    }

    public int hashCode() {
        return this.f33251c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f33251c + "'}";
    }

    /* JADX INFO: compiled from: Option.java */
    class a implements b<Object> {
        a() {
        }

        @Override // r0.g.b
        public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }
}
