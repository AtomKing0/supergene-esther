package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StartStopToken.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StartStopTokens {

    @NotNull
    private final Object lock = new Object();

    @NotNull
    private final Map<WorkGenerationalId, StartStopToken> runs = new LinkedHashMap();

    public final boolean contains(@NotNull WorkGenerationalId id) {
        boolean zContainsKey;
        t.i(id, "id");
        synchronized (this.lock) {
            zContainsKey = this.runs.containsKey(id);
        }
        return zContainsKey;
    }

    @Nullable
    public final StartStopToken remove(@NotNull WorkGenerationalId id) {
        StartStopToken startStopTokenRemove;
        t.i(id, "id");
        synchronized (this.lock) {
            startStopTokenRemove = this.runs.remove(id);
        }
        return startStopTokenRemove;
    }

    @NotNull
    public final StartStopToken tokenFor(@NotNull WorkGenerationalId id) {
        StartStopToken startStopToken;
        t.i(id, "id");
        synchronized (this.lock) {
            Map<WorkGenerationalId, StartStopToken> map = this.runs;
            StartStopToken startStopToken2 = map.get(id);
            if (startStopToken2 == null) {
                startStopToken2 = new StartStopToken(id);
                map.put(id, startStopToken2);
            }
            startStopToken = startStopToken2;
        }
        return startStopToken;
    }

    @NotNull
    public final List<StartStopToken> remove(@NotNull String workSpecId) {
        List<StartStopToken> listP0;
        t.i(workSpecId, "workSpecId");
        synchronized (this.lock) {
            Map<WorkGenerationalId, StartStopToken> map = this.runs;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<WorkGenerationalId, StartStopToken> entry : map.entrySet()) {
                if (t.d(entry.getKey().getWorkSpecId(), workSpecId)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Iterator it = linkedHashMap.keySet().iterator();
            while (it.hasNext()) {
                this.runs.remove((WorkGenerationalId) it.next());
            }
            listP0 = d0.P0(linkedHashMap.values());
        }
        return listP0;
    }

    @NotNull
    public final StartStopToken tokenFor(@NotNull WorkSpec spec) {
        t.i(spec, "spec");
        return tokenFor(WorkSpecKt.generationalId(spec));
    }

    @Nullable
    public final StartStopToken remove(@NotNull WorkSpec spec) {
        t.i(spec, "spec");
        return remove(WorkSpecKt.generationalId(spec));
    }
}
