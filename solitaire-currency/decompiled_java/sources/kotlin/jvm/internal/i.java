package kotlin.jvm.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ClassReference.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i implements KClass<Object>, h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f29819b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Map<Class<? extends v8.g<?>>, Integer> f29820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, String> f29821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, String> f29822e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, String> f29823f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Map<String, String> f29824g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Class<?> f29825a;

    /* JADX INFO: compiled from: ClassReference.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        @Nullable
        public final String a(@NotNull Class<?> jClass) {
            String str;
            t.i(jClass, "jClass");
            String str2 = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (!jClass.isArray()) {
                String str3 = (String) i.f29823f.get(jClass.getName());
                return str3 == null ? jClass.getCanonicalName() : str3;
            }
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (str = (String) i.f29823f.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 == null ? "kotlin.Array" : str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x003d, code lost:
        
            if (r2 == null) goto L13;
         */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String b(@org.jetbrains.annotations.NotNull java.lang.Class<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "jClass"
                kotlin.jvm.internal.t.i(r8, r0)
                boolean r0 = r8.isAnonymousClass()
                r1 = 0
                if (r0 == 0) goto Le
                goto Lb6
            Le:
                boolean r0 = r8.isLocalClass()
                if (r0 == 0) goto L6c
                java.lang.String r0 = r8.getSimpleName()
                java.lang.reflect.Method r2 = r8.getEnclosingMethod()
                r3 = 2
                r4 = 36
                java.lang.String r5 = "name"
                if (r2 == 0) goto L43
                kotlin.jvm.internal.t.h(r0, r5)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r2 = r2.getName()
                r6.append(r2)
                r6.append(r4)
                java.lang.String r2 = r6.toString()
                java.lang.String r2 = p9.h.N0(r0, r2, r1, r3, r1)
                if (r2 != 0) goto L40
                goto L43
            L40:
                r1 = r2
                goto Lb6
            L43:
                java.lang.reflect.Constructor r8 = r8.getEnclosingConstructor()
                if (r8 == 0) goto L64
                kotlin.jvm.internal.t.h(r0, r5)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r8 = r8.getName()
                r2.append(r8)
                r2.append(r4)
                java.lang.String r8 = r2.toString()
                java.lang.String r1 = p9.h.N0(r0, r8, r1, r3, r1)
                goto Lb6
            L64:
                kotlin.jvm.internal.t.h(r0, r5)
                java.lang.String r1 = p9.h.M0(r0, r4, r1, r3, r1)
                goto Lb6
            L6c:
                boolean r0 = r8.isArray()
                if (r0 == 0) goto La1
                java.lang.Class r8 = r8.getComponentType()
                boolean r0 = r8.isPrimitive()
                java.lang.String r2 = "Array"
                if (r0 == 0) goto L9e
                java.util.Map r0 = kotlin.jvm.internal.i.e()
                java.lang.String r8 = r8.getName()
                java.lang.Object r8 = r0.get(r8)
                java.lang.String r8 = (java.lang.String) r8
                if (r8 == 0) goto L9e
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r8)
                r0.append(r2)
                java.lang.String r8 = r0.toString()
                r1 = r8
            L9e:
                if (r1 != 0) goto Lb6
                goto L40
            La1:
                java.util.Map r0 = kotlin.jvm.internal.i.e()
                java.lang.String r1 = r8.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto Lb6
                java.lang.String r1 = r8.getSimpleName()
            Lb6:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.i.a.b(java.lang.Class):java.lang.String");
        }

        public final boolean c(@Nullable Object obj, @NotNull Class<?> jClass) {
            t.i(jClass, "jClass");
            Map map = i.f29820c;
            t.g(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(jClass);
            if (num != null) {
                return t0.m(obj, num.intValue());
            }
            if (jClass.isPrimitive()) {
                jClass = g9.a.b(g9.a.c(jClass));
            }
            return jClass.isInstance(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i10 = 0;
        List listN = kotlin.collections.v.n(h9.a.class, h9.l.class, h9.p.class, h9.q.class, h9.r.class, h9.s.class, h9.t.class, h9.u.class, h9.v.class, h9.w.class, h9.b.class, h9.c.class, h9.d.class, h9.e.class, h9.f.class, h9.g.class, h9.h.class, h9.i.class, h9.j.class, h9.k.class, h9.m.class, h9.n.class, h9.o.class);
        ArrayList arrayList = new ArrayList(kotlin.collections.w.v(listN, 10));
        for (Object obj : listN) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.v.u();
            }
            arrayList.add(v8.y.a((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        f29820c = kotlin.collections.r0.s(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put(TypedValues.Custom.S_BOOLEAN, "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put(TypedValues.Custom.S_FLOAT, "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f29821d = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f29822e = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        t.h(collectionValues, "primitiveFqNames.values");
        for (String kotlinName : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            t.h(kotlinName, "kotlinName");
            sb.append(p9.r.Q0(kotlinName, '.', null, 2, null));
            sb.append("CompanionObject");
            v8.s sVarA = v8.y.a(sb.toString(), kotlinName + ".Companion");
            map3.put(sVarA.c(), sVarA.d());
        }
        for (Map.Entry<Class<? extends v8.g<?>>, Integer> entry : f29820c.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f29823f = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.q0.d(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), p9.r.Q0((String) entry2.getValue(), '.', null, 2, null));
        }
        f29824g = linkedHashMap;
    }

    public i(@NotNull Class<?> jClass) {
        t.i(jClass, "jClass");
        this.f29825a = jClass;
    }

    private final Void f() {
        throw new g9.b();
    }

    @Override // kotlin.jvm.internal.h
    @NotNull
    public Class<?> a() {
        return this.f29825a;
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof i) && t.d(g9.a.b(this), g9.a.b((KClass) obj));
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        f();
        throw new v8.h();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public Collection<KFunction<Object>> getConstructors() {
        f();
        throw new v8.h();
    }

    @Override // kotlin.reflect.KClass, kotlin.reflect.KDeclarationContainer
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        f();
        throw new v8.h();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public Collection<KClass<?>> getNestedClasses() {
        f();
        throw new v8.h();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public Object getObjectInstance() {
        f();
        throw new v8.h();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public String getQualifiedName() {
        return f29819b.a(a());
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KClass<? extends Object>> getSealedSubclasses() {
        f();
        throw new v8.h();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public String getSimpleName() {
        return f29819b.b(a());
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KType> getSupertypes() {
        f();
        throw new v8.h();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        f();
        throw new v8.h();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public KVisibility getVisibility() {
        f();
        throw new v8.h();
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return g9.a.b(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        f();
        throw new v8.h();
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        f();
        throw new v8.h();
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        f();
        throw new v8.h();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        f();
        throw new v8.h();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        f();
        throw new v8.h();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        f();
        throw new v8.h();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(@Nullable Object obj) {
        return f29819b.c(obj, a());
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        f();
        throw new v8.h();
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        f();
        throw new v8.h();
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        f();
        throw new v8.h();
    }

    @NotNull
    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
