package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.Objects;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: TopicOperation.java */
/* JADX INFO: loaded from: classes3.dex */
final class b1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f10368d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10371c;

    private b1(String str, String str2) {
        this.f10369a = d(str2, str);
        this.f10370b = str;
        this.f10371c = str + "!" + str2;
    }

    @Nullable
    static b1 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("!", -1);
        if (strArrSplit.length != 2) {
            return null;
        }
        return new b1(strArrSplit[0], strArrSplit[1]);
    }

    @NonNull
    private static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str2));
            str = str.substring(8);
        }
        if (str == null || !f10368d.matcher(str).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", str, "[a-zA-Z0-9-_.~%]{1,900}"));
        }
        return str;
    }

    public static b1 f(@NonNull String str) {
        return new b1(ExifInterface.LATITUDE_SOUTH, str);
    }

    public static b1 g(@NonNull String str) {
        return new b1("U", str);
    }

    public String b() {
        return this.f10370b;
    }

    public String c() {
        return this.f10369a;
    }

    public String e() {
        return this.f10371c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof b1)) {
            return false;
        }
        b1 b1Var = (b1) obj;
        return this.f10369a.equals(b1Var.f10369a) && this.f10370b.equals(b1Var.f10370b);
    }

    public int hashCode() {
        return Objects.hashCode(this.f10370b, this.f10369a);
    }
}
