package androidx.room;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: QueryInterceptorDatabase.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {

    @NotNull
    private final SupportSQLiteDatabase delegate;

    @NotNull
    private final RoomDatabase.QueryCallback queryCallback;

    @NotNull
    private final Executor queryCallbackExecutor;

    public QueryInterceptorDatabase(@NotNull SupportSQLiteDatabase delegate, @NotNull Executor queryCallbackExecutor, @NotNull RoomDatabase.QueryCallback queryCallback) {
        kotlin.jvm.internal.t.i(delegate, "delegate");
        kotlin.jvm.internal.t.i(queryCallbackExecutor, "queryCallbackExecutor");
        kotlin.jvm.internal.t.i(queryCallback, "queryCallback");
        this.delegate = delegate;
        this.queryCallbackExecutor = queryCallbackExecutor;
        this.queryCallback = queryCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beginTransaction$lambda$0(QueryInterceptorDatabase this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", kotlin.collections.v.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beginTransactionNonExclusive$lambda$1(QueryInterceptorDatabase this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", kotlin.collections.v.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beginTransactionWithListener$lambda$2(QueryInterceptorDatabase this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", kotlin.collections.v.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beginTransactionWithListenerNonExclusive$lambda$3(QueryInterceptorDatabase this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", kotlin.collections.v.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endTransaction$lambda$4(QueryInterceptorDatabase this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.queryCallback.onQuery("END TRANSACTION", kotlin.collections.v.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execSQL$lambda$10(QueryInterceptorDatabase this$0, String sql) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(sql, "$sql");
        this$0.queryCallback.onQuery(sql, kotlin.collections.v.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execSQL$lambda$11(QueryInterceptorDatabase this$0, String sql, List inputArguments) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(sql, "$sql");
        kotlin.jvm.internal.t.i(inputArguments, "$inputArguments");
        this$0.queryCallback.onQuery(sql, inputArguments);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void query$lambda$6(QueryInterceptorDatabase this$0, String query) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(query, "$query");
        this$0.queryCallback.onQuery(query, kotlin.collections.v.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void query$lambda$7(QueryInterceptorDatabase this$0, String query, Object[] bindArgs) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(query, "$query");
        kotlin.jvm.internal.t.i(bindArgs, "$bindArgs");
        this$0.queryCallback.onQuery(query, kotlin.collections.p.o0(bindArgs));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void query$lambda$8(QueryInterceptorDatabase this$0, SupportSQLiteQuery query, QueryInterceptorProgram queryInterceptorProgram) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(query, "$query");
        kotlin.jvm.internal.t.i(queryInterceptorProgram, "$queryInterceptorProgram");
        this$0.queryCallback.onQuery(query.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void query$lambda$9(QueryInterceptorDatabase this$0, SupportSQLiteQuery query, QueryInterceptorProgram queryInterceptorProgram) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(query, "$query");
        kotlin.jvm.internal.t.i(queryInterceptorProgram, "$queryInterceptorProgram");
        this$0.queryCallback.onQuery(query.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTransactionSuccessful$lambda$5(QueryInterceptorDatabase this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.queryCallback.onQuery("TRANSACTION SUCCESSFUL", kotlin.collections.v.l());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.o
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.beginTransaction$lambda$0(this.f1719a);
            }
        });
        this.delegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.g
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.beginTransactionNonExclusive$lambda$1(this.f1704a);
            }
        });
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(@NotNull SQLiteTransactionListener transactionListener) {
        kotlin.jvm.internal.t.i(transactionListener, "transactionListener");
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.i
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.beginTransactionWithListener$lambda$2(this.f1707a);
            }
        });
        this.delegate.beginTransactionWithListener(transactionListener);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(@NotNull SQLiteTransactionListener transactionListener) {
        kotlin.jvm.internal.t.i(transactionListener, "transactionListener");
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.m
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.beginTransactionWithListenerNonExclusive$lambda$3(this.f1715a);
            }
        });
        this.delegate.beginTransactionWithListenerNonExclusive(transactionListener);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NotNull
    public SupportSQLiteStatement compileStatement(@NotNull String sql) {
        kotlin.jvm.internal.t.i(sql, "sql");
        return new QueryInterceptorStatement(this.delegate.compileStatement(sql), sql, this.queryCallbackExecutor, this.queryCallback);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(@NotNull String table, @Nullable String str, @Nullable Object[] objArr) {
        kotlin.jvm.internal.t.i(table, "table");
        return this.delegate.delete(table, str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.q
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.endTransaction$lambda$4(this.f1722a);
            }
        });
        this.delegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execPerConnectionSQL(@NotNull String sql, @SuppressLint({"ArrayReturn"}) @Nullable Object[] objArr) {
        kotlin.jvm.internal.t.i(sql, "sql");
        this.delegate.execPerConnectionSQL(sql, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(@NotNull final String sql) {
        kotlin.jvm.internal.t.i(sql, "sql");
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.h
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.execSQL$lambda$10(this.f1705a, sql);
            }
        });
        this.delegate.execSQL(sql);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @Nullable
    public List<Pair<String, String>> getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @Nullable
    public String getPath() {
        return this.delegate.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.delegate.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(@NotNull String table, int i10, @NotNull ContentValues values) {
        kotlin.jvm.internal.t.i(table, "table");
        kotlin.jvm.internal.t.i(values, "values");
        return this.delegate.insert(table, i10, values);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isExecPerConnectionSQLSupported() {
        return this.delegate.isExecPerConnectionSQLSupported();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int i10) {
        return this.delegate.needUpgrade(i10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NotNull
    public Cursor query(@NotNull final String query) {
        kotlin.jvm.internal.t.i(query, "query");
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.p
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.query$lambda$6(this.f1720a, query);
            }
        });
        return this.delegate.query(query);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(boolean z10) {
        this.delegate.setForeignKeyConstraintsEnabled(z10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(@NotNull Locale locale) {
        kotlin.jvm.internal.t.i(locale, "locale");
        this.delegate.setLocale(locale);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int i10) {
        this.delegate.setMaxSqlCacheSize(i10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long j10) {
        return this.delegate.setMaximumSize(j10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long j10) {
        this.delegate.setPageSize(j10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.l
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.setTransactionSuccessful$lambda$5(this.f1714a);
            }
        });
        this.delegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int i10) {
        this.delegate.setVersion(i10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(@NotNull String table, int i10, @NotNull ContentValues values, @Nullable String str, @Nullable Object[] objArr) {
        kotlin.jvm.internal.t.i(table, "table");
        kotlin.jvm.internal.t.i(values, "values");
        return this.delegate.update(table, i10, values, str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long j10) {
        return this.delegate.yieldIfContendedSafely(j10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(@NotNull final String sql, @NotNull Object[] bindArgs) {
        kotlin.jvm.internal.t.i(sql, "sql");
        kotlin.jvm.internal.t.i(bindArgs, "bindArgs");
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(kotlin.collections.u.e(bindArgs));
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.s
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.execSQL$lambda$11(this.f1723a, sql, arrayList);
            }
        });
        this.delegate.execSQL(sql, new List[]{arrayList});
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NotNull
    public Cursor query(@NotNull final String query, @NotNull final Object[] bindArgs) {
        kotlin.jvm.internal.t.i(query, "query");
        kotlin.jvm.internal.t.i(bindArgs, "bindArgs");
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.k
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.query$lambda$7(this.f1711a, query, bindArgs);
            }
        });
        return this.delegate.query(query, bindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NotNull
    public Cursor query(@NotNull final SupportSQLiteQuery query) {
        kotlin.jvm.internal.t.i(query, "query");
        final QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        query.bindTo(queryInterceptorProgram);
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.n
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.query$lambda$8(this.f1716a, query, queryInterceptorProgram);
            }
        });
        return this.delegate.query(query);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NotNull
    public Cursor query(@NotNull final SupportSQLiteQuery query, @Nullable CancellationSignal cancellationSignal) {
        kotlin.jvm.internal.t.i(query, "query");
        final QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        query.bindTo(queryInterceptorProgram);
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.j
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.query$lambda$9(this.f1708a, query, queryInterceptorProgram);
            }
        });
        return this.delegate.query(query);
    }
}
