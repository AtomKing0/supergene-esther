package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EntityDeletionOrUpdateAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityDeletionOrUpdateAdapter(@NotNull RoomDatabase database) {
        super(database);
        kotlin.jvm.internal.t.i(database, "database");
    }

    protected abstract void bind(@NotNull SupportSQLiteStatement supportSQLiteStatement, T t10);

    @Override // androidx.room.SharedSQLiteStatement
    @NotNull
    protected abstract String createQuery();

    public final int handle(T t10) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            bind(supportSQLiteStatementAcquire, t10);
            return supportSQLiteStatementAcquire.executeUpdateDelete();
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final int handleMultiple(@NotNull Iterable<? extends T> entities) {
        kotlin.jvm.internal.t.i(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            Iterator<? extends T> it = entities.iterator();
            int iExecuteUpdateDelete = 0;
            while (it.hasNext()) {
                bind(supportSQLiteStatementAcquire, it.next());
                iExecuteUpdateDelete += supportSQLiteStatementAcquire.executeUpdateDelete();
            }
            return iExecuteUpdateDelete;
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final int handleMultiple(@NotNull T[] entities) {
        kotlin.jvm.internal.t.i(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            int iExecuteUpdateDelete = 0;
            for (T t10 : entities) {
                bind(supportSQLiteStatementAcquire, t10);
                iExecuteUpdateDelete += supportSQLiteStatementAcquire.executeUpdateDelete();
            }
            return iExecuteUpdateDelete;
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }
}
