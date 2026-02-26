package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import kotlin.collections.d0;
import kotlin.collections.r0;
import kotlin.collections.y0;
import kotlin.collections.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: InvalidationTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public class InvalidationTracker {

    @NotNull
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";

    @NotNull
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";

    @NotNull
    public static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1";

    @NotNull
    public static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";

    @NotNull
    private static final String TABLE_ID_COLUMN_NAME = "table_id";

    @NotNull
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";

    @Nullable
    private AutoCloser autoCloser;

    @Nullable
    private volatile SupportSQLiteStatement cleanupStatement;

    @NotNull
    private final RoomDatabase database;
    private volatile boolean initialized;

    @NotNull
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;

    @Nullable
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;

    @NotNull
    private final ObservedTableTracker observedTableTracker;

    @GuardedBy("observerMap")
    @NotNull
    private final SafeIterableMap<Observer, ObserverWrapper> observerMap;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    private final AtomicBoolean pendingRefresh;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final Runnable refreshRunnable;

    @NotNull
    private final Map<String, String> shadowTablesMap;

    @NotNull
    private final Object syncTriggersLock;

    @NotNull
    private final Map<String, Integer> tableIdLookup;

    @NotNull
    private final String[] tablesNames;

    @NotNull
    private final Object trackerLock;

    @NotNull
    private final Map<String, Set<String>> viewTables;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};

    /* JADX INFO: compiled from: InvalidationTracker.kt */
    public static final class ObservedTableTracker {
        public static final int ADD = 1;

        @NotNull
        public static final Companion Companion = new Companion(null);
        public static final int NO_OP = 0;
        public static final int REMOVE = 2;
        private boolean needsSync;

        @NotNull
        private final long[] tableObservers;

        @NotNull
        private final int[] triggerStateChanges;

        @NotNull
        private final boolean[] triggerStates;

        /* JADX INFO: compiled from: InvalidationTracker.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
                this();
            }
        }

        public ObservedTableTracker(int i10) {
            this.tableObservers = new long[i10];
            this.triggerStates = new boolean[i10];
            this.triggerStateChanges = new int[i10];
        }

        public final boolean getNeedsSync() {
            return this.needsSync;
        }

        @NotNull
        public final long[] getTableObservers() {
            return this.tableObservers;
        }

        @VisibleForTesting
        @Nullable
        public final int[] getTablesToSync() {
            synchronized (this) {
                if (!this.needsSync) {
                    return null;
                }
                long[] jArr = this.tableObservers;
                int length = jArr.length;
                int i10 = 0;
                int i11 = 0;
                while (i10 < length) {
                    int i12 = i11 + 1;
                    int i13 = 1;
                    boolean z10 = jArr[i10] > 0;
                    boolean[] zArr = this.triggerStates;
                    if (z10 != zArr[i11]) {
                        int[] iArr = this.triggerStateChanges;
                        if (!z10) {
                            i13 = 2;
                        }
                        iArr[i11] = i13;
                    } else {
                        this.triggerStateChanges[i11] = 0;
                    }
                    zArr[i11] = z10;
                    i10++;
                    i11 = i12;
                }
                this.needsSync = false;
                return (int[]) this.triggerStateChanges.clone();
            }
        }

        public final boolean onAdded(@NotNull int... tableIds) {
            boolean z10;
            kotlin.jvm.internal.t.i(tableIds, "tableIds");
            synchronized (this) {
                z10 = false;
                for (int i10 : tableIds) {
                    long[] jArr = this.tableObservers;
                    long j10 = jArr[i10];
                    jArr[i10] = 1 + j10;
                    if (j10 == 0) {
                        z10 = true;
                        this.needsSync = true;
                    }
                }
                k0 k0Var = k0.f35197a;
            }
            return z10;
        }

        public final boolean onRemoved(@NotNull int... tableIds) {
            boolean z10;
            kotlin.jvm.internal.t.i(tableIds, "tableIds");
            synchronized (this) {
                z10 = false;
                for (int i10 : tableIds) {
                    long[] jArr = this.tableObservers;
                    long j10 = jArr[i10];
                    jArr[i10] = j10 - 1;
                    if (j10 == 1) {
                        z10 = true;
                        this.needsSync = true;
                    }
                }
                k0 k0Var = k0.f35197a;
            }
            return z10;
        }

        public final void resetTriggerState() {
            synchronized (this) {
                Arrays.fill(this.triggerStates, false);
                this.needsSync = true;
                k0 k0Var = k0.f35197a;
            }
        }

        public final void setNeedsSync(boolean z10) {
            this.needsSync = z10;
        }
    }

    /* JADX INFO: compiled from: InvalidationTracker.kt */
    public static abstract class Observer {

        @NotNull
        private final String[] tables;

        public Observer(@NotNull String[] tables) {
            kotlin.jvm.internal.t.i(tables, "tables");
            this.tables = tables;
        }

        @NotNull
        public final String[] getTables$room_runtime_release() {
            return this.tables;
        }

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(@NotNull Set<String> set);

        /* JADX WARN: Illegal instructions before constructor call */
        protected Observer(@NotNull String firstTable, @NotNull String... rest) {
            kotlin.jvm.internal.t.i(firstTable, "firstTable");
            kotlin.jvm.internal.t.i(rest, "rest");
            List listC = kotlin.collections.u.c();
            kotlin.collections.a0.D(listC, rest);
            listC.add(firstTable);
            Object[] array = kotlin.collections.u.a(listC).toArray(new String[0]);
            kotlin.jvm.internal.t.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            this((String[]) array);
        }
    }

    /* JADX INFO: compiled from: InvalidationTracker.kt */
    public static final class ObserverWrapper {

        @NotNull
        private final Observer observer;

        @NotNull
        private final Set<String> singleTableSet;

        @NotNull
        private final int[] tableIds;

        @NotNull
        private final String[] tableNames;

        public ObserverWrapper(@NotNull Observer observer, @NotNull int[] tableIds, @NotNull String[] tableNames) {
            kotlin.jvm.internal.t.i(observer, "observer");
            kotlin.jvm.internal.t.i(tableIds, "tableIds");
            kotlin.jvm.internal.t.i(tableNames, "tableNames");
            this.observer = observer;
            this.tableIds = tableIds;
            this.tableNames = tableNames;
            this.singleTableSet = (tableNames.length == 0) ^ true ? y0.c(tableNames[0]) : z0.e();
            if (!(tableIds.length == tableNames.length)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        @NotNull
        public final Observer getObserver$room_runtime_release() {
            return this.observer;
        }

        @NotNull
        public final int[] getTableIds$room_runtime_release() {
            return this.tableIds;
        }

        public final void notifyByTableInvalidStatus$room_runtime_release(@NotNull Set<Integer> invalidatedTablesIds) {
            Set<String> setE;
            kotlin.jvm.internal.t.i(invalidatedTablesIds, "invalidatedTablesIds");
            int[] iArr = this.tableIds;
            int length = iArr.length;
            if (length != 0) {
                int i10 = 0;
                if (length != 1) {
                    Set setB = y0.b();
                    int[] iArr2 = this.tableIds;
                    int length2 = iArr2.length;
                    int i11 = 0;
                    while (i10 < length2) {
                        int i12 = i11 + 1;
                        if (invalidatedTablesIds.contains(Integer.valueOf(iArr2[i10]))) {
                            setB.add(this.tableNames[i11]);
                        }
                        i10++;
                        i11 = i12;
                    }
                    setE = y0.a(setB);
                } else {
                    setE = invalidatedTablesIds.contains(Integer.valueOf(iArr[0])) ? this.singleTableSet : z0.e();
                }
            } else {
                setE = z0.e();
            }
            if (!setE.isEmpty()) {
                this.observer.onInvalidated(setE);
            }
        }

        public final void notifyByTableNames$room_runtime_release(@NotNull String[] tables) {
            Set<String> setE;
            kotlin.jvm.internal.t.i(tables, "tables");
            int length = this.tableNames.length;
            if (length != 0) {
                boolean z10 = false;
                if (length != 1) {
                    Set setB = y0.b();
                    for (String str : tables) {
                        for (String str2 : this.tableNames) {
                            if (p9.q.x(str2, str, true)) {
                                setB.add(str2);
                            }
                        }
                    }
                    setE = y0.a(setB);
                } else {
                    int length2 = tables.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length2) {
                            break;
                        }
                        if (p9.q.x(tables[i10], this.tableNames[0], true)) {
                            z10 = true;
                            break;
                        }
                        i10++;
                    }
                    setE = z10 ? this.singleTableSet : z0.e();
                }
            } else {
                setE = z0.e();
            }
            if (!setE.isEmpty()) {
                this.observer.onInvalidated(setE);
            }
        }
    }

    /* JADX INFO: compiled from: InvalidationTracker.kt */
    public static final class WeakObserver extends Observer {

        @NotNull
        private final WeakReference<Observer> delegateRef;

        @NotNull
        private final InvalidationTracker tracker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WeakObserver(@NotNull InvalidationTracker tracker, @NotNull Observer delegate) {
            super(delegate.getTables$room_runtime_release());
            kotlin.jvm.internal.t.i(tracker, "tracker");
            kotlin.jvm.internal.t.i(delegate, "delegate");
            this.tracker = tracker;
            this.delegateRef = new WeakReference<>(delegate);
        }

        @NotNull
        public final WeakReference<Observer> getDelegateRef() {
            return this.delegateRef;
        }

        @NotNull
        public final InvalidationTracker getTracker() {
            return this.tracker;
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@NotNull Set<String> tables) {
            kotlin.jvm.internal.t.i(tables, "tables");
            Observer observer = this.delegateRef.get();
            if (observer == null) {
                this.tracker.removeObserver(this);
            } else {
                observer.onInvalidated(tables);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(@NotNull RoomDatabase database, @NotNull Map<String, String> shadowTablesMap, @NotNull Map<String, Set<String>> viewTables, @NotNull String... tableNames) {
        String lowerCase;
        kotlin.jvm.internal.t.i(database, "database");
        kotlin.jvm.internal.t.i(shadowTablesMap, "shadowTablesMap");
        kotlin.jvm.internal.t.i(viewTables, "viewTables");
        kotlin.jvm.internal.t.i(tableNames, "tableNames");
        this.database = database;
        this.shadowTablesMap = shadowTablesMap;
        this.viewTables = viewTables;
        this.pendingRefresh = new AtomicBoolean(false);
        this.observedTableTracker = new ObservedTableTracker(tableNames.length);
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(database);
        this.observerMap = new SafeIterableMap<>();
        this.syncTriggersLock = new Object();
        this.trackerLock = new Object();
        this.tableIdLookup = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str = tableNames[i10];
            Locale US = Locale.US;
            kotlin.jvm.internal.t.h(US, "US");
            String lowerCase2 = str.toLowerCase(US);
            kotlin.jvm.internal.t.h(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            this.tableIdLookup.put(lowerCase2, Integer.valueOf(i10));
            String str2 = this.shadowTablesMap.get(tableNames[i10]);
            if (str2 != null) {
                kotlin.jvm.internal.t.h(US, "US");
                lowerCase = str2.toLowerCase(US);
                kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr[i10] = lowerCase2;
        }
        this.tablesNames = strArr;
        for (Map.Entry<String, String> entry : this.shadowTablesMap.entrySet()) {
            String value = entry.getValue();
            Locale US2 = Locale.US;
            kotlin.jvm.internal.t.h(US2, "US");
            String lowerCase3 = value.toLowerCase(US2);
            kotlin.jvm.internal.t.h(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
            if (this.tableIdLookup.containsKey(lowerCase3)) {
                String key = entry.getKey();
                kotlin.jvm.internal.t.h(US2, "US");
                String lowerCase4 = key.toLowerCase(US2);
                kotlin.jvm.internal.t.h(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                Map<String, Integer> map = this.tableIdLookup;
                map.put(lowerCase4, r0.h(map, lowerCase3));
            }
        }
        this.refreshRunnable = new Runnable() { // from class: androidx.room.InvalidationTracker$refreshRunnable$1
            private final Set<Integer> checkUpdatedTable() {
                InvalidationTracker invalidationTracker = this.this$0;
                Set setB = y0.b();
                Cursor cursorQuery$default = RoomDatabase.query$default(invalidationTracker.getDatabase$room_runtime_release(), new SimpleSQLiteQuery(InvalidationTracker.SELECT_UPDATED_TABLES_SQL), null, 2, null);
                try {
                    Cursor cursor = cursorQuery$default;
                    while (cursor.moveToNext()) {
                        setB.add(Integer.valueOf(cursor.getInt(0)));
                    }
                    k0 k0Var = k0.f35197a;
                    f9.c.a(cursorQuery$default, null);
                    Set<Integer> setA = y0.a(setB);
                    if (!setA.isEmpty()) {
                        if (this.this$0.getCleanupStatement$room_runtime_release() == null) {
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                        SupportSQLiteStatement cleanupStatement$room_runtime_release = this.this$0.getCleanupStatement$room_runtime_release();
                        if (cleanupStatement$room_runtime_release == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        cleanupStatement$room_runtime_release.executeUpdateDelete();
                    }
                    return setA;
                } finally {
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Set<Integer> setE;
                AutoCloser autoCloser;
                AutoCloser autoCloser2;
                Lock closeLock$room_runtime_release = this.this$0.getDatabase$room_runtime_release().getCloseLock$room_runtime_release();
                closeLock$room_runtime_release.lock();
                try {
                    try {
                    } catch (SQLiteException e10) {
                        Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e10);
                        setE = z0.e();
                        closeLock$room_runtime_release.unlock();
                        autoCloser = this.this$0.autoCloser;
                        if (autoCloser != null) {
                        }
                    } catch (IllegalStateException e11) {
                        Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e11);
                        setE = z0.e();
                        closeLock$room_runtime_release.unlock();
                        autoCloser = this.this$0.autoCloser;
                        if (autoCloser != null) {
                        }
                    }
                    if (!this.this$0.ensureInitialization$room_runtime_release()) {
                        if (autoCloser2 != null) {
                            return;
                        } else {
                            return;
                        }
                    }
                    if (!this.this$0.getPendingRefresh().compareAndSet(true, false)) {
                        closeLock$room_runtime_release.unlock();
                        AutoCloser autoCloser3 = this.this$0.autoCloser;
                        if (autoCloser3 != null) {
                            autoCloser3.decrementCountAndScheduleClose();
                            return;
                        }
                        return;
                    }
                    if (this.this$0.getDatabase$room_runtime_release().inTransaction()) {
                        closeLock$room_runtime_release.unlock();
                        AutoCloser autoCloser4 = this.this$0.autoCloser;
                        if (autoCloser4 != null) {
                            autoCloser4.decrementCountAndScheduleClose();
                            return;
                        }
                        return;
                    }
                    SupportSQLiteDatabase writableDatabase = this.this$0.getDatabase$room_runtime_release().getOpenHelper().getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        setE = checkUpdatedTable();
                        writableDatabase.setTransactionSuccessful();
                        closeLock$room_runtime_release.unlock();
                        autoCloser = this.this$0.autoCloser;
                        if (autoCloser != null) {
                            autoCloser.decrementCountAndScheduleClose();
                        }
                        if (!setE.isEmpty()) {
                            SafeIterableMap<InvalidationTracker.Observer, InvalidationTracker.ObserverWrapper> observerMap$room_runtime_release = this.this$0.getObserverMap$room_runtime_release();
                            InvalidationTracker invalidationTracker = this.this$0;
                            synchronized (observerMap$room_runtime_release) {
                                Iterator<Map.Entry<K, V>> it = invalidationTracker.getObserverMap$room_runtime_release().iterator();
                                while (it.hasNext()) {
                                    ((InvalidationTracker.ObserverWrapper) ((Map.Entry) it.next()).getValue()).notifyByTableInvalidStatus$room_runtime_release(setE);
                                }
                                k0 k0Var = k0.f35197a;
                            }
                        }
                    } finally {
                        writableDatabase.endTransaction();
                    }
                } finally {
                    closeLock$room_runtime_release.unlock();
                    autoCloser2 = this.this$0.autoCloser;
                    if (autoCloser2 != null) {
                        autoCloser2.decrementCountAndScheduleClose();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAutoCloseCallback() {
        synchronized (this.trackerLock) {
            this.initialized = false;
            this.observedTableTracker.resetTriggerState();
            SupportSQLiteStatement supportSQLiteStatement = this.cleanupStatement;
            if (supportSQLiteStatement != null) {
                supportSQLiteStatement.close();
                k0 k0Var = k0.f35197a;
            }
        }
    }

    private final String[] resolveViews(String[] strArr) {
        Set setB = y0.b();
        for (String str : strArr) {
            Map<String, Set<String>> map = this.viewTables;
            Locale US = Locale.US;
            kotlin.jvm.internal.t.h(US, "US");
            String lowerCase = str.toLowerCase(US);
            kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map<String, Set<String>> map2 = this.viewTables;
                kotlin.jvm.internal.t.h(US, "US");
                String lowerCase2 = str.toLowerCase(US);
                kotlin.jvm.internal.t.h(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Set<String> set = map2.get(lowerCase2);
                kotlin.jvm.internal.t.f(set);
                setB.addAll(set);
            } else {
                setB.add(str);
            }
        }
        Object[] array = y0.a(setB).toArray(new String[0]);
        kotlin.jvm.internal.t.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    private final void startTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i10) {
        supportSQLiteDatabase.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i10 + ", 0)");
        String str = this.tablesNames[i10];
        for (String str2 : TRIGGERS) {
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + Companion.getTriggerName$room_runtime_release(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE " + UPDATE_TABLE_NAME + " SET " + INVALIDATED_COLUMN_NAME + " = 1 WHERE " + TABLE_ID_COLUMN_NAME + " = " + i10 + " AND " + INVALIDATED_COLUMN_NAME + " = 0; END";
            kotlin.jvm.internal.t.h(str3, "StringBuilder().apply(builderAction).toString()");
            supportSQLiteDatabase.execSQL(str3);
        }
    }

    private final void stopTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i10) {
        String str = this.tablesNames[i10];
        for (String str2 : TRIGGERS) {
            String str3 = "DROP TRIGGER IF EXISTS " + Companion.getTriggerName$room_runtime_release(str, str2);
            kotlin.jvm.internal.t.h(str3, "StringBuilder().apply(builderAction).toString()");
            supportSQLiteDatabase.execSQL(str3);
        }
    }

    private final String[] validateAndResolveTableNames(String[] strArr) {
        String[] strArrResolveViews = resolveViews(strArr);
        for (String str : strArrResolveViews) {
            Map<String, Integer> map = this.tableIdLookup;
            Locale US = Locale.US;
            kotlin.jvm.internal.t.h(US, "US");
            String lowerCase = str.toLowerCase(US);
            kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!map.containsKey(lowerCase)) {
                throw new IllegalArgumentException(("There is no table with name " + str).toString());
            }
        }
        return strArrResolveViews;
    }

    @SuppressLint({"RestrictedApi"})
    @WorkerThread
    public void addObserver(@NotNull Observer observer) {
        ObserverWrapper observerWrapperPutIfAbsent;
        kotlin.jvm.internal.t.i(observer, "observer");
        String[] strArrResolveViews = resolveViews(observer.getTables$room_runtime_release());
        ArrayList arrayList = new ArrayList(strArrResolveViews.length);
        for (String str : strArrResolveViews) {
            Map<String, Integer> map = this.tableIdLookup;
            Locale US = Locale.US;
            kotlin.jvm.internal.t.h(US, "US");
            String lowerCase = str.toLowerCase(US);
            kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Integer num = map.get(lowerCase);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
            arrayList.add(Integer.valueOf(num.intValue()));
        }
        int[] iArrO0 = d0.O0(arrayList);
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, iArrO0, strArrResolveViews);
        synchronized (this.observerMap) {
            observerWrapperPutIfAbsent = this.observerMap.putIfAbsent(observer, observerWrapper);
        }
        if (observerWrapperPutIfAbsent == null && this.observedTableTracker.onAdded(Arrays.copyOf(iArrO0, iArrO0.length))) {
            syncTriggers$room_runtime_release();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addWeakObserver(@NotNull Observer observer) {
        kotlin.jvm.internal.t.i(observer, "observer");
        addObserver(new WeakObserver(this, observer));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    public <T> LiveData<T> createLiveData(@NotNull String[] tableNames, @NotNull Callable<T> computeFunction) {
        kotlin.jvm.internal.t.i(tableNames, "tableNames");
        kotlin.jvm.internal.t.i(computeFunction, "computeFunction");
        return createLiveData(tableNames, false, computeFunction);
    }

    public final boolean ensureInitialization$room_runtime_release() {
        if (!this.database.isOpenInternal()) {
            return false;
        }
        if (!this.initialized) {
            this.database.getOpenHelper().getWritableDatabase();
        }
        if (this.initialized) {
            return true;
        }
        Log.e(Room.LOG_TAG, "database is not initialized even though it is open");
        return false;
    }

    @Nullable
    public final SupportSQLiteStatement getCleanupStatement$room_runtime_release() {
        return this.cleanupStatement;
    }

    @NotNull
    public final RoomDatabase getDatabase$room_runtime_release() {
        return this.database;
    }

    @NotNull
    public final SafeIterableMap<Observer, ObserverWrapper> getObserverMap$room_runtime_release() {
        return this.observerMap;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final AtomicBoolean getPendingRefresh() {
        return this.pendingRefresh;
    }

    @NotNull
    public final Map<String, Integer> getTableIdLookup$room_runtime_release() {
        return this.tableIdLookup;
    }

    @NotNull
    public final String[] getTablesNames$room_runtime_release() {
        return this.tablesNames;
    }

    public final void internalInit$room_runtime_release(@NotNull SupportSQLiteDatabase database) {
        kotlin.jvm.internal.t.i(database, "database");
        synchronized (this.trackerLock) {
            if (this.initialized) {
                Log.e(Room.LOG_TAG, "Invalidation tracker is initialized twice :/.");
                return;
            }
            database.execSQL("PRAGMA temp_store = MEMORY;");
            database.execSQL("PRAGMA recursive_triggers='ON';");
            database.execSQL(CREATE_TRACKING_TABLE_SQL);
            syncTriggers$room_runtime_release(database);
            this.cleanupStatement = database.compileStatement(RESET_UPDATED_TABLES_SQL);
            this.initialized = true;
            k0 k0Var = k0.f35197a;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting(otherwise = 3)
    public final void notifyObserversByTableNames(@NotNull String... tables) {
        kotlin.jvm.internal.t.i(tables, "tables");
        synchronized (this.observerMap) {
            Iterator<Map.Entry<K, V>> it = this.observerMap.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                kotlin.jvm.internal.t.h(entry, "(observer, wrapper)");
                Observer observer = (Observer) entry.getKey();
                ObserverWrapper observerWrapper = (ObserverWrapper) entry.getValue();
                if (!observer.isRemote$room_runtime_release()) {
                    observerWrapper.notifyByTableNames$room_runtime_release(tables);
                }
            }
            k0 k0Var = k0.f35197a;
        }
    }

    public void refreshVersionsAsync() {
        if (this.pendingRefresh.compareAndSet(false, true)) {
            AutoCloser autoCloser = this.autoCloser;
            if (autoCloser != null) {
                autoCloser.incrementCountAndEnsureDbIsOpen();
            }
            this.database.getQueryExecutor().execute(this.refreshRunnable);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @WorkerThread
    public void refreshVersionsSync() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser != null) {
            autoCloser.incrementCountAndEnsureDbIsOpen();
        }
        syncTriggers$room_runtime_release();
        this.refreshRunnable.run();
    }

    @SuppressLint({"RestrictedApi"})
    @WorkerThread
    public void removeObserver(@NotNull Observer observer) {
        ObserverWrapper observerWrapperRemove;
        kotlin.jvm.internal.t.i(observer, "observer");
        synchronized (this.observerMap) {
            observerWrapperRemove = this.observerMap.remove(observer);
        }
        if (observerWrapperRemove != null) {
            ObservedTableTracker observedTableTracker = this.observedTableTracker;
            int[] tableIds$room_runtime_release = observerWrapperRemove.getTableIds$room_runtime_release();
            if (observedTableTracker.onRemoved(Arrays.copyOf(tableIds$room_runtime_release, tableIds$room_runtime_release.length))) {
                syncTriggers$room_runtime_release();
            }
        }
    }

    public final void setAutoCloser$room_runtime_release(@NotNull AutoCloser autoCloser) {
        kotlin.jvm.internal.t.i(autoCloser, "autoCloser");
        this.autoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new Runnable() { // from class: androidx.room.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f1699a.onAutoCloseCallback();
            }
        });
    }

    public final void setCleanupStatement$room_runtime_release(@Nullable SupportSQLiteStatement supportSQLiteStatement) {
        this.cleanupStatement = supportSQLiteStatement;
    }

    public final void startMultiInstanceInvalidation$room_runtime_release(@NotNull Context context, @NotNull String name, @NotNull Intent serviceIntent) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(name, "name");
        kotlin.jvm.internal.t.i(serviceIntent, "serviceIntent");
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, name, serviceIntent, this, this.database.getQueryExecutor());
    }

    public final void stopMultiInstanceInvalidation$room_runtime_release() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.stop();
        }
        this.multiInstanceInvalidationClient = null;
    }

    public final void syncTriggers$room_runtime_release(@NotNull SupportSQLiteDatabase database) {
        kotlin.jvm.internal.t.i(database, "database");
        if (database.inTransaction()) {
            return;
        }
        try {
            Lock closeLock$room_runtime_release = this.database.getCloseLock$room_runtime_release();
            closeLock$room_runtime_release.lock();
            try {
                synchronized (this.syncTriggersLock) {
                    int[] tablesToSync = this.observedTableTracker.getTablesToSync();
                    if (tablesToSync == null) {
                        return;
                    }
                    Companion.beginTransactionInternal$room_runtime_release(database);
                    try {
                        int length = tablesToSync.length;
                        int i10 = 0;
                        int i11 = 0;
                        while (i10 < length) {
                            int i12 = tablesToSync[i10];
                            int i13 = i11 + 1;
                            if (i12 == 1) {
                                startTrackingTable(database, i11);
                            } else if (i12 == 2) {
                                stopTrackingTable(database, i11);
                            }
                            i10++;
                            i11 = i13;
                        }
                        database.setTransactionSuccessful();
                        database.endTransaction();
                        k0 k0Var = k0.f35197a;
                    } catch (Throwable th) {
                        database.endTransaction();
                        throw th;
                    }
                }
            } finally {
                closeLock$room_runtime_release.unlock();
            }
        } catch (SQLiteException e10) {
            Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e10);
        } catch (IllegalStateException e11) {
            Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e11);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    public <T> LiveData<T> createLiveData(@NotNull String[] tableNames, boolean z10, @NotNull Callable<T> computeFunction) {
        kotlin.jvm.internal.t.i(tableNames, "tableNames");
        kotlin.jvm.internal.t.i(computeFunction, "computeFunction");
        return this.invalidationLiveDataContainer.create(validateAndResolveTableNames(tableNames), z10, computeFunction);
    }

    /* JADX INFO: compiled from: InvalidationTracker.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final void beginTransactionInternal$room_runtime_release(@NotNull SupportSQLiteDatabase database) {
            kotlin.jvm.internal.t.i(database, "database");
            if (database.isWriteAheadLoggingEnabled()) {
                database.beginTransactionNonExclusive();
            } else {
                database.beginTransaction();
            }
        }

        @NotNull
        public final String getTriggerName$room_runtime_release(@NotNull String tableName, @NotNull String triggerType) {
            kotlin.jvm.internal.t.i(tableName, "tableName");
            kotlin.jvm.internal.t.i(triggerType, "triggerType");
            return "`room_table_modification_trigger_" + tableName + '_' + triggerType + '`';
        }

        @VisibleForTesting
        public static /* synthetic */ void getRESET_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getSELECT_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getRefreshRunnable$annotations() {
    }

    public final void syncTriggers$room_runtime_release() {
        if (this.database.isOpenInternal()) {
            syncTriggers$room_runtime_release(this.database.getOpenHelper().getWritableDatabase());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(@NotNull RoomDatabase database, @NotNull String... tableNames) {
        this(database, r0.g(), r0.g(), (String[]) Arrays.copyOf(tableNames, tableNames.length));
        kotlin.jvm.internal.t.i(database, "database");
        kotlin.jvm.internal.t.i(tableNames, "tableNames");
    }
}
