package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: FunctionReferenceImpl.java */
/* JADX INFO: loaded from: classes5.dex */
public class q extends p {
    public q(int i10, KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(i10, f.NO_RECEIVER, ((h) kDeclarationContainer).a(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }

    public q(int i10, Class cls, String str, String str2, int i11) {
        super(i10, f.NO_RECEIVER, cls, str, str2, i11);
    }

    public q(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(i10, obj, cls, str, str2, i11);
    }
}
