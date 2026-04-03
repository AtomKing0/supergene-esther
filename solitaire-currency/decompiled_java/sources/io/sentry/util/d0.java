package io.sentry.util;

import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import io.sentry.SentryLevel;
import io.sentry.w0;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Charset f28342a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Pattern f28343b = Pattern.compile("[\\W_]+");

    @Nullable
    public static String a(@Nullable String str, @NotNull w0 w0Var) {
        if (str != null && !str.isEmpty()) {
            try {
                return new StringBuilder(new BigInteger(1, MessageDigest.getInstance(AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1).digest(str.getBytes(f28342a))).toString(16)).toString();
            } catch (NoSuchAlgorithmException e10) {
                w0Var.b(SentryLevel.INFO, "SHA-1 isn't available to calculate the hash.", e10);
            } catch (Throwable th) {
                w0Var.c(SentryLevel.INFO, "string: %s could not calculate its hash", th, str);
            }
        }
        return null;
    }

    @Nullable
    public static String b(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] strArrSplit = f28343b.split(str, -1);
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            sb.append(c(str2));
        }
        return sb.toString();
    }

    @Nullable
    public static String c(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        Locale locale = Locale.ROOT;
        sb.append(strSubstring.toUpperCase(locale));
        sb.append(str.substring(1).toLowerCase(locale));
        return sb.toString();
    }

    public static int d(@NotNull String str, char c10) {
        int i10 = 0;
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (str.charAt(i11) == c10) {
                i10++;
            }
        }
        return i10;
    }

    @Nullable
    public static String e(@Nullable String str) {
        int i10;
        if (str == null) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(".");
        return (iLastIndexOf < 0 || str.length() <= (i10 = iLastIndexOf + 1)) ? str : str.substring(i10);
    }

    public static String f(@NotNull CharSequence charSequence, @NotNull Iterable<? extends CharSequence> iterable) {
        StringBuilder sb = new StringBuilder();
        Iterator<? extends CharSequence> it = iterable.iterator();
        if (it.hasNext()) {
            sb.append(it.next());
            while (it.hasNext()) {
                sb.append(charSequence);
                sb.append(it.next());
            }
        }
        return sb.toString();
    }

    public static String g(@NotNull String str) {
        return str.equals("0000-0000") ? "00000000-0000-0000-0000-000000000000" : str;
    }

    @Nullable
    public static String h(@Nullable String str, @Nullable String str2) {
        return (str == null || str2 == null || !str.startsWith(str2) || !str.endsWith(str2)) ? str : str.substring(str2.length(), str.length() - str2.length());
    }

    @Nullable
    public static String i(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }
}
