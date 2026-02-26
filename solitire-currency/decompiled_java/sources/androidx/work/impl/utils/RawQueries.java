package androidx.work.impl.utils;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.collections.d0;
import kotlin.collections.w;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RawQueries.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RawQueries {
    private static final void bindings(StringBuilder sb, int i10) {
        if (i10 <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add("?");
        }
        sb.append(d0.r0(arrayList, ",", null, null, 0, null, null, 62, null));
    }

    @NotNull
    public static final SupportSQLiteQuery toRawQuery(@NotNull WorkQuery workQuery) {
        t.i(workQuery, "<this>");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder("SELECT * FROM workspec");
        List<WorkInfo.State> states = workQuery.getStates();
        t.h(states, "states");
        String str = " AND";
        String str2 = " WHERE";
        if (!states.isEmpty()) {
            List<WorkInfo.State> states2 = workQuery.getStates();
            t.h(states2, "states");
            List<WorkInfo.State> list = states2;
            ArrayList arrayList2 = new ArrayList(w.v(list, 10));
            for (WorkInfo.State state : list) {
                t.f(state);
                arrayList2.add(Integer.valueOf(WorkTypeConverters.stateToInt(state)));
            }
            sb.append(" WHERE state IN (");
            bindings(sb, arrayList2.size());
            sb.append(")");
            arrayList.addAll(arrayList2);
            str2 = " AND";
        }
        List<UUID> ids = workQuery.getIds();
        t.h(ids, "ids");
        if (!ids.isEmpty()) {
            List<UUID> ids2 = workQuery.getIds();
            t.h(ids2, "ids");
            List<UUID> list2 = ids2;
            ArrayList arrayList3 = new ArrayList(w.v(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((UUID) it.next()).toString());
            }
            sb.append(str2 + " id IN (");
            bindings(sb, workQuery.getIds().size());
            sb.append(")");
            arrayList.addAll(arrayList3);
            str2 = " AND";
        }
        List<String> tags = workQuery.getTags();
        t.h(tags, "tags");
        if (!tags.isEmpty()) {
            sb.append(str2 + " id IN (SELECT work_spec_id FROM worktag WHERE tag IN (");
            bindings(sb, workQuery.getTags().size());
            sb.append("))");
            List<String> tags2 = workQuery.getTags();
            t.h(tags2, "tags");
            arrayList.addAll(tags2);
        } else {
            str = str2;
        }
        List<String> uniqueWorkNames = workQuery.getUniqueWorkNames();
        t.h(uniqueWorkNames, "uniqueWorkNames");
        if (!uniqueWorkNames.isEmpty()) {
            sb.append(str + " id IN (SELECT work_spec_id FROM workname WHERE name IN (");
            bindings(sb, workQuery.getUniqueWorkNames().size());
            sb.append("))");
            List<String> uniqueWorkNames2 = workQuery.getUniqueWorkNames();
            t.h(uniqueWorkNames2, "uniqueWorkNames");
            arrayList.addAll(uniqueWorkNames2);
        }
        sb.append(";");
        String string = sb.toString();
        t.h(string, "builder.toString()");
        return new SimpleSQLiteQuery(string, arrayList.toArray(new Object[0]));
    }
}
