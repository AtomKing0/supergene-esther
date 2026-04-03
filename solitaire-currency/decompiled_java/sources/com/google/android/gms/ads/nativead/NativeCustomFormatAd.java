package com.google.android.gms.ads.nativead;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface NativeCustomFormatAd {

    @NonNull
    public static final String ASSET_NAME_VIDEO = "_videoMediaView";

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
    public interface DisplayOpenMeasurement {
        void setView(@NonNull View view);

        boolean start();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
    public interface OnCustomClickListener {
        void onCustomClick(@NonNull NativeCustomFormatAd nativeCustomFormatAd, @NonNull String str);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
    public interface OnCustomFormatAdLoadedListener {
        void onCustomFormatAdLoaded(@NonNull NativeCustomFormatAd nativeCustomFormatAd);
    }

    void destroy();

    @Nullable
    List<String> getAvailableAssetNames();

    @Nullable
    String getCustomFormatId();

    @NonNull
    DisplayOpenMeasurement getDisplayOpenMeasurement();

    @Nullable
    NativeAd.Image getImage(@NonNull String str);

    @Nullable
    MediaContent getMediaContent();

    @Nullable
    CharSequence getText(@NonNull String str);

    void performClick(@NonNull String str);

    void recordImpression();
}
