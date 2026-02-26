package o1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: MultiClassKey.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class<?> f31805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class<?> f31806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Class<?> f31807c;

    public i() {
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f31805a = cls;
        this.f31806b = cls2;
        this.f31807c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f31805a.equals(iVar.f31805a) && this.f31806b.equals(iVar.f31806b) && k.c(this.f31807c, iVar.f31807c);
    }

    public int hashCode() {
        int iHashCode = ((this.f31805a.hashCode() * 31) + this.f31806b.hashCode()) * 31;
        Class<?> cls = this.f31807c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f31805a + ", second=" + this.f31806b + '}';
    }

    public i(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
