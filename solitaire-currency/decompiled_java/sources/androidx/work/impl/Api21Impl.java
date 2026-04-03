package androidx.work.impl;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.io.File;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WorkDatabasePathHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public final class Api21Impl {

    @NotNull
    public static final Api21Impl INSTANCE = new Api21Impl();

    private Api21Impl() {
    }

    @DoNotInline
    @NotNull
    public final File getNoBackupFilesDir(@NotNull Context context) {
        t.i(context, "context");
        File noBackupFilesDir = context.getNoBackupFilesDir();
        t.h(noBackupFilesDir, "context.noBackupFilesDir");
        return noBackupFilesDir;
    }
}
