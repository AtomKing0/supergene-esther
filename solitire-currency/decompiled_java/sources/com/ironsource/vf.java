package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class vf implements td {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Object> f15897a = new HashMap();

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f15899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f15900c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Context f15901d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f15902e;

        b a(Context context) {
            this.f15901d = context;
            return this;
        }

        b b(String str) {
            this.f15900c = str;
            return this;
        }

        b c(String str) {
            this.f15898a = str;
            return this;
        }

        b d(String str) {
            this.f15902e = str;
            return this;
        }

        b a(String str) {
            this.f15899b = str;
            return this;
        }

        public vf a() {
            return new vf(this);
        }
    }

    private vf(b bVar) {
        a(bVar);
        a(bVar.f15901d);
    }

    public static void b(String str) {
        f15897a.put(nb.f14108f, SDKUtils.encodeString(str));
    }

    @Override // com.ironsource.td
    public Map<String, Object> a() {
        return f15897a;
    }

    private void a(Context context) {
        f15897a.put(nb.f14107e, s8.b(context));
        f15897a.put(nb.f14108f, s8.d(context));
    }

    private void a(b bVar) {
        Context context = bVar.f15901d;
        la laVarB = la.b(context);
        f15897a.put(nb.f14112j, SDKUtils.encodeString(laVarB.e()));
        f15897a.put(nb.f14113k, SDKUtils.encodeString(laVarB.f()));
        f15897a.put(nb.f14114l, Integer.valueOf(laVarB.a()));
        f15897a.put(nb.f14115m, SDKUtils.encodeString(laVarB.d()));
        f15897a.put(nb.f14116n, SDKUtils.encodeString(laVarB.c()));
        f15897a.put(nb.f14106d, SDKUtils.encodeString(context.getPackageName()));
        f15897a.put(nb.f14109g, SDKUtils.encodeString(bVar.f15899b));
        f15897a.put("sessionid", SDKUtils.encodeString(bVar.f15898a));
        f15897a.put(nb.f14104b, SDKUtils.encodeString(SDKUtils.getSDKVersion()));
        f15897a.put("env", nb.f14122t);
        f15897a.put("origin", nb.f14119q);
        if (TextUtils.isEmpty(bVar.f15902e)) {
            return;
        }
        f15897a.put(nb.f14111i, SDKUtils.encodeString(bVar.f15902e));
    }

    public static void a(String str) {
        f15897a.put(nb.f14107e, SDKUtils.encodeString(str));
    }
}
