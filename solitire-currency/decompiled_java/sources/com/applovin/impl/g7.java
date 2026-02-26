package com.applovin.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g7 implements d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f5272a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f5273b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f5274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f5275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5277f;

    public static g7 a(b8 b8Var, com.applovin.impl.sdk.j jVar) {
        if (b8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        b8 b8VarC = b8Var.c("StaticResource");
        if (b8VarC == null || !URLUtil.isValidUrl(b8VarC.d())) {
            jVar.I();
            if (!com.applovin.impl.sdk.n.a()) {
                return null;
            }
            jVar.I().b("VastIndustryIcon", "Unable to create industry icon.  No valid image URL found.");
            return null;
        }
        g7 g7Var = new g7();
        g7Var.f5274c = Uri.parse(b8VarC.d());
        b8 b8VarB = b8Var.b("IconClickThrough");
        if (b8VarB != null && URLUtil.isValidUrl(b8VarB.d())) {
            g7Var.f5275d = Uri.parse(b8VarB.d());
        }
        String str = (String) b8Var.a().get("width");
        int i10 = 0;
        int i11 = (str == null || Integer.parseInt(str) <= 0) ? 0 : Integer.parseInt(str);
        String str2 = (String) b8Var.a().get("height");
        if (str2 != null && Integer.parseInt(str2) > 0) {
            i10 = Integer.parseInt(str2);
        }
        int iIntValue = ((Integer) jVar.a(l4.f5731r4)).intValue();
        if (i11 <= 0 || i10 <= 0) {
            g7Var.f5277f = iIntValue;
            g7Var.f5276e = iIntValue;
        } else {
            double d10 = i11 / i10;
            int iMin = Math.min(Math.max(i11, i10), iIntValue);
            if (i11 >= i10) {
                g7Var.f5276e = iMin;
                g7Var.f5277f = (int) (((double) iMin) / d10);
            } else {
                g7Var.f5277f = iMin;
                g7Var.f5276e = (int) (((double) iMin) * d10);
            }
        }
        return g7Var;
    }

    public Set b() {
        return this.f5272a;
    }

    public Uri c() {
        return this.f5275d;
    }

    public int d() {
        return this.f5277f;
    }

    public Uri e() {
        return this.f5274c;
    }

    public Set f() {
        return this.f5273b;
    }

    public int g() {
        return this.f5276e;
    }

    public String toString() {
        return "VastIndustryIcon{imageUri='" + e() + "', clickUri='" + c() + "', width=" + g() + ", height=" + d() + "}";
    }

    public static ImageView a(Uri uri, Context context, com.applovin.impl.sdk.j jVar) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        imageView.setVisibility(8);
        ImageViewUtils.setImageUri(imageView, uri, jVar);
        return imageView;
    }

    public static g7 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        k7 k7VarA;
        k7 k7VarA2;
        if (jSONObject == null) {
            return null;
        }
        g7 g7Var = new g7();
        String string = JsonUtils.getString(jSONObject, "image_uri", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        g7Var.f5274c = Uri.parse(string);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "click_trackers", new JSONArray());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i10, (JSONObject) null);
            if (jSONObject2 != null && (k7VarA2 = k7.a(jSONObject2, jVar)) != null) {
                g7Var.f5272a.add(k7VarA2);
            }
        }
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "view_trackers", new JSONArray());
        for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray2, i11, (JSONObject) null);
            if (jSONObject3 != null && (k7VarA = k7.a(jSONObject3, jVar)) != null) {
                g7Var.f5273b.add(k7VarA);
            }
        }
        String string2 = JsonUtils.getString(jSONObject, "click_uri", null);
        g7Var.f5275d = StringUtils.isValidString(string2) ? Uri.parse(string2) : null;
        g7Var.f5276e = JsonUtils.getInt(jSONObject, "width", 0);
        g7Var.f5277f = JsonUtils.getInt(jSONObject, "height", 0);
        return g7Var;
    }

    @Override // com.applovin.impl.d4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.f5272a.iterator();
        while (it.hasNext()) {
            jSONArray.put(((k7) it.next()).a());
        }
        JsonUtils.putJsonArray(jSONObject, "click_trackers", jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        Iterator it2 = this.f5273b.iterator();
        while (it2.hasNext()) {
            jSONArray.put(((k7) it2.next()).a());
        }
        JsonUtils.putJsonArray(jSONObject, "view_trackers", jSONArray2);
        Uri uri = this.f5274c;
        JsonUtils.putString(jSONObject, "image_uri", uri == null ? null : uri.toString());
        Uri uri2 = this.f5275d;
        JsonUtils.putString(jSONObject, "click_uri", uri2 != null ? uri2.toString() : null);
        JsonUtils.putInt(jSONObject, "width", this.f5276e);
        JsonUtils.putInt(jSONObject, "height", this.f5277f);
        return jSONObject;
    }
}
