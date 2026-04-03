package y1;

import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: compiled from: EncodedPayload.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w1.c f36410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f36411b;

    public h(@NonNull w1.c cVar, @NonNull byte[] bArr) {
        if (cVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f36410a = cVar;
        this.f36411b = bArr;
    }

    public byte[] a() {
        return this.f36411b;
    }

    public w1.c b() {
        return this.f36410a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f36410a.equals(hVar.f36410a)) {
            return Arrays.equals(this.f36411b, hVar.f36411b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f36410a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f36411b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f36410a + ", bytes=[...]}";
    }
}
