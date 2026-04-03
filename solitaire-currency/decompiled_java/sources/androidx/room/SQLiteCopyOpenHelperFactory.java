package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SQLiteCopyOpenHelperFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SQLiteCopyOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {

    @Nullable
    private final String mCopyFromAssetPath;

    @Nullable
    private final File mCopyFromFile;

    @Nullable
    private final Callable<InputStream> mCopyFromInputStream;

    @NotNull
    private final SupportSQLiteOpenHelper.Factory mDelegate;

    public SQLiteCopyOpenHelperFactory(@Nullable String str, @Nullable File file, @Nullable Callable<InputStream> callable, @NotNull SupportSQLiteOpenHelper.Factory mDelegate) {
        kotlin.jvm.internal.t.i(mDelegate, "mDelegate");
        this.mCopyFromAssetPath = str;
        this.mCopyFromFile = file;
        this.mCopyFromInputStream = callable;
        this.mDelegate = mDelegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @NotNull
    public SupportSQLiteOpenHelper create(@NotNull SupportSQLiteOpenHelper.Configuration configuration) {
        kotlin.jvm.internal.t.i(configuration, "configuration");
        return new SQLiteCopyOpenHelper(configuration.context, this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, configuration.callback.version, this.mDelegate.create(configuration));
    }
}
