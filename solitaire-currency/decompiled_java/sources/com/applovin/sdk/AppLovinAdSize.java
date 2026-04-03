package com.applovin.sdk;

import androidx.compose.animation.core.AnimationConstants;
import com.ironsource.mediationsdk.l;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinAdSize {
    public static final int SPAN = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f8034c;
    public static final AppLovinAdSize BANNER = new AppLovinAdSize(-1, 50, l.f13634a);
    public static final AppLovinAdSize LEADER = new AppLovinAdSize(-1, 90, "LEADER");
    public static final AppLovinAdSize MREC = new AppLovinAdSize(AnimationConstants.DefaultDurationMillis, 250, "MREC");
    public static final AppLovinAdSize INTERSTITIAL = new AppLovinAdSize(-1, -1, "INTER");
    public static final AppLovinAdSize NATIVE = new AppLovinAdSize(-1, -1, "NATIVE");

    private AppLovinAdSize(int i10, int i11, String str) {
        this.f8033b = i10;
        this.f8034c = i11;
        this.f8032a = str;
    }

    public static AppLovinAdSize fromString(String str) {
        if (l.f13634a.equalsIgnoreCase(str)) {
            return BANNER;
        }
        if ("MREC".equalsIgnoreCase(str)) {
            return MREC;
        }
        if ("LEADER".equalsIgnoreCase(str)) {
            return LEADER;
        }
        if ("INTERSTITIAL".equalsIgnoreCase(str) || "INTER".equalsIgnoreCase(str)) {
            return INTERSTITIAL;
        }
        if ("NATIVE".equalsIgnoreCase(str)) {
            return NATIVE;
        }
        throw new IllegalArgumentException("Unknown Ad Size: " + str);
    }

    public int getHeight() {
        return this.f8034c;
    }

    public String getLabel() {
        return this.f8032a.toUpperCase(Locale.ENGLISH);
    }

    public int getWidth() {
        return this.f8033b;
    }

    public String toString() {
        return getLabel();
    }
}
