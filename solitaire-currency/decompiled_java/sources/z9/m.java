package z9;

import da.f0;
import da.g1;
import da.h0;
import da.h1;
import da.p0;
import da.p1;
import da.r0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.w;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.s;
import v8.x;

/* JADX INFO: compiled from: Serializers.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class m {
    private static final KSerializer<? extends Object> a(KClass<Object> kClass, List<? extends KType> list, List<? extends KSerializer<Object>> list2) {
        if (t.d(kClass, o0.b(Collection.class)) ? true : t.d(kClass, o0.b(List.class)) ? true : t.d(kClass, o0.b(List.class)) ? true : t.d(kClass, o0.b(ArrayList.class))) {
            return new da.f(list2.get(0));
        }
        if (t.d(kClass, o0.b(HashSet.class))) {
            return new h0(list2.get(0));
        }
        if (t.d(kClass, o0.b(Set.class)) ? true : t.d(kClass, o0.b(Set.class)) ? true : t.d(kClass, o0.b(LinkedHashSet.class))) {
            return new r0(list2.get(0));
        }
        if (t.d(kClass, o0.b(HashMap.class))) {
            return new f0(list2.get(0), list2.get(1));
        }
        if (t.d(kClass, o0.b(Map.class)) ? true : t.d(kClass, o0.b(Map.class)) ? true : t.d(kClass, o0.b(LinkedHashMap.class))) {
            return new p0(list2.get(0), list2.get(1));
        }
        if (t.d(kClass, o0.b(Map.Entry.class))) {
            return aa.a.j(list2.get(0), list2.get(1));
        }
        if (t.d(kClass, o0.b(s.class))) {
            return aa.a.l(list2.get(0), list2.get(1));
        }
        if (t.d(kClass, o0.b(x.class))) {
            return aa.a.n(list2.get(0), list2.get(1), list2.get(2));
        }
        if (!g1.l(kClass)) {
            return null;
        }
        KClassifier classifier = list.get(0).getClassifier();
        t.g(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        return aa.a.a((KClass) classifier, list2.get(0));
    }

    private static final KSerializer<? extends Object> b(KClass<Object> kClass, List<? extends KSerializer<Object>> list) {
        Object[] array = list.toArray(new KSerializer[0]);
        t.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        KSerializer[] kSerializerArr = (KSerializer[]) array;
        return g1.d(kClass, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    private static final <T> KSerializer<T> c(KSerializer<T> kSerializer, boolean z10) {
        if (z10) {
            return aa.a.s(kSerializer);
        }
        t.g(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.SerializersKt__SerializersKt.nullable?>");
        return kSerializer;
    }

    @Nullable
    public static final KSerializer<? extends Object> d(@NotNull KClass<Object> kClass, @NotNull List<? extends KType> types, @NotNull List<? extends KSerializer<Object>> serializers) {
        t.i(kClass, "<this>");
        t.i(types, "types");
        t.i(serializers, "serializers");
        KSerializer<? extends Object> kSerializerA = a(kClass, types, serializers);
        return kSerializerA == null ? b(kClass, serializers) : kSerializerA;
    }

    @NotNull
    public static final KSerializer<Object> e(@NotNull fa.c cVar, @NotNull KType type) {
        t.i(cVar, "<this>");
        t.i(type, "type");
        KSerializer<Object> kSerializerF = f(cVar, type, true);
        if (kSerializerF != null) {
            return kSerializerF;
        }
        g1.m(h1.c(type));
        throw new v8.h();
    }

    private static final KSerializer<Object> f(fa.c cVar, KType kType, boolean z10) {
        KSerializer<Object> kSerializerA;
        KSerializer<? extends Object> kSerializerB;
        KClass<Object> kClassC = h1.c(kType);
        boolean zIsMarkedNullable = kType.isMarkedNullable();
        List<KTypeProjection> arguments = kType.getArguments();
        ArrayList arrayList = new ArrayList(w.v(arguments, 10));
        Iterator<T> it = arguments.iterator();
        while (it.hasNext()) {
            KType type = ((KTypeProjection) it.next()).getType();
            if (type == null) {
                throw new IllegalArgumentException(("Star projections in type arguments are not allowed, but had " + kType).toString());
            }
            arrayList.add(type);
        }
        if (arrayList.isEmpty()) {
            kSerializerA = k.a(kClassC, zIsMarkedNullable);
        } else {
            Object objB = k.b(kClassC, arrayList, zIsMarkedNullable);
            if (z10) {
                if (v8.t.g(objB)) {
                    objB = null;
                }
                kSerializerA = (KSerializer) objB;
            } else {
                if (v8.t.e(objB) != null) {
                    return null;
                }
                kSerializerA = (KSerializer) objB;
            }
        }
        if (kSerializerA != null) {
            return kSerializerA;
        }
        if (arrayList.isEmpty()) {
            kSerializerB = fa.c.c(cVar, kClassC, null, 2, null);
        } else {
            List<KSerializer<Object>> listE = l.e(cVar, arrayList, z10);
            if (listE == null) {
                return null;
            }
            KSerializer<? extends Object> kSerializerA2 = l.a(kClassC, arrayList, listE);
            kSerializerB = kSerializerA2 == null ? cVar.b(kClassC, listE) : kSerializerA2;
        }
        if (kSerializerB != null) {
            return c(kSerializerB, zIsMarkedNullable);
        }
        return null;
    }

    @Nullable
    public static final KSerializer<Object> g(@NotNull fa.c cVar, @NotNull KType type) {
        t.i(cVar, "<this>");
        t.i(type, "type");
        return f(cVar, type, false);
    }

    @Nullable
    public static final <T> KSerializer<T> h(@NotNull KClass<T> kClass) {
        t.i(kClass, "<this>");
        KSerializer<T> kSerializerB = g1.b(kClass);
        return kSerializerB == null ? p1.b(kClass) : kSerializerB;
    }

    @Nullable
    public static final List<KSerializer<Object>> i(@NotNull fa.c cVar, @NotNull List<? extends KType> typeArguments, boolean z10) {
        ArrayList arrayList;
        t.i(cVar, "<this>");
        t.i(typeArguments, "typeArguments");
        if (z10) {
            List<? extends KType> list = typeArguments;
            arrayList = new ArrayList(w.v(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(l.b(cVar, (KType) it.next()));
            }
        } else {
            List<? extends KType> list2 = typeArguments;
            arrayList = new ArrayList(w.v(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                KSerializer<Object> kSerializerC = l.c(cVar, (KType) it2.next());
                if (kSerializerC == null) {
                    return null;
                }
                arrayList.add(kSerializerC);
            }
        }
        return arrayList;
    }
}
