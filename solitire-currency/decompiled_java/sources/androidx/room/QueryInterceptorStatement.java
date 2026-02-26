package androidx.room;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: QueryInterceptorStatement.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class QueryInterceptorStatement implements SupportSQLiteStatement {

    @NotNull
    private final List<Object> bindArgsCache;

    @NotNull
    private final SupportSQLiteStatement delegate;

    @NotNull
    private final RoomDatabase.QueryCallback queryCallback;

    @NotNull
    private final Executor queryCallbackExecutor;

    @NotNull
    private final String sqlStatement;

    public QueryInterceptorStatement(@NotNull SupportSQLiteStatement delegate, @NotNull String sqlStatement, @NotNull Executor queryCallbackExecutor, @NotNull RoomDatabase.QueryCallback queryCallback) {
        kotlin.jvm.internal.t.i(delegate, "delegate");
        kotlin.jvm.internal.t.i(sqlStatement, "sqlStatement");
        kotlin.jvm.internal.t.i(queryCallbackExecutor, "queryCallbackExecutor");
        kotlin.jvm.internal.t.i(queryCallback, "queryCallback");
        this.delegate = delegate;
        this.sqlStatement = sqlStatement;
        this.queryCallbackExecutor = queryCallbackExecutor;
        this.queryCallback = queryCallback;
        this.bindArgsCache = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$0(QueryInterceptorStatement this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.queryCallback.onQuery(this$0.sqlStatement, this$0.bindArgsCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeInsert$lambda$2(QueryInterceptorStatement this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.queryCallback.onQuery(this$0.sqlStatement, this$0.bindArgsCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeUpdateDelete$lambda$1(QueryInterceptorStatement this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.queryCallback.onQuery(this$0.sqlStatement, this$0.bindArgsCache);
    }

    private final void saveArgsToCache(int i10, Object obj) {
        int i11 = i10 - 1;
        if (i11 >= this.bindArgsCache.size()) {
            int size = (i11 - this.bindArgsCache.size()) + 1;
            for (int i12 = 0; i12 < size; i12++) {
                this.bindArgsCache.add(null);
            }
        }
        this.bindArgsCache.set(i11, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void simpleQueryForLong$lambda$3(QueryInterceptorStatement this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.queryCallback.onQuery(this$0.sqlStatement, this$0.bindArgsCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void simpleQueryForString$lambda$4(QueryInterceptorStatement this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.queryCallback.onQuery(this$0.sqlStatement, this$0.bindArgsCache);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i10, @NotNull byte[] value) {
        kotlin.jvm.internal.t.i(value, "value");
        saveArgsToCache(i10, value);
        this.delegate.bindBlob(i10, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i10, double d10) {
        saveArgsToCache(i10, Double.valueOf(d10));
        this.delegate.bindDouble(i10, d10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i10, long j10) {
        saveArgsToCache(i10, Long.valueOf(j10));
        this.delegate.bindLong(i10, j10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i10) {
        Object[] array = this.bindArgsCache.toArray(new Object[0]);
        kotlin.jvm.internal.t.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        saveArgsToCache(i10, Arrays.copyOf(array, array.length));
        this.delegate.bindNull(i10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i10, @NotNull String value) {
        kotlin.jvm.internal.t.i(value, "value");
        saveArgsToCache(i10, value);
        this.delegate.bindString(i10, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.bindArgsCache.clear();
        this.delegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.u
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.execute$lambda$0(this.f1727a);
            }
        });
        this.delegate.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.v
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.executeInsert$lambda$2(this.f1728a);
            }
        });
        return this.delegate.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.t
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.executeUpdateDelete$lambda$1(this.f1726a);
            }
        });
        return this.delegate.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.x
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.simpleQueryForLong$lambda$3(this.f1730a);
            }
        });
        return this.delegate.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    @Nullable
    public String simpleQueryForString() {
        this.queryCallbackExecutor.execute(new Runnable() { // from class: androidx.room.w
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorStatement.simpleQueryForString$lambda$4(this.f1729a);
            }
        });
        return this.delegate.simpleQueryForString();
    }
}
