package r0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.security.MessageDigest;

/* JADX INFO: compiled from: Options.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayMap<g<?>, Object> f33253b = new o1.b();

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void f(@NonNull g<T> gVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        gVar.g(obj, messageDigest);
    }

    @Override // r0.f
    public void b(@NonNull MessageDigest messageDigest) {
        for (int i10 = 0; i10 < this.f33253b.size(); i10++) {
            f(this.f33253b.keyAt(i10), this.f33253b.valueAt(i10), messageDigest);
        }
    }

    @Nullable
    public <T> T c(@NonNull g<T> gVar) {
        return this.f33253b.containsKey(gVar) ? (T) this.f33253b.get(gVar) : gVar.c();
    }

    public void d(@NonNull h hVar) {
        this.f33253b.putAll((SimpleArrayMap<? extends g<?>, ? extends Object>) hVar.f33253b);
    }

    @NonNull
    public <T> h e(@NonNull g<T> gVar, @NonNull T t10) {
        this.f33253b.put(gVar, t10);
        return this;
    }

    @Override // r0.f
    public boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f33253b.equals(((h) obj).f33253b);
        }
        return false;
    }

    @Override // r0.f
    public int hashCode() {
        return this.f33253b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f33253b + '}';
    }
}
