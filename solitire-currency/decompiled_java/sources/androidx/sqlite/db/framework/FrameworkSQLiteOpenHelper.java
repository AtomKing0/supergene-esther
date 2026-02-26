package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import java.io.File;
import java.util.UUID;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.l;
import v8.n;

/* JADX INFO: compiled from: FrameworkSQLiteOpenHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String TAG = "SupportSQLite";
    private final boolean allowDataLossOnRecovery;

    @NotNull
    private final SupportSQLiteOpenHelper.Callback callback;

    @NotNull
    private final Context context;

    @NotNull
    private final l<OpenHelper> lazyDelegate;

    @Nullable
    private final String name;
    private final boolean useNoBackupDirectory;
    private boolean writeAheadLoggingEnabled;

    /* JADX INFO: compiled from: FrameworkSQLiteOpenHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: FrameworkSQLiteOpenHelper.kt */
    static final class DBRefHolder {

        /* JADX INFO: renamed from: db, reason: collision with root package name */
        @Nullable
        private FrameworkSQLiteDatabase f1734db;

        public DBRefHolder(@Nullable FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.f1734db = frameworkSQLiteDatabase;
        }

        @Nullable
        public final FrameworkSQLiteDatabase getDb() {
            return this.f1734db;
        }

        public final void setDb(@Nullable FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.f1734db = frameworkSQLiteDatabase;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: FrameworkSQLiteOpenHelper.kt */
    static final class OpenHelper extends SQLiteOpenHelper {

        @NotNull
        public static final Companion Companion = new Companion(null);
        private final boolean allowDataLossOnRecovery;

        @NotNull
        private final SupportSQLiteOpenHelper.Callback callback;

        @NotNull
        private final Context context;

        @NotNull
        private final DBRefHolder dbRef;

        @NotNull
        private final ProcessLock lock;
        private boolean migrated;
        private boolean opened;

        /* JADX INFO: compiled from: FrameworkSQLiteOpenHelper.kt */
        private static final class CallbackException extends RuntimeException {

            @NotNull
            private final CallbackName callbackName;

            @NotNull
            private final Throwable cause;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallbackException(@NotNull CallbackName callbackName, @NotNull Throwable cause) {
                super(cause);
                t.i(callbackName, "callbackName");
                t.i(cause, "cause");
                this.callbackName = callbackName;
                this.cause = cause;
            }

            @NotNull
            public final CallbackName getCallbackName() {
                return this.callbackName;
            }

            @Override // java.lang.Throwable
            @NotNull
            public Throwable getCause() {
                return this.cause;
            }
        }

        /* JADX INFO: compiled from: FrameworkSQLiteOpenHelper.kt */
        public enum CallbackName {
            ON_CONFIGURE,
            ON_CREATE,
            ON_UPGRADE,
            ON_DOWNGRADE,
            ON_OPEN
        }

        /* JADX INFO: compiled from: FrameworkSQLiteOpenHelper.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            @NotNull
            public final FrameworkSQLiteDatabase getWrappedDb(@NotNull DBRefHolder refHolder, @NotNull SQLiteDatabase sqLiteDatabase) {
                t.i(refHolder, "refHolder");
                t.i(sqLiteDatabase, "sqLiteDatabase");
                FrameworkSQLiteDatabase db2 = refHolder.getDb();
                if (db2 != null && db2.isDelegate(sqLiteDatabase)) {
                    return db2;
                }
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = new FrameworkSQLiteDatabase(sqLiteDatabase);
                refHolder.setDb(frameworkSQLiteDatabase);
                return frameworkSQLiteDatabase;
            }
        }

        /* JADX INFO: compiled from: FrameworkSQLiteOpenHelper.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CallbackName.values().length];
                try {
                    iArr[CallbackName.ON_CONFIGURE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CallbackName.ON_CREATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[CallbackName.ON_UPGRADE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[CallbackName.ON_DOWNGRADE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[CallbackName.ON_OPEN.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenHelper(@NotNull Context context, @Nullable String str, @NotNull final DBRefHolder dbRef, @NotNull final SupportSQLiteOpenHelper.Callback callback, boolean z10) {
            super(context, str, null, callback.version, new DatabaseErrorHandler() { // from class: androidx.sqlite.db.framework.d
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    FrameworkSQLiteOpenHelper.OpenHelper._init_$lambda$0(callback, dbRef, sQLiteDatabase);
                }
            });
            t.i(context, "context");
            t.i(dbRef, "dbRef");
            t.i(callback, "callback");
            this.context = context;
            this.dbRef = dbRef;
            this.callback = callback;
            this.allowDataLossOnRecovery = z10;
            if (str == null) {
                str = UUID.randomUUID().toString();
                t.h(str, "randomUUID().toString()");
            }
            this.lock = new ProcessLock(str, context.getCacheDir(), false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(SupportSQLiteOpenHelper.Callback callback, DBRefHolder dbRef, SQLiteDatabase dbObj) {
            t.i(callback, "$callback");
            t.i(dbRef, "$dbRef");
            Companion companion = Companion;
            t.h(dbObj, "dbObj");
            callback.onCorruption(companion.getWrappedDb(dbRef, dbObj));
        }

        private final SQLiteDatabase getWritableOrReadableDatabase(boolean z10) {
            if (z10) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                t.h(writableDatabase, "{\n                super.…eDatabase()\n            }");
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            t.h(readableDatabase, "{\n                super.…eDatabase()\n            }");
            return readableDatabase;
        }

        private final SQLiteDatabase innerGetDatabase(boolean z10) throws Throwable {
            File parentFile;
            String databaseName = getDatabaseName();
            boolean z11 = this.opened;
            if (databaseName != null && !z11 && (parentFile = this.context.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w(FrameworkSQLiteOpenHelper.TAG, "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                return getWritableOrReadableDatabase(z10);
            } catch (Throwable unused) {
                super.close();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return getWritableOrReadableDatabase(z10);
                } catch (Throwable th) {
                    super.close();
                    if (th instanceof CallbackException) {
                        CallbackException callbackException = th;
                        Throwable cause = callbackException.getCause();
                        int i10 = WhenMappings.$EnumSwitchMapping$0[callbackException.getCallbackName().ordinal()];
                        if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || !(cause instanceof SQLiteException)) {
                            throw cause;
                        }
                    } else if (!(th instanceof SQLiteException) || databaseName == null || !this.allowDataLossOnRecovery) {
                        throw th;
                    }
                    this.context.deleteDatabase(databaseName);
                    try {
                        return getWritableOrReadableDatabase(z10);
                    } catch (CallbackException e10) {
                        throw e10.getCause();
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() {
            try {
                ProcessLock.lock$default(this.lock, false, 1, null);
                super.close();
                this.dbRef.setDb(null);
                this.opened = false;
            } finally {
                this.lock.unlock();
            }
        }

        public final boolean getAllowDataLossOnRecovery() {
            return this.allowDataLossOnRecovery;
        }

        @NotNull
        public final SupportSQLiteOpenHelper.Callback getCallback() {
            return this.callback;
        }

        @NotNull
        public final Context getContext() {
            return this.context;
        }

        @NotNull
        public final DBRefHolder getDbRef() {
            return this.dbRef;
        }

        @NotNull
        public final SupportSQLiteDatabase getSupportDatabase(boolean z10) {
            try {
                this.lock.lock((this.opened || getDatabaseName() == null) ? false : true);
                this.migrated = false;
                SQLiteDatabase sQLiteDatabaseInnerGetDatabase = innerGetDatabase(z10);
                if (!this.migrated) {
                    return getWrappedDb(sQLiteDatabaseInnerGetDatabase);
                }
                close();
                return getSupportDatabase(z10);
            } finally {
                this.lock.unlock();
            }
        }

        @NotNull
        public final FrameworkSQLiteDatabase getWrappedDb(@NotNull SQLiteDatabase sqLiteDatabase) {
            t.i(sqLiteDatabase, "sqLiteDatabase");
            return Companion.getWrappedDb(this.dbRef, sqLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(@NotNull SQLiteDatabase db2) {
            t.i(db2, "db");
            if (!this.migrated && this.callback.version != db2.getVersion()) {
                db2.setMaxSqlCacheSize(1);
            }
            try {
                this.callback.onConfigure(getWrappedDb(db2));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CONFIGURE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(@NotNull SQLiteDatabase sqLiteDatabase) {
            t.i(sqLiteDatabase, "sqLiteDatabase");
            try {
                this.callback.onCreate(getWrappedDb(sqLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CREATE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(@NotNull SQLiteDatabase db2, int i10, int i11) {
            t.i(db2, "db");
            this.migrated = true;
            try {
                this.callback.onDowngrade(getWrappedDb(db2), i10, i11);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_DOWNGRADE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(@NotNull SQLiteDatabase db2) {
            t.i(db2, "db");
            if (!this.migrated) {
                try {
                    this.callback.onOpen(getWrappedDb(db2));
                } catch (Throwable th) {
                    throw new CallbackException(CallbackName.ON_OPEN, th);
                }
            }
            this.opened = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(@NotNull SQLiteDatabase sqLiteDatabase, int i10, int i11) {
            t.i(sqLiteDatabase, "sqLiteDatabase");
            this.migrated = true;
            try {
                this.callback.onUpgrade(getWrappedDb(sqLiteDatabase), i10, i11);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_UPGRADE, th);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteOpenHelper(@NotNull Context context, @Nullable String str, @NotNull SupportSQLiteOpenHelper.Callback callback) {
        this(context, str, callback, false, false, 24, null);
        t.i(context, "context");
        t.i(callback, "callback");
    }

    private final OpenHelper getDelegate() {
        return this.lazyDelegate.getValue();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.lazyDelegate.isInitialized()) {
            getDelegate().close();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @Nullable
    public String getDatabaseName() {
        return this.name;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NotNull
    public SupportSQLiteDatabase getReadableDatabase() {
        return getDelegate().getSupportDatabase(false);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NotNull
    public SupportSQLiteDatabase getWritableDatabase() {
        return getDelegate().getSupportDatabase(true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z10) {
        if (this.lazyDelegate.isInitialized()) {
            SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(getDelegate(), z10);
        }
        this.writeAheadLoggingEnabled = z10;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteOpenHelper(@NotNull Context context, @Nullable String str, @NotNull SupportSQLiteOpenHelper.Callback callback, boolean z10) {
        this(context, str, callback, z10, false, 16, null);
        t.i(context, "context");
        t.i(callback, "callback");
    }

    public FrameworkSQLiteOpenHelper(@NotNull Context context, @Nullable String str, @NotNull SupportSQLiteOpenHelper.Callback callback, boolean z10, boolean z11) {
        t.i(context, "context");
        t.i(callback, "callback");
        this.context = context;
        this.name = str;
        this.callback = callback;
        this.useNoBackupDirectory = z10;
        this.allowDataLossOnRecovery = z11;
        this.lazyDelegate = n.a(new FrameworkSQLiteOpenHelper$lazyDelegate$1(this));
    }

    public /* synthetic */ FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z10, boolean z11, int i10, k kVar) {
        this(context, str, callback, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? false : z11);
    }
}
