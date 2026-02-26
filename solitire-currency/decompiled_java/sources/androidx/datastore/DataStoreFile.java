package androidx.datastore;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DataStoreFile.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreFile {
    @NotNull
    public static final File dataStoreFile(@NotNull Context context, @NotNull String fileName) {
        t.i(context, "<this>");
        t.i(fileName, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), t.r("datastore/", fileName));
    }
}
