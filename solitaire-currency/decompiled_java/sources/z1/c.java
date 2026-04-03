package z1;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: AutoValue_CreationContext.java */
/* JADX INFO: loaded from: classes2.dex */
final class c extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f36978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i2.a f36979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i2.a f36980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f36981d;

    c(Context context, i2.a aVar, i2.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f36978a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f36979b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f36980c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f36981d = str;
    }

    @Override // z1.h
    public Context b() {
        return this.f36978a;
    }

    @Override // z1.h
    @NonNull
    public String c() {
        return this.f36981d;
    }

    @Override // z1.h
    public i2.a d() {
        return this.f36980c;
    }

    @Override // z1.h
    public i2.a e() {
        return this.f36979b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f36978a.equals(hVar.b()) && this.f36979b.equals(hVar.e()) && this.f36980c.equals(hVar.d()) && this.f36981d.equals(hVar.c());
    }

    public int hashCode() {
        return ((((((this.f36978a.hashCode() ^ 1000003) * 1000003) ^ this.f36979b.hashCode()) * 1000003) ^ this.f36980c.hashCode()) * 1000003) ^ this.f36981d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f36978a + ", wallClock=" + this.f36979b + ", monotonicClock=" + this.f36980c + ", backendName=" + this.f36981d + "}";
    }
}
