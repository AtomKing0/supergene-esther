package k2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import k2.h;

/* JADX INFO: compiled from: DeviceInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o f29330d = new o(0, 0, 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h.a<o> f29331e = new h.a() { // from class: k2.n
        @Override // k2.h.a
        public final h fromBundle(Bundle bundle) {
            return o.c(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f29332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f29333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f29334c;

    public o(int i10, int i11, int i12) {
        this.f29332a = i10;
        this.f29333b = i11;
        this.f29334c = i12;
    }

    private static String b(int i10) {
        return Integer.toString(i10, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o c(Bundle bundle) {
        return new o(bundle.getInt(b(0), 0), bundle.getInt(b(1), 0), bundle.getInt(b(2), 0));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f29332a == oVar.f29332a && this.f29333b == oVar.f29333b && this.f29334c == oVar.f29334c;
    }

    public int hashCode() {
        return ((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f29332a) * 31) + this.f29333b) * 31) + this.f29334c;
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(b(0), this.f29332a);
        bundle.putInt(b(1), this.f29333b);
        bundle.putInt(b(2), this.f29334c);
        return bundle;
    }
}
