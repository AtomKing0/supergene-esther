package com.unity3d.ads.core.data.datasource;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StoreDataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface StoreDataSource {
    @NotNull
    List<String> fetchStores(@NotNull List<String> list);
}
