package a4;

import androidx.annotation.Nullable;
import io.sentry.protocol.ViewHierarchyNode;

/* JADX INFO: compiled from: Size.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g0 f164c = new g0(-1, -1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f166b;

    public g0(int i10, int i11) {
        a.a((i10 == -1 || i10 >= 0) && (i11 == -1 || i11 >= 0));
        this.f165a = i10;
        this.f166b = i11;
    }

    public int a() {
        return this.f166b;
    }

    public int b() {
        return this.f165a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.f165a == g0Var.f165a && this.f166b == g0Var.f166b;
    }

    public int hashCode() {
        int i10 = this.f166b;
        int i11 = this.f165a;
        return i10 ^ ((i11 >>> 16) | (i11 << 16));
    }

    public String toString() {
        return this.f165a + ViewHierarchyNode.JsonKeys.X + this.f166b;
    }
}
