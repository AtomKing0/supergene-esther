package androidx.work.impl.model;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SystemIdInfoDao.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a {
    @Nullable
    public static SystemIdInfo a(SystemIdInfoDao systemIdInfoDao, @NotNull WorkGenerationalId id) {
        t.i(id, "id");
        return systemIdInfoDao.getSystemIdInfo(id.getWorkSpecId(), id.getGeneration());
    }

    public static void b(SystemIdInfoDao systemIdInfoDao, @NotNull WorkGenerationalId id) {
        t.i(id, "id");
        systemIdInfoDao.removeSystemIdInfo(id.getWorkSpecId(), id.getGeneration());
    }
}
