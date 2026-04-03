package com.king.amp.sa;

import android.os.Bundle;
import android.os.Parcelable;
import com.ironsource.sdk.controller.f;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes4.dex */
public class t1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static t1 f16971b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f16972a;

    private t1(a aVar) {
        if (aVar != null) {
            this.f16972a = aVar;
        } else {
            this.f16972a = new k1();
        }
    }

    private static void a(Bundle bundle, AdProviderNameValuePairs adProviderNameValuePairs) {
        if (bundle.containsKey("CreativeDurationMs")) {
            adProviderNameValuePairs.add("adDuration", Double.valueOf(((double) bundle.getInt("CreativeDurationMs")) / 1000.0d));
        }
    }

    private static void b(Bundle bundle, String str, String str2, AdProviderNameValuePairs adProviderNameValuePairs) {
        String string = bundle.getString(str2);
        if (string == null || string.isEmpty()) {
            return;
        }
        adProviderNameValuePairs.add(str, string);
    }

    private static void c(Bundle bundle, AdProviderNameValuePairs adProviderNameValuePairs) {
        Parcelable[] parcelableArray = bundle.getParcelableArray("Wrappers");
        if (parcelableArray == null || parcelableArray.length < 1) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Parcelable parcelable : parcelableArray) {
            Bundle bundle2 = parcelable instanceof Bundle ? (Bundle) parcelable : null;
            if (bundle2 == null) {
                g("Utils", "Metadata wrapper is not of type Bundle");
            } else {
                String string = bundle2.getString("AdId");
                if (string != null && !string.isEmpty()) {
                    sb.append(string);
                    sb.append(",");
                }
                String string2 = bundle2.getString("AdSystem");
                if (string2 != null && !string2.isEmpty()) {
                    sb2.append(string2);
                    sb2.append(",");
                }
            }
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        if (sb2.length() > 0) {
            sb2.setLength(sb2.length() - 1);
        }
        adProviderNameValuePairs.add("wrapperAdIds", sb.toString());
        adProviderNameValuePairs.add("wrapperAdSystems", sb2.toString());
    }

    public static synchronized t1 d(a aVar) {
        if (f16971b == null) {
            f16971b = new t1(aVar);
        }
        return f16971b;
    }

    public static void e(String str, String str2) {
        d(null).f16972a.a(str, str2);
    }

    public static void f(Bundle bundle, AdProviderNameValuePairs adProviderNameValuePairs) {
        b(bundle, f.b.f15004c, "AdId", adProviderNameValuePairs);
        b(bundle, "adCreativeName", "AdTitle", adProviderNameValuePairs);
        b(bundle, "dealId", "DealId", adProviderNameValuePairs);
        b(bundle, "adTagUrid", "adtagurid", adProviderNameValuePairs);
        a(bundle, adProviderNameValuePairs);
        b(bundle, "vastAdSystem", "AdSystem", adProviderNameValuePairs);
        b(bundle, "vastCreativeId", "CreativeId", adProviderNameValuePairs);
        b(bundle, "mainAssetUrl", "MediaUrl", adProviderNameValuePairs);
        c(bundle, adProviderNameValuePairs);
    }

    public static void g(String str, String str2) {
        d(null).f16972a.b(str, str2);
    }
}
