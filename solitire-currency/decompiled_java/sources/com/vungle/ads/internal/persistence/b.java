package com.vungle.ads.internal.persistence;

import androidx.annotation.VisibleForTesting;
import com.vungle.ads.internal.util.d;
import com.vungle.ads.internal.util.i;
import com.vungle.ads.internal.util.q;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FilePreferences.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    @NotNull
    public static final String FILENAME = "settings_vungle";

    @NotNull
    public static final String TPAT_FAILED_FILENAME = "failedTpats";

    @NotNull
    private final File file;

    @NotNull
    private final Executor ioExecutor;

    @NotNull
    private final ConcurrentHashMap<String, Object> values;

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final ConcurrentHashMap<String, b> filePreferenceMap = new ConcurrentHashMap<>();

    public /* synthetic */ b(Executor executor, q qVar, String str, k kVar) {
        this(executor, qVar, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: apply$lambda-0, reason: not valid java name */
    public static final void m4070apply$lambda0(b this$0, Serializable serializable) {
        t.i(this$0, "this$0");
        t.i(serializable, "$serializable");
        i.writeSerializable(this$0.file, serializable);
    }

    @NotNull
    public static final synchronized b get(@NotNull Executor executor, @NotNull q qVar, @NotNull String str) {
        return Companion.get(executor, qVar, str);
    }

    public final void apply() {
        final HashMap map = new HashMap(this.values);
        this.ioExecutor.execute(new Runnable() { // from class: com.vungle.ads.internal.persistence.a
            @Override // java.lang.Runnable
            public final void run() {
                b.m4070apply$lambda0(this.f24363a, map);
            }
        });
    }

    public final boolean getBoolean(@NotNull String key, boolean z10) {
        t.i(key, "key");
        Object obj = this.values.get(key);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z10;
    }

    public final int getInt(@NotNull String key, int i10) {
        t.i(key, "key");
        Object obj = this.values.get(key);
        return obj instanceof Integer ? ((Number) obj).intValue() : i10;
    }

    public final long getLong(@NotNull String key, long j10) {
        t.i(key, "key");
        Object obj = this.values.get(key);
        return obj instanceof Long ? ((Number) obj).longValue() : j10;
    }

    @NotNull
    public final String getString(@NotNull String key, @NotNull String defaultValue) {
        t.i(key, "key");
        t.i(defaultValue, "defaultValue");
        Object obj = this.values.get(key);
        return obj instanceof String ? (String) obj : defaultValue;
    }

    @NotNull
    public final HashSet<String> getStringSet(@NotNull String key, @NotNull HashSet<String> defaultValue) {
        t.i(key, "key");
        t.i(defaultValue, "defaultValue");
        Object obj = this.values.get(key);
        return obj instanceof HashSet ? d.getNewHashSet((HashSet) obj) : defaultValue;
    }

    @NotNull
    public final b put(@NotNull String key, boolean z10) {
        t.i(key, "key");
        this.values.put(key, Boolean.valueOf(z10));
        return this;
    }

    @NotNull
    public final b remove(@NotNull String key) {
        t.i(key, "key");
        if (this.values.containsKey(key)) {
            this.values.remove(key);
        }
        return this;
    }

    private b(Executor executor, q qVar, String str) {
        this.ioExecutor = executor;
        File file = new File(qVar.getSharedPrefsDir(), str);
        this.file = file;
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        this.values = concurrentHashMap;
        Object serializable = i.readSerializable(file);
        if (serializable instanceof HashMap) {
            concurrentHashMap.putAll((HashMap) serializable);
        }
    }

    @NotNull
    public final b put(@NotNull String key, @NotNull String value) {
        t.i(key, "key");
        t.i(value, "value");
        this.values.put(key, value);
        return this;
    }

    @Nullable
    public final Boolean getBoolean(@NotNull String key) {
        t.i(key, "key");
        Object obj = this.values.get(key);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        return null;
    }

    @Nullable
    public final String getString(@NotNull String key) {
        t.i(key, "key");
        Object obj = this.values.get(key);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    @NotNull
    public final b put(@NotNull String key, int i10) {
        t.i(key, "key");
        this.values.put(key, Integer.valueOf(i10));
        return this;
    }

    @NotNull
    public final b put(@NotNull String key, @Nullable HashSet<String> hashSet) {
        t.i(key, "key");
        this.values.put(key, d.getNewHashSet(hashSet));
        return this;
    }

    @NotNull
    public final b put(@NotNull String key, long j10) {
        t.i(key, "key");
        this.values.put(key, Long.valueOf(j10));
        return this;
    }

    /* synthetic */ b(Executor executor, q qVar, String str, int i10, k kVar) {
        this(executor, qVar, (i10 & 4) != 0 ? FILENAME : str);
    }

    /* JADX INFO: compiled from: FilePreferences.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        public static /* synthetic */ b get$default(a aVar, Executor executor, q qVar, String str, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                str = b.FILENAME;
            }
            return aVar.get(executor, qVar, str);
        }

        @NotNull
        public final synchronized b get(@NotNull Executor ioExecutor, @NotNull q pathProvider, @NotNull String filename) {
            Object bVar;
            Object objPutIfAbsent;
            t.i(ioExecutor, "ioExecutor");
            t.i(pathProvider, "pathProvider");
            t.i(filename, "filename");
            ConcurrentHashMap concurrentHashMap = b.filePreferenceMap;
            bVar = concurrentHashMap.get(filename);
            if (bVar == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(filename, (bVar = new b(ioExecutor, pathProvider, filename, null)))) != null) {
                bVar = objPutIfAbsent;
            }
            t.h(bVar, "filePreferenceMap.getOrP…, filename)\n            }");
            return (b) bVar;
        }

        @VisibleForTesting
        public static /* synthetic */ void getFILENAME$annotations() {
        }
    }
}
