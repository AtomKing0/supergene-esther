package com.google.android.datatransport.cct;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import y1.g;

/* JADX INFO: compiled from: CCTDestination.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String f8414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String f8415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f8416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Set<w1.c> f8417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f8418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f8419h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final String f8420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f8421b;

    static {
        String strA = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f8414c = strA;
        String strA2 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f8415d = strA2;
        String strA3 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f8416e = strA3;
        f8417f = Collections.unmodifiableSet(new HashSet(Arrays.asList(w1.c.b("proto"), w1.c.b("json"))));
        f8418g = new a(strA, null);
        f8419h = new a(strA2, strA3);
    }

    public a(@NonNull String str, @Nullable String str2) {
        this.f8420a = str;
        this.f8421b = str2;
    }

    @NonNull
    public static a c(@NonNull byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }

    @Override // y1.g
    public Set<w1.c> a() {
        return f8417f;
    }

    @Nullable
    public byte[] b() {
        String str = this.f8421b;
        if (str == null && this.f8420a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f8420a;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    @Nullable
    public String d() {
        return this.f8421b;
    }

    @NonNull
    public String e() {
        return this.f8420a;
    }

    @Override // y1.f
    @Nullable
    public byte[] getExtras() {
        return b();
    }

    @Override // y1.f
    @NonNull
    public String getName() {
        return "cct";
    }
}
