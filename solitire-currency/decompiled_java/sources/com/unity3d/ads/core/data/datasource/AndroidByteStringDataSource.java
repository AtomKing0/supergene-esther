package com.unity3d.ads.core.data.datasource;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import com.google.protobuf.ByteString;
import com.unity3d.ads.datastore.ByteStringStoreKt;
import com.unity3d.ads.datastore.ByteStringStoreOuterClass;
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

/* JADX INFO: compiled from: AndroidByteStringDataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidByteStringDataSource implements ByteStringDataSource {

    @NotNull
    private final DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.AndroidByteStringDataSource$get$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidByteStringDataSource.kt */
    @f(c = "com.unity3d.ads.core.data.datasource.AndroidByteStringDataSource$get$2", f = "AndroidByteStringDataSource.kt", l = {18}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements q<i<? super ByteStringStoreOuterClass.ByteStringStore>, Throwable, d<? super k0>, Object> {
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
                ByteStringStoreKt.Dsl.Companion companion = ByteStringStoreKt.Dsl.Companion;
                ByteStringStoreOuterClass.ByteStringStore.Builder builderNewBuilder = ByteStringStoreOuterClass.ByteStringStore.newBuilder();
                t.h(builderNewBuilder, "newBuilder()");
                ByteStringStoreKt.Dsl dsl_create = companion._create(builderNewBuilder);
                ByteString EMPTY = ByteString.EMPTY;
                t.h(EMPTY, "EMPTY");
                dsl_create.setData(EMPTY);
                ByteStringStoreOuterClass.ByteStringStore byteStringStore_build = dsl_create._build();
                this.L$0 = null;
                this.label = 1;
                if (iVar.emit(byteStringStore_build, this) == objE) {
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
        public final Object invoke(@NotNull i<? super ByteStringStoreOuterClass.ByteStringStore> iVar, @NotNull Throwable th, @Nullable d<? super k0> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(dVar);
            anonymousClass2.L$0 = iVar;
            anonymousClass2.L$1 = th;
            return anonymousClass2.invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.AndroidByteStringDataSource$set$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidByteStringDataSource.kt */
    @f(c = "com.unity3d.ads.core.data.datasource.AndroidByteStringDataSource$set$2", f = "AndroidByteStringDataSource.kt", l = {}, m = "invokeSuspend")
    static final class C31642 extends l implements p<ByteStringStoreOuterClass.ByteStringStore, d<? super ByteStringStoreOuterClass.ByteStringStore>, Object> {
        final /* synthetic */ ByteString $data;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31642(ByteString byteString, d<? super C31642> dVar) {
            super(2, dVar);
            this.$data = byteString;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            C31642 c31642 = new C31642(this.$data, dVar);
            c31642.L$0 = obj;
            return c31642;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull ByteStringStoreOuterClass.ByteStringStore byteStringStore, @Nullable d<? super ByteStringStoreOuterClass.ByteStringStore> dVar) {
            return ((C31642) create(byteStringStore, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            ByteStringStoreOuterClass.ByteStringStore byteStringStoreBuild = ((ByteStringStoreOuterClass.ByteStringStore) this.L$0).toBuilder().setData(this.$data).build();
            t.h(byteStringStoreBuild, "currentData.toBuilder()\n…\n                .build()");
            return byteStringStoreBuild;
        }
    }

    public AndroidByteStringDataSource(@NotNull DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore) {
        t.i(dataStore, "dataStore");
        this.dataStore = dataStore;
    }

    @Override // com.unity3d.ads.core.data.datasource.ByteStringDataSource
    @Nullable
    public Object get(@NotNull d<? super ByteStringStoreOuterClass.ByteStringStore> dVar) {
        return j.w(j.h(this.dataStore.getData(), new AnonymousClass2(null)), dVar);
    }

    @Override // com.unity3d.ads.core.data.datasource.ByteStringDataSource
    @Nullable
    public Object set(@NotNull ByteString byteString, @NotNull d<? super k0> dVar) {
        Object objUpdateData = this.dataStore.updateData(new C31642(byteString, null), dVar);
        return objUpdateData == a9.d.e() ? objUpdateData : k0.f35197a;
    }
}
