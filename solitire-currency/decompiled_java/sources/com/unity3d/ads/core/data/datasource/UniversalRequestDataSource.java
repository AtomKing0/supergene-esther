package com.unity3d.ads.core.data.datasource;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import com.google.protobuf.ByteString;
import com.unity3d.ads.datastore.UniversalRequestStoreOuterClass;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.i;
import s9.j;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: UniversalRequestDataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UniversalRequestDataSource {

    @NotNull
    private final DataStore<UniversalRequestStoreOuterClass.UniversalRequestStore> universalRequestStore;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.UniversalRequestDataSource$get$2, reason: invalid class name */
    /* JADX INFO: compiled from: UniversalRequestDataSource.kt */
    @f(c = "com.unity3d.ads.core.data.datasource.UniversalRequestDataSource$get$2", f = "UniversalRequestDataSource.kt", l = {16}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements q<i<? super UniversalRequestStoreOuterClass.UniversalRequestStore>, Throwable, d<? super k0>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass2(d<? super AnonymousClass2> dVar) {
            super(3, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                i iVar = (i) this.L$0;
                Throwable th = (Throwable) this.L$1;
                if (!(th instanceof CorruptionException)) {
                    throw th;
                }
                UniversalRequestStoreOuterClass.UniversalRequestStore defaultInstance = UniversalRequestStoreOuterClass.UniversalRequestStore.getDefaultInstance();
                t.h(defaultInstance, "getDefaultInstance()");
                this.L$0 = null;
                this.label = 1;
                if (iVar.emit(defaultInstance, this) == objE) {
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

        @Override // h9.q
        @Nullable
        public final Object invoke(@NotNull i<? super UniversalRequestStoreOuterClass.UniversalRequestStore> iVar, @NotNull Throwable th, @Nullable d<? super k0> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(dVar);
            anonymousClass2.L$0 = iVar;
            anonymousClass2.L$1 = th;
            return anonymousClass2.invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.UniversalRequestDataSource$remove$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UniversalRequestDataSource.kt */
    @f(c = "com.unity3d.ads.core.data.datasource.UniversalRequestDataSource$remove$2", f = "UniversalRequestDataSource.kt", l = {}, m = "invokeSuspend")
    static final class C31662 extends l implements p<UniversalRequestStoreOuterClass.UniversalRequestStore, d<? super UniversalRequestStoreOuterClass.UniversalRequestStore>, Object> {
        final /* synthetic */ String $key;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31662(String str, d<? super C31662> dVar) {
            super(2, dVar);
            this.$key = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            C31662 c31662 = new C31662(this.$key, dVar);
            c31662.L$0 = obj;
            return c31662;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull UniversalRequestStoreOuterClass.UniversalRequestStore universalRequestStore, @Nullable d<? super UniversalRequestStoreOuterClass.UniversalRequestStore> dVar) {
            return ((C31662) create(universalRequestStore, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            UniversalRequestStoreOuterClass.UniversalRequestStore.Builder builder = ((UniversalRequestStoreOuterClass.UniversalRequestStore) this.L$0).toBuilder();
            builder.removeUniversalRequestMap(this.$key);
            UniversalRequestStoreOuterClass.UniversalRequestStore universalRequestStoreBuild = builder.build();
            t.h(universalRequestStoreBuild, "dataBuilder.build()");
            return universalRequestStoreBuild;
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.UniversalRequestDataSource$set$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UniversalRequestDataSource.kt */
    @f(c = "com.unity3d.ads.core.data.datasource.UniversalRequestDataSource$set$2", f = "UniversalRequestDataSource.kt", l = {}, m = "invokeSuspend")
    static final class C31672 extends l implements p<UniversalRequestStoreOuterClass.UniversalRequestStore, d<? super UniversalRequestStoreOuterClass.UniversalRequestStore>, Object> {
        final /* synthetic */ ByteString $data;
        final /* synthetic */ String $key;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31672(String str, ByteString byteString, d<? super C31672> dVar) {
            super(2, dVar);
            this.$key = str;
            this.$data = byteString;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            C31672 c31672 = new C31672(this.$key, this.$data, dVar);
            c31672.L$0 = obj;
            return c31672;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull UniversalRequestStoreOuterClass.UniversalRequestStore universalRequestStore, @Nullable d<? super UniversalRequestStoreOuterClass.UniversalRequestStore> dVar) {
            return ((C31672) create(universalRequestStore, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            UniversalRequestStoreOuterClass.UniversalRequestStore.Builder builder = ((UniversalRequestStoreOuterClass.UniversalRequestStore) this.L$0).toBuilder();
            builder.putUniversalRequestMap(this.$key, this.$data);
            UniversalRequestStoreOuterClass.UniversalRequestStore universalRequestStoreBuild = builder.build();
            t.h(universalRequestStoreBuild, "dataBuilder.build()");
            return universalRequestStoreBuild;
        }
    }

    public UniversalRequestDataSource(@NotNull DataStore<UniversalRequestStoreOuterClass.UniversalRequestStore> universalRequestStore) {
        t.i(universalRequestStore, "universalRequestStore");
        this.universalRequestStore = universalRequestStore;
    }

    @Nullable
    public final Object get(@NotNull d<? super UniversalRequestStoreOuterClass.UniversalRequestStore> dVar) {
        return j.w(j.h(this.universalRequestStore.getData(), new AnonymousClass2(null)), dVar);
    }

    @Nullable
    public final Object remove(@NotNull String str, @NotNull d<? super k0> dVar) {
        Object objUpdateData = this.universalRequestStore.updateData(new C31662(str, null), dVar);
        return objUpdateData == a9.d.e() ? objUpdateData : k0.f35197a;
    }

    @Nullable
    public final Object set(@NotNull String str, @NotNull ByteString byteString, @NotNull d<? super k0> dVar) {
        Object objUpdateData = this.universalRequestStore.updateData(new C31672(str, byteString, null), dVar);
        return objUpdateData == a9.d.e() ? objUpdateData : k0.f35197a;
    }
}
