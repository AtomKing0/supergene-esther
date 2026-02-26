package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public final class CollectionUtils {
    private CollectionUtils() {
    }

    @KeepForSdk
    public static boolean isEmpty(@Nullable Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf() {
        return Collections.emptyList();
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(@NonNull K k10, @NonNull V v10, @NonNull K k11, @NonNull V v11, @NonNull K k12, @NonNull V v12) {
        Map mapZza = zza(3, false);
        mapZza.put(k10, v10);
        mapZza.put(k11, v11);
        mapZza.put(k12, v12);
        return Collections.unmodifiableMap(mapZza);
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOfKeyValueArrays(@NonNull K[] kArr, @NonNull V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length != length2) {
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + length2);
        }
        if (length == 0) {
            return Collections.emptyMap();
        }
        if (length == 1) {
            return Collections.singletonMap(kArr[0], vArr[0]);
        }
        Map mapZza = zza(length, false);
        for (int i10 = 0; i10 < kArr.length; i10++) {
            mapZza.put(kArr[i10], vArr[i10]);
        }
        return Collections.unmodifiableMap(mapZza);
    }

    @NonNull
    @KeepForSdk
    public static <T> Set<T> mutableSetOfWithSize(int i10) {
        return i10 == 0 ? new ArraySet() : zzb(i10, true);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(@NonNull T t10, @NonNull T t11, @NonNull T t12) {
        Set setZzb = zzb(3, false);
        setZzb.add(t10);
        setZzb.add(t11);
        setZzb.add(t12);
        return Collections.unmodifiableSet(setZzb);
    }

    private static Map zza(int i10, boolean z10) {
        return i10 <= 256 ? new ArrayMap(i10) : new HashMap(i10, 1.0f);
    }

    private static Set zzb(int i10, boolean z10) {
        if (i10 <= (true != z10 ? 256 : 128)) {
            return new ArraySet(i10);
        }
        return new HashSet(i10, true != z10 ? 1.0f : 0.75f);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(@NonNull T t10) {
        return Collections.singletonList(t10);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(@NonNull T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptyList();
        }
        if (length != 1) {
            return Collections.unmodifiableList(Arrays.asList(tArr));
        }
        return Collections.singletonList(tArr[0]);
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(@NonNull K k10, @NonNull V v10, @NonNull K k11, @NonNull V v11, @NonNull K k12, @NonNull V v12, @NonNull K k13, @NonNull V v13, @NonNull K k14, @NonNull V v14, @NonNull K k15, @NonNull V v15) {
        Map mapZza = zza(6, false);
        mapZza.put(k10, v10);
        mapZza.put(k11, v11);
        mapZza.put(k12, v12);
        mapZza.put(k13, v13);
        mapZza.put(k14, v14);
        mapZza.put(k15, v15);
        return Collections.unmodifiableMap(mapZza);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(@NonNull T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t10 = tArr[0];
            T t11 = tArr[1];
            Set setZzb = zzb(2, false);
            setZzb.add(t10);
            setZzb.add(t11);
            return Collections.unmodifiableSet(setZzb);
        }
        if (length == 3) {
            return setOf(tArr[0], tArr[1], tArr[2]);
        }
        if (length != 4) {
            Set setZzb2 = zzb(length, false);
            Collections.addAll(setZzb2, tArr);
            return Collections.unmodifiableSet(setZzb2);
        }
        T t12 = tArr[0];
        T t13 = tArr[1];
        T t14 = tArr[2];
        T t15 = tArr[3];
        Set setZzb3 = zzb(4, false);
        setZzb3.add(t12);
        setZzb3.add(t13);
        setZzb3.add(t14);
        setZzb3.add(t15);
        return Collections.unmodifiableSet(setZzb3);
    }
}
