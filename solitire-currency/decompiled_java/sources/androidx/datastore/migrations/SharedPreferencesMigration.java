package androidx.datastore.migrations;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.datastore.core.DataMigration;
import h9.p;
import h9.q;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.l;
import v8.n;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: SharedPreferencesMigration.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SharedPreferencesMigration<T> implements DataMigration<T> {

    @Nullable
    private final Context context;

    @Nullable
    private final Set<String> keySet;

    @NotNull
    private final q<SharedPreferencesView, T, d<? super T>, Object> migrate;

    @Nullable
    private final String name;

    @NotNull
    private final l sharedPrefs$delegate;

    @NotNull
    private final p<T, d<? super Boolean>, Object> shouldRunMigration;

    /* JADX INFO: renamed from: androidx.datastore.migrations.SharedPreferencesMigration$1, reason: invalid class name */
    /* JADX INFO: compiled from: SharedPreferencesMigration.kt */
    @f(c = "androidx.datastore.migrations.SharedPreferencesMigration$1", f = "SharedPreferencesMigration.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements p<T, d<? super Boolean>, Object> {
        int label;

        AnonymousClass1(d<? super AnonymousClass1> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass1(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return b.a(true);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(T t10, @Nullable d<? super Boolean> dVar) {
            return ((AnonymousClass1) create(t10, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.migrations.SharedPreferencesMigration$2, reason: invalid class name */
    /* JADX INFO: compiled from: SharedPreferencesMigration.kt */
    @f(c = "androidx.datastore.migrations.SharedPreferencesMigration$2", f = "SharedPreferencesMigration.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.l implements p<T, d<? super Boolean>, Object> {
        int label;

        AnonymousClass2(d<? super AnonymousClass2> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass2(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return b.a(true);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(T t10, @Nullable d<? super Boolean> dVar) {
            return ((AnonymousClass2) create(t10, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.migrations.SharedPreferencesMigration$3, reason: invalid class name */
    /* JADX INFO: compiled from: SharedPreferencesMigration.kt */
    @f(c = "androidx.datastore.migrations.SharedPreferencesMigration$3", f = "SharedPreferencesMigration.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass3 extends kotlin.coroutines.jvm.internal.l implements p<T, d<? super Boolean>, Object> {
        int label;

        AnonymousClass3(d<? super AnonymousClass3> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass3(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return b.a(true);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(T t10, @Nullable d<? super Boolean> dVar) {
            return ((AnonymousClass3) create(t10, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.migrations.SharedPreferencesMigration$4, reason: invalid class name */
    /* JADX INFO: compiled from: SharedPreferencesMigration.kt */
    static final class AnonymousClass4 extends v implements h9.a<SharedPreferences> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $sharedPreferencesName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Context context, String str) {
            super(0);
            this.$context = context;
            this.$sharedPreferencesName = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final SharedPreferences invoke() {
            SharedPreferences sharedPreferences = this.$context.getSharedPreferences(this.$sharedPreferencesName, 0);
            t.h(sharedPreferences, "context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)");
            return sharedPreferences;
        }
    }

    /* JADX INFO: compiled from: SharedPreferencesMigration.kt */
    @RequiresApi(24)
    private static final class Api24Impl {

        @NotNull
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @DoNotInline
        public static final boolean deleteSharedPreferences(@NotNull Context context, @NotNull String name) {
            t.i(context, "context");
            t.i(name, "name");
            return context.deleteSharedPreferences(name);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SharedPreferencesMigration.kt */
    @f(c = "androidx.datastore.migrations.SharedPreferencesMigration", f = "SharedPreferencesMigration.kt", l = {147}, m = "shouldMigrate")
    static final class C10321 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SharedPreferencesMigration<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10321(SharedPreferencesMigration<T> sharedPreferencesMigration, d<? super C10321> dVar) {
            super(dVar);
            this.this$0 = sharedPreferencesMigration;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.shouldMigrate(null, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(@NotNull Context context, @NotNull String sharedPreferencesName, @NotNull q<? super SharedPreferencesView, ? super T, ? super d<? super T>, ? extends Object> migrate) {
        this(context, sharedPreferencesName, null, null, migrate, 12, null);
        t.i(context, "context");
        t.i(sharedPreferencesName, "sharedPreferencesName");
        t.i(migrate, "migrate");
    }

    private final void deleteSharedPreferences(Context context, String str) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            if (!Api24Impl.deleteSharedPreferences(context, str)) {
                throw new IOException(t.r("Unable to delete SharedPreferences: ", str));
            }
        } else {
            File sharedPrefsFile = getSharedPrefsFile(context, str);
            File sharedPrefsBackup = getSharedPrefsBackup(sharedPrefsFile);
            sharedPrefsFile.delete();
            sharedPrefsBackup.delete();
        }
    }

    private final SharedPreferences getSharedPrefs() {
        return (SharedPreferences) this.sharedPrefs$delegate.getValue();
    }

    private final File getSharedPrefsBackup(File file) {
        return new File(t.r(file.getPath(), ".bak"));
    }

    private final File getSharedPrefsFile(Context context, String str) {
        return new File(new File(context.getApplicationInfo().dataDir, "shared_prefs"), t.r(str, ".xml"));
    }

    @Override // androidx.datastore.core.DataMigration
    @Nullable
    public Object cleanUp(@NotNull d<? super k0> dVar) throws IOException {
        k0 k0Var;
        Context context;
        String str;
        SharedPreferences.Editor editorEdit = getSharedPrefs().edit();
        Set<String> set = this.keySet;
        if (set == null) {
            editorEdit.clear();
        } else {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                editorEdit.remove((String) it.next());
            }
        }
        if (!editorEdit.commit()) {
            throw new IOException("Unable to delete migrated keys from SharedPreferences.");
        }
        if (getSharedPrefs().getAll().isEmpty() && (context = this.context) != null && (str = this.name) != null) {
            deleteSharedPreferences(context, str);
        }
        Set<String> set2 = this.keySet;
        if (set2 == null) {
            k0Var = null;
        } else {
            set2.clear();
            k0Var = k0.f35197a;
        }
        return k0Var == a9.d.e() ? k0Var : k0.f35197a;
    }

    @Override // androidx.datastore.core.DataMigration
    @Nullable
    public Object migrate(T t10, @NotNull d<? super T> dVar) {
        return this.migrate.invoke(new SharedPreferencesView(getSharedPrefs(), this.keySet), t10, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.datastore.core.DataMigration
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object shouldMigrate(T r5, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.datastore.migrations.SharedPreferencesMigration.C10321
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1 r0 = (androidx.datastore.migrations.SharedPreferencesMigration.C10321) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1 r0 = new androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            androidx.datastore.migrations.SharedPreferencesMigration r5 = (androidx.datastore.migrations.SharedPreferencesMigration) r5
            v8.u.b(r6)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            v8.u.b(r6)
            h9.p<T, z8.d<? super java.lang.Boolean>, java.lang.Object> r6 = r4.shouldRunMigration
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.mo4invoke(r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            r5 = r4
        L46:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r0 = 0
            if (r6 != 0) goto L54
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.b.a(r0)
            return r5
        L54:
            java.util.Set<java.lang.String> r6 = r5.keySet
            if (r6 != 0) goto L6e
            android.content.SharedPreferences r5 = r5.getSharedPrefs()
            java.util.Map r5 = r5.getAll()
            java.lang.String r6 = "sharedPrefs.all"
            kotlin.jvm.internal.t.h(r5, r6)
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L6c
            goto La0
        L6c:
            r3 = r0
            goto La0
        L6e:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            android.content.SharedPreferences r5 = r5.getSharedPrefs()
            boolean r1 = r6 instanceof java.util.Collection
            if (r1 == 0) goto L82
            r1 = r6
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L82
            goto L6c
        L82:
            java.util.Iterator r6 = r6.iterator()
        L86:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L6c
            java.lang.Object r1 = r6.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r5.contains(r1)
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.b.a(r1)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L86
        La0:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.b.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.migrations.SharedPreferencesMigration.shouldMigrate(java.lang.Object, z8.d):java.lang.Object");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(@NotNull Context context, @NotNull String sharedPreferencesName, @NotNull Set<String> keysToMigrate, @NotNull q<? super SharedPreferencesView, ? super T, ? super d<? super T>, ? extends Object> migrate) {
        this(context, sharedPreferencesName, keysToMigrate, null, migrate, 8, null);
        t.i(context, "context");
        t.i(sharedPreferencesName, "sharedPreferencesName");
        t.i(keysToMigrate, "keysToMigrate");
        t.i(migrate, "migrate");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(@NotNull h9.a<? extends SharedPreferences> produceSharedPreferences, @NotNull q<? super SharedPreferencesView, ? super T, ? super d<? super T>, ? extends Object> migrate) {
        this(produceSharedPreferences, (Set) null, (p) null, migrate, 6, (k) null);
        t.i(produceSharedPreferences, "produceSharedPreferences");
        t.i(migrate, "migrate");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(@NotNull h9.a<? extends SharedPreferences> produceSharedPreferences, @NotNull Set<String> keysToMigrate, @NotNull q<? super SharedPreferencesView, ? super T, ? super d<? super T>, ? extends Object> migrate) {
        this(produceSharedPreferences, keysToMigrate, (p) null, migrate, 4, (k) null);
        t.i(produceSharedPreferences, "produceSharedPreferences");
        t.i(keysToMigrate, "keysToMigrate");
        t.i(migrate, "migrate");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SharedPreferencesMigration(h9.a<? extends SharedPreferences> aVar, Set<String> set, p<? super T, ? super d<? super Boolean>, ? extends Object> pVar, q<? super SharedPreferencesView, ? super T, ? super d<? super T>, ? extends Object> qVar, Context context, String str) {
        this.shouldRunMigration = pVar;
        this.migrate = qVar;
        this.context = context;
        this.name = str;
        this.sharedPrefs$delegate = n.a(aVar);
        this.keySet = set == SharedPreferencesMigrationKt.getMIGRATE_ALL_KEYS() ? null : d0.S0(set);
    }

    /* synthetic */ SharedPreferencesMigration(h9.a aVar, Set set, p pVar, q qVar, Context context, String str, int i10, k kVar) {
        this((h9.a<? extends SharedPreferences>) aVar, (Set<String>) set, (i10 & 4) != 0 ? new AnonymousClass1(null) : pVar, qVar, context, str);
    }

    public /* synthetic */ SharedPreferencesMigration(h9.a aVar, Set set, p pVar, q qVar, int i10, k kVar) {
        this((h9.a<? extends SharedPreferences>) aVar, (Set<String>) ((i10 & 2) != 0 ? SharedPreferencesMigrationKt.getMIGRATE_ALL_KEYS() : set), (i10 & 4) != 0 ? new AnonymousClass2(null) : pVar, qVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(@NotNull h9.a<? extends SharedPreferences> produceSharedPreferences, @NotNull Set<String> keysToMigrate, @NotNull p<? super T, ? super d<? super Boolean>, ? extends Object> shouldRunMigration, @NotNull q<? super SharedPreferencesView, ? super T, ? super d<? super T>, ? extends Object> migrate) {
        this(produceSharedPreferences, keysToMigrate, shouldRunMigration, migrate, (Context) null, (String) null);
        t.i(produceSharedPreferences, "produceSharedPreferences");
        t.i(keysToMigrate, "keysToMigrate");
        t.i(shouldRunMigration, "shouldRunMigration");
        t.i(migrate, "migrate");
    }

    public /* synthetic */ SharedPreferencesMigration(Context context, String str, Set set, p pVar, q qVar, int i10, k kVar) {
        this(context, str, (i10 & 4) != 0 ? SharedPreferencesMigrationKt.getMIGRATE_ALL_KEYS() : set, (i10 & 8) != 0 ? new AnonymousClass3(null) : pVar, qVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(@NotNull Context context, @NotNull String sharedPreferencesName, @NotNull Set<String> keysToMigrate, @NotNull p<? super T, ? super d<? super Boolean>, ? extends Object> shouldRunMigration, @NotNull q<? super SharedPreferencesView, ? super T, ? super d<? super T>, ? extends Object> migrate) {
        this(new AnonymousClass4(context, sharedPreferencesName), keysToMigrate, shouldRunMigration, migrate, context, sharedPreferencesName);
        t.i(context, "context");
        t.i(sharedPreferencesName, "sharedPreferencesName");
        t.i(keysToMigrate, "keysToMigrate");
        t.i(shouldRunMigration, "shouldRunMigration");
        t.i(migrate, "migrate");
    }
}
