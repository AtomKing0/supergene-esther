package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.datasource.cache.ContentMetadata;
import com.ironsource.environment.StringUtils;
import com.ironsource.i9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class IronSourceSegment {
    public static final String AGE = "age";
    public static final String GENDER = "gen";
    public static final String IAPT = "iapt";
    public static final String LEVEL = "lvl";
    public static final String PAYING = "pay";
    public static final String USER_CREATION_DATE = "ucd";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f13258m = "segName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13259a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f13265g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13260b = 999999;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f13261c = 999999.99d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f13262d = "custom";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f13263e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13264f = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f13266h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AtomicBoolean f13267i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private double f13268j = -1.0d;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f13269k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ArrayList<Pair<String, String>> f13270l = new ArrayList<>();

    private boolean a(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]*$");
    }

    public int getAge() {
        return this.f13264f;
    }

    public String getGender() {
        return this.f13265g;
    }

    public double getIapt() {
        return this.f13268j;
    }

    public AtomicBoolean getIsPaying() {
        return this.f13267i;
    }

    public int getLevel() {
        return this.f13266h;
    }

    public ArrayList<Pair<String, String>> getSegmentData() {
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        if (this.f13264f != -1) {
            arrayList.add(new Pair<>(AGE, this.f13264f + ""));
        }
        if (!TextUtils.isEmpty(this.f13265g)) {
            arrayList.add(new Pair<>(GENDER, this.f13265g));
        }
        if (this.f13266h != -1) {
            arrayList.add(new Pair<>(LEVEL, this.f13266h + ""));
        }
        if (this.f13267i != null) {
            arrayList.add(new Pair<>(PAYING, this.f13267i + ""));
        }
        if (this.f13268j != -1.0d) {
            arrayList.add(new Pair<>(IAPT, this.f13268j + ""));
        }
        if (this.f13269k != 0) {
            arrayList.add(new Pair<>(USER_CREATION_DATE, this.f13269k + ""));
        }
        if (!TextUtils.isEmpty(this.f13259a)) {
            arrayList.add(new Pair<>(f13258m, this.f13259a));
        }
        arrayList.addAll(this.f13270l);
        return arrayList;
    }

    public String getSegmentName() {
        return this.f13259a;
    }

    public long getUcd() {
        return this.f13269k;
    }

    public void setAge(int i10) {
        if (i10 > 0 && i10 <= 199) {
            this.f13264f = i10;
            return;
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "setAge( " + i10 + " ) age must be between 1-199", 2);
    }

    public void setCustom(String str, String str2) {
        try {
            if (a(str) && a(str2) && a(str, 1, 32) && a(str2, 1, 32)) {
                String str3 = ContentMetadata.KEY_CUSTOM_PREFIX + str;
                if (this.f13270l.size() >= 5) {
                    this.f13270l.remove(0);
                }
                this.f13270l.add(new Pair<>(str3, str2));
                return;
            }
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "setCustom( " + str + " , " + str2 + " ) key and value must be alphanumeric and 1-32 in length", 2);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    public void setGender(String str) {
        if (!TextUtils.isEmpty(str) && (StringUtils.toLowerCase(str).equals(IronSourceConstants.a.f13909b) || StringUtils.toLowerCase(str).equals(IronSourceConstants.a.f13910c))) {
            this.f13265g = str;
            return;
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "setGender( " + str + " ) is invalid", 2);
    }

    public void setIAPTotal(double d10) {
        if (d10 > 0.0d && d10 < this.f13261c) {
            this.f13268j = Math.floor(d10 * 100.0d) / 100.0d;
            return;
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "setIAPTotal( " + d10 + " ) iapt must be between 0-" + this.f13261c, 2);
    }

    public void setIsPaying(boolean z10) {
        if (this.f13267i == null) {
            this.f13267i = new AtomicBoolean();
        }
        this.f13267i.set(z10);
    }

    public void setLevel(int i10) {
        if (i10 > 0 && i10 < this.f13260b) {
            this.f13266h = i10;
            return;
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "setLevel( " + i10 + " ) level must be between 1-" + this.f13260b, 2);
    }

    public void setSegmentName(String str) {
        if (a(str) && a(str, 1, 32)) {
            this.f13259a = str;
            return;
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "setSegmentName( " + str + " ) segment name must be alphanumeric and 1-32 in length", 2);
    }

    public void setUserCreationDate(long j10) {
        if (j10 > 0) {
            this.f13269k = j10;
            return;
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "setUserCreationDate( " + j10 + " ) is an invalid timestamp", 2);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        for (Pair<String, String> pair : getSegmentData()) {
            try {
                jSONObject.put((String) pair.first, pair.second);
            } catch (JSONException e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error("exception " + e10.getMessage());
            }
        }
        return jSONObject;
    }

    private boolean a(String str, int i10, int i11) {
        return str != null && str.length() >= i10 && str.length() <= i11;
    }
}
