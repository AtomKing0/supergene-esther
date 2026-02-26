package z3;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ironsource.v8;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: HttpUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f37380a = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f37381b = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    @Nullable
    public static String a(long j10, long j11) {
        if (j10 == 0 && j11 == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bytes=");
        sb.append(j10);
        sb.append("-");
        if (j11 != -1) {
            sb.append((j10 + j11) - 1);
        }
        return sb.toString();
    }

    public static long b(@Nullable String str, @Nullable String str2) {
        long j10;
        if (TextUtils.isEmpty(str)) {
            j10 = -1;
        } else {
            try {
                j10 = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                a4.t.c("HttpUtil", "Unexpected Content-Length [" + str + v8.i.f15839e);
                j10 = -1;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return j10;
        }
        Matcher matcher = f37380a.matcher(str2);
        if (!matcher.matches()) {
            return j10;
        }
        try {
            long j11 = (Long.parseLong((String) a4.a.e(matcher.group(2))) - Long.parseLong((String) a4.a.e(matcher.group(1)))) + 1;
            if (j10 < 0) {
                return j11;
            }
            if (j10 == j11) {
                return j10;
            }
            a4.t.i("HttpUtil", "Inconsistent headers [" + str + "] [" + str2 + v8.i.f15839e);
            return Math.max(j10, j11);
        } catch (NumberFormatException unused2) {
            a4.t.c("HttpUtil", "Unexpected Content-Range [" + str2 + v8.i.f15839e);
            return j10;
        }
    }

    public static long c(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = f37381b.matcher(str);
        if (matcher.matches()) {
            return Long.parseLong((String) a4.a.e(matcher.group(1)));
        }
        return -1L;
    }
}
