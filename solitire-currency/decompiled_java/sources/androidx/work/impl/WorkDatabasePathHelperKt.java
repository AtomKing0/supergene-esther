package androidx.work.impl;

import androidx.work.Logger;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WorkDatabasePathHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WorkDatabasePathHelperKt {

    @NotNull
    private static final String[] DATABASE_EXTRA_FILES;

    @NotNull
    private static final String TAG;

    @NotNull
    public static final String WORK_DATABASE_NAME = "androidx.work.workdb";

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("WrkDbPathHelper");
        t.h(strTagWithPrefix, "tagWithPrefix(\"WrkDbPathHelper\")");
        TAG = strTagWithPrefix;
        DATABASE_EXTRA_FILES = new String[]{"-journal", "-shm", "-wal"};
    }
}
