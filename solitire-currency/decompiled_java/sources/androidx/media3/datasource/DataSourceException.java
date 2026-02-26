package androidx.media3.datasource;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class DataSourceException extends IOException {

    @UnstableApi
    @Deprecated
    public static final int POSITION_OUT_OF_RANGE = 2008;
    public final int reason;

    @UnstableApi
    public DataSourceException(int i10) {
        this.reason = i10;
    }

    @UnstableApi
    public static boolean isCausedByPositionOutOfRange(IOException iOException) {
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof DataSourceException) && ((DataSourceException) cause).reason == 2008) {
                return true;
            }
        }
        return false;
    }

    @UnstableApi
    public DataSourceException(@Nullable Throwable th, int i10) {
        super(th);
        this.reason = i10;
    }

    @UnstableApi
    public DataSourceException(@Nullable String str, int i10) {
        super(str);
        this.reason = i10;
    }

    @UnstableApi
    public DataSourceException(@Nullable String str, @Nullable Throwable th, int i10) {
        super(str, th);
        this.reason = i10;
    }
}
