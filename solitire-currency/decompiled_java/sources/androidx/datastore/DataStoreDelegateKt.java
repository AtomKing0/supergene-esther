package androidx.datastore;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import h9.l;
import java.util.List;
import k9.a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.y2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DataStoreDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreDelegateKt {

    /* JADX INFO: renamed from: androidx.datastore.DataStoreDelegateKt$dataStore$1, reason: invalid class name */
    /* JADX INFO: compiled from: DataStoreDelegate.kt */
    static final class AnonymousClass1 extends v implements l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final List invoke(@NotNull Context it) {
            t.i(it, "it");
            return kotlin.collections.v.l();
        }
    }

    @NotNull
    public static final <T> a<Context, DataStore<T>> dataStore(@NotNull String fileName, @NotNull Serializer<T> serializer, @Nullable ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, @NotNull l<? super Context, ? extends List<? extends DataMigration<T>>> produceMigrations, @NotNull o0 scope) {
        t.i(fileName, "fileName");
        t.i(serializer, "serializer");
        t.i(produceMigrations, "produceMigrations");
        t.i(scope, "scope");
        return new DataStoreSingletonDelegate(fileName, serializer, replaceFileCorruptionHandler, produceMigrations, scope);
    }

    public static /* synthetic */ a dataStore$default(String str, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, l lVar, o0 o0Var, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i10 & 8) != 0) {
            lVar = AnonymousClass1.INSTANCE;
        }
        if ((i10 & 16) != 0) {
            o0Var = p0.a(e1.b().plus(y2.b(null, 1, null)));
        }
        return dataStore(str, serializer, replaceFileCorruptionHandler, lVar, o0Var);
    }
}
