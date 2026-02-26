package com.unity3d.ads.core.data.repository;

import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.data.model.CachedFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: CacheRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface CacheRepository {

    /* JADX INFO: compiled from: CacheRepository.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getFile$default(CacheRepository cacheRepository, String str, String str2, JSONArray jSONArray, int i10, d dVar, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFile");
            }
            if ((i11 & 4) != 0) {
                jSONArray = null;
            }
            JSONArray jSONArray2 = jSONArray;
            if ((i11 & 8) != 0) {
                i10 = 0;
            }
            return cacheRepository.getFile(str, str2, jSONArray2, i10, dVar);
        }
    }

    @Nullable
    Object clearCache(@NotNull d<? super k0> dVar);

    @Nullable
    Object doesFileExist(@NotNull String str, @NotNull d<? super Boolean> dVar);

    @Nullable
    Object getCacheSize(@NotNull d<? super Long> dVar);

    @Nullable
    Object getFile(@NotNull String str, @NotNull String str2, @Nullable JSONArray jSONArray, int i10, @NotNull d<? super CacheResult> dVar);

    void removeFile(@NotNull CachedFile cachedFile);

    @NotNull
    CacheResult retrieveFile(@NotNull String str);
}
