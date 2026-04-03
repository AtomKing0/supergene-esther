package w1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: Encoding.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f35323a;

    private c(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f35323a = str;
    }

    public static c b(@NonNull String str) {
        return new c(str);
    }

    public String a() {
        return this.f35323a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return this.f35323a.equals(((c) obj).f35323a);
        }
        return false;
    }

    public int hashCode() {
        return this.f35323a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return "Encoding{name=\"" + this.f35323a + "\"}";
    }
}
