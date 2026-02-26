package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: RoomSQLiteQuery.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;
    public static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    public static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    private int argCount;

    @NotNull
    private final int[] bindingTypes;

    @NotNull
    public final byte[][] blobBindings;

    @VisibleForTesting
    private final int capacity;

    @NotNull
    public final double[] doubleBindings;

    @NotNull
    public final long[] longBindings;

    @Nullable
    private volatile String query;

    @NotNull
    public final String[] stringBindings;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final TreeMap<Integer, RoomSQLiteQuery> queryPool = new TreeMap<>();

    /* JADX INFO: compiled from: RoomSQLiteQuery.kt */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Binding {
    }

    public /* synthetic */ RoomSQLiteQuery(int i10, kotlin.jvm.internal.k kVar) {
        this(i10);
    }

    @NotNull
    public static final RoomSQLiteQuery acquire(@NotNull String str, int i10) {
        return Companion.acquire(str, i10);
    }

    @NotNull
    public static final RoomSQLiteQuery copyFrom(@NotNull SupportSQLiteQuery supportSQLiteQuery) {
        return Companion.copyFrom(supportSQLiteQuery);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i10, @NotNull byte[] value) {
        kotlin.jvm.internal.t.i(value, "value");
        this.bindingTypes[i10] = 5;
        this.blobBindings[i10] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i10, double d10) {
        this.bindingTypes[i10] = 3;
        this.doubleBindings[i10] = d10;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i10, long j10) {
        this.bindingTypes[i10] = 2;
        this.longBindings[i10] = j10;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i10) {
        this.bindingTypes[i10] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i10, @NotNull String value) {
        kotlin.jvm.internal.t.i(value, "value");
        this.bindingTypes[i10] = 4;
        this.stringBindings[i10] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(@NotNull SupportSQLiteProgram statement) {
        kotlin.jvm.internal.t.i(statement, "statement");
        int argCount = getArgCount();
        if (1 > argCount) {
            return;
        }
        int i10 = 1;
        while (true) {
            int i11 = this.bindingTypes[i10];
            if (i11 == 1) {
                statement.bindNull(i10);
            } else if (i11 == 2) {
                statement.bindLong(i10, this.longBindings[i10]);
            } else if (i11 == 3) {
                statement.bindDouble(i10, this.doubleBindings[i10]);
            } else if (i11 == 4) {
                String str = this.stringBindings[i10];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                statement.bindString(i10, str);
            } else if (i11 == 5) {
                byte[] bArr = this.blobBindings[i10];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                statement.bindBlob(i10, bArr);
            }
            if (i10 == argCount) {
                return;
            } else {
                i10++;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        Arrays.fill(this.bindingTypes, 1);
        Arrays.fill(this.stringBindings, (Object) null);
        Arrays.fill(this.blobBindings, (Object) null);
        this.query = null;
    }

    public final void copyArgumentsFrom(@NotNull RoomSQLiteQuery other) {
        kotlin.jvm.internal.t.i(other, "other");
        int argCount = other.getArgCount() + 1;
        System.arraycopy(other.bindingTypes, 0, this.bindingTypes, 0, argCount);
        System.arraycopy(other.longBindings, 0, this.longBindings, 0, argCount);
        System.arraycopy(other.stringBindings, 0, this.stringBindings, 0, argCount);
        System.arraycopy(other.blobBindings, 0, this.blobBindings, 0, argCount);
        System.arraycopy(other.doubleBindings, 0, this.doubleBindings, 0, argCount);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.argCount;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    @NotNull
    public String getSql() {
        String str = this.query;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void init(@NotNull String query, int i10) {
        kotlin.jvm.internal.t.i(query, "query");
        this.query = query;
        this.argCount = i10;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = queryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.capacity), this);
            Companion.prunePoolLocked$room_runtime_release();
            k0 k0Var = k0.f35197a;
        }
    }

    private RoomSQLiteQuery(int i10) {
        this.capacity = i10;
        int i11 = i10 + 1;
        this.bindingTypes = new int[i11];
        this.longBindings = new long[i11];
        this.doubleBindings = new double[i11];
        this.stringBindings = new String[i11];
        this.blobBindings = new byte[i11][];
    }

    /* JADX INFO: compiled from: RoomSQLiteQuery.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final RoomSQLiteQuery acquire(@NotNull String query, int i10) {
            kotlin.jvm.internal.t.i(query, "query");
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            synchronized (treeMap) {
                Map.Entry<Integer, RoomSQLiteQuery> entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i10));
                if (entryCeilingEntry == null) {
                    k0 k0Var = k0.f35197a;
                    RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i10, null);
                    roomSQLiteQuery.init(query, i10);
                    return roomSQLiteQuery;
                }
                treeMap.remove(entryCeilingEntry.getKey());
                RoomSQLiteQuery sqliteQuery = entryCeilingEntry.getValue();
                sqliteQuery.init(query, i10);
                kotlin.jvm.internal.t.h(sqliteQuery, "sqliteQuery");
                return sqliteQuery;
            }
        }

        @NotNull
        public final RoomSQLiteQuery copyFrom(@NotNull SupportSQLiteQuery supportSQLiteQuery) {
            kotlin.jvm.internal.t.i(supportSQLiteQuery, "supportSQLiteQuery");
            final RoomSQLiteQuery roomSQLiteQueryAcquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
            supportSQLiteQuery.bindTo(new SupportSQLiteProgram() { // from class: androidx.room.RoomSQLiteQuery$Companion$copyFrom$1
                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindBlob(int i10, @NotNull byte[] value) {
                    kotlin.jvm.internal.t.i(value, "value");
                    roomSQLiteQueryAcquire.bindBlob(i10, value);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindDouble(int i10, double d10) {
                    roomSQLiteQueryAcquire.bindDouble(i10, d10);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindLong(int i10, long j10) {
                    roomSQLiteQueryAcquire.bindLong(i10, j10);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindNull(int i10) {
                    roomSQLiteQueryAcquire.bindNull(i10);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindString(int i10, @NotNull String value) {
                    kotlin.jvm.internal.t.i(value, "value");
                    roomSQLiteQueryAcquire.bindString(i10, value);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void clearBindings() {
                    roomSQLiteQueryAcquire.clearBindings();
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    roomSQLiteQueryAcquire.close();
                }
            });
            return roomSQLiteQueryAcquire;
        }

        public final void prunePoolLocked$room_runtime_release() {
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            if (treeMap.size() <= 15) {
                return;
            }
            int size = treeMap.size() - 10;
            Iterator<Integer> it = treeMap.descendingKeySet().iterator();
            kotlin.jvm.internal.t.h(it, "queryPool.descendingKeySet().iterator()");
            while (true) {
                int i10 = size - 1;
                if (size <= 0) {
                    return;
                }
                it.next();
                it.remove();
                size = i10;
            }
        }

        @VisibleForTesting
        public static /* synthetic */ void getDESIRED_POOL_SIZE$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getPOOL_LIMIT$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getQueryPool$annotations() {
        }
    }

    private static /* synthetic */ void getBindingTypes$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getBlobBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getDoubleBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLongBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getStringBindings$annotations() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
