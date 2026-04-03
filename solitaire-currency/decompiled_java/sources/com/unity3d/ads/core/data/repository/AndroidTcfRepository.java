package com.unity3d.ads.core.data.repository;

import com.unity3d.ads.core.data.datasource.TcfDataSource;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidTcfRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidTcfRepository implements TcfRepository {

    @NotNull
    private final TcfDataSource tcfDataSource;

    public AndroidTcfRepository(@NotNull TcfDataSource tcfDataSource) {
        t.i(tcfDataSource, "tcfDataSource");
        this.tcfDataSource = tcfDataSource;
    }

    @NotNull
    public final TcfDataSource getTcfDataSource() {
        return this.tcfDataSource;
    }

    @Override // com.unity3d.ads.core.data.repository.TcfRepository
    @Nullable
    public String getTcfString() {
        return this.tcfDataSource.getTcfString();
    }
}
