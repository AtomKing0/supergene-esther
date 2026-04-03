package io.sentry.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EventProcessorUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public final class f {
    public static List<io.sentry.g0> a(@Nullable List<io.sentry.internal.eventprocessor.a> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<io.sentry.internal.eventprocessor.a> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().c());
            }
        }
        return new CopyOnWriteArrayList(arrayList);
    }
}
