package androidx.room;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AutoClosingRoomOpenHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    @NotNull
    public final AutoCloser autoCloser;

    @NotNull
    private final AutoClosingSupportSQLiteDatabase autoClosingDb;

    @NotNull
    private final SupportSQLiteOpenHelper delegate;

    /* JADX INFO: compiled from: AutoClosingRoomOpenHelper.kt */
    public static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {

        @NotNull
        private final AutoCloser autoCloser;

        public AutoClosingSupportSQLiteDatabase(@NotNull AutoCloser autoCloser) {
            kotlin.jvm.internal.t.i(autoCloser, "autoCloser");
            this.autoCloser = autoCloser;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransaction() {
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransaction();
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionNonExclusive() {
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionNonExclusive();
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListener(@NotNull SQLiteTransactionListener transactionListener) {
            kotlin.jvm.internal.t.i(transactionListener, "transactionListener");
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListener(transactionListener);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListenerNonExclusive(@NotNull SQLiteTransactionListener transactionListener) {
            kotlin.jvm.internal.t.i(transactionListener, "transactionListener");
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListenerNonExclusive(transactionListener);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.autoCloser.closeDatabaseIfOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @NotNull
        public SupportSQLiteStatement compileStatement(@NotNull String sql) {
            kotlin.jvm.internal.t.i(sql, "sql");
            return new AutoClosingSupportSqliteStatement(sql, this.autoCloser);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int delete(@NotNull String table, @Nullable String str, @Nullable Object[] objArr) {
            kotlin.jvm.internal.t.i(table, "table");
            return ((Number) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$delete$1(table, str, objArr))).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void disableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean enableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void endTransaction() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() == null) {
                throw new IllegalStateException("End transaction called but delegateDb is null".toString());
            }
            try {
                SupportSQLiteDatabase delegateDatabase$room_runtime_release = this.autoCloser.getDelegateDatabase$room_runtime_release();
                kotlin.jvm.internal.t.f(delegateDatabase$room_runtime_release);
                delegateDatabase$room_runtime_release.endTransaction();
            } finally {
                this.autoCloser.decrementCountAndScheduleClose();
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public /* synthetic */ void execPerConnectionSQL(String str, Object[] objArr) {
            g.c.a(this, str, objArr);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(@NotNull String sql) throws SQLException {
            kotlin.jvm.internal.t.i(sql, "sql");
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$1(sql));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @Nullable
        public List<Pair<String, String>> getAttachedDbs() {
            return (List) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1.INSTANCE);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getMaximumSize() {
            return ((Number) this.autoCloser.executeRefCountingFunction(new g0() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1
                @Override // kotlin.jvm.internal.g0, kotlin.reflect.KProperty1
                @Nullable
                public Object get(@Nullable Object obj) {
                    return Long.valueOf(((SupportSQLiteDatabase) obj).getMaximumSize());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getPageSize() {
            return ((Number) this.autoCloser.executeRefCountingFunction(new kotlin.jvm.internal.a0() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1
                @Override // kotlin.jvm.internal.a0, kotlin.reflect.KProperty1
                @Nullable
                public Object get(@Nullable Object obj) {
                    return Long.valueOf(((SupportSQLiteDatabase) obj).getPageSize());
                }

                @Override // kotlin.jvm.internal.a0, kotlin.reflect.KMutableProperty1
                public void set(@Nullable Object obj, @Nullable Object obj2) {
                    ((SupportSQLiteDatabase) obj).setPageSize(((Number) obj2).longValue());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @Nullable
        public String getPath() {
            return (String) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1.INSTANCE);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int getVersion() {
            return ((Number) this.autoCloser.executeRefCountingFunction(new kotlin.jvm.internal.a0() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1
                @Override // kotlin.jvm.internal.a0, kotlin.reflect.KProperty1
                @Nullable
                public Object get(@Nullable Object obj) {
                    return Integer.valueOf(((SupportSQLiteDatabase) obj).getVersion());
                }

                @Override // kotlin.jvm.internal.a0, kotlin.reflect.KMutableProperty1
                public void set(@Nullable Object obj, @Nullable Object obj2) {
                    ((SupportSQLiteDatabase) obj).setVersion(((Number) obj2).intValue());
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean inTransaction() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() == null) {
                return false;
            }
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long insert(@NotNull String table, int i10, @NotNull ContentValues values) throws SQLException {
            kotlin.jvm.internal.t.i(table, "table");
            kotlin.jvm.internal.t.i(values, "values");
            return ((Number) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$insert$1(table, i10, values))).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDatabaseIntegrityOk() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDatabaseIntegrityOk$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDbLockedByCurrentThread() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() == null) {
                return false;
            }
            return ((Boolean) this.autoCloser.executeRefCountingFunction(new g0() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDbLockedByCurrentThread$1
                @Override // kotlin.jvm.internal.g0, kotlin.reflect.KProperty1
                @Nullable
                public Object get(@Nullable Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).isDbLockedByCurrentThread());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public /* synthetic */ boolean isExecPerConnectionSQLSupported() {
            return g.c.b(this);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isOpen() {
            SupportSQLiteDatabase delegateDatabase$room_runtime_release = this.autoCloser.getDelegateDatabase$room_runtime_release();
            if (delegateDatabase$room_runtime_release == null) {
                return false;
            }
            return delegateDatabase$room_runtime_release.isOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isReadOnly() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @RequiresApi(api = 16)
        public boolean isWriteAheadLoggingEnabled() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isWriteAheadLoggingEnabled$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean needUpgrade(int i10) {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$needUpgrade$1(i10))).booleanValue();
        }

        public final void pokeOpen() {
            this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pokeOpen$1.INSTANCE);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @NotNull
        public Cursor query(@NotNull String query) {
            kotlin.jvm.internal.t.i(query, "query");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(query), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @RequiresApi(api = 16)
        public void setForeignKeyConstraintsEnabled(boolean z10) {
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setForeignKeyConstraintsEnabled$1(z10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setLocale(@NotNull Locale locale) {
            kotlin.jvm.internal.t.i(locale, "locale");
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setLocale$1(locale));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setMaxSqlCacheSize(int i10) {
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaxSqlCacheSize$1(i10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long setMaximumSize(long j10) {
            return ((Number) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaximumSize$1(j10))).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setPageSize(long j10) {
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$2(j10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setTransactionSuccessful() {
            k0 k0Var;
            SupportSQLiteDatabase delegateDatabase$room_runtime_release = this.autoCloser.getDelegateDatabase$room_runtime_release();
            if (delegateDatabase$room_runtime_release != null) {
                delegateDatabase$room_runtime_release.setTransactionSuccessful();
                k0Var = k0.f35197a;
            } else {
                k0Var = null;
            }
            if (k0Var == null) {
                throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null".toString());
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setVersion(int i10) {
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$2(i10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int update(@NotNull String table, int i10, @NotNull ContentValues values, @Nullable String str, @Nullable Object[] objArr) {
            kotlin.jvm.internal.t.i(table, "table");
            kotlin.jvm.internal.t.i(values, "values");
            return ((Number) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$update$1(table, i10, values, str, objArr))).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(@NotNull String sql, @NotNull Object[] bindArgs) throws SQLException {
            kotlin.jvm.internal.t.i(sql, "sql");
            kotlin.jvm.internal.t.i(bindArgs, "bindArgs");
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$2(sql, bindArgs));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely(long j10) {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$2.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @NotNull
        public Cursor query(@NotNull String query, @NotNull Object[] bindArgs) {
            kotlin.jvm.internal.t.i(query, "query");
            kotlin.jvm.internal.t.i(bindArgs, "bindArgs");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(query, bindArgs), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @NotNull
        public Cursor query(@NotNull SupportSQLiteQuery query) {
            kotlin.jvm.internal.t.i(query, "query");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(query), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @RequiresApi(api = 24)
        @NotNull
        public Cursor query(@NotNull SupportSQLiteQuery query, @Nullable CancellationSignal cancellationSignal) {
            kotlin.jvm.internal.t.i(query, "query");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(query, cancellationSignal), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: AutoClosingRoomOpenHelper.kt */
    private static final class KeepAliveCursor implements Cursor {

        @NotNull
        private final AutoCloser autoCloser;

        @NotNull
        private final Cursor delegate;

        public KeepAliveCursor(@NotNull Cursor delegate, @NotNull AutoCloser autoCloser) {
            kotlin.jvm.internal.t.i(delegate, "delegate");
            kotlin.jvm.internal.t.i(autoCloser, "autoCloser");
            this.delegate = delegate;
            this.autoCloser = autoCloser;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
            this.autoCloser.decrementCountAndScheduleClose();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i10, CharArrayBuffer charArrayBuffer) {
            this.delegate.copyStringToBuffer(i10, charArrayBuffer);
        }

        @Override // android.database.Cursor
        public void deactivate() {
            this.delegate.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i10) {
            return this.delegate.getBlob(i10);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.delegate.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String str) {
            return this.delegate.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String str) {
            return this.delegate.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public String getColumnName(int i10) {
            return this.delegate.getColumnName(i10);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.delegate.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.delegate.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i10) {
            return this.delegate.getDouble(i10);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.delegate.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i10) {
            return this.delegate.getFloat(i10);
        }

        @Override // android.database.Cursor
        public int getInt(int i10) {
            return this.delegate.getInt(i10);
        }

        @Override // android.database.Cursor
        public long getLong(int i10) {
            return this.delegate.getLong(i10);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 19)
        @NotNull
        public Uri getNotificationUri() {
            return SupportSQLiteCompat.Api19Impl.getNotificationUri(this.delegate);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 29)
        @NotNull
        public List<Uri> getNotificationUris() {
            return SupportSQLiteCompat.Api29Impl.getNotificationUris(this.delegate);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.delegate.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i10) {
            return this.delegate.getShort(i10);
        }

        @Override // android.database.Cursor
        public String getString(int i10) {
            return this.delegate.getString(i10);
        }

        @Override // android.database.Cursor
        public int getType(int i10) {
            return this.delegate.getType(i10);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.delegate.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.delegate.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.delegate.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.delegate.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.delegate.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.delegate.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i10) {
            return this.delegate.isNull(i10);
        }

        @Override // android.database.Cursor
        public boolean move(int i10) {
            return this.delegate.move(i10);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.delegate.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.delegate.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.delegate.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i10) {
            return this.delegate.moveToPosition(i10);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.delegate.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.delegate.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.delegate.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        public boolean requery() {
            return this.delegate.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.delegate.respond(bundle);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 23)
        public void setExtras(@NotNull Bundle extras) {
            kotlin.jvm.internal.t.i(extras, "extras");
            SupportSQLiteCompat.Api23Impl.setExtras(this.delegate, extras);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.delegate.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 29)
        public void setNotificationUris(@NotNull ContentResolver cr, @NotNull List<? extends Uri> uris) {
            kotlin.jvm.internal.t.i(cr, "cr");
            kotlin.jvm.internal.t.i(uris, "uris");
            SupportSQLiteCompat.Api29Impl.setNotificationUris(this.delegate, cr, uris);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.delegate.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.delegate.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public AutoClosingRoomOpenHelper(@NotNull SupportSQLiteOpenHelper delegate, @NotNull AutoCloser autoCloser) {
        kotlin.jvm.internal.t.i(delegate, "delegate");
        kotlin.jvm.internal.t.i(autoCloser, "autoCloser");
        this.delegate = delegate;
        this.autoCloser = autoCloser;
        autoCloser.init(getDelegate());
        this.autoClosingDb = new AutoClosingSupportSQLiteDatabase(autoCloser);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.autoClosingDb.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @Nullable
    public String getDatabaseName() {
        return this.delegate.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    @NotNull
    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 24)
    @NotNull
    public SupportSQLiteDatabase getReadableDatabase() {
        this.autoClosingDb.pokeOpen();
        return this.autoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 24)
    @NotNull
    public SupportSQLiteDatabase getWritableDatabase() {
        this.autoClosingDb.pokeOpen();
        return this.autoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z10) {
        this.delegate.setWriteAheadLoggingEnabled(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AutoClosingRoomOpenHelper.kt */
    static final class AutoClosingSupportSqliteStatement implements SupportSQLiteStatement {

        @NotNull
        private final AutoCloser autoCloser;

        @NotNull
        private final ArrayList<Object> binds;

        @NotNull
        private final String sql;

        public AutoClosingSupportSqliteStatement(@NotNull String sql, @NotNull AutoCloser autoCloser) {
            kotlin.jvm.internal.t.i(sql, "sql");
            kotlin.jvm.internal.t.i(autoCloser, "autoCloser");
            this.sql = sql;
            this.autoCloser = autoCloser;
            this.binds = new ArrayList<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void doBinds(SupportSQLiteStatement supportSQLiteStatement) {
            Iterator<T> it = this.binds.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                it.next();
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.v.u();
                }
                Object obj = this.binds.get(i10);
                if (obj == null) {
                    supportSQLiteStatement.bindNull(i11);
                } else if (obj instanceof Long) {
                    supportSQLiteStatement.bindLong(i11, ((Number) obj).longValue());
                } else if (obj instanceof Double) {
                    supportSQLiteStatement.bindDouble(i11, ((Number) obj).doubleValue());
                } else if (obj instanceof String) {
                    supportSQLiteStatement.bindString(i11, (String) obj);
                } else if (obj instanceof byte[]) {
                    supportSQLiteStatement.bindBlob(i11, (byte[]) obj);
                }
                i10 = i11;
            }
        }

        private final <T> T executeSqliteStatementWithRefCount(h9.l<? super SupportSQLiteStatement, ? extends T> lVar) {
            return (T) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1(this, lVar));
        }

        private final void saveBinds(int i10, Object obj) {
            int size;
            int i11 = i10 - 1;
            if (i11 >= this.binds.size() && (size = this.binds.size()) <= i11) {
                while (true) {
                    this.binds.add(null);
                    if (size == i11) {
                        break;
                    } else {
                        size++;
                    }
                }
            }
            this.binds.set(i11, obj);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindBlob(int i10, @NotNull byte[] value) {
            kotlin.jvm.internal.t.i(value, "value");
            saveBinds(i10, value);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindDouble(int i10, double d10) {
            saveBinds(i10, Double.valueOf(d10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindLong(int i10, long j10) {
            saveBinds(i10, Long.valueOf(j10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindNull(int i10) {
            saveBinds(i10, null);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindString(int i10, @NotNull String value) {
            kotlin.jvm.internal.t.i(value, "value");
            saveBinds(i10, value);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void clearBindings() {
            this.binds.clear();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public void execute() {
            executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1.INSTANCE);
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long executeInsert() {
            return ((Number) executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1.INSTANCE)).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public int executeUpdateDelete() {
            return ((Number) executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1.INSTANCE)).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long simpleQueryForLong() {
            return ((Number) executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForLong$1.INSTANCE)).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        @Nullable
        public String simpleQueryForString() {
            return (String) executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForString$1.INSTANCE);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }
}
