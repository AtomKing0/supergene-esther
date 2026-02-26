package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class CursorWindowCompat {

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static CursorWindow createCursorWindow(String str, long j10) {
            return new CursorWindow(str, j10);
        }
    }

    private CursorWindowCompat() {
    }

    @NonNull
    public static CursorWindow create(@Nullable String str, long j10) {
        return Build.VERSION.SDK_INT >= 28 ? Api28Impl.createCursorWindow(str, j10) : new CursorWindow(str);
    }
}
