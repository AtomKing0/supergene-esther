package androidx.room;

import android.database.sqlite.SQLiteConstraintException;
import androidx.annotation.RestrictTo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import p9.r;

/* JADX INFO: compiled from: EntityUpsertionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class EntityUpsertionAdapter<T> {

    @NotNull
    private final EntityInsertionAdapter<T> insertionAdapter;

    @NotNull
    private final EntityDeletionOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertionAdapter(@NotNull EntityInsertionAdapter<T> insertionAdapter, @NotNull EntityDeletionOrUpdateAdapter<T> updateAdapter) {
        kotlin.jvm.internal.t.i(insertionAdapter, "insertionAdapter");
        kotlin.jvm.internal.t.i(updateAdapter, "updateAdapter");
        this.insertionAdapter = insertionAdapter;
        this.updateAdapter = updateAdapter;
    }

    private final void checkUniquenessException(SQLiteConstraintException sQLiteConstraintException) {
        String message = sQLiteConstraintException.getMessage();
        if (message == null || !r.N(message, "1555", true)) {
            throw sQLiteConstraintException;
        }
    }

    public final void upsert(T t10) {
        try {
            this.insertionAdapter.insert(t10);
        } catch (SQLiteConstraintException e10) {
            checkUniquenessException(e10);
            this.updateAdapter.handle(t10);
        }
    }

    public final long upsertAndReturnId(T t10) {
        try {
            return this.insertionAdapter.insertAndReturnId(t10);
        } catch (SQLiteConstraintException e10) {
            checkUniquenessException(e10);
            this.updateAdapter.handle(t10);
            return -1L;
        }
    }

    @NotNull
    public final long[] upsertAndReturnIdsArray(@NotNull T[] entities) {
        long jInsertAndReturnId;
        kotlin.jvm.internal.t.i(entities, "entities");
        int length = entities.length;
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(entities[i10]);
            } catch (SQLiteConstraintException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(entities[i10]);
                jInsertAndReturnId = -1;
            }
            jArr[i10] = jInsertAndReturnId;
        }
        return jArr;
    }

    @NotNull
    public final Long[] upsertAndReturnIdsArrayBox(@NotNull T[] entities) {
        long jInsertAndReturnId;
        kotlin.jvm.internal.t.i(entities, "entities");
        int length = entities.length;
        Long[] lArr = new Long[length];
        for (int i10 = 0; i10 < length; i10++) {
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(entities[i10]);
            } catch (SQLiteConstraintException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(entities[i10]);
                jInsertAndReturnId = -1;
            }
            lArr[i10] = Long.valueOf(jInsertAndReturnId);
        }
        return lArr;
    }

    @NotNull
    public final List<Long> upsertAndReturnIdsList(@NotNull T[] entities) {
        kotlin.jvm.internal.t.i(entities, "entities");
        List listC = kotlin.collections.u.c();
        for (T t10 : entities) {
            try {
                listC.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t10)));
            } catch (SQLiteConstraintException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(t10);
                listC.add(-1L);
            }
        }
        return kotlin.collections.u.a(listC);
    }

    public final void upsert(@NotNull T[] entities) {
        kotlin.jvm.internal.t.i(entities, "entities");
        for (T t10 : entities) {
            try {
                this.insertionAdapter.insert(t10);
            } catch (SQLiteConstraintException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(t10);
            }
        }
    }

    @NotNull
    public final long[] upsertAndReturnIdsArray(@NotNull Collection<? extends T> entities) {
        long jInsertAndReturnId;
        kotlin.jvm.internal.t.i(entities, "entities");
        Iterator<? extends T> it = entities.iterator();
        int size = entities.size();
        long[] jArr = new long[size];
        for (int i10 = 0; i10 < size; i10++) {
            T next = it.next();
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(next);
                jInsertAndReturnId = -1;
            }
            jArr[i10] = jInsertAndReturnId;
        }
        return jArr;
    }

    @NotNull
    public final Long[] upsertAndReturnIdsArrayBox(@NotNull Collection<? extends T> entities) {
        long jInsertAndReturnId;
        kotlin.jvm.internal.t.i(entities, "entities");
        Iterator<? extends T> it = entities.iterator();
        int size = entities.size();
        Long[] lArr = new Long[size];
        for (int i10 = 0; i10 < size; i10++) {
            T next = it.next();
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(next);
                jInsertAndReturnId = -1;
            }
            lArr[i10] = Long.valueOf(jInsertAndReturnId);
        }
        return lArr;
    }

    public final void upsert(@NotNull Iterable<? extends T> entities) {
        kotlin.jvm.internal.t.i(entities, "entities");
        for (T t10 : entities) {
            try {
                this.insertionAdapter.insert(t10);
            } catch (SQLiteConstraintException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(t10);
            }
        }
    }

    @NotNull
    public final List<Long> upsertAndReturnIdsList(@NotNull Collection<? extends T> entities) {
        kotlin.jvm.internal.t.i(entities, "entities");
        List listC = kotlin.collections.u.c();
        for (T t10 : entities) {
            try {
                listC.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t10)));
            } catch (SQLiteConstraintException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(t10);
                listC.add(-1L);
            }
        }
        return kotlin.collections.u.a(listC);
    }
}
