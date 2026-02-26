package com.ironsource;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class un {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f15599a = "com.google.market";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f15600b = "com.android.vending";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f15601c = "isInstalled";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f15602d = "un";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ArrayList<String> f15603e = new a();

    class a extends ArrayList<String> {
        a() {
            add(un.f15599a);
            add("com.android.vending");
        }
    }

    class b extends JSONObject {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f15604a;

        b(boolean z10) throws JSONException {
            this.f15604a = z10;
            put("isInstalled", z10);
        }
    }

    private enum c {
        GOOGLE_PLAY(2, new String[]{"com.android.vending"}),
        GOOGLE_MARKET(4, new String[]{un.f15599a}),
        SAMSUNG(5, new String[]{"com.sec.android.app.samsungapps"}),
        AMAZON(6, new String[]{"com.amazon.venezia"}),
        HUAWEI(7, new String[]{"com.huawei.appmarket"});


        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final Map<String, c> f15610h = new HashMap();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f15612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String[] f15613b;

        static {
            for (c cVar : values()) {
                for (String str : cVar.d()) {
                    f15610h.put(str, cVar);
                }
            }
        }

        c(int i10, String[] strArr) {
            this.f15612a = i10;
            this.f15613b = strArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int c() {
            return this.f15612a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String[] d() {
            return this.f15613b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ArrayList<String> b() {
            return new ArrayList<>(f15610h.keySet());
        }
    }

    private static JSONObject a(Context context) {
        return a(context, f15603e);
    }

    private static ArrayList<String> b(Context context) {
        List<ApplicationInfo> listO = el.N().f().o(context);
        ArrayList<String> arrayList = new ArrayList<>();
        for (ApplicationInfo applicationInfo : listO) {
            if (applicationInfo != null) {
                arrayList.add(applicationInfo.packageName.toLowerCase(Locale.getDefault()));
            }
        }
        return arrayList;
    }

    public static Integer c(Context context) {
        JSONObject jSONObjectA = a(context, c.b());
        int iPow = 0;
        for (c cVar : c.values()) {
            String[] strArrD = cVar.d();
            int length = strArrD.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                JSONObject jSONObjectOptJSONObject = jSONObjectA.optJSONObject(strArrD[i10]);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optBoolean("isInstalled")) {
                    iPow = (int) (((double) iPow) + Math.pow(2.0d, r5.c() - 1));
                    break;
                }
                i10++;
            }
        }
        return Integer.valueOf(iPow);
    }

    public static boolean d(Context context) {
        JSONObject jSONObjectA = a(context);
        Iterator<String> itKeys = jSONObjectA.keys();
        while (itKeys.hasNext()) {
            JSONObject jSONObjectOptJSONObject = jSONObjectA.optJSONObject(itKeys.next());
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optBoolean("isInstalled")) {
                return true;
            }
        }
        return false;
    }

    private static JSONObject a(Context context, ArrayList<String> arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList<String> arrayListB = b(context);
            for (String str : arrayList) {
                jSONObject.put(str, a(arrayListB.contains(str.trim().toLowerCase(Locale.getDefault()))));
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            Log.d(f15602d, "Error while extracting packages installation data");
        }
        return jSONObject;
    }

    private static JSONObject a(boolean z10) throws JSONException {
        return new b(z10);
    }
}
