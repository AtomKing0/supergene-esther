package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.ironsource.gi;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class o7 implements d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f6470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Uri f6471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f6472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f6476g;

    public enum a {
        Progressive,
        Streaming
    }

    private o7() {
    }

    public static o7 a(b8 b8Var, com.applovin.impl.sdk.j jVar) {
        if (b8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            String strD = b8Var.d();
            if (!URLUtil.isValidUrl(strD)) {
                jVar.I();
                if (!com.applovin.impl.sdk.n.a()) {
                    return null;
                }
                jVar.I().b("VastVideoFile", "Unable to create video file. Could not find URL.");
                return null;
            }
            Uri uri = Uri.parse(strD);
            o7 o7Var = new o7();
            o7Var.f6470a = uri;
            o7Var.f6471b = uri;
            o7Var.f6476g = a(b8Var);
            o7Var.f6472c = a((String) b8Var.a().get(gi.f12296h));
            o7Var.f6475f = StringUtils.parseInt((String) b8Var.a().get("height"));
            o7Var.f6474e = StringUtils.parseInt((String) b8Var.a().get("width"));
            o7Var.f6473d = ((String) b8Var.a().get("type")).toLowerCase(Locale.ENGLISH);
            return o7Var;
        } catch (Throwable th) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("VastVideoFile", "Error occurred while initializing", th);
            }
            jVar.A().a("VastVideoFile", th);
            return null;
        }
    }

    public long b() {
        return this.f6476g;
    }

    public String c() {
        return this.f6473d;
    }

    public Uri d() {
        return this.f6470a;
    }

    public Uri e() {
        return this.f6471b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o7)) {
            return false;
        }
        o7 o7Var = (o7) obj;
        if (this.f6474e != o7Var.f6474e || this.f6475f != o7Var.f6475f || this.f6476g != o7Var.f6476g) {
            return false;
        }
        Uri uri = this.f6470a;
        if (uri == null ? o7Var.f6470a != null : !uri.equals(o7Var.f6470a)) {
            return false;
        }
        Uri uri2 = this.f6471b;
        if (uri2 == null ? o7Var.f6471b != null : !uri2.equals(o7Var.f6471b)) {
            return false;
        }
        if (this.f6472c != o7Var.f6472c) {
            return false;
        }
        String str = this.f6473d;
        String str2 = o7Var.f6473d;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        Uri uri = this.f6470a;
        int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.f6471b;
        int iHashCode2 = (iHashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        a aVar = this.f6472c;
        int iHashCode3 = (iHashCode2 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str = this.f6473d;
        return ((((((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + this.f6474e) * 31) + this.f6475f) * 31) + Long.valueOf(this.f6476g).hashCode();
    }

    public String toString() {
        return "VastVideoFile{sourceVideoUri=" + this.f6470a + ", videoUri=" + this.f6471b + ", deliveryType=" + this.f6472c + ", fileType='" + this.f6473d + "', width=" + this.f6474e + ", height=" + this.f6475f + ", bitrate=" + this.f6476g + '}';
    }

    private static a a(String str) {
        if (StringUtils.isValidString(str)) {
            if ("progressive".equalsIgnoreCase(str)) {
                return a.Progressive;
            }
            if ("streaming".equalsIgnoreCase(str)) {
                return a.Streaming;
            }
        }
        return a.Progressive;
    }

    private static long a(b8 b8Var) {
        Map mapA = b8Var.a();
        long j10 = StringUtils.parseLong((String) mapA.get("bitrate"), 0L);
        return j10 != 0 ? j10 : (StringUtils.parseLong((String) mapA.get("minBitrate"), 0L) + StringUtils.parseLong((String) mapA.get("maxBitrate"), 0L)) / 2;
    }

    public void a(Uri uri) {
        this.f6471b = uri;
    }

    public static o7 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        String string = JsonUtils.getString(jSONObject, "source_video_uri", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        Uri uri = Uri.parse(string);
        if (TextUtils.isEmpty(JsonUtils.getString(jSONObject, "video_uri", null))) {
            return null;
        }
        Uri uri2 = Uri.parse(string);
        String string2 = JsonUtils.getString(jSONObject, "file_type", null);
        if (TextUtils.isEmpty(string2)) {
            return null;
        }
        a aVarValueOf = a.valueOf(JsonUtils.getString(jSONObject, "delivery_type", a.Progressive.toString()));
        int i10 = JsonUtils.getInt(jSONObject, "width", 0);
        int i11 = JsonUtils.getInt(jSONObject, "height", 0);
        int i12 = JsonUtils.getInt(jSONObject, "bitrate", 0);
        o7 o7Var = new o7();
        o7Var.f6470a = uri;
        o7Var.f6471b = uri2;
        o7Var.f6472c = aVarValueOf;
        o7Var.f6473d = string2;
        o7Var.f6474e = i10;
        o7Var.f6475f = i11;
        o7Var.f6476g = i12;
        return o7Var;
    }

    @Override // com.applovin.impl.d4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        Uri uri = this.f6470a;
        if (uri != null) {
            JsonUtils.putString(jSONObject, "source_video_uri", uri.toString());
        }
        Uri uri2 = this.f6471b;
        if (uri2 != null) {
            JsonUtils.putString(jSONObject, "video_uri", uri2.toString());
        }
        a aVar = this.f6472c;
        JsonUtils.putString(jSONObject, "delivery_type", aVar == null ? null : aVar.toString());
        JsonUtils.putString(jSONObject, "file_type", this.f6473d);
        JsonUtils.putInt(jSONObject, "width", this.f6474e);
        JsonUtils.putInt(jSONObject, "height", this.f6475f);
        JsonUtils.putLong(jSONObject, "bitrate", this.f6476g);
        return jSONObject;
    }
}
