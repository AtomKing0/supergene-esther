package androidx.lifecycle;

import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: Transformations.kt */
/* JADX INFO: loaded from: classes.dex */
final class Transformations$switchMap$2$onChanged$1 extends v implements h9.l {
    final /* synthetic */ MediatorLiveData $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Transformations$switchMap$2$onChanged$1(MediatorLiveData mediatorLiveData) {
        super(1);
        this.$result = mediatorLiveData;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m3933invoke(obj);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m3933invoke(Object obj) {
        this.$result.setValue(obj);
    }
}
