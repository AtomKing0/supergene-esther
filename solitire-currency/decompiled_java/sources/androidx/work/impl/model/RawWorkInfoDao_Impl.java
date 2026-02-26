package androidx.work.impl.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import s9.h;

/* JADX INFO: loaded from: classes2.dex */
public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    private final RoomDatabase __db;

    public RawWorkInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipWorkProgressAsandroidxWorkData(HashMap<String, ArrayList<Data>> map) {
        int i10;
        Set<String> setKeySet = map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (map.size() > 999) {
            HashMap<String, ArrayList<Data>> map2 = new HashMap<>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
            loop0: while (true) {
                i10 = 0;
                for (String str : setKeySet) {
                    map2.put(str, map.get(str));
                    i10++;
                    if (i10 == 999) {
                        break;
                    }
                }
                __fetchRelationshipWorkProgressAsandroidxWorkData(map2);
                map2 = new HashMap<>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
            }
            if (i10 > 0) {
                __fetchRelationshipWorkProgressAsandroidxWorkData(map2);
                return;
            }
            return;
        }
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int size = setKeySet.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 0);
        int i11 = 1;
        for (String str2 : setKeySet) {
            if (str2 == null) {
                roomSQLiteQueryAcquire.bindNull(i11);
            } else {
                roomSQLiteQueryAcquire.bindString(i11, str2);
            }
            i11++;
        }
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (cursorQuery.moveToNext()) {
                ArrayList<Data> arrayList = map.get(cursorQuery.getString(columnIndex));
                if (arrayList != null) {
                    arrayList.add(Data.fromByteArray(cursorQuery.isNull(0) ? null : cursorQuery.getBlob(0)));
                }
            }
        } finally {
            cursorQuery.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipWorkTagAsjavaLangString(HashMap<String, ArrayList<String>> map) {
        int i10;
        Set<String> setKeySet = map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (map.size() > 999) {
            HashMap<String, ArrayList<String>> map2 = new HashMap<>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
            loop0: while (true) {
                i10 = 0;
                for (String str : setKeySet) {
                    map2.put(str, map.get(str));
                    i10++;
                    if (i10 == 999) {
                        break;
                    }
                }
                __fetchRelationshipWorkTagAsjavaLangString(map2);
                map2 = new HashMap<>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
            }
            if (i10 > 0) {
                __fetchRelationshipWorkTagAsjavaLangString(map2);
                return;
            }
            return;
        }
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int size = setKeySet.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 0);
        int i11 = 1;
        for (String str2 : setKeySet) {
            if (str2 == null) {
                roomSQLiteQueryAcquire.bindNull(i11);
            } else {
                roomSQLiteQueryAcquire.bindString(i11, str2);
            }
            i11++;
        }
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (cursorQuery.moveToNext()) {
                ArrayList<String> arrayList = map.get(cursorQuery.getString(columnIndex));
                if (arrayList != null) {
                    arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                }
            }
        } finally {
            cursorQuery.close();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(SupportSQLiteQuery supportSQLiteQuery) {
        Data dataFromByteArray;
        long j10;
        int i10;
        boolean z10;
        boolean z11;
        boolean z12;
        Set<Constraints.ContentUriTrigger> setByteArrayToSetOfTriggers;
        int i11;
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, supportSQLiteQuery, true, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "id");
            int columnIndex2 = CursorUtil.getColumnIndex(cursorQuery, "state");
            int columnIndex3 = CursorUtil.getColumnIndex(cursorQuery, "output");
            int columnIndex4 = CursorUtil.getColumnIndex(cursorQuery, "initial_delay");
            int columnIndex5 = CursorUtil.getColumnIndex(cursorQuery, "interval_duration");
            int columnIndex6 = CursorUtil.getColumnIndex(cursorQuery, "flex_duration");
            int columnIndex7 = CursorUtil.getColumnIndex(cursorQuery, "run_attempt_count");
            int columnIndex8 = CursorUtil.getColumnIndex(cursorQuery, "backoff_policy");
            int columnIndex9 = CursorUtil.getColumnIndex(cursorQuery, "backoff_delay_duration");
            int columnIndex10 = CursorUtil.getColumnIndex(cursorQuery, "last_enqueue_time");
            int columnIndex11 = CursorUtil.getColumnIndex(cursorQuery, "period_count");
            int columnIndex12 = CursorUtil.getColumnIndex(cursorQuery, "generation");
            int columnIndex13 = CursorUtil.getColumnIndex(cursorQuery, "next_schedule_time_override");
            int columnIndex14 = CursorUtil.getColumnIndex(cursorQuery, DownloadService.KEY_STOP_REASON);
            int columnIndex15 = CursorUtil.getColumnIndex(cursorQuery, "required_network_type");
            int columnIndex16 = CursorUtil.getColumnIndex(cursorQuery, "requires_charging");
            int columnIndex17 = CursorUtil.getColumnIndex(cursorQuery, "requires_device_idle");
            int columnIndex18 = CursorUtil.getColumnIndex(cursorQuery, "requires_battery_not_low");
            int columnIndex19 = CursorUtil.getColumnIndex(cursorQuery, "requires_storage_not_low");
            int columnIndex20 = CursorUtil.getColumnIndex(cursorQuery, "trigger_content_update_delay");
            int columnIndex21 = CursorUtil.getColumnIndex(cursorQuery, "trigger_max_content_delay");
            int columnIndex22 = CursorUtil.getColumnIndex(cursorQuery, "content_uri_triggers");
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            int i12 = columnIndex13;
            HashMap<String, ArrayList<Data>> map2 = new HashMap<>();
            while (cursorQuery.moveToNext()) {
                int i13 = columnIndex12;
                String string = cursorQuery.getString(columnIndex);
                if (map.get(string) == null) {
                    i11 = columnIndex11;
                    map.put(string, new ArrayList<>());
                } else {
                    i11 = columnIndex11;
                }
                String string2 = cursorQuery.getString(columnIndex);
                if (map2.get(string2) == null) {
                    map2.put(string2, new ArrayList<>());
                }
                columnIndex12 = i13;
                columnIndex11 = i11;
            }
            int i14 = columnIndex11;
            int i15 = columnIndex12;
            cursorQuery.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(map);
            __fetchRelationshipWorkProgressAsandroidxWorkData(map2);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string3 = (columnIndex == -1 || cursorQuery.isNull(columnIndex)) ? null : cursorQuery.getString(columnIndex);
                WorkInfo.State stateIntToState = columnIndex2 == -1 ? null : WorkTypeConverters.intToState(cursorQuery.getInt(columnIndex2));
                if (columnIndex3 == -1) {
                    dataFromByteArray = null;
                } else {
                    dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndex3) ? null : cursorQuery.getBlob(columnIndex3));
                }
                long j11 = columnIndex4 == -1 ? 0L : cursorQuery.getLong(columnIndex4);
                long j12 = columnIndex5 == -1 ? 0L : cursorQuery.getLong(columnIndex5);
                long j13 = columnIndex6 == -1 ? 0L : cursorQuery.getLong(columnIndex6);
                boolean z13 = false;
                int i16 = columnIndex7 == -1 ? 0 : cursorQuery.getInt(columnIndex7);
                BackoffPolicy backoffPolicyIntToBackoffPolicy = columnIndex8 == -1 ? null : WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndex8));
                long j14 = columnIndex9 == -1 ? 0L : cursorQuery.getLong(columnIndex9);
                if (columnIndex10 == -1) {
                    i10 = i14;
                    j10 = 0;
                } else {
                    j10 = cursorQuery.getLong(columnIndex10);
                    i10 = i14;
                }
                int i17 = i10 == -1 ? 0 : cursorQuery.getInt(i10);
                int i18 = i15;
                int i19 = i10;
                int i20 = i18 == -1 ? 0 : cursorQuery.getInt(i18);
                int i21 = i12;
                long j15 = i21 == -1 ? 0L : cursorQuery.getLong(i21);
                int i22 = columnIndex14;
                int i23 = i22 == -1 ? 0 : cursorQuery.getInt(i22);
                int i24 = columnIndex15;
                NetworkType networkTypeIntToNetworkType = i24 == -1 ? null : WorkTypeConverters.intToNetworkType(cursorQuery.getInt(i24));
                int i25 = columnIndex16;
                if (i25 == -1) {
                    z10 = false;
                } else {
                    z10 = cursorQuery.getInt(i25) != 0;
                }
                int i26 = columnIndex17;
                if (i26 == -1) {
                    z11 = false;
                } else {
                    z11 = cursorQuery.getInt(i26) != 0;
                }
                int i27 = columnIndex18;
                if (i27 == -1) {
                    z12 = false;
                } else {
                    z12 = cursorQuery.getInt(i27) != 0;
                }
                int i28 = columnIndex19;
                if (i28 != -1 && cursorQuery.getInt(i28) != 0) {
                    z13 = true;
                }
                boolean z14 = z13;
                int i29 = columnIndex20;
                long j16 = i29 == -1 ? 0L : cursorQuery.getLong(i29);
                int i30 = columnIndex21;
                long j17 = i30 != -1 ? cursorQuery.getLong(i30) : 0L;
                int i31 = columnIndex22;
                if (i31 == -1) {
                    setByteArrayToSetOfTriggers = null;
                } else {
                    setByteArrayToSetOfTriggers = WorkTypeConverters.byteArrayToSetOfTriggers(cursorQuery.isNull(i31) ? null : cursorQuery.getBlob(i31));
                }
                Constraints constraints = new Constraints(networkTypeIntToNetworkType, z10, z11, z12, z14, j16, j17, setByteArrayToSetOfTriggers);
                ArrayList<String> arrayList2 = map.get(cursorQuery.getString(columnIndex));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                }
                ArrayList<String> arrayList3 = arrayList2;
                ArrayList<Data> arrayList4 = map2.get(cursorQuery.getString(columnIndex));
                if (arrayList4 == null) {
                    arrayList4 = new ArrayList<>();
                }
                arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateIntToState, dataFromByteArray, j11, j12, j13, constraints, i16, backoffPolicyIntToBackoffPolicy, j14, j10, i17, i20, j15, i23, arrayList3, arrayList4));
                i14 = i19;
                i15 = i18;
                i12 = i21;
                columnIndex14 = i22;
                columnIndex15 = i24;
                columnIndex16 = i25;
                columnIndex17 = i26;
                columnIndex18 = i27;
                columnIndex19 = i28;
                columnIndex20 = i29;
                columnIndex21 = i30;
                columnIndex22 = i31;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public h<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosFlow(final SupportSQLiteQuery supportSQLiteQuery) {
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, new Callable<List<WorkSpec.WorkInfoPojo>>() { // from class: androidx.work.impl.model.RawWorkInfoDao_Impl.2
            @Override // java.util.concurrent.Callable
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                Data dataFromByteArray;
                long j10;
                int i10;
                boolean z10;
                boolean z11;
                boolean z12;
                Set<Constraints.ContentUriTrigger> setByteArrayToSetOfTriggers;
                int i11;
                Cursor cursorQuery = DBUtil.query(RawWorkInfoDao_Impl.this.__db, supportSQLiteQuery, true, null);
                try {
                    int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "id");
                    int columnIndex2 = CursorUtil.getColumnIndex(cursorQuery, "state");
                    int columnIndex3 = CursorUtil.getColumnIndex(cursorQuery, "output");
                    int columnIndex4 = CursorUtil.getColumnIndex(cursorQuery, "initial_delay");
                    int columnIndex5 = CursorUtil.getColumnIndex(cursorQuery, "interval_duration");
                    int columnIndex6 = CursorUtil.getColumnIndex(cursorQuery, "flex_duration");
                    int columnIndex7 = CursorUtil.getColumnIndex(cursorQuery, "run_attempt_count");
                    int columnIndex8 = CursorUtil.getColumnIndex(cursorQuery, "backoff_policy");
                    int columnIndex9 = CursorUtil.getColumnIndex(cursorQuery, "backoff_delay_duration");
                    int columnIndex10 = CursorUtil.getColumnIndex(cursorQuery, "last_enqueue_time");
                    int columnIndex11 = CursorUtil.getColumnIndex(cursorQuery, "period_count");
                    int columnIndex12 = CursorUtil.getColumnIndex(cursorQuery, "generation");
                    int columnIndex13 = CursorUtil.getColumnIndex(cursorQuery, "next_schedule_time_override");
                    int columnIndex14 = CursorUtil.getColumnIndex(cursorQuery, DownloadService.KEY_STOP_REASON);
                    int columnIndex15 = CursorUtil.getColumnIndex(cursorQuery, "required_network_type");
                    int columnIndex16 = CursorUtil.getColumnIndex(cursorQuery, "requires_charging");
                    int columnIndex17 = CursorUtil.getColumnIndex(cursorQuery, "requires_device_idle");
                    int columnIndex18 = CursorUtil.getColumnIndex(cursorQuery, "requires_battery_not_low");
                    int columnIndex19 = CursorUtil.getColumnIndex(cursorQuery, "requires_storage_not_low");
                    int columnIndex20 = CursorUtil.getColumnIndex(cursorQuery, "trigger_content_update_delay");
                    int columnIndex21 = CursorUtil.getColumnIndex(cursorQuery, "trigger_max_content_delay");
                    int columnIndex22 = CursorUtil.getColumnIndex(cursorQuery, "content_uri_triggers");
                    HashMap map = new HashMap();
                    int i12 = columnIndex13;
                    HashMap map2 = new HashMap();
                    while (cursorQuery.moveToNext()) {
                        int i13 = columnIndex12;
                        String string = cursorQuery.getString(columnIndex);
                        if (((ArrayList) map.get(string)) == null) {
                            i11 = columnIndex11;
                            map.put(string, new ArrayList());
                        } else {
                            i11 = columnIndex11;
                        }
                        String string2 = cursorQuery.getString(columnIndex);
                        if (((ArrayList) map2.get(string2)) == null) {
                            map2.put(string2, new ArrayList());
                        }
                        columnIndex12 = i13;
                        columnIndex11 = i11;
                    }
                    int i14 = columnIndex11;
                    int i15 = columnIndex12;
                    cursorQuery.moveToPosition(-1);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(map);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(map2);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string3 = (columnIndex == -1 || cursorQuery.isNull(columnIndex)) ? null : cursorQuery.getString(columnIndex);
                        WorkInfo.State stateIntToState = columnIndex2 == -1 ? null : WorkTypeConverters.intToState(cursorQuery.getInt(columnIndex2));
                        if (columnIndex3 == -1) {
                            dataFromByteArray = null;
                        } else {
                            dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndex3) ? null : cursorQuery.getBlob(columnIndex3));
                        }
                        long j11 = columnIndex4 == -1 ? 0L : cursorQuery.getLong(columnIndex4);
                        long j12 = columnIndex5 == -1 ? 0L : cursorQuery.getLong(columnIndex5);
                        long j13 = columnIndex6 == -1 ? 0L : cursorQuery.getLong(columnIndex6);
                        boolean z13 = false;
                        int i16 = columnIndex7 == -1 ? 0 : cursorQuery.getInt(columnIndex7);
                        BackoffPolicy backoffPolicyIntToBackoffPolicy = columnIndex8 == -1 ? null : WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndex8));
                        long j14 = columnIndex9 == -1 ? 0L : cursorQuery.getLong(columnIndex9);
                        if (columnIndex10 == -1) {
                            i10 = i14;
                            j10 = 0;
                        } else {
                            j10 = cursorQuery.getLong(columnIndex10);
                            i10 = i14;
                        }
                        int i17 = i10 == -1 ? 0 : cursorQuery.getInt(i10);
                        int i18 = i15;
                        int i19 = i10;
                        int i20 = i18 == -1 ? 0 : cursorQuery.getInt(i18);
                        int i21 = i12;
                        long j15 = i21 == -1 ? 0L : cursorQuery.getLong(i21);
                        int i22 = columnIndex14;
                        int i23 = i22 == -1 ? 0 : cursorQuery.getInt(i22);
                        int i24 = columnIndex15;
                        NetworkType networkTypeIntToNetworkType = i24 == -1 ? null : WorkTypeConverters.intToNetworkType(cursorQuery.getInt(i24));
                        int i25 = columnIndex16;
                        if (i25 == -1) {
                            z10 = false;
                        } else {
                            z10 = cursorQuery.getInt(i25) != 0;
                        }
                        int i26 = columnIndex17;
                        if (i26 == -1) {
                            z11 = false;
                        } else {
                            z11 = cursorQuery.getInt(i26) != 0;
                        }
                        int i27 = columnIndex18;
                        if (i27 == -1) {
                            z12 = false;
                        } else {
                            z12 = cursorQuery.getInt(i27) != 0;
                        }
                        int i28 = columnIndex19;
                        if (i28 != -1 && cursorQuery.getInt(i28) != 0) {
                            z13 = true;
                        }
                        boolean z14 = z13;
                        int i29 = columnIndex20;
                        long j16 = i29 == -1 ? 0L : cursorQuery.getLong(i29);
                        int i30 = columnIndex21;
                        long j17 = i30 != -1 ? cursorQuery.getLong(i30) : 0L;
                        int i31 = columnIndex22;
                        if (i31 == -1) {
                            setByteArrayToSetOfTriggers = null;
                        } else {
                            setByteArrayToSetOfTriggers = WorkTypeConverters.byteArrayToSetOfTriggers(cursorQuery.isNull(i31) ? null : cursorQuery.getBlob(i31));
                        }
                        Constraints constraints = new Constraints(networkTypeIntToNetworkType, z10, z11, z12, z14, j16, j17, setByteArrayToSetOfTriggers);
                        ArrayList arrayList2 = (ArrayList) map.get(cursorQuery.getString(columnIndex));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = arrayList2;
                        ArrayList arrayList4 = (ArrayList) map2.get(cursorQuery.getString(columnIndex));
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateIntToState, dataFromByteArray, j11, j12, j13, constraints, i16, backoffPolicyIntToBackoffPolicy, j14, j10, i17, i20, j15, i23, arrayList3, arrayList4));
                        i14 = i19;
                        i15 = i18;
                        i12 = i21;
                        columnIndex14 = i22;
                        columnIndex15 = i24;
                        columnIndex16 = i25;
                        columnIndex17 = i26;
                        columnIndex18 = i27;
                        columnIndex19 = i28;
                        columnIndex20 = i29;
                        columnIndex21 = i30;
                        columnIndex22 = i31;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(final SupportSQLiteQuery supportSQLiteQuery) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, new Callable<List<WorkSpec.WorkInfoPojo>>() { // from class: androidx.work.impl.model.RawWorkInfoDao_Impl.1
            @Override // java.util.concurrent.Callable
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                Data dataFromByteArray;
                long j10;
                int i10;
                boolean z10;
                boolean z11;
                boolean z12;
                Set<Constraints.ContentUriTrigger> setByteArrayToSetOfTriggers;
                int i11;
                Cursor cursorQuery = DBUtil.query(RawWorkInfoDao_Impl.this.__db, supportSQLiteQuery, true, null);
                try {
                    int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "id");
                    int columnIndex2 = CursorUtil.getColumnIndex(cursorQuery, "state");
                    int columnIndex3 = CursorUtil.getColumnIndex(cursorQuery, "output");
                    int columnIndex4 = CursorUtil.getColumnIndex(cursorQuery, "initial_delay");
                    int columnIndex5 = CursorUtil.getColumnIndex(cursorQuery, "interval_duration");
                    int columnIndex6 = CursorUtil.getColumnIndex(cursorQuery, "flex_duration");
                    int columnIndex7 = CursorUtil.getColumnIndex(cursorQuery, "run_attempt_count");
                    int columnIndex8 = CursorUtil.getColumnIndex(cursorQuery, "backoff_policy");
                    int columnIndex9 = CursorUtil.getColumnIndex(cursorQuery, "backoff_delay_duration");
                    int columnIndex10 = CursorUtil.getColumnIndex(cursorQuery, "last_enqueue_time");
                    int columnIndex11 = CursorUtil.getColumnIndex(cursorQuery, "period_count");
                    int columnIndex12 = CursorUtil.getColumnIndex(cursorQuery, "generation");
                    int columnIndex13 = CursorUtil.getColumnIndex(cursorQuery, "next_schedule_time_override");
                    int columnIndex14 = CursorUtil.getColumnIndex(cursorQuery, DownloadService.KEY_STOP_REASON);
                    int columnIndex15 = CursorUtil.getColumnIndex(cursorQuery, "required_network_type");
                    int columnIndex16 = CursorUtil.getColumnIndex(cursorQuery, "requires_charging");
                    int columnIndex17 = CursorUtil.getColumnIndex(cursorQuery, "requires_device_idle");
                    int columnIndex18 = CursorUtil.getColumnIndex(cursorQuery, "requires_battery_not_low");
                    int columnIndex19 = CursorUtil.getColumnIndex(cursorQuery, "requires_storage_not_low");
                    int columnIndex20 = CursorUtil.getColumnIndex(cursorQuery, "trigger_content_update_delay");
                    int columnIndex21 = CursorUtil.getColumnIndex(cursorQuery, "trigger_max_content_delay");
                    int columnIndex22 = CursorUtil.getColumnIndex(cursorQuery, "content_uri_triggers");
                    HashMap map = new HashMap();
                    int i12 = columnIndex13;
                    HashMap map2 = new HashMap();
                    while (cursorQuery.moveToNext()) {
                        int i13 = columnIndex12;
                        String string = cursorQuery.getString(columnIndex);
                        if (((ArrayList) map.get(string)) == null) {
                            i11 = columnIndex11;
                            map.put(string, new ArrayList());
                        } else {
                            i11 = columnIndex11;
                        }
                        String string2 = cursorQuery.getString(columnIndex);
                        if (((ArrayList) map2.get(string2)) == null) {
                            map2.put(string2, new ArrayList());
                        }
                        columnIndex12 = i13;
                        columnIndex11 = i11;
                    }
                    int i14 = columnIndex11;
                    int i15 = columnIndex12;
                    cursorQuery.moveToPosition(-1);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(map);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(map2);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string3 = (columnIndex == -1 || cursorQuery.isNull(columnIndex)) ? null : cursorQuery.getString(columnIndex);
                        WorkInfo.State stateIntToState = columnIndex2 == -1 ? null : WorkTypeConverters.intToState(cursorQuery.getInt(columnIndex2));
                        if (columnIndex3 == -1) {
                            dataFromByteArray = null;
                        } else {
                            dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndex3) ? null : cursorQuery.getBlob(columnIndex3));
                        }
                        long j11 = columnIndex4 == -1 ? 0L : cursorQuery.getLong(columnIndex4);
                        long j12 = columnIndex5 == -1 ? 0L : cursorQuery.getLong(columnIndex5);
                        long j13 = columnIndex6 == -1 ? 0L : cursorQuery.getLong(columnIndex6);
                        boolean z13 = false;
                        int i16 = columnIndex7 == -1 ? 0 : cursorQuery.getInt(columnIndex7);
                        BackoffPolicy backoffPolicyIntToBackoffPolicy = columnIndex8 == -1 ? null : WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndex8));
                        long j14 = columnIndex9 == -1 ? 0L : cursorQuery.getLong(columnIndex9);
                        if (columnIndex10 == -1) {
                            i10 = i14;
                            j10 = 0;
                        } else {
                            j10 = cursorQuery.getLong(columnIndex10);
                            i10 = i14;
                        }
                        int i17 = i10 == -1 ? 0 : cursorQuery.getInt(i10);
                        int i18 = i15;
                        int i19 = i10;
                        int i20 = i18 == -1 ? 0 : cursorQuery.getInt(i18);
                        int i21 = i12;
                        long j15 = i21 == -1 ? 0L : cursorQuery.getLong(i21);
                        int i22 = columnIndex14;
                        int i23 = i22 == -1 ? 0 : cursorQuery.getInt(i22);
                        int i24 = columnIndex15;
                        NetworkType networkTypeIntToNetworkType = i24 == -1 ? null : WorkTypeConverters.intToNetworkType(cursorQuery.getInt(i24));
                        int i25 = columnIndex16;
                        if (i25 == -1) {
                            z10 = false;
                        } else {
                            z10 = cursorQuery.getInt(i25) != 0;
                        }
                        int i26 = columnIndex17;
                        if (i26 == -1) {
                            z11 = false;
                        } else {
                            z11 = cursorQuery.getInt(i26) != 0;
                        }
                        int i27 = columnIndex18;
                        if (i27 == -1) {
                            z12 = false;
                        } else {
                            z12 = cursorQuery.getInt(i27) != 0;
                        }
                        int i28 = columnIndex19;
                        if (i28 != -1 && cursorQuery.getInt(i28) != 0) {
                            z13 = true;
                        }
                        boolean z14 = z13;
                        int i29 = columnIndex20;
                        long j16 = i29 == -1 ? 0L : cursorQuery.getLong(i29);
                        int i30 = columnIndex21;
                        long j17 = i30 != -1 ? cursorQuery.getLong(i30) : 0L;
                        int i31 = columnIndex22;
                        if (i31 == -1) {
                            setByteArrayToSetOfTriggers = null;
                        } else {
                            setByteArrayToSetOfTriggers = WorkTypeConverters.byteArrayToSetOfTriggers(cursorQuery.isNull(i31) ? null : cursorQuery.getBlob(i31));
                        }
                        Constraints constraints = new Constraints(networkTypeIntToNetworkType, z10, z11, z12, z14, j16, j17, setByteArrayToSetOfTriggers);
                        ArrayList arrayList2 = (ArrayList) map.get(cursorQuery.getString(columnIndex));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = arrayList2;
                        ArrayList arrayList4 = (ArrayList) map2.get(cursorQuery.getString(columnIndex));
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateIntToState, dataFromByteArray, j11, j12, j13, constraints, i16, backoffPolicyIntToBackoffPolicy, j14, j10, i17, i20, j15, i23, arrayList3, arrayList4));
                        i14 = i19;
                        i15 = i18;
                        i12 = i21;
                        columnIndex14 = i22;
                        columnIndex15 = i24;
                        columnIndex16 = i25;
                        columnIndex17 = i26;
                        columnIndex18 = i27;
                        columnIndex19 = i28;
                        columnIndex20 = i29;
                        columnIndex21 = i30;
                        columnIndex22 = i31;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }
}
