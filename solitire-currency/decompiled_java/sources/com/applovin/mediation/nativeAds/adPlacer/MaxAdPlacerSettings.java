package com.applovin.mediation.nativeAds.adPlacer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.n;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class MaxAdPlacerSettings {
    public static final int MIN_REPEATING_INTERVAL = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f8009c = new TreeSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8010d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8011e = 256;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8012f = 4;

    public MaxAdPlacerSettings(String str) {
        this.f8007a = str;
    }

    public void addFixedPosition(int i10) {
        this.f8009c.add(Integer.valueOf(i10));
    }

    public String getAdUnitId() {
        return this.f8007a;
    }

    public Set<Integer> getFixedPositions() {
        return this.f8009c;
    }

    public int getMaxAdCount() {
        return this.f8011e;
    }

    public int getMaxPreloadedAdCount() {
        return this.f8012f;
    }

    @Nullable
    public String getPlacement() {
        return this.f8008b;
    }

    public int getRepeatingInterval() {
        return this.f8010d;
    }

    public boolean hasValidPositioning() {
        return !this.f8009c.isEmpty() || isRepeatingEnabled();
    }

    public boolean isRepeatingEnabled() {
        return this.f8010d >= 2;
    }

    public void resetFixedPositions() {
        this.f8009c.clear();
    }

    public void setMaxAdCount(int i10) {
        this.f8011e = i10;
    }

    public void setMaxPreloadedAdCount(int i10) {
        this.f8012f = i10;
    }

    public void setPlacement(@Nullable String str) {
        this.f8008b = str;
    }

    public void setRepeatingInterval(int i10) {
        if (i10 >= 2) {
            this.f8010d = i10;
            n.g("MaxAdPlacerSettings", "Repeating interval set to " + i10);
            return;
        }
        this.f8010d = 0;
        n.j("MaxAdPlacerSettings", "Repeating interval has been disabled, since it has been set to " + i10 + ", which is less than minimum value of 2");
    }

    @NonNull
    public String toString() {
        return "MaxAdPlacerSettings{adUnitId='" + this.f8007a + "', fixedPositions=" + this.f8009c + ", repeatingInterval=" + this.f8010d + ", maxAdCount=" + this.f8011e + ", maxPreloadedAdCount=" + this.f8012f + '}';
    }
}
