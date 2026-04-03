package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EntityInsertionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityInsertionAdapter(@NotNull RoomDatabase database) {
        super(database);
        kotlin.jvm.internal.t.i(database, "database");
    }

    protected abstract void bind(@Nullable SupportSQLiteStatement supportSQLiteStatement, T t10);

    public final void insert(T t10) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            bind(supportSQLiteStatementAcquire, t10);
            supportSQLiteStatementAcquire.executeInsert();
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final long insertAndReturnId(T t10) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            bind(supportSQLiteStatementAcquire, t10);
            return supportSQLiteStatementAcquire.executeInsert();
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    @NotNull
    public final long[] insertAndReturnIdsArray(@NotNull Collection<? extends T> entities) {
        kotlin.jvm.internal.t.i(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            long[] jArr = new long[entities.size()];
            int i10 = 0;
            for (T t10 : entities) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.v.u();
                }
                bind(supportSQLiteStatementAcquire, t10);
                jArr[i10] = supportSQLiteStatementAcquire.executeInsert();
                i10 = i11;
            }
            return jArr;
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    @NotNull
    public final Long[] insertAndReturnIdsArrayBox(@NotNull Collection<? extends T> entities) {
        kotlin.jvm.internal.t.i(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        Iterator<? extends T> it = entities.iterator();
        try {
            int size = entities.size();
            Long[] lArr = new Long[size];
            for (int i10 = 0; i10 < size; i10++) {
                bind(supportSQLiteStatementAcquire, it.next());
                lArr[i10] = Long.valueOf(supportSQLiteStatementAcquire.executeInsert());
            }
            return lArr;
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    @NotNull
    public final List<Long> insertAndReturnIdsList(@NotNull T[] entities) {
        kotlin.jvm.internal.t.i(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            List listC = kotlin.collections.u.c();
            for (T t10 : entities) {
                bind(supportSQLiteStatementAcquire, t10);
                listC.add(Long.valueOf(supportSQLiteStatementAcquire.executeInsert()));
            }
            return kotlin.collections.u.a(listC);
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final void insert(@NotNull T[] entities) {
        kotlin.jvm.internal.t.i(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            for (T t10 : entities) {
                bind(supportSQLiteStatementAcquire, t10);
                supportSQLiteStatementAcquire.executeInsert();
            }
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    @NotNull
    public final long[] insertAndReturnIdsArray(@NotNull T[] entities) {
        kotlin.jvm.internal.t.i(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            long[] jArr = new long[entities.length];
            int length = entities.length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                int i12 = i11 + 1;
                bind(supportSQLiteStatementAcquire, entities[i10]);
                jArr[i11] = supportSQLiteStatementAcquire.executeInsert();
                i10++;
                i11 = i12;
            }
            return jArr;
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final Long[] insertAndReturnIdsArrayBox(@NotNull T[] entities) {
        kotlin.jvm.internal.t.i(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        Iterator itA = kotlin.jvm.internal.c.a(entities);
        try {
            int length = entities.length;
            Long[] lArr = new Long[length];
            for (int i10 = 0; i10 < length; i10++) {
                bind(supportSQLiteStatementAcquire, itA.next());
                lArr[i10] = Long.valueOf(supportSQLiteStatementAcquire.executeInsert());
            }
            return lArr;
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    @NotNull
    public final List<Long> insertAndReturnIdsList(@NotNull Collection<? extends T> entities) {
        kotlin.jvm.internal.t.i(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            List listC = kotlin.collections.u.c();
            Iterator<T> it = entities.iterator();
            while (it.hasNext()) {
                bind(supportSQLiteStatementAcquire, it.next());
                listC.add(Long.valueOf(supportSQLiteStatementAcquire.executeInsert()));
            }
            return kotlin.collections.u.a(listC);
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final void insert(@NotNull Iterable<? extends T> entities) {
        kotlin.jvm.internal.t.i(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            Iterator<? extends T> it = entities.iterator();
            while (it.hasNext()) {
                bind(supportSQLiteStatementAcquire, it.next());
                supportSQLiteStatementAcquire.executeInsert();
            }
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }
}
