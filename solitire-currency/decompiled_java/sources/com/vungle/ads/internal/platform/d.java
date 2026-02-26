package com.vungle.ads.internal.platform;

import androidx.core.util.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface d {

    @NotNull
    public static final a Companion = a.$$INSTANCE;

    @NotNull
    public static final String MANUFACTURER_AMAZON = "Amazon";

    /* JADX INFO: compiled from: Platform.kt */
    public static final class a {
        static final /* synthetic */ a $$INSTANCE = new a();

        @NotNull
        public static final String MANUFACTURER_AMAZON = "Amazon";

        private a() {
        }
    }

    @Nullable
    com.vungle.ads.internal.model.c getAdvertisingInfo();

    @Nullable
    String getAppSetId();

    @Nullable
    Integer getAppSetIdScope();

    @NotNull
    String getCarrierName();

    @Nullable
    String getUserAgent();

    void getUserAgentLazy(@NotNull Consumer<String> consumer);

    float getVolumeLevel();

    boolean isAtLeastMinimumSDK();

    boolean isBatterySaverEnabled();

    boolean isSdCardPresent();

    boolean isSideLoaded();

    boolean isSilentModeEnabled();

    boolean isSoundEnabled();
}
