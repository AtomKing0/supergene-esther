package com.moloco.sdk.acm.db;

import androidx.room.TypeConverter;
import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.r;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    @TypeConverter
    @NotNull
    public final c a(@NotNull String eventType) {
        t.i(eventType, "eventType");
        return c.valueOf(eventType);
    }

    @TypeConverter
    @NotNull
    public final String b(@NotNull c eventType) {
        t.i(eventType, "eventType");
        return eventType.name();
    }

    @TypeConverter
    @NotNull
    public final String c(@NotNull List<String> tags) {
        t.i(tags, "tags");
        return d0.r0(tags, ",", null, null, 0, null, null, 62, null);
    }

    @TypeConverter
    @NotNull
    public final List<String> d(@NotNull String tagsString) {
        t.i(tagsString, "tagsString");
        return tagsString.length() == 0 ? v.l() : r.C0(tagsString, new String[]{","}, false, 0, 6, null);
    }
}
