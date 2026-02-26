package io.sentry;

import java.util.Locale;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MeasurementUnit.java */
/* JADX INFO: loaded from: classes5.dex */
public interface l2 {

    /* JADX INFO: compiled from: MeasurementUnit.java */
    public enum a implements l2 {
        NANOSECOND,
        MICROSECOND,
        MILLISECOND,
        SECOND,
        MINUTE,
        HOUR,
        DAY,
        WEEK;

        @Override // io.sentry.l2
        @NotNull
        public String apiName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }

    @ApiStatus.Internal
    @NotNull
    String apiName();
}
