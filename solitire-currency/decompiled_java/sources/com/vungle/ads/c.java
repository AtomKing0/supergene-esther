package com.vungle.ads;

import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    public static final int AUTO_ROTATE = 2;

    @NotNull
    public static final a Companion = new a(null);
    public static final int IMMEDIATE_BACK = 2;
    public static final int LANDSCAPE = 1;
    public static final int PORTRAIT = 0;

    @NotNull
    private static final String WATERMARK = "WATERMARK";
    private int settings;

    @NotNull
    private Map<String, String> extras = new LinkedHashMap();
    private int adOrientation = 2;

    /* JADX INFO: compiled from: AdConfig.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public final int getAdOrientation() {
        return this.adOrientation;
    }

    public final int getSettings() {
        return this.settings;
    }

    @Nullable
    public final String getWatermark$vungle_ads_release() {
        return this.extras.get(WATERMARK);
    }

    public final void setAdOrientation(int i10) {
        this.adOrientation = i10;
    }

    public final void setBackButtonImmediatelyEnabled(boolean z10) {
        this.settings = z10 ? this.settings | 2 : this.settings & (-3);
    }

    public final void setWatermark(@NotNull String watermark) {
        kotlin.jvm.internal.t.i(watermark, "watermark");
        this.extras.put(WATERMARK, watermark);
    }

    public static /* synthetic */ void getAdOrientation$annotations() {
    }
}
