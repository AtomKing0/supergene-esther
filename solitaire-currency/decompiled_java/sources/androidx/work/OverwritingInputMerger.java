package androidx.work;

import androidx.work.Data;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OverwritingInputMerger.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverwritingInputMerger extends InputMerger {
    @Override // androidx.work.InputMerger
    @NotNull
    public Data merge(@NotNull List<Data> inputs) throws Throwable {
        t.i(inputs, "inputs");
        Data.Builder builder = new Data.Builder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Data> it = inputs.iterator();
        while (it.hasNext()) {
            Map<String, Object> keyValueMap = it.next().getKeyValueMap();
            t.h(keyValueMap, "input.keyValueMap");
            linkedHashMap.putAll(keyValueMap);
        }
        builder.putAll(linkedHashMap);
        Data dataBuild = builder.build();
        t.h(dataBuild, "output.build()");
        return dataBuild;
    }
}
