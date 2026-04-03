package da;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CollectionSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class q1<ElementKlass, Element extends ElementKlass> extends r<Element, Element[], ArrayList<Element>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final KClass<ElementKlass> f24614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final SerialDescriptor f24615c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q1(@NotNull KClass<ElementKlass> kClass, @NotNull KSerializer<Element> eSerializer) {
        super(eSerializer, null);
        kotlin.jvm.internal.t.i(kClass, "kClass");
        kotlin.jvm.internal.t.i(eSerializer, "eSerializer");
        this.f24614b = kClass;
        this.f24615c = new d(eSerializer.getDescriptor());
    }

    @Override // da.r, kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.f24615c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public ArrayList<Element> a() {
        return new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public int b(@NotNull ArrayList<Element> arrayList) {
        kotlin.jvm.internal.t.i(arrayList, "<this>");
        return arrayList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull ArrayList<Element> arrayList, int i10) {
        kotlin.jvm.internal.t.i(arrayList, "<this>");
        arrayList.ensureCapacity(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Iterator<Element> d(@NotNull Element[] elementArr) {
        kotlin.jvm.internal.t.i(elementArr, "<this>");
        return kotlin.jvm.internal.c.a(elementArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public int e(@NotNull Element[] elementArr) {
        kotlin.jvm.internal.t.i(elementArr, "<this>");
        return elementArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.r
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public void n(@NotNull ArrayList<Element> arrayList, int i10, Element element) {
        kotlin.jvm.internal.t.i(arrayList, "<this>");
        arrayList.add(i10, element);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public ArrayList<Element> k(@NotNull Element[] elementArr) {
        kotlin.jvm.internal.t.i(elementArr, "<this>");
        return new ArrayList<>(kotlin.collections.o.c(elementArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public Element[] l(@NotNull ArrayList<Element> arrayList) {
        kotlin.jvm.internal.t.i(arrayList, "<this>");
        return (Element[]) g1.n(arrayList, this.f24614b);
    }
}
