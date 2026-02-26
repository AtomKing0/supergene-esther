package io.sentry.internal.modules;

import io.sentry.w0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CompositeModulesLoader.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
@ApiStatus.Experimental
public final class a extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<b> f27925e;

    public a(@NotNull List<b> list, @NotNull w0 w0Var) {
        super(w0Var);
        this.f27925e = list;
    }

    @Override // io.sentry.internal.modules.d
    protected Map<String, String> b() {
        TreeMap treeMap = new TreeMap();
        Iterator<b> it = this.f27925e.iterator();
        while (it.hasNext()) {
            Map<String, String> mapA = it.next().a();
            if (mapA != null) {
                treeMap.putAll(mapA);
            }
        }
        return treeMap;
    }
}
