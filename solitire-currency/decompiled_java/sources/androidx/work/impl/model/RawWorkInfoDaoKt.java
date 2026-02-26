package androidx.work.impl.model;

import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.WorkInfo;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k0;
import org.jetbrains.annotations.NotNull;
import s9.h;

/* JADX INFO: compiled from: RawWorkInfoDao.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RawWorkInfoDaoKt {
    @NotNull
    public static final h<List<WorkInfo>> getWorkInfoPojosFlow(@NotNull RawWorkInfoDao rawWorkInfoDao, @NotNull k0 dispatcher, @NotNull SupportSQLiteQuery query) {
        t.i(rawWorkInfoDao, "<this>");
        t.i(dispatcher, "dispatcher");
        t.i(query, "query");
        return WorkSpecDaoKt.dedup(rawWorkInfoDao.getWorkInfoPojosFlow(query), dispatcher);
    }
}
