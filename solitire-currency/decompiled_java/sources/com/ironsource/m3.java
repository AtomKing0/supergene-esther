package com.ironsource;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: loaded from: classes4.dex */
public final class m3 {

    public static final class a implements OutcomeReceiver<Object, Exception> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z8.d<v8.k0> f13114a;

        /* JADX WARN: Multi-variable type inference failed */
        a(z8.d<? super v8.k0> dVar) {
            this.f13114a = dVar;
        }

        @Override // android.os.OutcomeReceiver
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(@NotNull Exception error) {
            kotlin.jvm.internal.t.i(error, "error");
            z8.d<v8.k0> dVar = this.f13114a;
            t.a aVar = v8.t.f35208b;
            dVar.resumeWith(v8.t.b(v8.u.a(error)));
        }

        @Override // android.os.OutcomeReceiver
        public void onResult(@Nullable Object obj) {
            z8.d<v8.k0> dVar = this.f13114a;
            t.a aVar = v8.t.f35208b;
            dVar.resumeWith(v8.t.b(v8.k0.f35197a));
        }
    }

    @RequiresApi(31)
    @NotNull
    public static final OutcomeReceiver<Object, Exception> a(@NotNull z8.d<? super v8.k0> dVar) {
        kotlin.jvm.internal.t.i(dVar, "<this>");
        return new a(dVar);
    }
}
