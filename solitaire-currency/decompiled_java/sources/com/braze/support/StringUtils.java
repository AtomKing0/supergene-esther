package com.braze.support;

import android.content.Context;
import android.content.SharedPreferences;
import bo.app.xc0;
import bo.app.yc0;
import com.braze.support.BrazeLogger;
import h9.l;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.s0;
import kotlin.jvm.internal.t;
import p9.q;
import v8.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class StringUtils {
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("StringUtils");

    public static final long getByteSize(String str) {
        t.i(str, "<this>");
        t.h(str.getBytes(p9.d.f32952b), "this as java.lang.String).getBytes(charset)");
        return r2.length;
    }

    public static final String getCacheFileSuffix(Context context, String str, String str2) throws NoSuchAlgorithmException {
        t.i(context, "context");
        String str3 = str == null ? "null" : str;
        if (t.d(str3, "null")) {
            return getSuffixFromUserIdHashAndApiKey("37a6259cc0c1dae299a7866489dff0bd", str2);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.support.stringutils.cachefilesuffix", 0);
        String string = sharedPreferences.getString("user_id_key", null);
        if (string != null && t.d(string, str3)) {
            String string2 = sharedPreferences.getString("user_id_hash_value", null);
            if (string2 != null && string2.length() != 0) {
                return getSuffixFromUserIdHashAndApiKey(string2, str2);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) xc0.f4262a, 14, (Object) null);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new yc0(str3, str2), 12, (Object) null);
        String md5Hash = getMd5Hash(str3);
        sharedPreferences.edit().putString("user_id_key", str3).putString("user_id_hash_value", md5Hash).apply();
        return getSuffixFromUserIdHashAndApiKey(md5Hash, str2);
    }

    public static final String getMd5Hash(String str) throws NoSuchAlgorithmException {
        t.i(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes(p9.d.f32952b);
        t.h(bytes, "this as java.lang.String).getBytes(charset)");
        BigInteger bigInteger = new BigInteger(1, messageDigest.digest(bytes));
        s0 s0Var = s0.f29840a;
        String str2 = String.format(Locale.US, "%032x", Arrays.copyOf(new Object[]{bigInteger}, 1));
        t.h(str2, "format(locale, format, *args)");
        return str2;
    }

    private static final String getSuffixFromUserIdHashAndApiKey(String str, String str2) {
        if (str2 == null || q.z(str2)) {
            return "." + str;
        }
        return "." + str + '.' + str2;
    }

    public static final void ifNonEmpty(String str, l<? super String, k0> block) {
        t.i(block, "block");
        if (str == null || str.length() == 0) {
            return;
        }
        block.invoke(str);
    }

    public static final boolean isNullOrBlank(String str) {
        return str == null || q.z(str);
    }

    public static final String truncateToByteLength(String str, int i10) {
        t.i(str, "<this>");
        if (getByteSize(str) <= i10) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        t.h(charArray, "this as java.lang.String).toCharArray()");
        int byteSize = 0;
        for (char c10 : charArray) {
            byteSize += (int) getByteSize(String.valueOf(c10));
            if (byteSize > i10) {
                break;
            }
            sb.append(c10);
        }
        String string = sb.toString();
        t.h(string, "truncatedStringBuilder.toString()");
        return string;
    }

    public static final String getCacheFileSuffix(Context context, String str) {
        t.i(context, "context");
        return getCacheFileSuffix(context, str, null);
    }
}
