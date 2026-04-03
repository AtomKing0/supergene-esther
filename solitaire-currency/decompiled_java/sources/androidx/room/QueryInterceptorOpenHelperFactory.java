package androidx.room;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: QueryInterceptorOpenHelperFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class QueryInterceptorOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {

    @NotNull
    private final SupportSQLiteOpenHelper.Factory delegate;

    @NotNull
    private final RoomDatabase.QueryCallback queryCallback;

    @NotNull
    private final Executor queryCallbackExecutor;

    public QueryInterceptorOpenHelperFactory(@NotNull SupportSQLiteOpenHelper.Factory delegate, @NotNull Executor queryCallbackExecutor, @NotNull RoomDatabase.QueryCallback queryCallback) {
        kotlin.jvm.internal.t.i(delegate, "delegate");
        kotlin.jvm.internal.t.i(queryCallbackExecutor, "queryCallbackExecutor");
        kotlin.jvm.internal.t.i(queryCallback, "queryCallback");
        this.delegate = delegate;
        this.queryCallbackExecutor = queryCallbackExecutor;
        this.queryCallback = queryCallback;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @NotNull
    public SupportSQLiteOpenHelper create(@NotNull SupportSQLiteOpenHelper.Configuration configuration) {
        kotlin.jvm.internal.t.i(configuration, "configuration");
        return new QueryInterceptorOpenHelper(this.delegate.create(configuration), this.queryCallbackExecutor, this.queryCallback);
    }
}
