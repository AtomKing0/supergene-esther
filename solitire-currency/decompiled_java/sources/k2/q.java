package k2;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.io.IOException;
import k2.h;

/* JADX INFO: compiled from: ExoPlaybackException.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q extends n2 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final h.a<q> f29410k = new h.a() { // from class: k2.p
        @Override // k2.h.a
        public final h fromBundle(Bundle bundle) {
            return q.e(bundle);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f29411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f29412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f29413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final o1 f29414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f29415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final l3.y f29416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final boolean f29417j;

    private q(int i10, Throwable th, int i11) {
        this(i10, th, null, i11, null, -1, null, 4, false);
    }

    public static /* synthetic */ q e(Bundle bundle) {
        return new q(bundle);
    }

    public static q g(Throwable th, String str, int i10, @Nullable o1 o1Var, int i11, boolean z10, int i12) {
        return new q(1, th, null, i12, str, i10, o1Var, o1Var == null ? 4 : i11, z10);
    }

    public static q h(IOException iOException, int i10) {
        return new q(0, iOException, i10);
    }

    @Deprecated
    public static q i(RuntimeException runtimeException) {
        return j(runtimeException, 1000);
    }

    public static q j(RuntimeException runtimeException, int i10) {
        return new q(2, runtimeException, i10);
    }

    private static String k(int i10, @Nullable String str, @Nullable String str2, int i11, @Nullable o1 o1Var, int i12) {
        String str3;
        if (i10 == 0) {
            str3 = "Source error";
        } else if (i10 != 1) {
            str3 = i10 != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            str3 = str2 + " error, index=" + i11 + ", format=" + o1Var + ", format_supported=" + a4.o0.R(i12);
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str3 + ": " + str;
    }

    @CheckResult
    q f(@Nullable l3.y yVar) {
        return new q((String) a4.o0.j(getMessage()), getCause(), this.f29293a, this.f29411d, this.f29412e, this.f29413f, this.f29414g, this.f29415h, yVar, this.f29294b, this.f29417j);
    }

    @Override // k2.n2, k2.h
    public Bundle toBundle() {
        Bundle bundle = super.toBundle();
        bundle.putInt(n2.d(1001), this.f29411d);
        bundle.putString(n2.d(1002), this.f29412e);
        bundle.putInt(n2.d(1003), this.f29413f);
        if (this.f29414g != null) {
            bundle.putBundle(n2.d(1004), this.f29414g.toBundle());
        }
        bundle.putInt(n2.d(1005), this.f29415h);
        bundle.putBoolean(n2.d(1006), this.f29417j);
        return bundle;
    }

    private q(int i10, @Nullable Throwable th, @Nullable String str, int i11, @Nullable String str2, int i12, @Nullable o1 o1Var, int i13, boolean z10) {
        this(k(i10, str, str2, i12, o1Var, i13), th, i11, i10, str2, i12, o1Var, i13, null, SystemClock.elapsedRealtime(), z10);
    }

    private q(Bundle bundle) {
        super(bundle);
        this.f29411d = bundle.getInt(n2.d(1001), 2);
        this.f29412e = bundle.getString(n2.d(1002));
        this.f29413f = bundle.getInt(n2.d(1003), -1);
        Bundle bundle2 = bundle.getBundle(n2.d(1004));
        this.f29414g = bundle2 == null ? null : (o1) o1.H.fromBundle(bundle2);
        this.f29415h = bundle.getInt(n2.d(1005), 4);
        this.f29417j = bundle.getBoolean(n2.d(1006), false);
        this.f29416i = null;
    }

    private q(String str, @Nullable Throwable th, int i10, int i11, @Nullable String str2, int i12, @Nullable o1 o1Var, int i13, @Nullable l3.y yVar, long j10, boolean z10) {
        super(str, th, i10, j10);
        a4.a.a(!z10 || i11 == 1);
        a4.a.a(th != null || i11 == 3);
        this.f29411d = i11;
        this.f29412e = str2;
        this.f29413f = i12;
        this.f29414g = o1Var;
        this.f29415h = i13;
        this.f29416i = yVar;
        this.f29417j = z10;
    }
}
