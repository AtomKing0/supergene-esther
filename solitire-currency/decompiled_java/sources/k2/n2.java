package k2;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import k2.h;

/* JADX INFO: compiled from: PlaybackException.java */
/* JADX INFO: loaded from: classes2.dex */
public class n2 extends Exception implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h.a<n2> f29292c = new h.a() { // from class: k2.m2
        @Override // k2.h.a
        public final h fromBundle(Bundle bundle) {
            return new n2(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f29293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f29294b;

    protected n2(Bundle bundle) {
        this(bundle.getString(d(2)), c(bundle), bundle.getInt(d(0), 1000), bundle.getLong(d(1), SystemClock.elapsedRealtime()));
    }

    private static RemoteException a(@Nullable String str) {
        return new RemoteException(str);
    }

    private static Throwable b(Class<?> cls, @Nullable String str) throws Exception {
        return (Throwable) cls.getConstructor(String.class).newInstance(str);
    }

    @Nullable
    private static Throwable c(Bundle bundle) {
        String string = bundle.getString(d(3));
        String string2 = bundle.getString(d(4));
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(string, true, n2.class.getClassLoader());
            Throwable thB = Throwable.class.isAssignableFrom(cls) ? b(cls, string2) : null;
            if (thB != null) {
                return thB;
            }
        } catch (Throwable unused) {
        }
        return a(string2);
    }

    protected static String d(int i10) {
        return Integer.toString(i10, 36);
    }

    @Override // k2.h
    @CallSuper
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(d(0), this.f29293a);
        bundle.putLong(d(1), this.f29294b);
        bundle.putString(d(2), getMessage());
        Throwable cause = getCause();
        if (cause != null) {
            bundle.putString(d(3), cause.getClass().getName());
            bundle.putString(d(4), cause.getMessage());
        }
        return bundle;
    }

    protected n2(@Nullable String str, @Nullable Throwable th, int i10, long j10) {
        super(str, th);
        this.f29293a = i10;
        this.f29294b = j10;
    }
}
