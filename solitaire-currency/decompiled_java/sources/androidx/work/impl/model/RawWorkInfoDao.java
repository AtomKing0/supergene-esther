package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.impl.model.WorkSpec;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import s9.h;

/* JADX INFO: compiled from: RawWorkInfoDao.kt */
/* JADX INFO: loaded from: classes2.dex */
@Dao
public interface RawWorkInfoDao {
    @RawQuery(observedEntities = {WorkSpec.class})
    @NotNull
    List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(@NotNull SupportSQLiteQuery supportSQLiteQuery);

    @RawQuery(observedEntities = {WorkSpec.class})
    @NotNull
    h<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosFlow(@NotNull SupportSQLiteQuery supportSQLiteQuery);

    @RawQuery(observedEntities = {WorkSpec.class})
    @NotNull
    LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(@NotNull SupportSQLiteQuery supportSQLiteQuery);
}
