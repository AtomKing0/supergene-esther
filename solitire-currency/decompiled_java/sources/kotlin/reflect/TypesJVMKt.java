package kotlin.reflect;

import g9.a;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.w;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;
import o9.g;
import o9.m;
import o9.o;
import org.jetbrains.annotations.NotNull;
import v8.q;

/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class TypesJVMKt {

    /* JADX INFO: compiled from: TypesJVM.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type computeJavaType(KType kType, boolean z10) {
        KClassifier classifier = kType.getClassifier();
        if (classifier instanceof KTypeParameter) {
            return new TypeVariableImpl((KTypeParameter) classifier);
        }
        if (!(classifier instanceof KClass)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
        }
        KClass kClass = (KClass) classifier;
        Class clsB = z10 ? a.b(kClass) : a.a(kClass);
        List<KTypeProjection> arguments = kType.getArguments();
        if (arguments.isEmpty()) {
            return clsB;
        }
        if (!clsB.isArray()) {
            return createPossiblyInnerType(clsB, arguments);
        }
        if (clsB.getComponentType().isPrimitive()) {
            return clsB;
        }
        KTypeProjection kTypeProjection = (KTypeProjection) d0.F0(arguments);
        if (kTypeProjection == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
        }
        KVariance kVarianceComponent1 = kTypeProjection.component1();
        KType kTypeComponent2 = kTypeProjection.component2();
        int i10 = kVarianceComponent1 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kVarianceComponent1.ordinal()];
        if (i10 == -1 || i10 == 1) {
            return clsB;
        }
        if (i10 != 2 && i10 != 3) {
            throw new q();
        }
        t.f(kTypeComponent2);
        Type typeComputeJavaType$default = computeJavaType$default(kTypeComponent2, false, 1, null);
        return typeComputeJavaType$default instanceof Class ? clsB : new GenericArrayTypeImpl(typeComputeJavaType$default);
    }

    static /* synthetic */ Type computeJavaType$default(KType kType, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return computeJavaType(kType, z10);
    }

    private static final Type createPossiblyInnerType(Class<?> cls, List<KTypeProjection> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            List<KTypeProjection> list2 = list;
            ArrayList arrayList = new ArrayList(w.v(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(getJavaType((KTypeProjection) it.next()));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            List<KTypeProjection> list3 = list;
            ArrayList arrayList2 = new ArrayList(w.v(list3, 10));
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(getJavaType((KTypeProjection) it2.next()));
            }
            return new ParameterizedTypeImpl(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type typeCreatePossiblyInnerType = createPossiblyInnerType(declaringClass, list.subList(length, list.size()));
        List<KTypeProjection> listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(w.v(listSubList, 10));
        Iterator<T> it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(getJavaType((KTypeProjection) it3.next()));
        }
        return new ParameterizedTypeImpl(cls, typeCreatePossiblyInnerType, arrayList3);
    }

    @NotNull
    public static final Type getJavaType(@NotNull KType kType) {
        Type typeB;
        t.i(kType, "<this>");
        return (!(kType instanceof u) || (typeB = ((u) kType).b()) == null) ? computeJavaType$default(kType, false, 1, null) : typeB;
    }

    public static /* synthetic */ void getJavaType$annotations(KType kType) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String typeToString(Type type) {
        String name;
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            g gVarF = m.f(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
            name = ((Class) o.r(gVarF)).getName() + p9.q.C("[]", o.i(gVarF));
        } else {
            name = cls.getName();
        }
        t.h(name, "{\n        if (type.isArr…   } else type.name\n    }");
        return name;
    }

    private static /* synthetic */ void getJavaType$annotations(KTypeProjection kTypeProjection) {
    }

    private static final Type getJavaType(KTypeProjection kTypeProjection) {
        KVariance variance = kTypeProjection.getVariance();
        if (variance == null) {
            return WildcardTypeImpl.Companion.getSTAR();
        }
        KType type = kTypeProjection.getType();
        t.f(type);
        int i10 = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i10 == 1) {
            return new WildcardTypeImpl(null, computeJavaType(type, true));
        }
        if (i10 == 2) {
            return computeJavaType(type, true);
        }
        if (i10 == 3) {
            return new WildcardTypeImpl(computeJavaType(type, true), null);
        }
        throw new q();
    }
}
