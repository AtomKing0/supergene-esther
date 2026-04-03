package k2;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: RendererConfiguration.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d3 f29074b = new d3(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f29075a;

    public d3(boolean z10) {
        this.f29075a = z10;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && d3.class == obj.getClass() && this.f29075a == ((d3) obj).f29075a;
    }

    public int hashCode() {
        return !this.f29075a ? 1 : 0;
    }
}
