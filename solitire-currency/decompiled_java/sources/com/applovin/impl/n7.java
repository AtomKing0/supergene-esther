package com.applovin.impl;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n7 implements d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f6417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f6418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f6420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f6421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private g7 f6422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map f6423g;

    private n7() {
        this.f6417a = Collections.emptyList();
        this.f6418b = Collections.emptyList();
        this.f6421e = new HashSet();
        this.f6423g = new HashMap();
    }

    public static n7 a(b8 b8Var, n7 n7Var, e7 e7Var, com.applovin.impl.sdk.j jVar) {
        b8 b8VarC;
        g7 g7VarA;
        List listA;
        b8 b8VarC2;
        List listA2;
        b8 b8VarC3;
        int iA;
        if (b8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (e7Var == null) {
            throw new IllegalArgumentException("No context specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (n7Var == null) {
            try {
                n7Var = new n7(e7Var);
            } catch (Throwable th) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("VastVideoCreative", "Error occurred while initializing", th);
                }
                jVar.A().a("VastVideoCreative", th);
                return null;
            }
        }
        if (n7Var.f6419c == 0 && (b8VarC3 = b8Var.c("Duration")) != null && (iA = a(b8VarC3.d(), jVar)) > 0) {
            n7Var.f6419c = iA;
        }
        b8 b8VarC4 = b8Var.c("MediaFiles");
        if (b8VarC4 != null && (listA2 = a(b8VarC4, jVar)) != null && listA2.size() > 0) {
            List list = n7Var.f6417a;
            if (list != null) {
                listA2.addAll(list);
            }
            n7Var.f6417a = listA2;
        }
        b8 b8VarC5 = b8Var.c("VideoClicks");
        if (b8VarC5 != null) {
            if (n7Var.f6420d == null && (b8VarC2 = b8VarC5.c("ClickThrough")) != null) {
                String strD = b8VarC2.d();
                if (StringUtils.isValidString(strD)) {
                    n7Var.f6420d = Uri.parse(strD);
                }
            }
            m7.a(b8VarC5.a("ClickTracking"), n7Var.f6421e, e7Var, jVar);
        }
        b8 b8VarC6 = b8Var.c("Icons");
        if (b8VarC6 != null && (g7VarA = g7.a((b8VarC = b8VarC6.c("Icon")), jVar)) != null) {
            b8 b8VarC7 = b8VarC.c("IconClicks");
            if (b8VarC7 != null && (listA = b8VarC7.a("IconClickTracking")) != null) {
                m7.a(listA, g7VarA.f5272a, e7Var, jVar);
            }
            List listA3 = b8VarC.a("IconViewTracking");
            if (listA3 != null) {
                m7.a(listA3, g7VarA.f5273b, e7Var, jVar);
            }
            n7Var.f6422f = g7VarA;
        }
        m7.a(b8Var, n7Var.f6423g, e7Var, jVar);
        return n7Var;
    }

    public Uri c() {
        return this.f6420d;
    }

    public int d() {
        return this.f6419c;
    }

    public Map e() {
        return this.f6423g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n7)) {
            return false;
        }
        n7 n7Var = (n7) obj;
        if (this.f6419c != n7Var.f6419c) {
            return false;
        }
        List list = this.f6417a;
        if (list == null ? n7Var.f6417a != null : !list.equals(n7Var.f6417a)) {
            return false;
        }
        Uri uri = this.f6420d;
        if (uri == null ? n7Var.f6420d != null : !uri.equals(n7Var.f6420d)) {
            return false;
        }
        Set set = this.f6421e;
        if (set == null ? n7Var.f6421e != null : !set.equals(n7Var.f6421e)) {
            return false;
        }
        Map map = this.f6423g;
        Map map2 = n7Var.f6423g;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public g7 f() {
        return this.f6422f;
    }

    public List g() {
        return this.f6417a;
    }

    public int hashCode() {
        List list = this.f6417a;
        int iHashCode = (((list != null ? list.hashCode() : 0) * 31) + this.f6419c) * 31;
        Uri uri = this.f6420d;
        int iHashCode2 = (iHashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        Set set = this.f6421e;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map map = this.f6423g;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "VastVideoCreative{videoFiles=" + this.f6417a + ", durationSeconds=" + this.f6419c + ", destinationUri=" + this.f6420d + ", clickTrackers=" + this.f6421e + ", eventTrackers=" + this.f6423g + ", industryIcon=" + this.f6422f + '}';
    }

    public Set b() {
        return this.f6421e;
    }

    private n7(e7 e7Var) {
        this.f6417a = Collections.emptyList();
        this.f6418b = Collections.emptyList();
        this.f6421e = new HashSet();
        this.f6423g = new HashMap();
        this.f6418b = e7Var.f();
    }

    private static int a(String str, com.applovin.impl.sdk.j jVar) {
        try {
            List<String> listExplode = CollectionUtils.explode(str, ":");
            if (listExplode.size() == 3) {
                return (int) (TimeUnit.HOURS.toSeconds(StringUtils.parseInt(listExplode.get(0))) + TimeUnit.MINUTES.toSeconds(StringUtils.parseInt(listExplode.get(1))) + ((long) StringUtils.parseInt(listExplode.get(2))));
            }
        } catch (Throwable unused) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().b("VastVideoCreative", "Unable to parse duration from \"" + str + "\"");
            }
        }
        return 0;
    }

    private static List a(b8 b8Var, com.applovin.impl.sdk.j jVar) {
        List listA = b8Var.a("MediaFile");
        ArrayList arrayList = new ArrayList(listA.size());
        List<String> listExplode = CollectionUtils.explode((String) jVar.a(l4.f5699n4));
        List<String> listExplode2 = CollectionUtils.explode((String) jVar.a(l4.f5691m4));
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            o7 o7VarA = o7.a((b8) it.next(), jVar);
            if (o7VarA != null) {
                try {
                    String strC = o7VarA.c();
                    if (StringUtils.isValidString(strC) && !listExplode.contains(strC)) {
                        arrayList.add(o7VarA);
                    } else {
                        if (((Boolean) jVar.a(l4.f5707o4)).booleanValue()) {
                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(o7VarA.e().toString());
                            if (StringUtils.isValidString(fileExtensionFromUrl) && !listExplode2.contains(fileExtensionFromUrl)) {
                                arrayList.add(o7VarA);
                            }
                        }
                        jVar.I();
                        if (com.applovin.impl.sdk.n.a()) {
                            jVar.I().k("VastVideoCreative", "Video file not supported: " + o7VarA);
                        }
                    }
                } catch (Throwable th) {
                    jVar.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        jVar.I().a("VastVideoCreative", "Failed to validate video file: " + o7VarA, th);
                    }
                }
            }
        }
        return arrayList;
    }

    public o7 a(long j10) {
        List list = this.f6417a;
        o7 o7Var = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        List<o7> arrayList = new ArrayList(3);
        for (String str : this.f6418b) {
            for (o7 o7Var2 : this.f6417a) {
                String strC = o7Var2.c();
                if (StringUtils.isValidString(strC) && str.equalsIgnoreCase(strC)) {
                    arrayList.add(o7Var2);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = this.f6417a;
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.applovin.impl.ub
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return n7.a((o7) obj, (o7) obj2);
            }
        });
        for (o7 o7Var3 : arrayList) {
            if (o7Var3.b() > j10) {
                break;
            }
            o7Var = o7Var3;
        }
        return o7Var != null ? o7Var : (o7) arrayList.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(o7 o7Var, o7 o7Var2) {
        return Long.compare(o7Var.b(), o7Var2.b());
    }

    public static n7 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        n7 n7Var = new n7();
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "video_files", new JSONArray());
        n7Var.f6417a = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            o7 o7VarA = o7.a(JsonUtils.getJSONObject(jSONArray, i10, (JSONObject) null), jVar);
            if (o7VarA != null) {
                n7Var.f6417a.add(o7VarA);
            }
        }
        n7Var.f6418b = JsonUtils.getStringList(jSONObject, "preferred_video_file_types", Collections.emptyList());
        n7Var.f6419c = JsonUtils.getInt(jSONObject, "duration_seconds", 0);
        String string = JsonUtils.getString(jSONObject, "destination_uri", null);
        n7Var.f6420d = StringUtils.isValidString(string) ? Uri.parse(string) : null;
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "click_trackers", new JSONArray());
        for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
            k7 k7VarA = k7.a(JsonUtils.getJSONObject(jSONArray2, i11, (JSONObject) null), jVar);
            if (k7VarA != null) {
                n7Var.f6421e.add(k7VarA);
            }
        }
        n7Var.f6422f = g7.a(JsonUtils.getJSONObject(jSONObject, "industry_icon", (JSONObject) null), jVar);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "event_trackers", new JSONObject());
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            HashSet hashSet = new HashSet();
            String next = itKeys.next();
            JSONArray jSONArray3 = JsonUtils.getJSONArray(jSONObject2, next, new JSONArray());
            for (int i12 = 0; i12 < jSONArray3.length(); i12++) {
                k7 k7VarA2 = k7.a(JsonUtils.getJSONObject(jSONArray3, i12, (JSONObject) null), jVar);
                if (k7VarA2 != null) {
                    hashSet.add(k7VarA2);
                }
            }
            n7Var.f6423g.put(next, hashSet);
        }
        return n7Var;
    }

    @Override // com.applovin.impl.d4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        List list = this.f6417a;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(((o7) it.next()).a());
            }
        }
        JsonUtils.putJsonArray(jSONObject, "video_files", jSONArray);
        JsonUtils.putJsonArray(jSONObject, "preferred_video_file_types", new JSONArray((Collection) this.f6418b));
        JsonUtils.putInt(jSONObject, "duration_seconds", this.f6419c);
        Uri uri = this.f6420d;
        JsonUtils.putString(jSONObject, "destination_uri", uri == null ? null : uri.toString());
        JSONArray jSONArray2 = new JSONArray();
        Iterator it2 = this.f6421e.iterator();
        while (it2.hasNext()) {
            jSONArray2.put(((k7) it2.next()).a());
        }
        JsonUtils.putJsonArray(jSONObject, "click_trackers", jSONArray2);
        g7 g7Var = this.f6422f;
        if (g7Var != null) {
            JsonUtils.putJSONObject(jSONObject, "industry_icon", g7Var.a());
        }
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.f6423g.keySet()) {
            Set set = (Set) this.f6423g.get(str);
            if (set != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator it3 = set.iterator();
                while (it3.hasNext()) {
                    jSONArray3.put(((k7) it3.next()).a());
                }
                JsonUtils.putJsonArray(jSONObject2, str, jSONArray3);
            }
        }
        JsonUtils.putJSONObject(jSONObject, "event_trackers", jSONObject2);
        return jSONObject;
    }
}
