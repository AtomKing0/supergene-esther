package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SharedSQLiteStatement.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class SharedSQLiteStatement {

    @NotNull
    private final RoomDatabase database;

    @NotNull
    private final AtomicBoolean lock;

    @NotNull
    private final v8.l stmt$delegate;

    public SharedSQLiteStatement(@NotNull RoomDatabase database) {
        kotlin.jvm.internal.t.i(database, "database");
        this.database = database;
        this.lock = new AtomicBoolean(false);
        this.stmt$delegate = v8.n.a(new SharedSQLiteStatement$stmt$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SupportSQLiteStatement createNewStatement() {
        return this.database.compileStatement(createQuery());
    }

    private final SupportSQLiteStatement getStmt() {
        return (SupportSQLiteStatement) this.stmt$delegate.getValue();
    }

    @NotNull
    public SupportSQLiteStatement acquire() {
        assertNotMainThread();
        return getStmt(this.lock.compareAndSet(false, true));
    }

    protected void assertNotMainThread() {
        this.database.assertNotMainThread();
    }

    @NotNull
    protected abstract String createQuery();

    public void release(@NotNull SupportSQLiteStatement statement) {
        kotlin.jvm.internal.t.i(statement, "statement");
        if (statement == getStmt()) {
            this.lock.set(false);
        }
    }

    private final SupportSQLiteStatement getStmt(boolean z10) {
        return z10 ? getStmt() : createNewStatement();
    }
}
