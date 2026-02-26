package androidx.work.impl.model;

import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WorkTagDao.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c {
    public static void a(WorkTagDao workTagDao, @NotNull String id, @NotNull Set tags) {
        t.i(id, "id");
        t.i(tags, "tags");
        Iterator it = tags.iterator();
        while (it.hasNext()) {
            workTagDao.insert(new WorkTag((String) it.next(), id));
        }
    }
}
