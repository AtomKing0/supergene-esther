package androidx.datastore.migrations;

import android.content.SharedPreferences;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.collections.q0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SharedPreferencesMigration.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SharedPreferencesView {

    @Nullable
    private final Set<String> keySet;

    @NotNull
    private final SharedPreferences prefs;

    public SharedPreferencesView(@NotNull SharedPreferences prefs, @Nullable Set<String> set) {
        t.i(prefs, "prefs");
        this.prefs = prefs;
        this.keySet = set;
    }

    private final String checkKey(String str) {
        Set<String> set = this.keySet;
        if (set == null || set.contains(str)) {
            return str;
        }
        throw new IllegalStateException(t.r("Can't access key outside migration: ", str).toString());
    }

    public static /* synthetic */ String getString$default(SharedPreferencesView sharedPreferencesView, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return sharedPreferencesView.getString(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Set getStringSet$default(SharedPreferencesView sharedPreferencesView, String str, Set set, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            set = null;
        }
        return sharedPreferencesView.getStringSet(str, set);
    }

    public final boolean contains(@NotNull String key) {
        t.i(key, "key");
        return this.prefs.contains(checkKey(key));
    }

    @NotNull
    public final Map<String, Object> getAll() {
        Map<String, ?> all = this.prefs.getAll();
        t.h(all, "prefs.all");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Set<String> set = this.keySet;
            if (set == null ? true : set.contains(key)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(q0.d(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key2 = entry2.getKey();
            Object value = entry2.getValue();
            if (value instanceof Set) {
                value = d0.T0((Iterable) value);
            }
            linkedHashMap2.put(key2, value);
        }
        return linkedHashMap2;
    }

    public final boolean getBoolean(@NotNull String key, boolean z10) {
        t.i(key, "key");
        return this.prefs.getBoolean(checkKey(key), z10);
    }

    public final float getFloat(@NotNull String key, float f10) {
        t.i(key, "key");
        return this.prefs.getFloat(checkKey(key), f10);
    }

    public final int getInt(@NotNull String key, int i10) {
        t.i(key, "key");
        return this.prefs.getInt(checkKey(key), i10);
    }

    public final long getLong(@NotNull String key, long j10) {
        t.i(key, "key");
        return this.prefs.getLong(checkKey(key), j10);
    }

    @Nullable
    public final String getString(@NotNull String key, @Nullable String str) {
        t.i(key, "key");
        return this.prefs.getString(checkKey(key), str);
    }

    @Nullable
    public final Set<String> getStringSet(@NotNull String key, @Nullable Set<String> set) {
        t.i(key, "key");
        Set<String> stringSet = this.prefs.getStringSet(checkKey(key), set);
        if (stringSet == null) {
            return null;
        }
        return d0.S0(stringSet);
    }
}
