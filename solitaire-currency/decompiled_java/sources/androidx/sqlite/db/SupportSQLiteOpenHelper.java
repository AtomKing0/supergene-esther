package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteCompat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: compiled from: SupportSQLiteOpenHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface SupportSQLiteOpenHelper extends Closeable {

    /* JADX INFO: compiled from: SupportSQLiteOpenHelper.kt */
    public static abstract class Callback {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private static final String TAG = "SupportSQLite";
        public final int version;

        /* JADX INFO: compiled from: SupportSQLiteOpenHelper.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }
        }

        public Callback(int i10) {
            this.version = i10;
        }

        private final void deleteDatabaseFile(String str) {
            if (q.x(str, ":memory:", true)) {
                return;
            }
            int length = str.length() - 1;
            int i10 = 0;
            boolean z10 = false;
            while (i10 <= length) {
                boolean z11 = t.k(str.charAt(!z10 ? i10 : length), 32) <= 0;
                if (z10) {
                    if (!z11) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z11) {
                    i10++;
                } else {
                    z10 = true;
                }
            }
            if (str.subSequence(i10, length + 1).toString().length() == 0) {
                return;
            }
            Log.w(TAG, "deleting the database file: " + str);
            try {
                SupportSQLiteCompat.Api16Impl.deleteDatabase(new File(str));
            } catch (Exception e10) {
                Log.w(TAG, "delete failed: ", e10);
            }
        }

        public void onConfigure(@NotNull SupportSQLiteDatabase db2) {
            t.i(db2, "db");
        }

        public void onCorruption(@NotNull SupportSQLiteDatabase db2) {
            t.i(db2, "db");
            Log.e(TAG, "Corruption reported by sqlite on database: " + db2 + ".path");
            if (!db2.isOpen()) {
                String path = db2.getPath();
                if (path != null) {
                    deleteDatabaseFile(path);
                    return;
                }
                return;
            }
            List<Pair<String, String>> attachedDbs = null;
            try {
                try {
                    attachedDbs = db2.getAttachedDbs();
                } catch (SQLiteException unused) {
                }
                try {
                    db2.close();
                } catch (IOException unused2) {
                }
                if (attachedDbs != null) {
                    return;
                }
            } finally {
                if (attachedDbs != null) {
                    Iterator<T> it = attachedDbs.iterator();
                    while (it.hasNext()) {
                        Object obj = ((Pair) it.next()).second;
                        t.h(obj, "p.second");
                        deleteDatabaseFile((String) obj);
                    }
                } else {
                    String path2 = db2.getPath();
                    if (path2 != null) {
                        deleteDatabaseFile(path2);
                    }
                }
            }
        }

        public abstract void onCreate(@NotNull SupportSQLiteDatabase supportSQLiteDatabase);

        public void onDowngrade(@NotNull SupportSQLiteDatabase db2, int i10, int i11) {
            t.i(db2, "db");
            throw new SQLiteException("Can't downgrade database from version " + i10 + " to " + i11);
        }

        public void onOpen(@NotNull SupportSQLiteDatabase db2) {
            t.i(db2, "db");
        }

        public abstract void onUpgrade(@NotNull SupportSQLiteDatabase supportSQLiteDatabase, int i10, int i11);
    }

    /* JADX INFO: compiled from: SupportSQLiteOpenHelper.kt */
    public interface Factory {
        @NotNull
        SupportSQLiteOpenHelper create(@NotNull Configuration configuration);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @Nullable
    String getDatabaseName();

    @NotNull
    SupportSQLiteDatabase getReadableDatabase();

    @NotNull
    SupportSQLiteDatabase getWritableDatabase();

    @RequiresApi(api = 16)
    void setWriteAheadLoggingEnabled(boolean z10);

    /* JADX INFO: compiled from: SupportSQLiteOpenHelper.kt */
    public static final class Configuration {

        @NotNull
        public static final Companion Companion = new Companion(null);
        public final boolean allowDataLossOnRecovery;

        @NotNull
        public final Callback callback;

        @NotNull
        public final Context context;

        @Nullable
        public final String name;
        public final boolean useNoBackupDirectory;

        /* JADX INFO: compiled from: SupportSQLiteOpenHelper.kt */
        public static class Builder {
            private boolean allowDataLossOnRecovery;

            @Nullable
            private Callback callback;

            @NotNull
            private final Context context;

            @Nullable
            private String name;
            private boolean useNoBackupDirectory;

            public Builder(@NotNull Context context) {
                t.i(context, "context");
                this.context = context;
            }

            @NotNull
            public Builder allowDataLossOnRecovery(boolean z10) {
                this.allowDataLossOnRecovery = z10;
                return this;
            }

            @NotNull
            public Configuration build() {
                Callback callback = this.callback;
                if (callback == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.".toString());
                }
                boolean z10 = true;
                if (this.useNoBackupDirectory) {
                    String str = this.name;
                    if (str == null || str.length() == 0) {
                        z10 = false;
                    }
                }
                if (z10) {
                    return new Configuration(this.context, this.name, callback, this.useNoBackupDirectory, this.allowDataLossOnRecovery);
                }
                throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.".toString());
            }

            @NotNull
            public Builder callback(@NotNull Callback callback) {
                t.i(callback, "callback");
                this.callback = callback;
                return this;
            }

            @NotNull
            public Builder name(@Nullable String str) {
                this.name = str;
                return this;
            }

            @NotNull
            public Builder noBackupDirectory(boolean z10) {
                this.useNoBackupDirectory = z10;
                return this;
            }
        }

        /* JADX INFO: compiled from: SupportSQLiteOpenHelper.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            @NotNull
            public final Builder builder(@NotNull Context context) {
                t.i(context, "context");
                return new Builder(context);
            }
        }

        public Configuration(@NotNull Context context, @Nullable String str, @NotNull Callback callback, boolean z10, boolean z11) {
            t.i(context, "context");
            t.i(callback, "callback");
            this.context = context;
            this.name = str;
            this.callback = callback;
            this.useNoBackupDirectory = z10;
            this.allowDataLossOnRecovery = z11;
        }

        @NotNull
        public static final Builder builder(@NotNull Context context) {
            return Companion.builder(context);
        }

        public /* synthetic */ Configuration(Context context, String str, Callback callback, boolean z10, boolean z11, int i10, k kVar) {
            this(context, str, callback, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? false : z11);
        }
    }
}
