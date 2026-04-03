package androidx.work;

import androidx.work.Data;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.s;

/* JADX INFO: compiled from: Data.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DataKt {
    public static final /* synthetic */ <T> boolean hasKeyWithValueOfType(Data data, String key) {
        t.i(data, "<this>");
        t.i(key, "key");
        t.o(4, "T");
        return data.hasKeyWithValueOfType(key, Object.class);
    }

    @NotNull
    public static final Data workDataOf(@NotNull s<String, ? extends Object>... pairs) throws Throwable {
        t.i(pairs, "pairs");
        Data.Builder builder = new Data.Builder();
        for (s<String, ? extends Object> sVar : pairs) {
            builder.put(sVar.c(), sVar.d());
        }
        Data dataBuild = builder.build();
        t.h(dataBuild, "dataBuilder.build()");
        return dataBuild;
    }
}
