package l5;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: DependencyCycleException.java */
/* JADX INFO: loaded from: classes3.dex */
public class s extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<c<?>> f30891a;

    public s(List<c<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f30891a = list;
    }
}
