package b4;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import k2.h;

/* JADX INFO: compiled from: ColorInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements k2.h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f2083f = new c(1, 2, 3, null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final h.a<c> f2084g = new h.a() { // from class: b4.b
        @Override // k2.h.a
        public final k2.h fromBundle(Bundle bundle) {
            return c.e(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final byte[] f2088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2089e;

    public c(int i10, int i11, int i12, @Nullable byte[] bArr) {
        this.f2085a = i10;
        this.f2086b = i11;
        this.f2087c = i12;
        this.f2088d = bArr;
    }

    public static int b(int i10) {
        if (i10 == 1) {
            return 1;
        }
        if (i10 != 9) {
            return (i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int c(int i10) {
        if (i10 == 1) {
            return 3;
        }
        if (i10 == 16) {
            return 6;
        }
        if (i10 != 18) {
            return (i10 == 6 || i10 == 7) ? 3 : -1;
        }
        return 7;
    }

    private static String d(int i10) {
        return Integer.toString(i10, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c e(Bundle bundle) {
        return new c(bundle.getInt(d(0), -1), bundle.getInt(d(1), -1), bundle.getInt(d(2), -1), bundle.getByteArray(d(3)));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f2085a == cVar.f2085a && this.f2086b == cVar.f2086b && this.f2087c == cVar.f2087c && Arrays.equals(this.f2088d, cVar.f2088d);
    }

    public int hashCode() {
        if (this.f2089e == 0) {
            this.f2089e = ((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f2085a) * 31) + this.f2086b) * 31) + this.f2087c) * 31) + Arrays.hashCode(this.f2088d);
        }
        return this.f2089e;
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(d(0), this.f2085a);
        bundle.putInt(d(1), this.f2086b);
        bundle.putInt(d(2), this.f2087c);
        bundle.putByteArray(d(3), this.f2088d);
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(this.f2085a);
        sb.append(", ");
        sb.append(this.f2086b);
        sb.append(", ");
        sb.append(this.f2087c);
        sb.append(", ");
        sb.append(this.f2088d != null);
        sb.append(")");
        return sb.toString();
    }
}
