package n1;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import o1.j;
import r0.f;

/* JADX INFO: compiled from: ObjectKey.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f31559b;

    public b(@NonNull Object obj) {
        this.f31559b = j.d(obj);
    }

    @Override // r0.f
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f31559b.toString().getBytes(f.f33247a));
    }

    @Override // r0.f
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f31559b.equals(((b) obj).f31559b);
        }
        return false;
    }

    @Override // r0.f
    public int hashCode() {
        return this.f31559b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f31559b + '}';
    }
}
