package bo.app;

import android.util.Base64;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class we0 implements g10 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f4200d = BrazeLogger.getBrazeLogTag((Class<?>) we0.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e00 f4203c;

    public we0() {
        long jNowInMilliseconds = DateTimeUtils.nowInMilliseconds();
        this.f4202b = jNowInMilliseconds;
        this.f4201a = jNowInMilliseconds / 1000;
    }

    public static String a(String str) {
        if (StringUtils.isNullOrBlank(str)) {
            return null;
        }
        try {
            return new String(Base64.decode(str, 0)).split("_")[0];
        } catch (Exception e10) {
            BrazeLogger.e(f4200d, "Unexpected error decoding Base64 encoded campaign Id " + str, e10);
            return null;
        }
    }

    public we0(e00 e00Var) {
        this();
        this.f4203c = e00Var;
    }
}
