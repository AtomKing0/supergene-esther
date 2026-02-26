package androidx.datastore.core;

import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: DataMigrationInitializer.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1", f = "DataMigrationInitializer.kt", l = {45}, m = "invokeSuspend")
final class DataMigrationInitializer$Companion$runMigrations$2$1$1 extends l implements h9.l<d<? super k0>, Object> {
    final /* synthetic */ DataMigration<T> $migration;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataMigrationInitializer$Companion$runMigrations$2$1$1(DataMigration<T> dataMigration, d<? super DataMigrationInitializer$Companion$runMigrations$2$1$1> dVar) {
        super(1, dVar);
        this.$migration = dataMigration;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@NotNull d<?> dVar) {
        return new DataMigrationInitializer$Companion$runMigrations$2$1$1(this.$migration, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            DataMigration<T> dataMigration = this.$migration;
            this.label = 1;
            if (dataMigration.cleanUp(this) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return k0.f35197a;
    }

    @Override // h9.l
    @Nullable
    public final Object invoke(@Nullable d<? super k0> dVar) {
        return ((DataMigrationInitializer$Companion$runMigrations$2$1$1) create(dVar)).invokeSuspend(k0.f35197a);
    }
}
