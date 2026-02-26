package ba;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SerialDescriptors.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f2277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private List<? extends Annotation> f2278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<String> f2279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final Set<String> f2280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final List<SerialDescriptor> f2281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final List<List<Annotation>> f2282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final List<Boolean> f2283g;

    public a(@NotNull String serialName) {
        t.i(serialName, "serialName");
        this.f2277a = serialName;
        this.f2278b = v.l();
        this.f2279c = new ArrayList();
        this.f2280d = new HashSet();
        this.f2281e = new ArrayList();
        this.f2282f = new ArrayList();
        this.f2283g = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(a aVar, String str, SerialDescriptor serialDescriptor, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            list = v.l();
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        aVar.a(str, serialDescriptor, list, z10);
    }

    public final void a(@NotNull String elementName, @NotNull SerialDescriptor descriptor, @NotNull List<? extends Annotation> annotations, boolean z10) {
        t.i(elementName, "elementName");
        t.i(descriptor, "descriptor");
        t.i(annotations, "annotations");
        if (!this.f2280d.add(elementName)) {
            throw new IllegalArgumentException(("Element with name '" + elementName + "' is already registered").toString());
        }
        this.f2279c.add(elementName);
        this.f2281e.add(descriptor);
        this.f2282f.add(annotations);
        this.f2283g.add(Boolean.valueOf(z10));
    }

    @NotNull
    public final List<Annotation> c() {
        return this.f2278b;
    }

    @NotNull
    public final List<List<Annotation>> d() {
        return this.f2282f;
    }

    @NotNull
    public final List<SerialDescriptor> e() {
        return this.f2281e;
    }

    @NotNull
    public final List<String> f() {
        return this.f2279c;
    }

    @NotNull
    public final List<Boolean> g() {
        return this.f2283g;
    }

    public final void h(@NotNull List<? extends Annotation> list) {
        t.i(list, "<set-?>");
        this.f2278b = list;
    }
}
