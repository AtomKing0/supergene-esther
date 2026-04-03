package androidx.privacysandbox.ads.adservices.internal;

import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.media3.common.PlaybackException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AdServicesInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AdServicesInfo {

    @NotNull
    public static final AdServicesInfo INSTANCE = new AdServicesInfo();

    /* JADX INFO: compiled from: AdServicesInfo.kt */
    @RequiresApi(30)
    private static final class Extensions30Impl {

        @NotNull
        public static final Extensions30Impl INSTANCE = new Extensions30Impl();

        private Extensions30Impl() {
        }

        @DoNotInline
        public final int getAdServicesVersion() {
            return SdkExtensions.getExtensionVersion(PlaybackException.CUSTOM_ERROR_CODE_BASE);
        }
    }

    private AdServicesInfo() {
    }

    public final int version() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Extensions30Impl.INSTANCE.getAdServicesVersion();
        }
        return 0;
    }
}
