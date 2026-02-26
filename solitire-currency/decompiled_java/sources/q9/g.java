package q9;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.onetrust.otpublishers.headless.Public.OTCCPAGeolocationConstants;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DurationUnit.kt */
/* JADX INFO: loaded from: classes5.dex */
class g extends f {
    @NotNull
    public static final e d(char c10, boolean z10) {
        if (!z10) {
            if (c10 == 'D') {
                return e.f33190h;
            }
            throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + c10);
        }
        if (c10 == 'H') {
            return e.f33189g;
        }
        if (c10 == 'M') {
            return e.f33188f;
        }
        if (c10 == 'S') {
            return e.f33187e;
        }
        throw new IllegalArgumentException("Invalid duration ISO time unit: " + c10);
    }

    @NotNull
    public static final e e(@NotNull String shortName) {
        t.i(shortName, "shortName");
        int iHashCode = shortName.hashCode();
        if (iHashCode != 100) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 115) {
                        if (iHashCode != 3494) {
                            if (iHashCode != 3525) {
                                if (iHashCode == 3742 && shortName.equals(OTCCPAGeolocationConstants.US)) {
                                    return e.f33185c;
                                }
                            } else if (shortName.equals("ns")) {
                                return e.f33184b;
                            }
                        } else if (shortName.equals("ms")) {
                            return e.f33186d;
                        }
                    } else if (shortName.equals(CmcdData.Factory.STREAMING_FORMAT_SS)) {
                        return e.f33187e;
                    }
                } else if (shortName.equals("m")) {
                    return e.f33188f;
                }
            } else if (shortName.equals(CmcdData.Factory.STREAMING_FORMAT_HLS)) {
                return e.f33189g;
            }
        } else if (shortName.equals("d")) {
            return e.f33190h;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: " + shortName);
    }
}
