package com.ironsource;

import com.ironsource.mediationsdk.impressionData.ImpressionData;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class f5 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f12047n = "adMarkup";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f12048o = "instance";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f12049p = "adData";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f12050q = "price";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f12051r = "serverData";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f12052s = "loadTimeout";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f12053t = "order";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f12054u = "show";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f12055v = "price";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f12056w = "notifications";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f12057x = "burl";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f12058y = "lurl";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f12059z = "nurl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f12062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f12063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Integer f12064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f12065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f12066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f12067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<String> f12068i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<String> f12069j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<String> f12070k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ImpressionData f12071l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f12072m;

    public f5(String str) {
        this.f12060a = null;
        this.f12061b = "";
        this.f12062c = null;
        this.f12063d = "";
        this.f12064e = null;
        this.f12065f = -1;
        this.f12066g = -1;
        this.f12067h = -1;
        this.f12068i = new ArrayList();
        this.f12069j = new ArrayList();
        this.f12070k = new ArrayList();
        this.f12071l = null;
        this.f12072m = true;
        this.f12060a = str;
    }

    public ImpressionData a(String str) {
        ImpressionData impressionData = this.f12071l;
        if (impressionData == null) {
            return null;
        }
        ImpressionData impressionData2 = new ImpressionData(impressionData);
        impressionData2.replaceMacroForPlacementWithValue(com.ironsource.mediationsdk.d.f13336q, str);
        return impressionData2;
    }

    public List<String> b() {
        return this.f12068i;
    }

    public String c() {
        return this.f12060a;
    }

    public int d() {
        return this.f12065f;
    }

    @Nullable
    public Integer e() {
        return this.f12064e;
    }

    public List<String> f() {
        return this.f12069j;
    }

    public List<String> g() {
        return this.f12070k;
    }

    public String h() {
        return this.f12063d;
    }

    public int i() {
        return this.f12067h;
    }

    public String j() {
        return this.f12061b;
    }

    public int k() {
        return this.f12066g;
    }

    public boolean l() {
        return this.f12072m;
    }

    public f5(JSONObject jSONObject) {
        this(jSONObject, -1, null);
    }

    @Nullable
    public JSONObject a() {
        return this.f12062c;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007b A[Catch: Exception -> 0x00c7, TryCatch #0 {Exception -> 0x00c7, blocks: (B:3:0x003c, B:5:0x0042, B:6:0x0048, B:8:0x004e, B:12:0x0061, B:13:0x0063, B:15:0x007b, B:16:0x008e, B:18:0x00ac, B:19:0x00bb, B:9:0x0053, B:11:0x0059), top: B:24:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ac A[Catch: Exception -> 0x00c7, TryCatch #0 {Exception -> 0x00c7, blocks: (B:3:0x003c, B:5:0x0042, B:6:0x0048, B:8:0x004e, B:12:0x0061, B:13:0x0063, B:15:0x007b, B:16:0x008e, B:18:0x00ac, B:19:0x00bb, B:9:0x0053, B:11:0x0059), top: B:24:0x003c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public f5(org.json.JSONObject r13, int r14, org.json.JSONObject r15) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.f5.<init>(org.json.JSONObject, int, org.json.JSONObject):void");
    }

    private void a(@Nullable JSONObject jSONObject, int i10) {
        this.f12065f = i10;
        this.f12066g = i10;
        this.f12067h = i10;
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt(f12054u, i10);
            this.f12066g = iOptInt;
            this.f12067h = jSONObject.optInt("price", iOptInt);
        }
    }

    private void a(JSONObject jSONObject, String str, List<String> list) throws JSONException {
        if (jSONObject.has(str)) {
            list.addAll(hj.b(jSONObject.getJSONArray(str)));
        }
    }
}
