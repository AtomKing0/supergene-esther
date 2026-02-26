package com.unity3d.ads.core.configuration;

import com.unity3d.services.core.misc.JsonStorage;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

/* JADX INFO: compiled from: MetadataReader.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class MetadataReader<T> {

    @NotNull
    private final JsonStorage jsonStorage;

    @NotNull
    private final String key;

    public MetadataReader(@NotNull JsonStorage jsonStorage, @NotNull String key) {
        t.i(jsonStorage, "jsonStorage");
        t.i(key, "key");
        this.jsonStorage = jsonStorage;
        this.key = key;
    }

    @NotNull
    public final JsonStorage getJsonStorage() {
        return this.jsonStorage;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public final /* synthetic */ <T> T read(T t10) {
        T t11 = (T) getJsonStorage().get(getKey());
        if (t11 == null) {
            return t10;
        }
        t.o(3, "T");
        return t11;
    }

    public final /* synthetic */ <T> T readAndDelete(T t10) throws JSONException {
        Object obj = getJsonStorage().get(getKey());
        if (obj != null) {
            t.h(obj, "get(key)");
            t.o(3, "T");
            t10 = (T) obj;
        }
        Object obj2 = getJsonStorage().get(getKey());
        if (obj2 != null) {
            t.h(obj2, "get(key)");
            getJsonStorage().delete(getKey());
        }
        return t10;
    }
}
