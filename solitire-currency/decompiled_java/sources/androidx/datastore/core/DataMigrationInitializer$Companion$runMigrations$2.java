package androidx.datastore.core;

import h9.p;
import java.util.List;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: DataMigrationInitializer.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", l = {44, 46}, m = "invokeSuspend")
final class DataMigrationInitializer$Companion$runMigrations$2<T> extends l implements p<T, d<? super T>, Object> {
    final /* synthetic */ List<h9.l<d<? super k0>, Object>> $cleanUps;
    final /* synthetic */ List<DataMigration<T>> $migrations;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DataMigrationInitializer$Companion$runMigrations$2(List<? extends DataMigration<T>> list, List<h9.l<d<? super k0>, Object>> list2, d<? super DataMigrationInitializer$Companion$runMigrations$2> dVar) {
        super(2, dVar);
        this.$migrations = list;
        this.$cleanUps = list2;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        DataMigrationInitializer$Companion$runMigrations$2 dataMigrationInitializer$Companion$runMigrations$2 = new DataMigrationInitializer$Companion$runMigrations$2(this.$migrations, this.$cleanUps, dVar);
        dataMigrationInitializer$Companion$runMigrations$2.L$0 = obj;
        return dataMigrationInitializer$Companion$runMigrations$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0093 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.a
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = a9.b.e()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L24
            if (r1 != r2) goto L1c
            java.lang.Object r1 = r10.L$1
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r4 = r10.L$0
            java.util.List r4 = (java.util.List) r4
            v8.u.b(r11)
            r7 = r10
            goto L8e
        L1c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L24:
            java.lang.Object r1 = r10.L$3
            java.lang.Object r4 = r10.L$2
            androidx.datastore.core.DataMigration r4 = (androidx.datastore.core.DataMigration) r4
            java.lang.Object r5 = r10.L$1
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r10.L$0
            java.util.List r6 = (java.util.List) r6
            v8.u.b(r11)
            r7 = r10
            r9 = r6
            r6 = r4
            r4 = r9
            goto L6c
        L3a:
            v8.u.b(r11)
            java.lang.Object r11 = r10.L$0
            java.util.List<androidx.datastore.core.DataMigration<T>> r1 = r10.$migrations
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List<h9.l<z8.d<? super v8.k0>, java.lang.Object>> r4 = r10.$cleanUps
            java.util.Iterator r1 = r1.iterator()
            r5 = r10
        L4a:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L93
            java.lang.Object r6 = r1.next()
            androidx.datastore.core.DataMigration r6 = (androidx.datastore.core.DataMigration) r6
            r5.L$0 = r4
            r5.L$1 = r1
            r5.L$2 = r6
            r5.L$3 = r11
            r5.label = r3
            java.lang.Object r7 = r6.shouldMigrate(r11, r5)
            if (r7 != r0) goto L67
            return r0
        L67:
            r9 = r1
            r1 = r11
            r11 = r7
            r7 = r5
            r5 = r9
        L6c:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L90
            androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1 r11 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1
            r8 = 0
            r11.<init>(r6, r8)
            r4.add(r11)
            r7.L$0 = r4
            r7.L$1 = r5
            r7.L$2 = r8
            r7.L$3 = r8
            r7.label = r2
            java.lang.Object r11 = r6.migrate(r1, r7)
            if (r11 != r0) goto L91
            return r0
        L8e:
            r5 = r7
            goto L4a
        L90:
            r11 = r1
        L91:
            r1 = r5
            goto L8e
        L93:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo4invoke(T t10, @Nullable d<? super T> dVar) {
        return ((DataMigrationInitializer$Companion$runMigrations$2) create(t10, dVar)).invokeSuspend(k0.f35197a);
    }
}
